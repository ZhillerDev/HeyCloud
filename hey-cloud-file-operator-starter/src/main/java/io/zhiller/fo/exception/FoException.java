package io.zhiller.fo.exception;

public class FoException extends RuntimeException {
  public FoException(Throwable cause) {
    super("FileOperator 中间件故障", cause);
  }

  public FoException(String message) {
    super(message);
  }

  public FoException(String message, Throwable cause) {
    super(message, cause);
  }
}
