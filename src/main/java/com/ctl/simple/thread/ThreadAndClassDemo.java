package com.ctl.simple.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 测试类：创建不同的线程实体，让它们“进入MyClass”
public class ThreadAndClassDemo {
    static void main() throws InterruptedException {
        // 1. Thread直接创建的平台线程（线程实体）
        Thread platformThread = new Thread(() -> {
            MyClass.doSomething(); // 这个线程实体进入MyClass类
        }, "手动创建的平台线程");
        platformThread.start();
        platformThread.join();

        // 2. 线程池中的平台线程（线程实体）
        ExecutorService pool = Executors.newFixedThreadPool(1);
        // 线程池的线程实体进入MyClass类
        pool.submit(MyClass::doSomething);
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.SECONDS);

        // 3. 虚拟线程（线程实体，Java 21+）
        // 虚拟线程实体进入MyClass类
        Thread virtualThread = Thread.ofVirtual().unstarted(MyClass::doSomething);
        virtualThread.setName("手动创建的虚拟线程");
        virtualThread.start();
        virtualThread.join();
    }
}
