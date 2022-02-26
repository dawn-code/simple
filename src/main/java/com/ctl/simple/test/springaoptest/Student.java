package com.ctl.simple.test.springaoptest;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class Student {

    public final void display() {
        System.out.println("I am a student");
    }
}
