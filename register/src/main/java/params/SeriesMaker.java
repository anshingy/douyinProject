package params;

import com.space.register.entity.DeviceEntity;
import httpmaker.ConstructRequest;
import jsonreader.tools.GzipGetteer;
import okhttp3.*;
import params.tools.ConstructRequestUrl;
import po.RequestTokenVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: register
 * @description: 各种request请求构造
 * @author: Mr.Jia
 * @create: 2018-09-12 12:26
 **/
public class SeriesMaker {
    public static void main(String[] args) {
        DeviceEntity a = new DeviceEntity();
        app_notice_status(a);

    }

    public static void app_notice_status(DeviceEntity deviceEntity){


        String host = "http://ib.snssdk.com";
        String msg = "/service/1/app_notice_status/?";

        //构造token
        Map<String, String> token = new HashMap<String, String>();

        token.put("system_notify_status","1");
        token.put("rom","MIUI-7.5.19");
        token.put("os","android");
        token.put("package","com.ss.android.ugc.aweme");
        token.put("notice","0");

        token.put("os_api","23");
//        token.put("device_type","Redmi 4X");
//        token.put("device_platform","android");
        token.put("device_type",deviceEntity.getDevice_type());
        token.put("device_platform",deviceEntity.getDevice_platform());
        token.put("ssmix","a");
//        token.put("iid","43782700054");
        token.put("iid",deviceEntity.getIid());
        token.put("manifest_version_code","176");
        token.put("dpi","320");
        token.put("uuid",deviceEntity.getUuid());
//        token.put("uuid","866709033510131");
        token.put("version_code","176");
        token.put("app_name","aweme");
        token.put("version_name","1.7.6");
        token.put("openudid",deviceEntity.getOpenudid());
        token.put("device_id",deviceEntity.getDeviceId());
//        token.put("openudid","ea6c4b63a1678e5b");
//        token.put("device_id","40402989481");
        token.put("resolution","1280*720");
        token.put("os_version","6.0.1");
        token.put("language","zh");
        token.put("device_brand",deviceEntity.getDevice_brand());
//        token.put("device_brand","Xiaomi");
        token.put("ac","wifi");
        token.put("update_version_code","1762");
        token.put("aid","1128");
        token.put("channel","tengxun");
        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);
        token.put("_rticket",_rticket);
        token.put("ts",ts);
        token.put("as","a1iosdfgh");
        token.put("cp","androide1");


        //url构建完成,其中cookie需要从前面的cookie参数中提取
        String url = ConstructRequestUrl.constructUrl(host, msg, token);

        String cookie = deviceEntity.getCookie();
        cookie += ";qh[360]=1";

        Map<String, String> header = new HashMap<String, String>();

        header.put("Accept-Encoding","gzip");
        header.put("Cache-Control","max-stale=0");

        header.put("Host","ib.snssdk.com");
        header.put("Connection","Keep-Alive");
        header.put("Cookie",cookie);
        //header.put("Cookie","install_id=43782700054;ttreq=1$95b32f4b15e00896d8410a72758d62a3f37ebb82;qh[360]=1;odin_tt=4463424e46573152475634337430746e480f80f535e9aef66682fc695123f164db58b49cd38085adfef4072a7b8d883d");
        header.put("User-Agent","okhttp/3.8.1");

        RequestTokenVo requestToSend = new RequestTokenVo();



        requestToSend.setUrl(url);
        requestToSend.setHeader(header);
        requestToSend.setBody(null);
        Request request = null;
        request = ConstructRequest.constructGet(requestToSend);

        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response response) throws IOException {
                System.out.println("响应成功");
                System.out.println(GzipGetteer.uncompressToString(response.body().bytes() ,"utf-8"));
            }
            @Override
            public void onFailure(Call arg0, IOException arg1) {
                System.out.println("响应失败");
            }
        });


    }
}
