package io.zhiller.fo.operator.upload.model;

import lombok.Data;

@Data
public class UploadFileInfo {
  private String bucketName;
  private String key;
  private String uploadId;
}
