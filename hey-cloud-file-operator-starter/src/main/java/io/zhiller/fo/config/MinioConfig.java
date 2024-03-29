package io.zhiller.fo.config;

import io.minio.MinioClient;
import io.zhiller.fo.domain.storage.MinioProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MinioConfig {

  @Resource
  private MinioProps minioProps;

  @Bean
  public MinioClient client() {
    return MinioClient.builder().endpoint(minioProps.getEndpoint())
      .credentials(minioProps.getAccessKey(), minioProps.getSecretKey()).build();
  }
}
