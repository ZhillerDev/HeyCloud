package io.zhiller.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.infrastructure.constants.common.AjaxResult;
import io.zhiller.infrastructure.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试接口", description = "未开放接口测试区域")
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class DemoController {
  private final IUserService userService;

  @GetMapping("demo")
  public AjaxResult getAllUsers() {
    return userService.getAllUsers();
  }
}
