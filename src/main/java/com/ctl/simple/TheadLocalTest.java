package com.ctl.simple;

public class TheadLocalTest {

    static  ThreadLocal<String> str = new ThreadLocal<>();

    static void main() {
        str.set("a");
        str.set("b");
        str.get();
        System.out.println("abc");
    }
}
