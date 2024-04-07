package io.zhiller.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.zhiller.basic.logic.FileLogicDeal;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "任务管理接口", description = "管理文件上传与下载任务等")
@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
  private final FileLogicDeal fileLogicDeal;


}
