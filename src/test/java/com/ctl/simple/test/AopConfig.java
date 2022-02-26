package com.ctl.simple.test;

import com.ctl.simple.test.springaoptest.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "com.ctl.simple.test")
@EnableAspectJAutoProxy
public class AopConfig {


    @Test
    public void testProxy() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        // 注意，这里只能通过Human.class获取，而无法通过Student.class，因为在Spirng容器中，
        // 使用JDK动态代理，Ioc容器中，存储的是一个类型为Human的代理对象
        Student human = context.getBean(Student.class);
        human.display();
        // 输出代理类的父类，以此判断是JDK还是CGLib
        System.out.println(human.getClass().getSuperclass());
        System.out.println(human.getClass());
    }
}