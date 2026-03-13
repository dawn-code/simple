package com.ctl.simple.thread;

// 一个普通的类
public class MyClass {
    // 类中的方法
    public static void doSomething() {
        // 获取当前执行这个方法的线程（即“进入这个类的线程”）
        Thread currentThread = Thread.currentThread();
        System.out.println("进入MyClass的线程名称：" + currentThread.getName());
        System.out.println("这个线程是否是虚拟线程：" + currentThread.isVirtual());
    }
}

