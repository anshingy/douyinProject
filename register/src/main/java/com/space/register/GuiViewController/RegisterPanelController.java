package com.space.register.GuiViewController;

import com.space.register.GuiViewService.RegisterService;
import com.space.register.GuiViewService.impl.RegisterServiceImpl;

import javax.swing.*;

/**
* @Description: 注册面板的控制层
* @Author: Space
* @Date: 2018/9/22/022
*/
public class RegisterPanelController {

    /**
     * 开始注册监听
     * @param log
     */
    public static void beginRegister(JTextArea log, String api) {
        RegisterService registerService = new RegisterServiceImpl();
        registerService.beginRegister(log, api);

    }

    /**
     * 停止注册
     * @param log
     */
    public static void stopRegister(JTextArea log) {
        RegisterService registerService = new RegisterServiceImpl();
        registerService.stopRegister(log);
    }
}
