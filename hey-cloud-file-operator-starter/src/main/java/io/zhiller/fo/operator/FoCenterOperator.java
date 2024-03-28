package io.zhiller.fo.operator;


import io.zhiller.fo.config.FoProperties;
import io.zhiller.fo.config.MinioConfig;

public class FoCenterOperator {
  private String storageType;
  private MinioConfig minioConfig;

  public FoCenterOperator(FoProperties properties) {
    this.storageType = properties.getStorageType();
    this.minioConfig = properties.getMinioConfig();
  }


}
