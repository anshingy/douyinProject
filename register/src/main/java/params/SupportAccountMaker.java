package params;

import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import httpmaker.ConstructRequest;
import jsonreader.tools.GzipGetteer;
import okhttp3.*;
import po.RequestTokenVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: register
 * @description: 获取预加载视频id的构造模块
 * @author: Mr.Jia
 * @create: 2018-09-05 20:41
 **/
public class SupportAccountMaker {

    public static ArrayList<String> getAwemeListMaker(OkHttpClient okHttpClient, DeviceEntity deviceEntity, DYUserEntity dyUserEntity){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://aweme.snssdk.com/aweme/v1/feed/?type=0&max_cursor=0&min_cursor=0&count=6&volume=0.0&pull_type=0&ts="+ts+"&app_type=normal&os_api=25&device_type="+deviceEntity.getDevice_type()+"&device_platform=android&ssmix=a&iid="+deviceEntity.getIid()+"&manifest_version_code=176&dpi=320&uuid="+deviceEntity.getUuid()+"&version_code=176&app_name=aweme&version_name=1.7.6&openudid="+deviceEntity.getOpenudid()+"&device_id="+deviceEntity.getDeviceId()+"&resolution=1280*720&os_version=7.1.2&language=zh&device_brand="+deviceEntity.getDevice_brand()+"&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket="+_rticket+"&as=a1iosdfgh&cp=androide1";

        Map<String, String> header = new HashMap<String, String>();

        header.put("Host","aweme.snssdk.com");
        header.put("Connection","Keep-Alive");
        header.put("Accept-Encoding","gzip");
        header.put("Cookie", dyUserEntity.getUserCookie());
        header.put("User-Agent","okhttp/3.8.1");


        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl(url);
        requestToSend.setHeader(header);
        requestToSend.setBody(null);
        Request request = null;
        request = ConstructRequest.constructGet(requestToSend);

//        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        ArrayList<String> resultToReturn = new ArrayList<String>();


        try {
            Response response = call.execute();
            String result = GzipGetteer.uncompressToString(response.body().bytes());
            resultToReturn = getAwemeIdList(result);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultToReturn;
    }

    public static void getVideoMaker(OkHttpClient okHttpClient, String awemeId, DeviceEntity deviceEntity, DYUserEntity dyUserEntity){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://aweme.snssdk.com/aweme/v1/aweme/stats/?os_api=25&device_type="+deviceEntity.getDevice_type()+"&device_platform=android&ssmix=a&iid="+deviceEntity.getIid()+"&manifest_version_code=176&dpi=320&uuid="+deviceEntity.getUuid()+"&version_code=176&app_name=aweme&version_name=1.7.6&openudid="+deviceEntity.getOpenudid()+"&device_id="+deviceEntity.getDeviceId()+"&resolution=1280*720&os_version=7.1.2&language=zh&device_brand="+deviceEntity.getDevice_brand()+"&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket="+_rticket+"&ts="+ts+"&as=a1iosdfgh&cp=androide1";
        Map<String, String> header = new HashMap<String, String>();


        header.put("Accept-Encoding","gzip");
        header.put("Cache-Control","max-stale=0");
        header.put("Content-Type","Content-Type");
        header.put("Content-Length","500");
        header.put("Host","aweme.snssdk.com");
        header.put("Connection","Keep-Alive");
        header.put("Cookie",dyUserEntity.getUserCookie());
        header.put("User-Agent","okhttp/3.8.1");


        //构造body
        Map <String, String> body = new HashMap<String, String>();

        body.put("item_id",awemeId);
        body.put("tab_type","0");
        body.put("play_delta","1");
        body.put("aweme_type","0");
        body.put("retry_type","no_retry");
        body.put("os_api","22");
        body.put("device_type",deviceEntity.getDevice_type());
        body.put("device_platform",deviceEntity.getDevice_platform());
        body.put("ssmix","a");
        body.put("iid",deviceEntity.getIid());
        body.put("manifest_version_code","176");
        body.put("dpi","240");
        body.put("uuid",deviceEntity.getUuid());
        body.put("version_code","176");
        body.put("app_name","aweme");
        body.put("version_name","1.7.6");
        body.put("openudid",deviceEntity.getOpenudid());
        body.put("device_id",deviceEntity.getDeviceId());
        body.put("resolution","1280*720");
        body.put("os_version","5.1.1");
        body.put("language","zh");
        body.put("device_brand",deviceEntity.getDevice_brand());
        body.put("ac","wifi");
        body.put("update_version_code","1762");
        body.put("aid","1128");
        body.put("channel","tengxun");
        body.put("_rticket",_rticket);


        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl(url);
        requestToSend.setHeader(header);
        requestToSend.setBody(body);
        Request request = null;
        request = ConstructRequest.constructPost(requestToSend);

//        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        ArrayList<String> resultToReturn = new ArrayList<String>();

        try {
            Response response = call.execute();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getAwemeId(OkHttpClient okHttpClient, DeviceEntity deviceEntity, DYUserEntity dyUserEntity, String user_id){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://aweme.snssdk.com/aweme/v1/aweme/post/?user_id="+user_id+"&max_cursor=0&count=20&retry_type=no_retry&iid="+deviceEntity.getIid()+"&device_id="+deviceEntity.getDeviceId()+"&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type="+deviceEntity.getDevice_type()+"&device_brand="+deviceEntity.getDevice_brand()+"&language=zh&os_api=25&os_version=7.1.2&uuid="+deviceEntity.getUuid()+"&openudid="+deviceEntity.getOpenudid()+"&manifest_version_code=176&resolution=1280*720&dpi=320&update_version_code=1762&_rticket="+_rticket+"&ts="+ts+"&as=a1iosdfgh&cp=androide1";

        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Encoding","gzip");
        header.put("Host","aweme.snssdk.com");
        header.put("Cache-Control","max-stale=60");
        header.put("Connection","Keep-Alive");
        header.put("User-Agent","okhttp/3.8.1");
        header.put("Cookie",dyUserEntity.getUserCookie());


        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl(url);
        requestToSend.setHeader(header);
        requestToSend.setBody(null);
        Request request = null;
        request = ConstructRequest.constructGet(requestToSend);

//        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        String result_awemeId = "";
        try {
            Response response = call.execute();
            String result = GzipGetteer.uncompressToString(response.body().bytes(),"utf-8");

            String []temp_result = result.split(",");
            for(int i = 0;i < temp_result.length;i++){

                String []line_split = temp_result[i].split("\"aweme_id\":");
                if(line_split.length == 2){
                    char []array = line_split[1].toCharArray();
                    String awemeId = "";
                    for(int j = 0; j < array.length;j++){
                        if (Character.isDigit(array[j])){
                            awemeId += array[j];
                        }
                    }
                    result_awemeId = awemeId;
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result_awemeId;
    }

    public static ArrayList<String> getAwemeIdList(String temp){


        ArrayList<String> result = new ArrayList<>();
        String []temp1 = temp.split(",");
        for(int i = 0;i < temp1.length;i++){
            String []temp2 = temp1[i].split(":");
            if(temp2[0].equals(" \"aweme_id\"")){
                result.add(temp2[1]);
            }
        }

        ArrayList<String> resultToReturn = new ArrayList<>();
        for(int i = 0;i < result.size();i+=3){
            char []array = result.get(i).toCharArray();
            String str_temp ="";
            for(int j = 0;j < array.length;j++){
                if (Character.isDigit(array[j])){
                    str_temp += array[j];
                }
            }
            resultToReturn.add(str_temp);
        }
        return resultToReturn;
    }

    public static String MapToString(Map map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "=" ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? ";" : "");
        }
        return sb.toString();
    }
}
