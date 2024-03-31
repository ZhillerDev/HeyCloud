package io.zhiller.basic.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
  public static String getFileExtension(String filePath) {
    Path path = Paths.get(filePath);
    return path.getFileName().toString().contains(".") ? path.getFileName().toString().split("\\.")[1] : "";
  }

  public static String getFileName(String filePath) {
    Path path = Paths.get(filePath);
    return path.getFileName().toString();
  }
}
