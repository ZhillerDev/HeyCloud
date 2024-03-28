package io.zhiller.fo.config;

import lombok.Data;

@Data
public class MinioConfig {
  private String endpoint;
  private String accessKey;
  private String secretKey;
  private String bucketName;
}
