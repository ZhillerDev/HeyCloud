package io.zhiller.application;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.stp.StpUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "io.zhiller.*")
@MapperScan("io.zhiller.infrastructure.mapper")
public class HeyCloudApp {

  public static void main(String[] args) {
    SpringApplication.run(HeyCloudApp.class, args);

    initiation();
  }

  private static void initiation() {
    System.out.println("token配置项：" + SaManager.getConfig());
  }

}
