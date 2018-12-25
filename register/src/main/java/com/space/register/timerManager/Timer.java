package com.space.register.timerManager;

import com.google.gson.Gson;
import com.space.register.dao.OrderRepository;
import com.space.register.entity.OrderEntity;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: register
 * @description: 定时器
 * @author: Mr.Jia
 * @create: 2018-10-07 19:01
 **/
@Component
public class Timer extends Thread{

    @Resource
    OrderRepository orderRepository;

    // 服务启动的时候自动加载
    @PostConstruct
    public void init() {
        this.start();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final long timeInterval = 20000;
        final String url = "http://192.168.0.108:8888/api/order/getOrderListByService?key=SsPpQqZz";

        //下面请求从平台读取可插入订单
        while (true) {

            //下面用于请求url获取可插入订单
            Request.Builder builder = new Request.Builder();
            builder.url(url);
            Request request = builder.get().build();
            OkHttpClient okHttpClient=new OkHttpClient();
            Call call = okHttpClient.newCall(request);
            String result = "";
            try {
                Response response = call.execute();
                result = response.body().string();
                //System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String []status = result.split("\"status\"");
            int judge = 0;
            if(status.length == 3){
                for(int i = 1; i < status.length;i++){
                    char []tempArray = status[i].toCharArray();
                    for(int j = 0;j < tempArray.length;j++){
                        if (Character.isDigit(tempArray[j]) && tempArray[j] != '0'){
                            i = status.length;
                            judge = 1;
                            break;
                        }
                    }
                }
            }else {
                judge = 1;
            }

            ArrayList<OrderEntity> orderEntityList = new ArrayList<>();
            Gson gson = new Gson();
            Map<Object, Object> map = new HashMap<Object, Object>();
            if(judge == 0){
                String context = result.split("\\[")[1].split("]")[0];
                String []temp = context.split("},\\{");
                ArrayList<String> contextList = new ArrayList<>();

                contextList.add(temp[0] + "}");
                for(int i = 1;i < temp.length - 1;i++){
                    contextList.add("{" + temp[i] + "}");
                }
                contextList.add("{" + temp[temp.length - 1]);

                for(int i = 0;i < contextList.size();i++){
                    map =  gson.fromJson(contextList.get(i), map.getClass());
                    OrderEntity orderEntity = new OrderEntity();

                    for (Map.Entry<Object, Object> entry : map.entrySet()) {
                        String videoId = "";
                        orderEntity.setStatus("1");
                        if(entry.getKey().equals("orderNumber")){
                            orderEntity.setOrderNumber((String) entry.getValue());
                        }
                        if(entry.getKey().equals("videoId")){
                            videoId = (String) entry.getValue();
                            orderEntity.setVideoID(videoId);
                        }
                        if(entry.getKey().equals("operaCount")){
                            String str = String.valueOf(entry.getValue());
                            orderEntity.setThumbUpOrFollowNum(Integer.parseInt(str.split("\\.")[0]));
                        }
                        if(entry.getKey().equals("goodsType")){
                            orderEntity.setTypes((String) entry.getValue());
                        }

                        ArrayList<OrderEntity> tempOrderEntity = orderRepository.findByNum(videoId);

                        int max = 0;
                        if(tempOrderEntity != null){
                            for(int j = 0;j < tempOrderEntity.size();j++){
                                if(tempOrderEntity.get(j).getLangestDYId() > max){
                                    max = tempOrderEntity.get(j).getLangestDYId();
                                }
                            }
                            orderEntity.setLangestDYId(max);
                        }else {
                            orderEntity.setLangestDYId(max);
                        }
                    }
                    orderEntityList.add(orderEntity);
                }
            }else {
                System.out.println("暂无可插入订单");
            }
            orderRepository.saveAll(orderEntityList);
            if(judge == 0){
                System.out.println("成功插入"+orderEntityList.size()+"个新订单");
            }
            //线程睡眠
            try {
                sleep(timeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
