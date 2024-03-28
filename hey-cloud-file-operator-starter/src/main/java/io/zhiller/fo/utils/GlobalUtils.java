package io.zhiller.fo.utils;

public class GlobalUtils {
  public static String LOCAL_STORAGE_PATH;
  public static String ROOT_PATH;
  public static final String[] IMG_FILE = {"bmp", "jpg", "png", "tif", "gif", "jpeg"};
  public static final String[] DOC_FILE = {"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "hlp", "wps", "rtf", "html", "pdf"};
  public static final String[] VIDEO_FILE = {"avi", "mp4", "mpg", "mov", "swf"};
  public static final String[] MUSIC_FILE = {"wav", "aif", "au", "mp3", "ram", "wma", "mmf", "amr", "aac", "flac"};
  public static final String[] TXT_FILE = {"txt", "html", "java", "xml", "js", "css", "json", "sql"};
  public static final int IMAGE_TYPE = 1;
  public static final int DOC_TYPE = 2;
  public static final int VIDEO_TYPE = 3;
  public static final int MUSIC_TYPE = 4;
  public static final int OTHER_TYPE = 5;
  public static final int SHARE_FILE = 6;
  public static final int RECYCLE_FILE = 7;

  /**
   * 判断图片文件
   *
   * @param extendName 文件名
   * @return boolean
   */
  public static boolean isImageFile(String extendName) {
    for (String extend : IMG_FILE) {
      if (extendName.equalsIgnoreCase(extend)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 判断视频文件
   *
   * @param extendName 文件名
   * @return boolean
   */
  public static boolean isVideoFile(String extendName) {
    for (String extend : VIDEO_FILE) {
      if (extendName.equalsIgnoreCase(extend)) {
        return true;
      }
    }
    return false;
  }



}
