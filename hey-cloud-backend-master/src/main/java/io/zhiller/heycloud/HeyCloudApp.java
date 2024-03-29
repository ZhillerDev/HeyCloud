package io.zhiller.heycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
public class HeyCloudApp {

  public static void main(String[] args) {
    SpringApplication.run(HeyCloudApp.class, args);
  }

}
