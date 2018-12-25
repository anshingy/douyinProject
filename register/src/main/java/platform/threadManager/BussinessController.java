package platform.threadManager;

import com.space.register.configurer.OrderThreadDatabaseImpl;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.OrderEntity;
import platform.email.HostIPGetter;
import platform.thread.BussinessThread;
import platform.thread.RegisterThread;
import po.HostIPPo;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: protool
 * @description: 控制点赞线程组的实现类
 * @author: Mr.gao
 * @create: 2018-09-27 17:28
 **/
public class BussinessController {

//    public static LinkedBlockingQueue<HostIPPo> hostIpQueneForBusiness = new LinkedBlockingQueue<HostIPPo>();
//
//    public static ArrayList<DYUserEntity> dyUserEntities = new ArrayList<DYUserEntity>();
//    public static long beginTime;
//    //1代表需要点赞的订单，0代表已完成的订单，-1代表异常订单,3表示正在被执行的订单
//    public static String orderStatus ="1";
//    //单个线程分配的订单数量
//    public static int orderNumber = 10;
//    OrderThreadDatabaseImpl orderThreadDatabase = new OrderThreadDatabaseImpl();
//    public void doBusinessWork(){
//        ArrayList<OrderEntity> orderEntitiess = orderThreadDatabase.getAllOrder(orderStatus);
//        int lessId =0;
//        int number = 0;
//        BussinessThread.getNeedIPFromWeb(BussinessController.hostIpQueneForBusiness);
//        int threadNum = orderEntitiess.size()/orderNumber;
//        if(orderEntitiess.size()%orderNumber!=0){
//            threadNum++;
//        }
//        //###############
//        threadNum =1;
//
//        Thread[] threads = new Thread[threadNum];
//        //beginTime = System.currentTimeMillis();
//        for(int i =0;i<threadNum;i++){
//            ArrayList<OrderEntity> orderEntities1 = new ArrayList<OrderEntity>();
//            for(int k=0;k<orderNumber;k++){
//                if(!orderEntitiess.isEmpty()){
//                    OrderEntity orderEntity = orderEntitiess.remove(0);
//                    orderEntities1.add(orderEntity);
//                    if(orderEntity.getLangestDYId()>lessId){
//                        lessId = orderEntity.getLangestDYId();
//                    }
//                    if(orderEntity.getThumbUpOrFollowNum()>number){
//                        number = (int) (orderEntity.getThumbUpOrFollowNum()*1.5);
//                    }
//                }
//                else{
//                    break;
//                }
//            }
//            dyUserEntities = orderThreadDatabase.getNumsUser(lessId,number);
//            lessId =0;
//            number =0;
//            threads[i] = new Thread(new BussinessThread(orderEntities1,dyUserEntities));
//            threads[i].start();
//        }
//    }

}
