package io.zhiller.fo.domain.constants;

import lombok.Getter;

@Getter
public enum StorageTypeEnum {
  LOCAL(0, "本地存储"),
  MINIO(1, "minio存储");

  private final int code;
  private final String name;

  StorageTypeEnum(int code, String name) {
    this.code = code;
    this.name = name;
  }


}
