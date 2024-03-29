package io.zhiller.fo.operator.upload.factory;

import io.zhiller.fo.domain.constants.StorageTypeEnum;
import io.zhiller.fo.domain.constants.UploadStatusEnum;
import io.zhiller.fo.exception.operator.UploadException;
import io.zhiller.fo.operator.upload.IUploader;
import io.zhiller.fo.operator.upload.model.UploadFile;
import io.zhiller.fo.operator.upload.model.UploadFileResult;
import io.zhiller.fo.operator.upload.model.UploadMultipartFile;
import io.zhiller.fo.utils.GlobalUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@Component
public class LocalUploader extends IUploader {

  public static Map<String, String> FILE_URL_MAP = new HashMap<>();

  @Override
  protected UploadFileResult doUploadFlow(UploadMultipartFile multipartFile, UploadFile uploadFile) {
    UploadFileResult uploadFileResult = new UploadFileResult();
    try {
      String fileUrl = GlobalUtils.getUploadFileUrl(uploadFile.getIdentifier(), multipartFile.getExtendName());
      if (StringUtils.isNotEmpty(FILE_URL_MAP.get(uploadFile.getIdentifier()))) {
        fileUrl = FILE_URL_MAP.get(uploadFile.getIdentifier());
      } else {
        FILE_URL_MAP.put(uploadFile.getIdentifier(), fileUrl);
      }
      String tempFileUrl = fileUrl + "_tmp";
      String confFileUrl = fileUrl.replace("." + multipartFile.getExtendName(), ".conf");

      File file = new File(GlobalUtils.getStaticPath() + fileUrl);
      File tempFile = new File(GlobalUtils.getStaticPath() + tempFileUrl);
      File confFile = new File(GlobalUtils.getStaticPath() + confFileUrl);

      //第一步 打开将要写入的文件
      RandomAccessFile raf = new RandomAccessFile(tempFile, "rw");
      //第二步 打开通道
      try {
        FileChannel fileChannel = raf.getChannel();
        //第三步 计算偏移量
        long position = (uploadFile.getChunkNumber() - 1) * uploadFile.getChunkSize();
        //第四步 获取分片数据
        byte[] fileData = multipartFile.getUploadBytes();
        //第五步 写入数据
        fileChannel.position(position);
        fileChannel.write(ByteBuffer.wrap(fileData));
        fileChannel.force(true);
        fileChannel.close();
      } finally {
        IOUtils.closeQuietly(raf);
      }

      //判断是否完成文件的传输并进行校验与重命名
      boolean isComplete = checkUploadStatus(uploadFile, confFile);
      uploadFileResult.setFileUrl(fileUrl);
      uploadFileResult.setFileName(multipartFile.getFileName());
      uploadFileResult.setExtendName(multipartFile.getExtendName());
      uploadFileResult.setFileSize(uploadFile.getTotalSize());
      uploadFileResult.setStorageType(StorageTypeEnum.LOCAL);

      if (uploadFile.getTotalChunks() == 1) {
        uploadFileResult.setFileSize(multipartFile.getSize());
      }
      uploadFileResult.setIdentifier(uploadFile.getIdentifier());
      if (isComplete) {
        tempFile.renameTo(file);
        FILE_URL_MAP.remove(uploadFile.getIdentifier());

        if (GlobalUtils.isImageFile(uploadFileResult.getExtendName())) {

          InputStream is = null;
          try {
            is = Files.newInputStream(GlobalUtils.getLocalSaveFile(fileUrl).toPath());

            BufferedImage src = ImageIO.read(is);
            uploadFileResult.setBufferedImage(src);
          } catch (IOException e) {
            e.printStackTrace();
          } finally {
            IOUtils.closeQuietly(is);
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

  @Override
  public void cancelUpload(UploadFile uploadFile) {
    String fileUrl = FILE_URL_MAP.get(uploadFile.getIdentifier());
    String tempFileUrl = fileUrl + "_tmp";
    String confFileUrl = fileUrl.replace("." + FilenameUtils.getExtension(fileUrl), ".conf");
    File tempFile = new File(tempFileUrl);
    if (tempFile.exists()) {
      tempFile.delete();
    }
    File confFile = new File(confFileUrl);
    if (confFile.exists()) {
      confFile.delete();
    }
  }

  @Override
  protected void doUploadFileChunk(UploadMultipartFile multipartFile, UploadFile uploadFile) throws IOException {

  }

  @Override
  protected UploadFileResult organizationalResults(UploadMultipartFile multipartFile, UploadFile uploadFile) {
    return null;
  }
}
