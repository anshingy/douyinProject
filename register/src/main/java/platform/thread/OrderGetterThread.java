package platform.thread;

import com.space.register.entity.OrderEntity;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: hehedada
 * @description: 订单获取线程
 * @author: Mr.gao
 * @create: 2018-10-21 20:52
 **/
public class OrderGetterThread implements Runnable {

    public static String orderStatus ="1";
    public static LinkedBlockingQueue linkedBlockingQueue;
    public OrderGetterThread(LinkedBlockingQueue linkedBlockingQueue){
        this.linkedBlockingQueue = linkedBlockingQueue;
    }
    @Override
    public void run() {
        while (true){
            ArrayList<OrderEntity> orderEntities = BussinessControllerThread.orderThreadDatabase.getAllOrder(orderStatus);
            for(OrderEntity orderEntity:orderEntities){
                try {
                    linkedBlockingQueue.put(orderEntity);
                } catch (InterruptedException e) {
                    System.out.println("插入订单过程中出现错误");
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
