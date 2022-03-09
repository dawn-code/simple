package com.ctl.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/**
 * @author ctl
 */
//@EnableSwagger2
//@SpringBootApplication
@MapperScan("com.ctl.simple.mapper")
public class SimpleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SimpleApplication.class, args);
    }

}
