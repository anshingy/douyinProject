package params;

import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import jsonreader.tools.GzipGetteer;
import keytools.SSEntty;
import okhttp3.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: register
 * @description: app_log构造的类
 * @author: Mr.Jia
 * @create: 2018-09-23 15:52
 **/
public class AppLogMaker {

    public static String app_log(OkHttpClient okHttpClient, DeviceEntity deviceEntity, DYUserEntity dyUserEntity, String body_msg) throws IOException {

        String _rticket = String.valueOf(System.currentTimeMillis());
        char[] temp = _rticket.toCharArray();
        String ts = "";
        for (int i = 0; i < temp.length - 3; i++) {
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts++;

        String url = "http://log.snssdk.com/service/2/app_log/?iid=" + deviceEntity.getIid() + "&device_id=" + deviceEntity.getDeviceId() + "&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=" + deviceEntity.getDevice_type() + "&device_brand=" + deviceEntity.getDevice_brand() + "&language=zh&os_api=25&os_version=7.1.2&uuid=" + deviceEntity.getUuid() + "&openudid=" + deviceEntity.getOpenudid() + "&manifest_version_code=176&resolution=1280*720&dpi=320&update_version_code=1762&_rticket=" + _rticket + "&tt_data=a";

        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Encoding", "gzip");
        header.put("Host", "log.snssdk.com");
        header.put("Cache-Control", "max-stale=0");
        header.put("Connection", "Keep-Alive");
        header.put("Content-Length", "1500");
        header.put("Content-Type", "application/octet-stream;tt-data=a");
        header.put("Cookie", "install_id=" + deviceEntity.getIid() + ";qh[360]=1;" + dyUserEntity.getUserCookie());
        header.put("User-Agent", "okhttp/3.8.1");



        byte[] sendMessage = GzipGetteer.compress(body_msg);
        sendMessage = SSEntty.getTTEnttyResult(sendMessage);

        MediaType type = MediaType.parse("application/octet-stream;tt-data=a");
        RequestBody body = RequestBody.create(type, sendMessage);

        Request.Builder builder = new Request.Builder();
        builder.url(url);
        for (String key : header.keySet()) {        //添加header信息
            builder.addHeader(key, header.get(key).trim());
        }

        Request request = builder.post(body).build();

//        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        String result = "";

            Response response = call.execute();
            result = GzipGetteer.uncompressToString(response.body().bytes());

        return result;
    }

}
