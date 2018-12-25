package platform.tv;

import com.space.register.entity.DeviceEntity;
import enums.paramtable.DirTable;
import jsonreader.tools.GzipGetteer;
import keytools.HandleEncrypt;
import keytools.SSEntty;
import okhttp3.*;
import org.json.JSONObject;
import params.CesJson;
import params.ParamCreater;
import params.tools.RequestURLCreater;
import platform.tcp.TcpClientForTV;

import java.io.IOException;

/**
 * @ Author     ：GXDTJJC
 * @ Date       ：Created in 19:43 2018/8/30/030
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class DeviceTvRegister {

    public static Request getDeviceCreaterRequest(JSONObject jsonObject){
        //TcpClientForTV tcpClientForTV = new TcpClientForTV();

        String device_URL = RequestURLCreater.getUrlFromJsonAndMap(jsonObject);
        String result = jsonObject.toString();
        byte[] sendMessage = GzipGetteer.compress(result);
        sendMessage = SSEntty.getTTEnttyResult(sendMessage);
        //数据准备完毕
        MediaType type=MediaType.parse("application/octet-stream");
        RequestBody fileBody= RequestBody.create(type,sendMessage);
        Request request=new Request.Builder().url(device_URL)
                .addHeader("Accept-Encoding","gzip")
                .addHeader("Cache-Control","max-stale=0")
                .addHeader("Content-Type","application/octet-stream;tt-data=a")
                .addHeader("Host","ib.snssdk.com")
                .addHeader("Connection","Keep-Alive")
                .addHeader("User-Agent","okhttp/3.7.0.6")
                .post(fileBody)//直接传输加密后的json数据
                .build();
        return request;
    }

    public static Request getSendMessagePower(DeviceEntity deviceEntity,String extra){
        String ts = ParamCreater.get_Ts(ParamCreater.get_Rticket());
        String device_URL = DirTable.sendMessagePower+ts;
        String result = CesJson.jsonConstruct(deviceEntity,extra);
        TcpClientForTV tcpClientForTV = new TcpClientForTV();
        byte[] sendMessage = tcpClientForTV.get_Key_For_Devices(result.getBytes());
        //数据准备完毕
        MediaType type=MediaType.parse("application/octet-stream");
        RequestBody fileBody= RequestBody.create(type,sendMessage);
        Request request=new Request.Builder().url(device_URL)
                .addHeader("Accept-Encoding","gzip")
                .addHeader("Cookie","sessionid=")
                .addHeader("Content-Type","application/octet-stream")
                .addHeader("Host","xlog.snssdk.com")
                .addHeader("Connection","Keep-Alive")
                .addHeader("User-Agent","okhttp/3.8.1")
                .post(fileBody)//直接传输加密后的json数据
                .build();
        return request;
    }
    public static void main(String[]args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        //deviceEntity.getDevice_type()+deviceEntity.getUuid()+deviceEntity.getOpenudid()
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setDevice_type("mx5");
        deviceEntity.setUuid("865166024649694");
        deviceEntity.setOpenudid("252dcc2cf3b536cc");
        deviceEntity.setDeviceId("46355050685");
        Request request = getSendMessagePower(deviceEntity,"login");
        try {
            Response response = okHttpClient.newCall(request).execute();
            String result = response.body().string();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
