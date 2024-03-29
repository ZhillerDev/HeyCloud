package io.zhiller.fo.domain.storage;

import lombok.Data;

@Data
public class MinioProps {
  private String endpoint;
  private String accessKey;
  private String secretKey;
  private String bucketName;
}
