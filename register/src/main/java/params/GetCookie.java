package params;


import okhttp3.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @program: protocol
 * @description: 用于发送http请求的实现类
 * @author: gaoxiang
 * @create: 2018-08-27 15:07
 **/
public class GetCookie {

    /**
     * 请求发送验证码
     * @return
     * @throws IOException
     */
    public static Request sendMessageToLogin() throws IOException{
        FormBody.Builder params=new FormBody.Builder();
        // 构建GET请求，并设置User-Agent请求消息头和Cookie请求消息头
        Request request = new Request.Builder()
                .url("https://i.snssdk.com/passport/mobile/send_code/?mix_mode=1&mobile=2e3d33283430343530343c3c343033&captcha=&type=3731&unbind_exist=0&retry_type=no_retry&iid=42358438317&device_id=39930642845&ac=wifi&channel=tengxun_new&aid=1128&app_name=aweme&version_code=185&version_name=1.8.5&device_platform=android&ssmix=a&device_type=oppo+r7&device_brand=oppo&language=zh&os_api=22&os_version=5.1.1&uuid=865166025663769&openudid=7f0e150875dea94e&manifest_version_code=185&resolution=1280*720&dpi=240&update_version_code=1852&_rticket=1535441181801&ts=1535441186&as=a1iosdfgh&cp=androide1")
                .addHeader("Host", "ib.snssdk.com")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("Accept-Encoding", "gzip")
                .addHeader("User-Agent", "okhttp/3.7.0.6")
                .addHeader("Cache-Control","max-stale=0")
                .get()
                .build();

        return request;
    }

    /**
     * 确认验证码，进行登录
     * @return
     * @throws IOException
     */
    public static Request enterCodeToLogin() throws IOException{

        FormBody.Builder params=new FormBody.Builder();

        params.add("mobile","2e3d33283430343530343c3c343033");
        params.add("code","3d32333c");
        params.add("mix_mode","1");
        params.add("captcha","");
        params.add("retry_type","no_retry");
        params.add("os_api","22");
        params.add("device_type","oppo%20r7");
        params.add("device_platform","android");
        params.add("ssmix","a");
        params.add("iid","42358438317");
        params.add("manifest_version_code","185");
        params.add("dpi","240");
        params.add("uuid","865166025663769");
        params.add("version_code","185");
        params.add("app_name","aweme");
        params.add("version_name","1.8.5");
        params.add("openudid","7f0e150875dea94e");
        params.add("device_id","39930642845");
        params.add("resolution","1280*720");
        params.add("os_version","5.1.1");
        params.add("language","zh");
        params.add("device_brand","oppo");
        params.add("ac","wifi");
        params.add("update_version_code","1852");
        params.add("aid","1128");
        params.add("channel","tengxun_new");
        params.add("_rticket","1535441190865");



        Request request = new Request.Builder()

                .url("https://i.snssdk.com/user/mobile/quick_login/?os_api=22&device_type=oppo+r7&device_platform=android&ssmix=a&iid=42358438317&manifest_version_code=185&dpi=240&uuid=865166025663769&version_code=185&app_name=aweme&version_name=1.8.5&openudid=7f0e150875dea94e&device_id=39930642845&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=oppo&ac=wifi&update_version_code=1852&aid=1128&channel=tengxun_new&_rticket=1535440708470&ts=1535440712&as=a1iosdfgh&cp=androide1")
                .addHeader("Host", "ib.snssdk.com")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("Accept-Encoding", "gzip")
                .addHeader("Content-Length", "477")
                .addHeader("Content-Type", "application/octet-stream;tt-data=a")
                .addHeader("User-Agent", "okhttp/3.7.0.6")
                .addHeader("Cache-Control","max-stale=0")
                .post(params.build())
                .build();
        return request;
    }

    public static void main(String[]args) throws IOException {

        OkHttpClient okHttpClient=new OkHttpClient();
        Request request1 = sendMessageToLogin();
        Request request2 = enterCodeToLogin();


//        Call call1=okHttpClient.newCall(request1);
//        call1.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call arg0, Response response) throws IOException {
//                System.out.println("响应成功,已经成功获取验证码");
//            }
//            @Override
//            public void onFailure(Call arg0, IOException arg1) {
//                System.out.println("响应失败");
//            }
//        });


//        Call call2=okHttpClient.newCall(request2);
//        call2.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call arg0, Response response) throws IOException {
////                String result = GzipGetteer.uncompressToString(response.body().bytes());
////                String sid_tt = getSessionKeyFromJsonResponse(result);
////                String sessionid = sid_tt;
////                System.out.println("sid_tt:"+sid_tt);
////                System.out.println("sessionid:"+sessionid);
//                System.out.println("响应成功");
//                Headers responseHeaders = response.headers();
//
//                int responseHeadersLength = responseHeaders.size();
//                ArrayList<String> cookie = new ArrayList<String>();
//                for (int i = 0; i < responseHeadersLength; i++){
//                    String headerName = responseHeaders.name(i);
//                    String headerValue = responseHeaders.value(i);
//                    if(headerName.equals("Set-Cookie")){
//                        cookie.add(headerValue);
//                    }
//                }
//                cookie = getCookieFromResponseHeaders(cookie);
//                System.out.println(cookie);
//            }
//            @Override
//            public void onFailure(Call arg0, IOException arg1) {
//                System.out.println("响应失败");
//            }
//        });





        //System.out.println(GzipGetteer.uncompressToString(response.body().bytes() ,"utf-8"));
    }

    /**
     * 从返回json中获取sesionid
     * @param response
     * @return
     */
    public static String getSessionKeyFromJsonResponse(String response){
        String []temp1 = response.split(",");
        String result = "";
        for(int i = 0;i < temp1.length;i++){
            String []temp2 = temp1[i].split(":");
            if(temp2[0].equals("\"session_key\"")){
                String []temp3 = temp2[1].split("");
                for(int j = 1;j < temp3.length - 1;j++){
                    result += temp3[j];
                }
            }
        }
        return result;
    }

    /**
     *
     * @param responseHeaders
     * @return
     */
    public static ArrayList<String> getCookieFromResponseHeaders(ArrayList<String> responseHeaders){
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0;i < responseHeaders.size();i++){
            String []temp = responseHeaders.get(i).split(";");
            result.add(temp[0]);
        }
        return result;
    }
}
