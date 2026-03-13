package com.ctl.simple.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    @Bean("customThreadPool")
    public Executor customThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 1. 核心线程数：根据 CPU 核心数配置（常用公式：CPU核心数 * 2 + 1）
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;
        executor.setCorePoolSize(corePoolSize);
        
        // 2. 最大线程数：核心线程数的 2-4 倍（避免设置过大，防止内存溢出）
        executor.setMaxPoolSize(corePoolSize * 3);
        
        // 3. 任务队列容量：超出核心线程数的任务先放入队列
        executor.setQueueCapacity(1000);
        
        // 4. 线程空闲超时时间（非核心线程）
        executor.setKeepAliveSeconds(60);
        
        // 5. 线程名称前缀（便于排查问题）
        executor.setThreadNamePrefix("custom-task-");
        
        // 6. 拒绝策略：当线程数达最大值且队列满时，直接抛出异常（可根据业务调整）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        
        // 7. 初始化线程池
        executor.initialize();
        return executor;
    }
}