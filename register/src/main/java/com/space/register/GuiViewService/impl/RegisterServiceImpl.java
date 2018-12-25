package com.space.register.GuiViewService.impl;

import com.space.register.GuiViewService.RegisterService;
import com.space.register.controller.DeviceController;
import com.space.register.dao.DYUserRepository;
import com.space.register.dao.DeviceRepository;
import org.springframework.stereotype.Component;
import platform.email.HostIPGetter;
import platform.thread.RegisterThread;
import po.HostIPPo;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
* @Description: 注册层实现类
* @Author: Space
* @Date: 2018/9/22/022
*/
@Component
public class RegisterServiceImpl implements RegisterService {
    @Resource
    protected com.space.register.dao.DYUserRepository DYUserRepository;
    @Resource
    protected DeviceRepository deviceRepository;
    private static RegisterServiceImpl rs;

    public static int thread_num = RegisterThread.thread_num;

    Thread[] registerThreads =new Thread[thread_num];
    @PostConstruct
    public void init() {
        rs = this;
        rs.DYUserRepository = this.DYUserRepository;
        rs.deviceRepository = this.deviceRepository;
    }


    @Override
    public void beginRegister(JTextArea log, String api) {
        log.append("开始注册\n");
        log.append(api+"\n");
        if(!api.isEmpty()){
            api = api.substring(0,api.length()-1);
            HostIPGetter.ipHostGetter = api;
        }
        DeviceController.getNeedIPFromWeb(RegisterThread.hostIpQuene);
        if(!api.isEmpty()){
            HostIPGetter.ipHostGetter = api;
        }
        Thread[] registerThreads =new Thread[thread_num];
        for(int i=0;i<thread_num;i++){
            registerThreads[i] = new Thread(new RegisterThread(log));
            registerThreads[i].start();
        }
    }

    @Override
    public void stopRegister(JTextArea log) {
        log.append("停止注册\n");
        for(int i=0;i<thread_num;i++){
            registerThreads[i].interrupt();
        }
    }


}
