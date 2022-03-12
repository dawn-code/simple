package com.ctl.simple.spi;

import java.util.ServiceLoader;

/**
 * SPI测试
 * <p>
 * ServiceLoader
 *
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