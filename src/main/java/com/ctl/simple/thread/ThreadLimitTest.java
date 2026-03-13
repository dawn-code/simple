package com.ctl.simple.thread;

public class ThreadLimitTest {
    static void main() {
        int count = 0;
        try {
            while (true) {
                new Thread(() -> {
                    try { Thread.sleep(Long.MAX_VALUE); }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
                count++;
                System.out.println("已创建线程数：" + count);
            }
        } catch (OutOfMemoryError | Exception e) {
            System.out.println("创建失败，最大线程数：" + count);
            System.out.println("原因：" + e.getMessage());
        }
    }
}