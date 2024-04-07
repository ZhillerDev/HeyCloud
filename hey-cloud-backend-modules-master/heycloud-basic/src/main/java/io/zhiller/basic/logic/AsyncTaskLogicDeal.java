package io.zhiller.basic.logic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@Async("asyncTaskExecutor")
public class AsyncTaskLogicDeal {
  @Resource
  FileLogicDeal fileLogicDeal;

}
