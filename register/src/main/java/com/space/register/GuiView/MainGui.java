package com.space.register.GuiView;

import com.space.register.GuiView.JavaApplication1.src.guiview.panel.FollowPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Auther: Administrator
 * @Date: 2018/9/21/021 21:59
 * @Description:
 */
public class MainGui {
    private JButton registerButton;
    private JPanel register;
    private JButton diggButton;
    private JButton followButton;
    private JPanel mainPanel;
    private JPanel buttonPanel;



    public MainGui() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("注册");
            }
        });
        followButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FollowPanel followPanel = new FollowPanel();
                mainPanel = null;
                System.out.println("关注");
            }
        });
        diggButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点赞");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainGui");
        frame.setContentPane(new MainGui().register);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


    }
}
