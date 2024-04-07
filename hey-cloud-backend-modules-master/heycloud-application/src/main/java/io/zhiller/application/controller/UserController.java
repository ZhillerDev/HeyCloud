package io.zhiller.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.basic.constants.common.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "用户信息接口", description = "用于获取用户头像等内容")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

}
