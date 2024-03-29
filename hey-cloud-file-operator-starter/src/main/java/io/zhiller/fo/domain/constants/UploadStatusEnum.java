package io.zhiller.fo.domain.constants;

public enum UploadStatusEnum {
  FAIL(0, "上传失败"),
  SUCCESS(1, "上传成功"),
  UNCOMPLATE(2, "未完成");

  private final int code;
  private final String message;

  UploadStatusEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
