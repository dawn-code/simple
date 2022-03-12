package com.ctl.simple.jdkdynamic;

import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class ProxyTest {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        CustomInvocationHandler handler = new CustomInvocationHandler(new HelloWorldImpl());
        HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{HelloWorld.class},
                handler);
        proxy.sayHello("Mikan");
    }

}