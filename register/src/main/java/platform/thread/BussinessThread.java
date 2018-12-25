package platform.thread;

import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.entity.OrderEntity;
import okhttp3.OkHttpClient;
import platform.threadManager.MoneyGetter;
import po.HostIPPo;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: protool
 * @description: 实现盈利业务的线程实现
 * @author: Mr.gao
 * @create: 2018-09-27 15:12
 **/
public class BussinessThread implements Runnable {

    public static int oneIpThumbUp = 17;
    public static int orderNums = 4;
    public static int onceUserNum = 35;
    public ArrayList<OrderEntity> orderEntitiess = new ArrayList<>();
    public ArrayList<DYUserEntity> dyUserEntitiess = new ArrayList<>();
    public LinkedBlockingQueue<DYUserEntity> dyUserEntities = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        Thread dyUserThread = new Thread(new UserGetterThread(dyUserEntities));
        dyUserThread.start();
        OkHttpClient okHttpClient = changeOkHttpHost();
        DYUserEntity dyUserEntity = null;
        DeviceEntity deviceEntity = null;
        OrderEntity orderEntity;
        int ipInfo = 0;
        do{

            while(orderEntitiess.size()<orderNums){
                if(BussinessControllerThread.orderEntities.size()!=0){
                    try {
                        orderEntitiess.add(BussinessControllerThread.orderEntities.take());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
            while(dyUserEntitiess.size()<onceUserNum){
                try {
                    dyUserEntitiess.add(dyUserEntities.take());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            if(orderEntitiess.size()>0){
                System.out.println("该线程抢到订单数量为"+orderEntitiess.size());
                for(int k=0;k<onceUserNum;k++){
                    try {
                        if(dyUserEntitiess.size()>0){
                            dyUserEntity = dyUserEntitiess.remove(0);
                        }else{
                            break;
                        }


                        deviceEntity = BussinessControllerThread.orderThreadDatabase.getDeviceByID(Integer.parseInt(dyUserEntity.getSimulationID()));

                    } catch (Exception e) {
                        System.out.println("线程获取用户失败了");
                        e.printStackTrace();
                    }
                    for(int i = 0; i< orderEntitiess.size(); i++){
                        //System.out.println("靠跑啊");
                        orderEntity = orderEntitiess.get(i);
                        try {
                            if(MoneyGetter.makeThumbUpAndFollow(okHttpClient,deviceEntity,dyUserEntity,orderEntity)){
                                System.out.println("订单点赞完成");
                                orderEntitiess.remove(i);

                                break;
                            }
                            ipInfo++;
                            if(ipInfo>=oneIpThumbUp){
                                System.out.println("###########################进行ip更换操作");
                                okHttpClient = changeOkHttpHost();
                                ipInfo =0;
                            }
                            System.out.println("用户电话为:"+dyUserEntity.getId());
                            System.out.println("订单号为:"+orderEntity.getVideoID());
                            Thread.sleep(2000);
                        }catch (Exception e){
                            System.out.println("点赞过程中出错");
                            okHttpClient = changeOkHttpHost();
                            ipInfo =0;
                            e.printStackTrace();
                        }
                    }
                    BussinessControllerThread.orderThreadDatabase.saveDyUser(dyUserEntity);
                }

            }else{
                continue;
            }
            //异常用户暂时保留
//            if(userNum>=dyUserEntities.size()){
//                System.out.println("用户使用完毕");
//                for(OrderEntity orderEntity1:orderEntitiess){
//                    orderEntity1.setStatus("-1");
//                    orderThreadDatabase.updataOrderInfo(orderEntity1);
//                }
//                for(DYUserEntity dyUserEntity1:dyUserEntities){
//                    orderThreadDatabase.saveDyUser(dyUserEntity1);
//                }
//                break;
//            }

            ;
        }while (true);
    }
    //修改okhttp代理的方法
    public static OkHttpClient changeOkHttpHost(){
        HostIPPo hostIPPo;
        try {
            hostIPPo = BussinessControllerThread.hostIpQuene.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return changeOkHttpHost();
        }
        OkHttpClient okHttpClient;
        {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
                    .connectTimeout(60,TimeUnit.SECONDS)//设置连接超时时间
                    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostIPPo.host, hostIPPo.port)))
                    .build();
        }
        return okHttpClient;
    }

    public static void main(String[]args){

    }

}
