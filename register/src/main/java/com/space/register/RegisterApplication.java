package com.space.register;

import com.space.register.GuiView.JavaApplication1.src.guiview.JFrame.MainFrame;
import com.space.register.configurer.OrderThreadDatabaseImpl;
import com.space.register.configurer.RegisterThreadDatabaseImpl;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.entity.OrderEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.threadManager.BussinessController;

@SpringBootApplication
public class RegisterApplication {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                SpringApplication.run(RegisterApplication.class, args);
                //getTestOrder();
                //RegisterThreadDatabaseImpl registerThreadDatabase = new RegisterThreadDatabaseImpl();
            }
        });
//        SpringApplication.run(RegisterApplication.class, args);

    }
    public static void getTestOrder(){
        OrderThreadDatabaseImpl orderThreadDatabase = new OrderThreadDatabaseImpl();
        for(int i =0;i<1000;i++){
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setStatus("1");
            int lessId = 0;
            orderEntity.setLangestDYId(lessId);
            int lessIdDou = (int) (Math.random()*1000);
            orderEntity.setThumbUpOrFollowNum(lessIdDou);
            orderEntity.setTypes("dydz100");
            orderThreadDatabase.updataOrderInfo(orderEntity);
        }
        System.out.println("添加测试用订单完毕");
    }
}