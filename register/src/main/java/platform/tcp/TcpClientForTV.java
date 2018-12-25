package platform.tcp;

import jsonreader.tools.GzipGetteer;

import java.io.*;
import java.net.Socket;

/**
 * @program: hehedada
 * @description: 用于操作tcp从而实现xlog加密的实现类
 * @author: Mr.gao
 * @create: 2018-10-15 15:04
 **/
public class TcpClientForTV {

    public  String ip = "127.0.0.1";
    public  int port =9001;
    public  String adb_path ="C:\\Users\\Administrator\\AppData\\Local\\Android\\Sdk\\platform-enums.paramtable.urltools\\adb.exe";
    public Socket socket;
    public TcpClientForTV(){
        startSocket();
    }

    public TcpClientForTV(String ip,int port){
        this.ip = ip;
        this.port = port;
        startSocket();

    }
    public void startSocket(){
        try {
            Runtime.getRuntime().exec("adb  forward tcp:9001 tcp:9001");
            socket = new Socket(ip,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("客户端会话创建");
    }

    public byte[] get_Key_For_Devices(String device_Info) {
        send_String(device_Info);
        System.out.println("开始传输数据");
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //接受传入的信息，并转化为字节流
        byte[] result = get_Bytes(dataInputStream);
        //  输出为了测试而已
        //System.out.println(new String(result));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<result.length;i++){
            stringBuilder.append(result[i]+" ");
        }
        //System.out.println("传输内容: "+device_Info);
        //System.out.println("传输结果："+stringBuilder.toString());

        return result;
    }

    public byte[] get_Key_For_Devices(byte[] device_Info) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<device_Info.length;i++){
        stringBuilder.append(device_Info[i]+" ");
        }
        send_Bytes(socket,device_Info);
        System.out.println("开始传输数据");
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
        e.printStackTrace();
        }

        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //接受传入的信息，并转化为字节流
        byte[] result = get_Bytes(dataInputStream);
        //  输出为了测试而已
        //System.out.println(new String(result));
//        stringBuilder = new StringBuilder();
//        for(int i =0;i<result.length;i++){
//        stringBuilder.append(result[i]+" ");
//        }
       // System.out.println("结果二进制内容为: "+stringBuilder.toString());
        System.out.println("使用测试方法传输一次数据");
        return result;
    }

    public byte[] get_Bytes(DataInputStream dataInputStream){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte buff = 0;
        try {
            int length = dataInputStream.readInt();

            for(int i=0;i<length;i++){
                buff = dataInputStream.readByte();
                byteArrayOutputStream.write(buff);
            }
            //byteArrayOutputStream.write('\0');
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("出现tcp错误: "+ buff);
        }
        return  byteArrayOutputStream.toByteArray();
    }

    public void send_Bytes(Socket socket,byte[] result){
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            DataOutputStream dataOnputStream = new DataOutputStream(outputStream);
           // System.out.println(result.length);
            dataOnputStream.writeInt(result.length);
            dataOnputStream.write(result);
            dataOnputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send_String(String string){

        try {
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.println(string);
            //System.out.println(string);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发送信息出错");
        }
        ;
    }

    public static void main(String[] args) throws IOException {
        String syrBuff = "{\"event_v3\":[{\"nt\":4,\"event\":\"plugin_upload_json\",\"params\":{\"retry_count\":\"0\",\"content\":\"{\\\"plugin\\\":[{\\\"packagename\\\":\\\"com.ss.android.ugc.aweme.ffmpeg_so\\\",\\\"versioncode\\\":0},{\\\"packagename\\\":\\\"com.ss.android.ugc.aweme.shortvideo_so\\\",\\\"versioncode\\\":0}],\\\"patch\\\":[]}\"},\"event_id\":97,\"session_id\":\"fd9ebe88-8efb-4dd9-bf97-550d1a452fe2\",\"datetime\":\"2018-09-01 16:34:23\"},{\"nt\":4,\"event\":\"plugin_response_json\",\"params\":{\"retry_count\":\"2\",\"is_success\":\"1\",\"content\":\"[]\"},\"event_id\":98,\"session_id\":\"fd9ebe88-8efb-4dd9-bf97-550d1a452fe2\",\"datetime\":\"2018-09-01 16:34:23\"}],\"launch\":[{\"datetime\":\"2018-09-01 16:34:23\",\"session_id\":\"fd9ebe88-8efb-4dd9-bf97-550d1a452fe2\",\"is_background\":true}],\"magic_tag\":\"ss_app_log\",\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"udid\":\"865166024287115\",\"openudid\":\"06e7aa24d4d4c8a4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"baidu\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.8.3\",\"version_code\":183,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"5.1.1\",\"os_api\":22,\"device_model\":\"f103\",\"device_brand\":\"gionee\",\"device_manufacturer\":\"gionee\",\"language\":\"zh\",\"resolution\":\"900x1600\",\"display_density\":\"hdpi\",\"density_dpi\":240,\"mc\":\"00:81:41:de:1e:56\",\"carrier\":\"CHINA MOBILE\",\"mcc_mnc\":\"46000\",\"clientudid\":\"71cfb1e8-ca28-447b-9acf-0b5c4033cb88\",\"device_id\":\"39262138748\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"V9.5.2.0.LACCNFA\",\"release_build\":\"61b8304_20180522\",\"update_version_code\":1832,\"manifest_version_code\":183,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"00c7c516\",\"serial_number\":\"00c7c516\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"LMY48Z\",\"region\":\"CN\",\"tz_name\":\"Asia\\/Shanghai\",\"tz_offset\":28800,\"sim_region\":\"cn\"},\"_gen_time\":1535791855231}";
        System.out.println(syrBuff);
        TcpClientForTV tcpClientForTV = new TcpClientForTV();

        tcpClientForTV.get_Key_For_Devices(GzipGetteer.compress(syrBuff));
    }
}

