package platform.thread;

import platform.email.HostIPGetter;
import po.HostIPPo;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: hehedada
 * @description: 持续获取ip的线程实现
 * @author: Mr.gao
 * @create: 2018-10-18 21:03
 **/
public class IPThread implements Runnable {

    public static LinkedBlockingQueue linkedBlockingQueue;
    public IPThread(){
        linkedBlockingQueue = RegisterThread.hostIpQuene;
    }
    public IPThread(LinkedBlockingQueue linkedBlockingQueue){
        this.linkedBlockingQueue =linkedBlockingQueue;
    }
    @Override
    public void run() {
        while (true){
            ArrayList<HostIPPo> hostIPPos = HostIPGetter.getIpByXdali(5);
            for(HostIPPo hostIPPo:hostIPPos){
                try {
                    linkedBlockingQueue.put(hostIPPo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
