package com.space.register.entity;

import javax.persistence.*;

/**
 * @program: protool
 * @description: 订单存储实体类，用来存储需要点赞或者关注的订单
 * @author: Mr.gao
 * @create: 2018-09-25 15:42
 **/
@Entity
@Table(name = "t_dy_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderNumber; // 订单号

    private String videoID; // 视频id

    private int thumbUpOrFollowNum; // 点赞数

    private String status; // 订单状态

    private String types; // 订单类型

    public int langestDYId;

    public int getLangestDYId() {
        return langestDYId;
    }

    public void setLangestDYId(int langestDYId) {
        this.langestDYId = langestDYId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public int getThumbUpOrFollowNum() {
        return thumbUpOrFollowNum;
    }

    public void setThumbUpOrFollowNum(int thumbUpOrFollowNum) {
        this.thumbUpOrFollowNum = thumbUpOrFollowNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", OrderNumber='" + orderNumber + '\'' +
                ", videoID='" + videoID + '\'' +
                ", thumbUpOrFollowNum=" + thumbUpOrFollowNum +
                ", status='" + status + '\'' +
                ", types='" + types + '\'' +
                '}';
    }
}
