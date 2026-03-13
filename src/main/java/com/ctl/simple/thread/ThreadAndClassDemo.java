package com.ctl.simple.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 测试类：创建不同的线程实体，让它们“进入MyClass”
public class ThreadAndClassDemo {
    static void main() throws InterruptedException {
        // 1. Thread直接创建的平台线程（线程实体）
        // 这个线程实体进入MyClass类
        Thread platformThread = new Thread(MyClass::doSomething, "手动创建的平台线程");
        platformThread.start();
        platformThread.join();

        // 2. 线程池中的平台线程（线程实体）
        try (ExecutorService pool = Executors.newFixedThreadPool(1)) {
            // 线程池的线程实体进入MyClass类
            pool.submit(MyClass::doSomething);
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.SECONDS);

        }

        // 3. 虚拟线程（线程实体，Java 21+）
        // 虚拟线程实体进入MyClass类
        Thread virtualThread = Thread.ofVirtual().unstarted(MyClass::doSomething);
        virtualThread.setName("手动创建的虚拟线程");
        virtualThread.start();
        virtualThread.join();
    }

    static class MyClass {
        // 类中的方法
        public static void doSomething() {
            // 获取当前执行这个方法的线程（即“进入这个类的线程”）
            Thread currentThread = Thread.currentThread();
            System.out.println("进入MyClass的线程名称：" + currentThread.getName());
            System.out.println("这个线程是否是虚拟线程：" + currentThread.isVirtual());
        }
    }

}
