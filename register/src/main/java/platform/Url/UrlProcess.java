package platform.Url;

import httpmaker.ConstructRequest;
import jsonreader.tools.GzipGetteer;
import okhttp3.*;
import po.RequestTokenVo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: protool
 * @description: url的传递和获取
 * @author: Mr.gao
 * @create: 2018-09-06 14:34
 **/
public class UrlProcess {

    public static void main(String[] args) {
        String []host_list = {"host1", "host2", "host3"};
        String []port_list = {"port1", "port2", "port3"};
        String []vpnNume_list = {"VPN1", "VPN2", "VPN3"};
        for(int i = 0;i < 3; i++){
            storeUrlMsg(host_list[i], port_list[i], vpnNume_list[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int i = 3;
        while ( i >= 0){
            System.out.println(getUrlMsg());
            i --;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //发送到192.168.0.109来存储一个host和port
    public static void storeUrlMsg(String host, String port, String vpnNum){

        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl("http://192.168.0.109:8887/main/get?host="+host+"&"+"port="+port+"&"+"vpnNum="+vpnNum);

        Request.Builder builder = new Request.Builder();
        builder.url(requestToSend.getUrl());
        Request request = builder.get().build();

        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response response) throws IOException {
                System.out.println("响应成功");

            }
            @Override
            public void onFailure(Call arg0, IOException arg1) {
                System.out.println("响应失败");
            }
        });

    }

    public static String getUrlMsg(){
        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl("http://192.168.0.109:8887/main/post");

        Request.Builder builder = new Request.Builder();
        builder.url(requestToSend.getUrl());
        Request request = builder.get().build();

        OkHttpClient okHttpClient=new OkHttpClient();
        String result = "";
        try {
            Response response = okHttpClient.newCall(request).execute();
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
