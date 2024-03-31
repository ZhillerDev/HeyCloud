package io.zhiller.fo;


import io.zhiller.fo.config.FoProperties;
import io.zhiller.fo.operator.FoCenterOperator;
import io.zhiller.fo.operator.upload.factory.MinioUploader;
import io.zhiller.fo.utils.GlobalUtils;
import io.zhiller.fo.utils.storage.RedisLockUtils;
import io.zhiller.fo.utils.storage.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@Slf4j
@Configuration
//@ConditionalOnClass(FoProperties.class)
@EnableConfigurationProperties({FoProperties.class})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FileOperatorEntryPoint {
  @Autowired
  private FoProperties properties;

  @Bean
  public FoCenterOperator centerOperator() {
    GlobalUtils.LOCAL_STORAGE_PATH = properties.getLocalStoragePath();
    String bucketName = properties.getBucketName();
    if (StringUtils.isNotEmpty(bucketName)) {
      GlobalUtils.ROOT_PATH = properties.getBucketName();
    } else {
      GlobalUtils.ROOT_PATH = "upload";
    }
    return new FoCenterOperator(properties);
  }

  @Bean
  public MinioUploader minioUploader() {
    return new MinioUploader(this.properties.getMinioProps());
  }

  @Bean
  public RedisUtils redisUtils() {
    return new RedisUtils();
  }

  @Bean
  public RedisLockUtils lockUtils() {
    return new RedisLockUtils();
  }
}
