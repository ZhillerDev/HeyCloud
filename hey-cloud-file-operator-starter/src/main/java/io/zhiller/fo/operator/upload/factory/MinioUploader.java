package io.zhiller.fo.operator.upload.factory;

import io.zhiller.fo.operator.upload.IUploader;
import io.zhiller.fo.operator.upload.model.UploadFile;
import io.zhiller.fo.operator.upload.model.UploadFileResult;
import io.zhiller.fo.operator.upload.model.UploadMultipartFile;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MinioUploader extends IUploader {
  @Override
  public void cancelUpload(UploadFile uploadFile) {

  }

  @Override
  protected void doUploadFileChunk(UploadMultipartFile qiwenMultipartFile, UploadFile uploadFile) throws IOException {

  }

  @Override
  protected UploadFileResult organizationalResults(UploadMultipartFile qiwenMultipartFile, UploadFile uploadFile) {
    return null;
  }
}
