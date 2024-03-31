package io.zhiller.fo.config;

import io.minio.MinioClient;
import io.zhiller.fo.domain.storage.MinioProps;
import io.zhiller.fo.operator.upload.factory.MinioUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MinioConfig {
  @Autowired
  private FoProperties foProperties;

  @Bean
  public MinioClient minioClient() {
    MinioProps minioProps = foProperties.getMinioProps();
    return MinioClient.builder().endpoint(minioProps.getEndpoint())
      .credentials(minioProps.getAccessKey(), minioProps.getSecretKey()).build();
  }
}
