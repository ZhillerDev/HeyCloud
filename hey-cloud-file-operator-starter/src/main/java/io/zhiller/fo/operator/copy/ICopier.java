package io.zhiller.fo.operator.copy;

import io.zhiller.fo.operator.copy.model.CopyFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Slf4j
@Component
public abstract class ICopier {
  /**
   * 将服务器文件流拷贝到云端，并返回文件url
   * @param inputStream 文件流
   * @param copyFile 拷贝文件相关参数
   * @return 文件url
   */
  public abstract String copy(InputStream inputStream, CopyFile copyFile);
}
