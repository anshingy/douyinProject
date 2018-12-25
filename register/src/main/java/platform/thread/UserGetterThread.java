package platform.thread;

import com.space.register.entity.DYUserEntity;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: hehedada
 * @description:
 * @author: Mr.gao
 * @create: 2018-10-21 20:58
 **/
public class UserGetterThread implements Runnable{
    public static int lessId = 41000;
    public static int dyUserNum = 3000;
    public static int AlldyUserNum = 0;
    public static LinkedBlockingQueue linkedBlockingQueue;

    public UserGetterThread(LinkedBlockingQueue linkedBlockingQueue){
        this.linkedBlockingQueue = linkedBlockingQueue;
        AlldyUserNum = BussinessControllerThread.orderThreadDatabase.getUserNum();
    }

    @Override
    public void run() {
        int nowID = lessId;
        while (true){
            if(linkedBlockingQueue.size()<dyUserNum){
                if(nowID>=AlldyUserNum){
                    nowID = lessId;
                }
                ArrayList<DYUserEntity> dyUserEntities = BussinessControllerThread.orderThreadDatabase.getNumsUser(nowID,dyUserNum);
                for(DYUserEntity dyUserEntity:dyUserEntities){
                    try {
                        linkedBlockingQueue.put(dyUserEntity);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                nowID+= dyUserEntities.size();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
