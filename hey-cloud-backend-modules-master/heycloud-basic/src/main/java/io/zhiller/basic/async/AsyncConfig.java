package io.zhiller.basic.async;

import io.zhiller.basic.exception.UncaughtExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@EnableAsync
@Component
@EnableConfigurationProperties(AsyncProperties.class)
public class AsyncConfig implements AsyncConfigurer {
  @Autowired
  AsyncProperties asyncProperties;

  @Bean("asyncTaskExecutor")
  @Override
  public Executor getAsyncExecutor() {
    //Java虚拟机可用的处理器数
    int processors = Runtime.getRuntime().availableProcessors();
    //定义线程池
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    //核心线程数
    taskExecutor.setCorePoolSize(Objects.nonNull(asyncProperties.getCorePoolSize()) ? asyncProperties.getCorePoolSize() : processors);
    //线程池最大线程数,默认：40000
    taskExecutor.setMaxPoolSize(Objects.nonNull(asyncProperties.getMaxPoolSize()) ? asyncProperties.getMaxPoolSize() : 40000);
    //线程队列最大线程数,默认：80000
    taskExecutor.setQueueCapacity(Objects.nonNull(asyncProperties.getMaxPoolSize()) ? asyncProperties.getMaxPoolSize() : 80000);
    //线程名称前缀
    taskExecutor.setThreadNamePrefix(StringUtils.isNotEmpty(asyncProperties.getThreadNamePrefix()) ? asyncProperties.getThreadNamePrefix() : "Cloud-Async-");
    //线程池中线程最大空闲时间，默认：60，单位：秒
    taskExecutor.setKeepAliveSeconds(asyncProperties.getKeepAliveSeconds());
    //核心线程是否允许超时，默认:false
    taskExecutor.setAllowCoreThreadTimeOut(asyncProperties.isAllowCoreThreadTimeOut());
    //IOC容器关闭时是否阻塞等待剩余的任务执行完成，默认:false（必须设置setAwaitTerminationSeconds）
    taskExecutor.setWaitForTasksToCompleteOnShutdown(asyncProperties.isWaitForTasksToCompleteOnShutdown());
    //阻塞IOC容器关闭的时间，默认：10秒（必须设置setWaitForTasksToCompleteOnShutdown）
    taskExecutor.setAwaitTerminationSeconds(asyncProperties.getAwaitTerminationSeconds());
    /**
     * 拒绝策略，默认是AbortPolicy
     * AbortPolicy：丢弃任务并抛出RejectedExecutionException异常
     * DiscardPolicy：丢弃任务但不抛出异常
     * DiscardOldestPolicy：丢弃最旧的处理程序，然后重试，如果执行器关闭，这时丢弃任务
     * CallerRunsPolicy：执行器执行任务失败，则在策略回调方法中执行任务，如果执行器关闭，这时丢弃任务
     */
    taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
    //初始化
    //taskExecutor.initialize();

    return taskExecutor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new UncaughtExceptionHandler();
  }
}
