package com.ctl.simple.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 虽然是扩展增强，但是可以和接口无关性
 *
 * @author Administrator
 */
public class CustomInvocationHandler implements InvocationHandler {

    private Object target;

    public CustomInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invocation");
        Object retVal = method.invoke(target, args);
        System.out.println("After invocation");
        return retVal;
    }

}
