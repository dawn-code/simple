package com.ctl.simple;

public class TheadLocalTest {

    static  ThreadLocal<String> str = new ThreadLocal<>();

    public static void main(String[] args) {
        str.set("a");
        str.set("b");
        str.get();
    }
}
