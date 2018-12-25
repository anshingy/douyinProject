package com.space.register.GuiViewService;

import javax.swing.*;

/**
* @Description: 注册服务层接口
* @Author: Space
* @Date: 2018/9/22/022
*/
public interface RegisterService {

    /**
     * 注册抖音账号的实现
     * @param log
     */
    void beginRegister(JTextArea log, String api);

    /**
     * 停止注册的接口
     * @param log
     */
    void stopRegister(JTextArea log);
}
