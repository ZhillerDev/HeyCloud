package io.zhiller.common.minio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MinioDto {
  private String fileName;
  private String fileExtension;
  private long fileSize;
}
