package platform.thread;

import com.space.register.configurer.OrderThreadDatabaseImpl;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.OrderEntity;
import po.HostIPPo;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: hehedada
 * @description: 线程点赞控制类
 * @author: Mr.gao
 * @create: 2018-10-21 20:40
 **/
public class BussinessControllerThread implements Runnable {

    public static LinkedBlockingQueue<HostIPPo> hostIpQuene = new LinkedBlockingQueue<HostIPPo>();
    public static LinkedBlockingQueue<OrderEntity> orderEntities = new LinkedBlockingQueue<>();
    //public static LinkedBlockingQueue<DYUserEntity> dyUserEntities = new LinkedBlockingQueue<>();
    public static OrderThreadDatabaseImpl orderThreadDatabase = new OrderThreadDatabaseImpl();
    public static int ThreadNum =5;
    @Override
    public void run() {
        orderThreadDatabase.getOrderListNew();
        Thread ipthread = new Thread(new IPThread(hostIpQuene));
        Thread orderThread = new Thread(new OrderGetterThread(orderEntities));
        //Thread dyUserThread = new Thread(new UserGetterThread(dyUserEntities));
        Thread[] businessThread = new Thread[ThreadNum];
        ipthread.start();
        orderThread.start();
        //dyUserThread.start();

        for (int i=0;i<ThreadNum;i++){
            businessThread[i] = new Thread(new BussinessThread());

        }
        for(int i=0;i<ThreadNum;i++){
            businessThread[i].start();
        }
    }
}
