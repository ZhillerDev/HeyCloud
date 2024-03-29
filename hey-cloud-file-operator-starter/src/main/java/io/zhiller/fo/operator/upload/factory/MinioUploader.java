package io.zhiller.fo.operator.upload.factory;

import io.minio.*;
import io.minio.errors.MinioException;
import io.zhiller.fo.domain.storage.MinioProps;
import io.zhiller.fo.domain.constants.StorageTypeEnum;
import io.zhiller.fo.domain.constants.UploadStatusEnum;
import io.zhiller.fo.exception.operator.UploadException;
import io.zhiller.fo.operator.upload.IUploader;
import io.zhiller.fo.operator.upload.model.UploadFile;
import io.zhiller.fo.operator.upload.model.UploadFileResult;
import io.zhiller.fo.operator.upload.model.UploadMultipartFile;
import io.zhiller.fo.utils.GlobalUtils;
import io.zhiller.fo.utils.storage.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MinioUploader extends IUploader {

  private MinioProps minioProps;

  @Autowired
  private MinioClient minioClient;

  @Resource
  RedisUtils redisUtils;

  public MinioUploader() {
  }

  public MinioUploader(MinioProps minioProps) {
    this.minioProps = minioProps;
  }

  @Override
  public void cancelUpload(UploadFile uploadFile) {

  }

  @Override
  protected void doUploadFileChunk(UploadMultipartFile multipartFile, UploadFile uploadFile) throws IOException {

  }

  @Override
  protected UploadFileResult organizationalResults(UploadMultipartFile multipartFile, UploadFile uploadFile) {
    return null;
  }

  @Override
  protected UploadFileResult doUploadFlow(UploadMultipartFile multipartFile, UploadFile uploadFile) {
    UploadFileResult uploadFileResult = new UploadFileResult();
    try {
      multipartFile.getFileUrl(uploadFile.getIdentifier());
      String fileUrl = GlobalUtils.getUploadFileUrl(uploadFile.getIdentifier(), multipartFile.getExtendName());

      File tempFile = GlobalUtils.getTempFile(fileUrl);
      File processFile = GlobalUtils.getProcessFile(fileUrl);

      byte[] fileData = multipartFile.getUploadBytes();

      writeByteDataToFile(fileData, tempFile, uploadFile);

      //判断是否完成文件的传输并进行校验与重命名
      boolean isComplete = checkUploadStatus(uploadFile, processFile);
      uploadFileResult.setFileUrl(fileUrl);
      uploadFileResult.setFileName(multipartFile.getFileName());
      uploadFileResult.setExtendName(multipartFile.getExtendName());
      uploadFileResult.setFileSize(uploadFile.getTotalSize());
      uploadFileResult.setStorageType(StorageTypeEnum.MINIO);

      if (uploadFile.getTotalChunks() == 1) {
        uploadFileResult.setFileSize(multipartFile.getSize());
      }
      uploadFileResult.setIdentifier(uploadFile.getIdentifier());
      if (isComplete) {

        minioUpload(fileUrl, tempFile, uploadFile);
        uploadFileResult.setFileUrl(fileUrl);
        tempFile.delete();

        if (GlobalUtils.isImageFile(uploadFileResult.getExtendName())) {
          InputStream inputStream = null;
          try {
            inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(minioProps.getBucketName()).object(uploadFileResult.getFileUrl()).build());
            BufferedImage src = ImageIO.read(inputStream);
            uploadFileResult.setBufferedImage(src);
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            IOUtils.closeQuietly(inputStream);
          }

        }

        uploadFileResult.setStatus(UploadStatusEnum.SUCCESS);
      } else {
        uploadFileResult.setStatus(UploadStatusEnum.UNCOMPLATE);
      }
    } catch (IOException e) {
      throw new UploadException(e);
    }
    return uploadFileResult;
  }

  private void minioUpload(String fileUrl, File file, UploadFile uploadFile) {
    InputStream inputStream = null;
    try {
      // 检查存储桶是否已经存在
      boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProps.getBucketName()).build());
      if (!isExist) {
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProps.getBucketName()).build());
      }
      inputStream = new FileInputStream(file);
      minioClient.putObject(
        PutObjectArgs.builder().bucket(minioProps.getBucketName()).object(fileUrl).stream(
            inputStream, uploadFile.getTotalSize(), 1024 * 1024 * 5)
//                            .contentType("video/mp4")
          .build());
    } catch (MinioException | InvalidKeyException | NoSuchAlgorithmException | IOException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(inputStream);
    }

  }
}
