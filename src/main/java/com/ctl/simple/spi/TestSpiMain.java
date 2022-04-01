package com.ctl.simple.spi;

import java.util.ServiceLoader;

/**
 * SPI测试
 * <p>
 * ServiceLoader
 *
 * @author Jxr
 */
public class TestSpiMain {

    public static void main(String[] args) {
        ServiceLoader<InitializerService> initializers = ServiceLoader.load(InitializerService.class);
        for (InitializerService initializer : initializers) {
            initializer.init();
        }
    }
}