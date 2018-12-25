package com.space.register.GuiViewService;

import javax.swing.*;
import java.awt.*;

/**
* @Description: 关注点赞接口
* @Author: Space
* @Date: 2018/9/22/022
*/
public interface FollowAndDiggService {

    /**
     * 关注的接口
     * @param userid
     * @param textLog
     */
    void follow(String dyid,String userid, JTextArea textLog);

    /**
     * 点赞的接口
     * @param dyid
     * @param videoId
     * @param log
     */
    void digg(String dyid, String videoId, JTextArea log);

    /**
     * 修改信息的接口
     * @param dyid
     * @param log
     */
    void modify(String dyid, JTextArea log);

}
