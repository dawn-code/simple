package com.ctl.simple.service.impl;

import com.ctl.simple.service.ServiceInitializer;

/**
 * @author Administrator
 */
public class UploadInitializer implements ServiceInitializer {
    @Override
    public void init() {
        System.out.println("上传功能初始化！");
    }
}