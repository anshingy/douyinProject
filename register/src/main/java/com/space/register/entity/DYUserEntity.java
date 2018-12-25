package com.space.register.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: protool
 * @description: 某应用账户信息存储类
 * @author: Mr.gao
 * @create: 2018-09-02 11:41
 **/

@Entity
@Table(name = "t_dy_user")
public class DYUserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phoneNum;

    private String phoneArea;

    private String password;

    private String simulationID;

    private String belong;

    @Column(columnDefinition = "text")

    private String userCookie;

    private String uid;

    @Column(columnDefinition = "text")
    private String appLog;

    private int like_power;

    private int event_id;
    // 0或空表示还未被使用，1表示该用户已在当前轮次内使用
    private int used_turn;

    private String registerDate;

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getUsed_turn() {
        return used_turn;
    }

    public void setUsed_turn(int used_turn) {
        this.used_turn = used_turn;
    }

    public String getAppLog() {
        return appLog;
    }

    public void setAppLog(String appLog) {
        this.appLog = appLog;
    }

    public int getLike_power() {
        return like_power;
    }

    public void setLike_power(int like_power) {
        this.like_power = like_power;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneArea() {
        return phoneArea;
    }

    public void setPhoneArea(String phoneArea) {
        this.phoneArea = phoneArea;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSimulationID() {
        return simulationID;
    }

    public void setSimulationID(String simulationID) {
        this.simulationID = simulationID;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getUserCookie() {
        return userCookie;
    }

    public void setUserCookie(String userCookie) {
        this.userCookie = userCookie;
    }

    @Override
    public String toString() {
        return "DYUserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", phoneArea='" + phoneArea + '\'' +
                ", password='" + password + '\'' +
                ", simulationID='" + simulationID + '\'' +
                ", belong='" + belong + '\'' +
                ", userCookie='" + userCookie + '\'' +
                ", uid='" + uid + '\'' +
                ", appLog='" + appLog + '\'' +
                ", like_power=" + like_power +
                ", event_id=" + event_id +
                '}';
    }

}
