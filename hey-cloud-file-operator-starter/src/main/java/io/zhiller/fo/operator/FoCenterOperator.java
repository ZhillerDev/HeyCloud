package io.zhiller.fo.operator;


import io.zhiller.fo.config.FoProperties;
import io.zhiller.fo.domain.storage.MinioProps;

public class FoCenterOperator {
  private String storageType;
  private MinioProps minioProps;

  public FoCenterOperator(FoProperties properties) {
    this.storageType = properties.getStorageType();
    this.minioProps = properties.getMinioProps();
  }


}
