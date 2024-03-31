package io.zhiller.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.domain.user.User;
import io.zhiller.basic.constants.common.AjaxResult;
import io.zhiller.infrastructure.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "测试接口", description = "未开放接口测试区域")
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class DemoController {
  private final IUserService userService;

  @GetMapping("demo")
  public AjaxResult getAllUsers() {
    List<User> allUsers = userService.getAllUsers();
    if (allUsers.isEmpty()) return AjaxResult.error();
    else return AjaxResult.success(allUsers);
  }
}
