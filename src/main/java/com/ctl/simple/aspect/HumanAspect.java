package com.ctl.simple.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Aspect
@Component
public class HumanAspect {
    //

    /**
     *  为Student这个类的所有方法，配置这个前置通知
     */
    @Before("execution(* com.ctl.simple.aspect.Student.*(..))")
    public void before() {
        System.out.println("before student");
    }
}
