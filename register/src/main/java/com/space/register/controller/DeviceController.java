package com.space.register.controller;

import com.space.register.dao.DYUserRepository;
import com.space.register.dao.DeviceRepository;
import com.space.register.service.DeviceService;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.email.HostIPGetter;
import platform.thread.RegisterThread;
import platform.threadManager.BussinessController;
import po.HostIPPo;

import javax.annotation.Resource;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    DeviceService deviceService;

    @Resource
    DeviceRepository deviceRepository;

    @Resource
    DYUserRepository dyUserRepository;
    public static int thread_num = RegisterThread.thread_num;

    @RequestMapping("/maker")
    public String deviceMain(){
//        BussinessController bussinessController =new BussinessController();
//        bussinessController.doBusinessWork();
        getNeedIPFromWeb(RegisterThread.hostIpQuene);
        Thread[] registerThreads =new Thread[thread_num];
        for(int i=0;i<thread_num;i++){
            registerThreads[i] = new Thread(new RegisterThread(new JTextArea()));
            registerThreads[i].start();
        }
        //切换
//        RegisterThread registerThread = new RegisterThread();
//        try {
//            for (int i =0;i<4;i++){
//                registerThread.oneUserInfo("",0);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        return "呵呵哒哒";
    }

    public static void getNeedIPFromWeb(LinkedBlockingQueue<HostIPPo> hostIpQuene){
        ArrayList<HostIPPo> hostIPPos = HostIPGetter.getIpByXdali(5);
        if(hostIpQuene.size()>RegisterThread.thread_num*2-1){
            return;
        }
        if(hostIPPos == null){
            System.out.println("IP用完了，结束线程");
            return;
        }
        for(HostIPPo hostIPPo:hostIPPos){
            try {
                hostIpQuene.put(hostIPPo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(hostIpQuene.size()<RegisterThread.thread_num*2-1){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getNeedIPFromWeb(hostIpQuene);
        }
    }
}
//    ArrayList<DYUserEntity> dyUserEntities1 = dyUserRepository.findAll();
//    ArrayList<DYUserEntity> dyUserEntities = new ArrayList<>();
//        System.out.println(dyUserEntities.size());
//                for(DYUserEntity dyUserEntity:dyUserEntities1){
//                if(dyUserEntity.getId()>=143){
//                dyUserEntities.add(dyUserEntity);
//                }
//                }
//                System.out.println(dyUserEntities.size());
//                try {
//                Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                e.printStackTrace();
//                }
//                DeviceEntity deviceEntity = null;
//                DYUserEntity dyUserEntity =null;
//                int count =0;
//                int num = 1;
//                while (num<dyUserEntities.size()) {
//        HostIPPo hostIPPo = HostIPGetter.getIpByXdali(1).get(0);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//        .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
//        .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
//        .connectTimeout(60, TimeUnit.SECONDS)//设置连接超时时间
//        .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostIPPo.host, hostIPPo.port)))
//        .build();
//        count++;
//        System.out.println("用掉IP数量为：" + count);
//        for (int i = 0; i < 10; i++) {
//        dyUserEntity = dyUserEntities.get(num);
//        num++;
//        if(num>dyUserEntities.size()){
//        break;
//        }
//        deviceEntity = deviceRepository.getOne(Integer.parseInt(dyUserEntity.getSimulationID()));
//        Request request = UserPowerGetter.getAppLogs(dyUserEntity, deviceEntity);
//        try {
//        Response response = okHttpClient.newCall(request).execute();
//        System.out.println(GzipGetteer.uncompressToString(response.body().bytes()));
//        dyUserEntity.setLikePower(0);
//        dyUserRepository.save(dyUserEntity);
//        } catch (IOException e) {
//        e.printStackTrace();
//        break;
//        }
//        System.out.println(deviceEntity.getId() + " 号被解封");
//
//        }
//
//        }