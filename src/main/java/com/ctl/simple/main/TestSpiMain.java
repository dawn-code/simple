package com.ctl.simple.main;

import com.ctl.simple.service.ServiceInitializer;

import java.util.ServiceLoader;

/**
 * @author Administrator
 */
public class TestSpiMain {

    public static void main(String[] args) {
        ServiceLoader<ServiceInitializer> initializers = ServiceLoader.load(ServiceInitializer.class);
        for (ServiceInitializer initializer : initializers) {
            initializer.init();
        }
    }
}