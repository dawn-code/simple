package com.ctl.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ctl
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.ctl.simple.mapper")
public class SimpleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SimpleApplication.class, args);
    }

}
