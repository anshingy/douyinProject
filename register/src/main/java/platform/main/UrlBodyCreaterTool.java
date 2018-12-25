package platform.main;

import com.space.register.entity.DeviceEntity;
import enums.paramtable.urltools.URLmakeTools;
import params.ParamCreater;
import po.RequestTokenVo;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @program: protool
 * @description: 用来生成url与body字符串的工具类
 * @author: Mr.gao
 * @create: 2018-09-12 16:31
 **/
public class UrlBodyCreaterTool {

    /**
     *
     * @param headers 包含host与cookie的header信息的map数据类型
     * @return 添加了基本信息的head 的map数据类型
     */
    public static Map<String,String> getMyHeaders(Map<String,String> headers){
        headers.put("Accept-Encoding","gzip");
        headers.put("Cache-Control","max-stale=0");
        headers.put("Connection","Keep-Alive");
        headers.put("User-Agent","okhttp/3.8.1");
        return headers;
    }

    public static String getUrlFromEntityAndMap(String hostAndMsg, Map<String,String> allVauleMaps, DeviceEntity deviceEntity){
        Map<String,String> deviceMap = deviceEntity.getDeviceMap();
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append(hostAndMsg);
        String rticket =ParamCreater.get_Rticket();
        deviceMap.put("_rticket", rticket);
        deviceMap.put("ts",ParamCreater.get_Ts(rticket));
        deviceMap.put("max_time",ParamCreater.get_Rticket());
        stringBuilder.append(getBodyByMapAndMap(allVauleMaps,deviceMap));
        return stringBuilder.toString();
    }

    public static String getUrlFromMapAndMap(String hostAndMsg, Map<String,String> allVauleMaps, Map<String,String> deviceMap){
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append(hostAndMsg);
        String rticket =ParamCreater.get_Rticket();
        deviceMap.put("_rticket", rticket);
        deviceMap.put("ts",ParamCreater.get_Ts(rticket));
        stringBuilder.append(getBodyByMapAndMap(allVauleMaps,deviceMap));
        return stringBuilder.toString();
    }

    public static String getBodyByMapAndMap(Map<String,String> allVauleMaps, Map<String,String> changeVaule){
        StringBuilder stringBuilder = new StringBuilder() ;
        int i = 0;
        for(String key :allVauleMaps.keySet()){
            if(i==0){
                if(changeVaule.containsKey(key)){
                    stringBuilder.append(key+"="+changeVaule.get(key));
                }else{
                    stringBuilder.append(key+"="+allVauleMaps.get(key));
                }

            }
            else{
                if(changeVaule.containsKey(key)){
                    stringBuilder.append("&"+key+"="+changeVaule.get(key));
                }else{
                    stringBuilder.append("&"+key+"="+allVauleMaps.get(key));
                }
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static Map<String,String> getDeviceAbleBody(String allbodyVaule, Map<String,String>body ){
        Map<String,String> allVauleMap = URLmakeTools.url_split(allbodyVaule);
        String rticket = ParamCreater.get_Rticket();
        body.put("_rticket", rticket);
        body.put("ts", ParamCreater.get_Ts(rticket));
        String bodyNew = UrlBodyCreaterTool.getBodyByMapAndMap(allVauleMap,body);
        return URLmakeTools.url_split(bodyNew);
    }

    public static String getURLEncoderString(String str) {//url编码
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String URLDecoderString(String str) {//url解码
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[]args){
        System.out.println(URLDecoderString("push_sdk=%5B1%2C2%2C6%2C7%2C8%2C9%5D&retry_type=no_retry&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674477983"));
    }

}
