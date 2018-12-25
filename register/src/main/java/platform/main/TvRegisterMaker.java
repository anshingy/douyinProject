package platform.main;

import com.space.register.entity.DeviceEntity;
import httpmaker.ConstructRequest;
import jsonreader.tools.GzipGetteer;
import jsonreader.tools.JsonTableGetter;
import keytools.HandleEncrypt;
import keytools.SSEntty;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import params.ParamCreater;
import params.tools.KeyControler;
import params.tools.RequestURLCreater;
import platform.tv.DeviceTvRegister;
import po.PhonePo;
import po.RequestTokenVo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: protool
 * @description: 某应用注册流程全部实现类
 * @author: Mr.gao
 * @create: 2018-09-02 16:10
 **/
public class TvRegisterMaker {

    DeviceTvRegister deviceTvRegister;
    public OkHttpClient okHttpClient;

    public TvRegisterMaker(){
        deviceTvRegister = new DeviceTvRegister();
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(60,TimeUnit.SECONDS)//设置连接超时时间
                .build();

    }

    public TvRegisterMaker(String hostname,int port){
        if(port == -1){
            deviceTvRegister = new DeviceTvRegister();
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
                    .connectTimeout(60,TimeUnit.SECONDS)//设置连接超时时间
                    .build();
        }else{
            deviceTvRegister = new DeviceTvRegister();
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
                    .connectTimeout(60,TimeUnit.SECONDS)//设置连接超时时间
                    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port)))
                    .build();
        }
    }
    public DeviceEntity registerUserToTv(String hehe){
        //DeviceTvRegister deviceRegisterTV = new DeviceTvRegister();
        JSONObject jsonObject = JsonTableGetter.construtJson();
        Request request = deviceTvRegister.getDeviceCreaterRequest(jsonObject);
        Response response = null;
        String jsonString = null;
        Headers header = null;
        JSONObject resultJson =null;
        try {
            response = okHttpClient.newCall(request).execute();
            jsonString =GzipGetteer.uncompressToString(response.body().bytes());
            header = response.headers();
            resultJson = new JSONObject(jsonString);
            //System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("注册设备结果获取失败");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("注册设备结果获取失败");
        }
        //处理注册设备返回的信息
        DeviceEntity deviceEntity = new DeviceEntity();
        try {
            JSONObject headerJson = jsonObject.getJSONObject("header");
            deviceEntity.setDeviceId(resultJson.getString("device_id"));
            deviceEntity.setDevice_brand(headerJson.getString("device_brand"));
            deviceEntity.setDevice_platform("android");
            deviceEntity.setDevice_type(headerJson.getString("device_model"));
            deviceEntity.setIid(resultJson.getString("install_id"));
            deviceEntity.setOpenudid(headerJson.getString("openudid"));
            deviceEntity.setUuid(headerJson.getString("udid"));
            deviceEntity.setDevice_register_json(jsonObject.toString());
            ArrayList<String> strings = RequestURLCreater.getCookieFromResponseHeaders(RequestURLCreater.getStrCookie(header));
            StringBuilder cookies = new StringBuilder();
            for(int i=0;i<strings.size();i++){
                if(i==strings.size()-1){
                    cookies.append(strings.get(i));
                    break;
                }
                cookies.append(strings.get(i)+";");
            }
            deviceEntity.setCookie(cookies.toString());
            JSONArray jsonArray = headerJson.getJSONArray("sim_serial_number");
            JSONObject map = jsonArray.getJSONObject(0);
            deviceEntity.setSim_ICCid((String) map.get("sim_serial_number"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return deviceEntity;
    }
    public DeviceEntity registerUserToTv(){
        //DeviceTvRegister deviceRegisterTV = new DeviceTvRegister();
        JSONObject jsonObject = JsonTableGetter.construtJson();
        Response response = null;
        String jsonString = null;
        Headers header = null;
        JSONObject resultJson =null;
        DeviceEntity deviceEntity = new DeviceEntity();
        JSONObject headerJson = null;
        try {
            headerJson = jsonObject.getJSONObject("header");
            deviceEntity.setDevice_brand(headerJson.getString("device_brand"));
            deviceEntity.setDevice_platform("android");
            deviceEntity.setDevice_type(headerJson.getString("device_model"));
            deviceEntity.setOpenudid(headerJson.getString("openudid"));
            deviceEntity.setUuid(headerJson.getString("udid"));
            deviceEntity.setDevice_register_json(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Request request = device_register(deviceEntity);
        try {
            response = okHttpClient.newCall(request).execute();
            jsonString =GzipGetteer.uncompressToString(response.body().bytes());
            header = response.headers();
            resultJson = new JSONObject(jsonString);
            deviceEntity.setDeviceId(resultJson.getString("device_id"));
            deviceEntity.setIid(resultJson.getString("install_id"));
            //System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("注册设备结果获取失败");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("注册设备结果获取失败");
        }
        //处理注册设备返回的信息

        try {


            ArrayList<String> strings = RequestURLCreater.getCookieFromResponseHeaders(RequestURLCreater.getStrCookie(header));
            StringBuilder cookies = new StringBuilder();
            for(int i=0;i<strings.size();i++){
                if(i==strings.size()-1){
                    cookies.append(strings.get(i));
                    break;
                }
                cookies.append(strings.get(i)+";");
            }
            deviceEntity.setCookie(cookies.toString());
            JSONArray jsonArray = headerJson.getJSONArray("sim_serial_number");
            JSONObject map = jsonArray.getJSONObject(0);
            deviceEntity.setSim_ICCid((String) map.get("sim_serial_number"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return deviceEntity;
    }

    public Request sendMessageForRegister(DeviceEntity deviceEntity,PhonePo phonePo,String code){

        String host = null;
        String message = null;
        if(code.equals("")){
            host = "https://is.snssdk.com";
            message = "/passport/mobile/send_code/v1/?";
        }else{
            host = "https://is.snssdk.com";
            message = "/passport/mobile/register/?";
        }
        Map<String,String> deviceMap = deviceEntity.getDeviceMap();
        String times = ParamCreater.get_Rticket();
        deviceMap.put("_rticket",times);
        deviceMap.put("ts",ParamCreater.get_Ts(times));
        String postUrl = RequestURLCreater.getSendMessageFromMap(host,message,deviceMap);
        postUrl+= KeyControler.getKeyForUse();
        //System.out.println("请求发送短信url"+postUrl);
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Accept-Encoding","gzip");
        headers.put("Cache-Control","max-stale=0");
        headers.put("Content-Type","application/x-www-form-urlencoded");
        headers.put("Host","is.snssdk.com");
        headers.put("Connection","Keep-Alive");
        headers.put("User-Agent","okhttp/3.8.1");
        String cookies = deviceEntity.getCookie()+";qh[360]=1";
        //System.out.println("cookie 内容"+ cookies);
        headers.put("Cookie",cookies);
        RequestTokenVo requestTokenVo = new RequestTokenVo();
        requestTokenVo.setUrl(postUrl);
        //System.out.println("获取的电话号码"+phonePo.getPhone_Num());
        Map<String,String> body = new HashMap<String,String>();
        if(code.equals("")){
            deviceMap =getDevice(deviceMap,phonePo);
            body = RequestURLCreater.getBodyForMessage(deviceMap);

            //System.out.println("body内容:  "+MapToString(body));
        }
        else{
            deviceMap = getDeviceCode(deviceMap,phonePo,code);
            body = RequestURLCreater.getBodyForRegister(deviceMap);
        }

        requestTokenVo.setHeader(headers);
        requestTokenVo.setBody(body);
        //System.out.println(requestTokenVo.getBody());
        return ConstructRequest.constructPost(requestTokenVo);
    }
    public static String MapToString(Map map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "=" ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? "&" : "");
        }
        return sb.toString();
    }

    public Map<String,String> getDevice(Map<String,String> kao,PhonePo phonePo){
        String phone = phonePo.getArea_Num()+phonePo.getPhone_Num();
        kao.put("mobile",ParamCreater.change_Mobile_to_Src(phone));
        return kao;
    }

    public Map<String,String> getDeviceCode(Map<String,String> kao,PhonePo phonePo,String code){
        String phone = phonePo.getArea_Num()+phonePo.getPhone_Num();
        kao.put("mobile",ParamCreater.change_Mobile_to_Src(phone));
        kao.put("password",ParamCreater.change_Mobile_to_Src("asd123456"));
        kao.put("code",ParamCreater.change_Mobile_to_Src(code));
        return kao;
    }

    public static Map<String, String> getAllGoodHeaders(String cookies){
        Map<String,String> odin_header = new HashMap<String,String>();
        odin_header.put("Accept-Encoding","gzip");
        odin_header.put("Cache-Control","max-stale=0");
        odin_header.put("Host","is.snssdk.com");
        odin_header.put("Connection","Keep-Alive");
        odin_header.put("Cookie",cookies);
        odin_header.put("User-Agent","okhttp/3.8.1");
        return odin_header;
    }

    public static String jsonConstruct(String extra,DeviceEntity deviceEntity){

        String part1 = "{\"p1\":\"\",\"p2\":\"\",\"pkg\":\"com.ss.android.ugc.aweme\",\"fp\":\"Xiaomi/santoni/santoni:7.1.2/N2G47H/8.9.13:user/release-keys\",\"vc\":270,\"VPN\":0,\"wifimac\":\"dc:fe:18:62:f2:f5\",\"location\":\"\",\"apps\":[],";
        if(extra.equals("login")){
            part1 = "{\"p1\":\""+deviceEntity.getDeviceId()+"\",\"p2\":\""+deviceEntity.getIid()+"\",\"pkg\":\"com.ss.android.ugc.aweme\",\"fp\":\"Xiaomi/bxr0q/bxr0q:7.1/XWJZXZ/:user/release-keys\",\"vc\":270,\"VPN\":0,\"wifimac\":\"dc:fe:18:62:f2:f5\",\"location\":\"\",\"apps\":[],";
        }
        String hw = "\"hw\":{\"brand\":\""+deviceEntity.getDevice_brand()+"\",\"model\":\""+deviceEntity.getDevice_type()+"\",\"board\":\"QC_Reference_Phone\",\"device\":\"santoni\",\"product\":\"santoni\",\"bt\":\"unknown\",\"display\":\"720*1280\",\"dpi\":320,\"bat\":4100,\"cpu\":{\"hw\":\"Qualcomm Technologies, Inc MSM8940\",\"max\":\"1401000\",\"min\":\"960000\",\"ft\":\"half thumb fastmult vfp edsp neon vfpv3 tls vfpv4 idiva idivt lpae evtstrm aes pmull sha1 sha2 crc32\"},\"mem\":{\"ram\":\"2.77 GB\",\"rom\":\"24.08 GB\",\"sd\":\"24.08 GB\"}},";
        String id = "\"id\":{\"imei\":\""+deviceEntity.getUuid()+"\",\"imsi\":\"460021051968262\",\"adid\":\""+deviceEntity.getOpenudid()+"\",\"mac\":\"68:3e:34:1e:c3:9a\",\"serial\":\"6d16cfb7d440\"},\"emulator\":{\"sig\":0,\"cb\":10,\"file\":[],\"prop\":[]},";
        String part2 = "\"env\":{\"ver\":\"0.5.8.28\",\"pkg\":\"com.ss.android.ugc.aweme\",\"uid\":10516,\"rebuild\":0,\"jd\":0,\"dbg\":0,\"tid\":0,\"xpd\":1,\"hk\":[],\"su\":0,\"sp\":\"/system/xbin/su\",\"ro.secure_s\":\"\",\"ro.debuggable_s\":\"\",\"click\":\"\",\"hph\":\"192.168.0.109\",\"hpp\":\"8888\",\"mc\":0,\"fc\":0,\"jexp\":0,\"xposed\":0,\"cydia\":0,\"frida\":0,\"vapp\":\"\",\"api\":[]},\"extra\":\""+extra+"\",\"extension\":{\"notify\":1174620016,\"tpid1\":0,\"tbin\":\"\"}}";

        return  part1 + hw + id + part2;
    }

    public static void xlog_v2(String extra,DeviceEntity deviceEntity){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://xlog.snssdk.com/v2/r?os=0&ver=0.5.8.28&m=1&app_ver=2.7.0&region=CN&aid=1128&did=" + deviceEntity.getDeviceId();

        Map<String, String> header = new HashMap<String, String>();
        header.put("Host","xlog.snssdk.com");
        header.put("Connection","Keep-Alive");
        header.put("Accept-Encoding","gzip");
        header.put("User-Agent","okhttp/3.10.0.1");
        header.put("Content-Length","1500");
        header.put("Cookie","sessionid=");
        header.put("Content-Type","application/octet-stream");

        MediaType type = MediaType.parse("application/octet-stream");
        byte[] list = HandleEncrypt.getCes("1",jsonConstruct(extra,deviceEntity));
//        System.out.println(new String(list));

        RequestBody body = RequestBody.create(type, list);

        Request.Builder builder = new Request.Builder();
        builder.url(url);
        for(String key : header.keySet()){        //添加header信息
            builder.addHeader(key, header.get(key).trim());
        }

        Request request = builder.post(body).build();

        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            //System.out.println("xlog_v2" + _rticket);

            Headers responseHeaders = response.headers();
            int responseHeadersLength = responseHeaders.size();
            for (int i = 0; i < responseHeadersLength; i++){
                String headerName = responseHeaders.name(i);
                String headerValue = responseHeaders.value(i);
                //System.out.print("TAG----------->Name:"+headerName+"------------>Value:"+headerValue+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Request device_register(DeviceEntity deviceEntity){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);
        long time = Long.parseLong(ts);

//        String url = "http://ib.snssdk.com/service/2/device_register/?ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type="+device_type+"&device_brand="+device_brand+"&language=zh&os_api="+os_api+"&os_version="+os_version+"&uuid="+uuid+"&openudid="+openudid+"&manifest_version_code=176&resolution="+resolution+"&dpi="+dpi+"&update_version_code=1762&_rticket="+_rticket+"&tt_data=a";
        String url = "https://ib.snssdk.com/service/2/device_register/?"+"ac=wifi&channel=xiaomi&aid=1128&app_name=aweme&version_code=270&version_name=2.7.0&device_platform=android&ssmix=a&device_type="+deviceEntity.getDevice_type()+"&device_brand="+deviceEntity.getDevice_brand()+"&language=zh&os_api=25&os_version=7.1.2&uuid="+deviceEntity.getUuid()+"&openudid="+deviceEntity.getOpenudid()+"&manifest_version_code=270&resolution=1280*720&dpi=320&update_version_code=2702&_rticket="+_rticket+"&tt_data=a";

        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Encoding","gzip");
        header.put("X-SS-QUERIES","");
        header.put("X-SS-REQ-TICKET",_rticket);
        header.put("sdk-version","1");
        header.put("Content-Type","application/octet-stream;tt-data=a");
        header.put("Content-Length","1000");
        header.put("Host","ib.snssdk.com");
        header.put("Connection","Keep-Alive");
        header.put("User-Agent","okhttp/3.10.0.1");

        String json = test11(deviceEntity).toString();
        byte[] sendMessage = GzipGetteer.compress(json);
        sendMessage = SSEntty.getTTEnttyResult(sendMessage);

        MediaType type = MediaType.parse("application/octet-stream;tt-data=a");
        RequestBody body = RequestBody.create(type, sendMessage);

        Request.Builder builder = new Request.Builder();
        builder.url(url);
        for (String key : header.keySet()) {        //添加header信息
            builder.addHeader(key, header.get(key).trim());
        }

        Request request = builder.post(body).build();
        return  request;
    }

    public static JSONObject test11(DeviceEntity deviceEntity) {

        String _rticket = String.valueOf(System.currentTimeMillis());
        char[] temp = _rticket.toCharArray();
        String ts = "";
        for (int i = 0; i < temp.length - 3; i++) {
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts++;
        ts = String.valueOf(temp_ts);
        long time = Long.parseLong(ts);

        String line = "{\"magic_tag\":\"ss_app_log\",\"header\":{\"display_name\":\"抖音短视频\",\"update_version_code\":1762,\"manifest_version_code\":176,\"aid\":1128,\"channel\":\"tengxun\",\"appkey\":\"57bfa27c67e58e7d920028d3\",\"package\":\"com.ss.android.ugc.aweme\",\"app_version\":\"1.7.6\",\"version_code\":176,\"sdk_version\":201,\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"release_build\":\"67a6344_20180308\",\"density_dpi\":320,\"display_density\":\"xhdpi\",\"resolution\":\"1280x720\",\"language\":\"zh\",\"mc\":\"F4:F5:DB:19:78:22\",\"timezone\":8,\"access\":\"wifi\",\"not_request_sender\":0,\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"rom\":\"MIUI-7.5.19\",\"rom_version\":\"miui_V8_7.5.19\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"openudid\":\"" + deviceEntity.getOpenudid() + "\",\"udid\":\"" + deviceEntity.getUuid() + "\",\"clientudid\":\"c73a17d8-8ac9-4cdb-bfee-6cc94fe83059\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[{\"sim_serial_number\":\"89860116235560851895\"}],\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":" + _rticket + "}";
        JSONObject result = null;
        try {
            result = new JSONObject(line);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Request send_code(DeviceEntity deviceEntity,PhonePo phonePo){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://is.snssdk.com/passport/mobile/send_code/?os_api=25&device_type="+deviceEntity.getDevice_type()+"&device_platform=android&ssmix=a&iid="+deviceEntity.getIid()+"&manifest_version_code=176&dpi=320&uuid="+deviceEntity.getUuid()+"&version_code=176&app_name=aweme&version_name=1.7.6&openudid="+deviceEntity.getOpenudid()+"&device_id="+deviceEntity.getDeviceId()+"&resolution=1280*720&os_version=7.1.2&language=zh&device_brand="+deviceEntity.getDevice_brand()+"&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket="+_rticket+"&ts="+ts+"&as=a1iosdfgh&cp=androide1";


        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Encoding","gzip");
        header.put("Host","is.snssdk.com");
        header.put("Content-Length","500");
        header.put("Cache-Control","max-stale=0");
        header.put("Content-Type","application/x-www-form-urlencoded");
        header.put("Cookie",deviceEntity.getCookie() +";qh[360]=1");
        header.put("Connection","Keep-Alive");
        header.put("User-Agent","okhttp/3.8.1");

        Map<String, String> body = new HashMap<String, String>();
        body.put("mix_mode","1");
        body.put("type","34");
        body.put("mobile",ParamCreater.change_Mobile_to_Src(phonePo.getArea_Num()+phonePo.getPhone_Num()));
        body.put("retry_type","no_retry");
        body.put("os_api","25");
        body.put("device_type",deviceEntity.getDevice_type());
        body.put("evice_platform","android");
        body.put("ssmix","a");
        body.put("iid",deviceEntity.getIid());
        body.put("manifest_version_code","176");
        body.put("dpi","320");
        body.put("uuid",deviceEntity.getUuid());
        body.put("version_code","176");
        body.put("app_name","aweme");
        body.put("version_name","1.7.6");
        body.put("openudid",deviceEntity.getOpenudid());
        body.put("device_id",deviceEntity.getDeviceId());
        body.put("resolution","1280*720");
        body.put("os_version","7.1.2");
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
        return  request;
    }
        public static void main(String[]args){
//        DeviceEntity deviceEntity = new DeviceEntity();
//        deviceEntity.setUuid("865166026228901");
//        deviceEntity.setOpenudid("fa0c47b8259279fb");
//        deviceEntity.setDevice_type("vivo x5m");
//        TvRegisterMaker tvRegisterMaker = new TvRegisterMaker();
//        System.out.println(tvRegisterMaker.getRealDevice_Info(JsonTableGetter.contrustJsonForReal(deviceEntity)));

    }
}
