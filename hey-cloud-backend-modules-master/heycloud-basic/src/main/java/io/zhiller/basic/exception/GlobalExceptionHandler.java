package io.zhiller.basic.exception;

import io.zhiller.basic.constants.common.AjaxRequest;
import io.zhiller.basic.constants.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
  /**
   * -------- 通用异常处理方法 --------
   **/
  @ExceptionHandler(Exception.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public AjaxResult error(Exception e) {
    e.printStackTrace();
    log.error("全局异常捕获：" + e);

    return AjaxResult.error();// 通用异常结果
  }

  /*空指针异常*/
  @ExceptionHandler(NullPointerException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public AjaxResult error(NullPointerException e) {
    e.printStackTrace();
    log.error("全局异常捕获：" + e);
    return AjaxResult.error("空指针异常");
  }
}
