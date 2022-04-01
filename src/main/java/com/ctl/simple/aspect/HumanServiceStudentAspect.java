package com.ctl.simple.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Jxr
 */
@Log4j2
@Aspect
@Component
public class HumanServiceStudentAspect {

    /**
     * 为Student这个类的所有方法，配置这个前置通知
     */
    @Before("execution(* com.ctl.simple.aspect.HumanServiceStudent.*(..))")
    public void before() {
        log.info("我是人类");
    }
}
