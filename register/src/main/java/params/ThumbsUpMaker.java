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
 * @description: 构造点赞模块
 * @author: Mr.Jia
 * @create: 2018-09-04 11:39
 **/
public class ThumbsUpMaker {


    public static ArrayList<String> thumbsUpMaker(OkHttpClient okHttpClient, String aweme_id, DeviceEntity deviceEntity, DYUserEntity dyUserEntity) throws IOException {


        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://api.amemv.com/aweme/v1/commit/item/digg/?aweme_id="+aweme_id+"&type=1&retry_type=no_retry&iid="+deviceEntity.getIid()+"&device_id="+deviceEntity.getDeviceId()+"&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type="+deviceEntity.getDevice_type()+"&device_brand="+deviceEntity.getDevice_brand()+"&language=zh&os_api=25&os_version=7.1.2&uuid="+deviceEntity.getUuid()+"&openudid="+deviceEntity.getOpenudid()+"&manifest_version_code=176&resolution=1280*720&dpi=480&update_version_code=1762&_rticket="+_rticket+"&ts="+ts+"&as=a1iosdfgh&cp=androide1";

        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Encoding","gzip");
        header.put("Host","api.amemv.com");
        header.put("Cache-Control","max-stale=0");
        header.put("Connection","Keep-Alive");
        header.put("Cookie",dyUserEntity.getUserCookie()+";qh[360]=1;install_id=" + deviceEntity.getIid());
        header.put("User-Agent","okhttp/3.8.1");

        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl(url);
        requestToSend.setHeader(header);
        requestToSend.setBody(null);
        Request request = null;
        request = ConstructRequest.constructGet(requestToSend);

//        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        ArrayList<String> result = new ArrayList<>();

            Response response = call.execute();
            result.add(GzipGetteer.uncompressToString(response.body().bytes()));
            System.out.println("点赞返回信息：" + result.get(0));
            Headers responseHeaders = response.headers();
            int responseHeadersLength = responseHeaders.size();
            for (int i = 0; i < responseHeadersLength; i++){
                String headerName = responseHeaders.name(i);
                String headerValue = responseHeaders.value(i);
                if(headerName.equals("X_TT_LOGID")||headerName.equals("x_tt_logid")){
                    result.add(headerValue);
                }
            }



        return result;
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
