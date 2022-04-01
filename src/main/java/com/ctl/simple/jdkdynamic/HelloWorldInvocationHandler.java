package com.ctl.simple.jdkdynamic;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 虽然是扩展增强，但是可以和接口无关性
 *
 * @author Jxr
 */
@Log4j2
public class HelloWorldInvocationHandler implements InvocationHandler {

    private final Object target;

    public HelloWorldInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Before invocation");
        Object retVal = method.invoke(target, args);
        log.info("After invocation");
        return retVal;
    }

}
