package io.zhiller.application.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "回收站接口", description = "管理回收站文件")
@Slf4j
@RestController
@RequestMapping("/task")
public class RecoveryController {
}
