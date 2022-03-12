package com.ctl.simple.service.impl;

import com.ctl.simple.service.ServiceInitializer;

/**
 * @author Administrator
 */
public class DownLoadInitializer implements ServiceInitializer {
    @Override
    public void init() {
        System.out.println("下载功能初始化！");
    }
}
