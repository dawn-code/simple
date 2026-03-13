package com.ctl.simple.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlatformThreadDemo {
    static void main() {
        // 创建固定大小的线程池（5 个平台线程）
        try (ExecutorService executor = Executors.newFixedThreadPool(5000000)) {

            // 提交 1000 个任务（会排队执行，因为只有 5 个线程）
            for (int i = 0; i < 100000000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    try {
                        // 模拟 IO 阻塞（比如数据库查询）
                        Thread.sleep(1000);
                        System.out.println("平台线程执行任务：" + taskId);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
            executor.shutdown();
        }
    }
}