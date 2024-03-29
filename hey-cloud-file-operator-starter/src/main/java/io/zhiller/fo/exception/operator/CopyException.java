package io.zhiller.fo.exception.operator;


import io.zhiller.fo.exception.FoException;

public class CopyException extends FoException {
    public CopyException(Throwable cause) {
        super("创建出现了异常", cause);
    }

    public CopyException(String message) {
        super(message);
    }

    public CopyException(String message, Throwable cause) {
        super(message, cause);
    }

}
