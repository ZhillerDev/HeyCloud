package io.zhiller.fo.operator.copy.factory;

import io.zhiller.fo.operator.copy.ICopier;
import io.zhiller.fo.operator.copy.model.CopyFile;

import java.io.InputStream;

public class LocalCopier extends ICopier {
  @Override
  public String copy(InputStream inputStream, CopyFile copyFile) {
    return null;
  }
}
