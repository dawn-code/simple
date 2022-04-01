package com.ctl.simple.aspect;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/simple")
@SpringBootApplication
@EnableAspectJAutoProxy
public class HumanServiceStudentAspectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanServiceStudentAspectApplication.class, args);
    }

    @Autowired
    HumanService humanServiceStudent;

    @GetMapping("/getStudent")
    public void getHumanServiceStudent() {
        log.info("request simple get interface");
        humanServiceStudent.display();
    }

}
