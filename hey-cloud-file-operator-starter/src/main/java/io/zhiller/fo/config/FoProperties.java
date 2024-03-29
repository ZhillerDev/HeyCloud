package io.zhiller.fo.config;

import io.zhiller.fo.domain.ThumbImage;
import io.zhiller.fo.domain.storage.MinioProps;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "fileoperator")
public class FoProperties {
  private String bucketName;
  private String storageType;
  private String localStoragePath;
  private ThumbImage thumbImage = new ThumbImage();
  private MinioProps minioProps = new MinioProps();
}
