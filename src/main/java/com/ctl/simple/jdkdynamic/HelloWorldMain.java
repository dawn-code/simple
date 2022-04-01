package com.ctl.simple.jdkdynamic;

import java.lang.reflect.Proxy;

/**
 * @author Jxr
 */
public class HelloWorldMain {

    public static void main(String[] args) {

        // 设置报错打印生成的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 传的实现
        HelloWorldInvocationHandler handler = new HelloWorldInvocationHandler(new HelloWorldImpl());

        // 传的接口
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(HelloWorldMain.class.getClassLoader(), new Class[]{HelloWorld.class}, handler);

        // 调的方法
        proxy.sayHello("Jxr");
    }

}