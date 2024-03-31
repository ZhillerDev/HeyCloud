package io.zhiller.common.minio;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "cloud.minio")
public class MinioProperties {
  /**
   * 访问地址
   */

  private String endpoint;

  /**
   * accessKey类似于用户ID，用于唯一标识你的账户
   */

  private String accessKey;

  /**
   * secretKey是你账户的密码
   */

  private String secretKey;

  /**
   * 默认存储桶
   */

  private String bucketName;

  @Bean
  public MinioClient minioClient() {
    MinioClient minioClient = MinioClient.builder()
      .endpoint(endpoint)
      .credentials(accessKey, secretKey)
      .build();
    return minioClient;
  }
}
