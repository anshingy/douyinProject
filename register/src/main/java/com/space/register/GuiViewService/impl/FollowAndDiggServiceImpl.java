package com.space.register.GuiViewService.impl;

import com.space.register.GuiViewService.FollowAndDiggService;
import com.space.register.dao.DYUserRepository;
import com.space.register.dao.DeviceRepository;
import com.space.register.dao.UrlRequestRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.entity.UrlRequestEntity;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import params.FollowMaker;
import params.ModifyInfoMaker;
import params.ThumbsUpMaker;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * 点赞实现的service层
 */
@Component
public class FollowAndDiggServiceImpl implements FollowAndDiggService {

    @Resource
    protected DYUserRepository DYUserRepository;
    @Resource
    protected DeviceRepository deviceRepository;
    @Resource
    protected UrlRequestRepository urlRequestRepository;
    private static FollowAndDiggServiceImpl fad;

    private static String session_id;

    @PostConstruct
    public void init() {
        fad = this;
        fad.DYUserRepository = this.DYUserRepository;
        fad.deviceRepository = this.deviceRepository;
        fad.urlRequestRepository = this.urlRequestRepository;
    }


    @Override
    public void follow(String dyid, String userid, JTextArea textLog) {

        //这个是视频id，需要参数传入

        System.out.println(dyid);
        System.out.println(userid);
        DYUserEntity dyUserEntity = fad.DYUserRepository.findById(Integer.parseInt(dyid));
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = fad.deviceRepository.getDeviceMsgById(Integer.parseInt(simulationId));


        //获取并构建url信息，包括host、msg、token
        UrlRequestEntity urlRequestEntity = fad.urlRequestRepository.findUrlById(4);

        OkHttpClient okHttpClient = new OkHttpClient();
        ArrayList <String> output = FollowMaker.FollowMaker(okHttpClient, userid, dyUserEntity, deviceEntity);
        System.out.println(output.size());

        textLog.append("-----关注id:" + userid + "----- 抖音号数据库id:"+ dyid + "-----\n");
        textLog.append(output.get(0) + "\n");
        textLog.append(output.get(1) + "\n");

    }

    @Override
    public void digg(String dyid, String videoId, JTextArea textLog) {


        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = fad.DYUserRepository.findById(Integer.parseInt(dyid));
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = fad.deviceRepository.getDeviceMsgById(Integer.parseInt(simulationId));

        OkHttpClient okHttpClient = new OkHttpClient();
        ArrayList<String> output = ThumbsUpMaker.thumbsUpMaker(okHttpClient, videoId, deviceEntity, dyUserEntity);

        textLog.append("-----点赞id:" + videoId + "----- 抖音号数据库id:"+ dyid + "-----\n");
        textLog.append(output.get(0) + "\n");
    }

    @Override
    public void modify(String dyid, JTextArea textLog){

        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = fad.DYUserRepository.findById(Integer.parseInt(dyid));
        String user_cookie = dyUserEntity.getUserCookie();
        String simulationId = dyUserEntity.getSimulationID();
        String uid = dyUserEntity.getUid();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = fad.deviceRepository.getDeviceMsgById(Integer.parseInt(simulationId));
        String cookie = deviceEntity.getCookie();
        cookie += (";"+ user_cookie);
        deviceEntity.setCookie(cookie);

        //获取并构建url信息，包括host、msg、token
        UrlRequestEntity urlRequestEntity1 = fad.urlRequestRepository.findUrlById(5);


        UrlRequestEntity urlRequestEntity2 = fad.urlRequestRepository.findUrlById(8);

        OkHttpClient okHttpClient = new OkHttpClient();
        String id = ModifyInfoMaker.modifyInfoMaker(okHttpClient, uid, deviceEntity, urlRequestEntity1, urlRequestEntity2);

        textLog.append("-----Modify----- 抖音号数据库id:"+ dyid + "-----\n");
        textLog.append("short:"+ id + "\n");
    }


    public static String MapToString(Map map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "=" ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? ";" : "");
        }
        return sb.toString();
    }

}
