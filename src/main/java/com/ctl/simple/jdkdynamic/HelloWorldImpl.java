package com.ctl.simple.jdkdynamic;

/**
 * @author Administrator
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}
