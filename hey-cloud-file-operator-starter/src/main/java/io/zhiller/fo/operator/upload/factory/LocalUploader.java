package io.zhiller.fo.operator.upload.factory;

import io.zhiller.fo.operator.upload.IUploader;
import io.zhiller.fo.operator.upload.model.UploadFile;
import io.zhiller.fo.operator.upload.model.UploadFileResult;
import io.zhiller.fo.operator.upload.model.UploadMultipartFile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class LocalUploader extends IUploader {

  public static Map<String, String> FILE_URL_MAP = new HashMap<>();

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
