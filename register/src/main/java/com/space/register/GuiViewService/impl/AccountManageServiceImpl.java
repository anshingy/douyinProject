package com.space.register.GuiViewService.impl;

import com.space.register.GuiViewService.AccountManageService;
import com.space.register.dao.DeviceRepository;
import com.space.register.dao.UrlRequestRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import org.openqa.selenium.remote.internal.OkHttpClient;
import org.springframework.stereotype.Component;
import params.AllAppLogConstruct;
import params.AppLogMaker;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.util.ArrayList;

/**
* @Description: 注册层实现类
* @Author: Space
* @Date: 2018/9/22/022
*/
@Component
public class AccountManageServiceImpl implements AccountManageService {
    @Resource
    protected com.space.register.dao.DYUserRepository DYUserRepository;
    @Resource
    protected DeviceRepository deviceRepository;
    @Resource
    protected UrlRequestRepository urlRequestRepository;
    private static AccountManageServiceImpl ams;

    @PostConstruct
    public void init() {
        ams = this;
        ams.DYUserRepository = this.DYUserRepository;
        ams.deviceRepository = this.deviceRepository;
        ams.urlRequestRepository = this.urlRequestRepository;
    }


    @Override
    public void appLog(String dyid, JTextArea textLog) {


        DYUserEntity dyUserEntity = ams.DYUserRepository.findById(Integer.parseInt(dyid));
        String simulationId = dyUserEntity.getSimulationID();


        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = ams.deviceRepository.getDeviceMsgById(Integer.parseInt(simulationId));

        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient();
        //String text = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, String.valueOf(System.currentTimeMillis() - 36000));

        //注册帐号前需要加载appLog
        //随机生成的session_id
        String session_id = AllAppLogConstruct.constructRandomSessionId();
        ArrayList<String> launch_body_msg = AllAppLogConstruct.launchApp(dyUserEntity.getAppLog(), session_id, dyUserEntity.getEvent_id());
        //修改全部变量event_id
        int event_id = Integer.valueOf(launch_body_msg.get(0));
        //修改数据库中event_id的值
        dyUserEntity.setEvent_id(event_id);
        //修改全局变量serverTime
        String launch_result = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, launch_body_msg.get(1));
        System.out.println("加载app结果：" + launch_result);

        //下面的是注册账号完成时发送的appLog
        //sendCodeTime是sendcode请求的ticket，纯数字格式
        String sendCodeTime =String.valueOf(System.currentTimeMillis() - 12000);
        String serverTime = String.valueOf(Long.parseLong(sendCodeTime) - 12000);
        ArrayList<String> register_body_msg = AllAppLogConstruct.register(dyUserEntity.getAppLog(), AllAppLogConstruct.constructRandomSessionId(), dyUserEntity.getEvent_id(), String.valueOf(serverTime), sendCodeTime, dyUserEntity.getUid());
        //修改数据库中event_id的值

        dyUserEntity.setEvent_id(Integer.valueOf(register_body_msg.get(0)));
        //修改全局变量serverTime
        String register_result = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, register_body_msg.get(1));
        System.out.println("注册账号结果：" + register_result);
        textLog.append("-----AppLog----- 抖音号数据库id:"+ dyid + "-----\n");
        textLog.append(register_result + "\n");
    }

}
