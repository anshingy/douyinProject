package com.space.register.GuiViewController;

import com.space.register.GuiViewService.AccountManageService;
import com.space.register.GuiViewService.FollowAndDiggService;
import com.space.register.GuiViewService.impl.AccountManageServiceImpl;
import com.space.register.GuiViewService.impl.FollowAndDiggServiceImpl;

import javax.swing.*;

/**
* @Description: 关注和点赞的控制器
* @Author: Space
* @Date: 2018/9/22/022
*/
public class FollowAndDiggController {


    /**
     * 关注
     * @param dyid
     * @param userid
     * @param jTextArea
     */
    public static void follow(String dyid,String userid, JTextArea jTextArea) {
        FollowAndDiggService followAndDiggService = new FollowAndDiggServiceImpl();
        followAndDiggService.follow(dyid,userid, jTextArea);
    }

    /**
     * 点赞
     * @param dyid
     * @param videoId
     * @param log
     */
    public static void digg(String dyid, String videoId, JTextArea log) {
        FollowAndDiggService followAndDiggService = new FollowAndDiggServiceImpl();
        followAndDiggService.digg(dyid, videoId, log);
    }

    /**
     * 更改个人资料
     * @param dyid
     * @param videoId
     * @param log
     */
    public static void modify(String dyid, String videoId, JTextArea log) {
        FollowAndDiggService followAndDiggService = new FollowAndDiggServiceImpl();
        followAndDiggService.modify(dyid, log);
    }

    /**
     * applog前段调用
     * @param userid
     * @param log
     */
    public static void app_log(String userid, JTextArea log) {
        AccountManageService accountManageService = new AccountManageServiceImpl();
        accountManageService.appLog(userid, log);
    }


}
