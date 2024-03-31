package io.zhiller.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.basic.constants.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "文件共享接口", description = "任何人都可以访问的文件接口")
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonFileController {
  public static final String CURRENT_MODULE = "文件共享";

  @Operation(summary = "将文件共享给他人")
  @PostMapping(value = "/commonFile")
  public AjaxResult commitFile() {
    return AjaxResult.error();
  }
}
