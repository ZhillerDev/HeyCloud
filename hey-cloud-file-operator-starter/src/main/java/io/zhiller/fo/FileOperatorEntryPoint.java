package io.zhiller.fo;


import io.zhiller.fo.config.FoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@Slf4j
@Configuration
@EnableConfigurationProperties({FoProperties.class})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FileOperatorEntryPoint {
  @Autowired
  private FoProperties properties;


}
