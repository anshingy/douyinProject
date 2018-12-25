package com.space.register.GuiViewController;

import com.space.register.GuiView.JavaApplication1.src.guiview.panel.RegisterPanel;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 主面板跳转controller
 *
 */
public class MainGuiViewController {


    public static List<JPanel> panels;

    public static RegisterPanel registerPanel;

    public MainGuiViewController(){
        panels = new ArrayList<>();
        registerPanel = new RegisterPanel();
        panels.add(registerPanel);
    }

    /**
     *
     * @param type
     * @param mainPanel
     */
    public void setMainPanel(int type, JPanel mainPanel) {
       mainPanel.add(panels.get(type));
    }


}
