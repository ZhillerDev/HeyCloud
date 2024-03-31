package io.zhiller.basic.stream;

import io.zhiller.fo.utils.GlobalUtils;
import org.apache.commons.io.FilenameUtils;

// 全局通用文件配置
public class CloudFile {
  private final String path;
  public static final String separator = "/";
  private boolean isDirectory;

  public CloudFile(String path, boolean isDirectory) {
    this.path = path;
    this.isDirectory = isDirectory;
  }

  public static String formatPath(String path) {
    path = GlobalUtils.pathSplitFormat(path);
    if ("/".equals(path)) {
      return path;
    }
    if (!path.startsWith(separator)) {
      path = separator + path;
    }
    if (path.endsWith("/")) {
      int length = path.length();
      return path.substring(0, length - 1);
    }

    return path;
  }

  public String getParent() {
    if (separator.equals(this.path)) {
      return null;
    }
    if (!this.path.contains("/")) {
      return null;
    }
    int index = path.lastIndexOf(separator);
    if (index == 0) {
      return separator;
    }
    return path.substring(0, index);
  }
  public CloudFile getParentFile() {
    String parentPath = this.getParent();
    return new CloudFile(parentPath, true);
  }

  public String getName() {
    int index = path.lastIndexOf(separator);
    if (!path.contains(separator)) {
      return path;
    }
    return path.substring(index + 1);
  }
  public String getExtendName() {
    return FilenameUtils.getExtension(getName());
  }

  public String getNameNotExtend() {
    return FilenameUtils.removeExtension(getName());
  }

  public String getPath() {
    return path;
  }

  public boolean isDirectory() {
    return isDirectory;
  }

  public boolean isFile() {
    return !isDirectory;
  }
}
