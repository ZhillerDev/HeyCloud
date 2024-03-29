package io.zhiller.fo.operator.copy.factory;

import io.zhiller.fo.exception.operator.CopyException;
import io.zhiller.fo.operator.copy.ICopier;
import io.zhiller.fo.operator.copy.model.CopyFile;
import io.zhiller.fo.utils.GlobalUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class LocalCopier extends ICopier {
  @Override
  public String copy(InputStream inputStream, CopyFile copyFile) {
    String uuid = UUID.randomUUID().toString();
    String fileUrl = GlobalUtils.getUploadFileUrl(uuid, copyFile.getExtendName());
    File saveFile = new File(GlobalUtils.getStaticPath() + fileUrl);
    try {
      FileUtils.copyInputStreamToFile(inputStream, saveFile);
    } catch (IOException e) {
      throw new CopyException("创建文件出现异常", e);
    } finally {
      IOUtils.closeQuietly(inputStream);
    }
    return fileUrl;
  }
}
