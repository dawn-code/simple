package com.ctl.simple.spi;

/**
 * @author Administrator
 */
public class UploadInitializer implements ServiceInitializer {
    @Override
    public void init() {
        System.out.println("上传功能初始化！");
    }
}