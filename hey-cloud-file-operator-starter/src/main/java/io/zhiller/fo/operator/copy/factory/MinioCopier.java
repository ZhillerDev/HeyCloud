package io.zhiller.fo.operator.copy.factory;

import io.zhiller.fo.domain.storage.MinioProps;
import io.zhiller.fo.operator.copy.ICopier;
import io.zhiller.fo.operator.copy.model.CopyFile;

import java.io.InputStream;

public class MinioCopier extends ICopier {
  private MinioProps minioProps;

  public MinioCopier() {
  }



  @Override
  public String copy(InputStream inputStream, CopyFile copyFile) {
    return null;
  }
}
