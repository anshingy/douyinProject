package params;

import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import jsonreader.tools.GzipGetteer;
import okhttp3.*;
import util.MD5Code;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: register
 * @description: 构造所有AppLog的类
 * @author: Mr.Jia
 * @create: 2018-09-25 21:03
 **/
public class AllAppLogConstruct {

    public static void main(String[] args) {


        //ArrayList<String> aaa = follow("","",1,"","","95629369316","6604793535671569671","104730282571");
        //System.out.println(aaa.get(0));
        //System.out.println(aaa.get(1));
    }


    /**
     * 这里的方法只是生成发送appLog的url所需要的body信息
     * @param appLog appLog取自数据库device表的appLog字段
     * @param session_id session_id因为考虑到每个appLog都需要用到所以先随机生成后传入
     * @param event_id event_id用来记录applog中的事件id
     * @return
     */
    public static ArrayList<String> launchApp(String appLog, String session_id, int event_id) {

        //events中最初的session_id自动生成,datetime是最初加载抖音时的系统时间
        //不同event使用的datetime可以考虑相同时间，只限于这个方法，也可以每个event都获取当前系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String session_id_random = constructRandomSessionId();

        String datetime = sdf.format(System.currentTimeMillis());
        String terminate = "";
        if(event_id != 0){
            terminate = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"monitor\",\"label\":\"terminate\",\"session_id\":\""+session_id_random+"\",\"datetime\":\""+datetime+"\",\"event_id\":"+(++event_id)+"},";
        }

        String datetime1 = sdf.format(System.currentTimeMillis());
        String allow_on = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"notice\",\"label\":\"allow_on\",\"session_id\":\""+session_id_random+"\",\"datetime\":\""+datetime1+"\",\"event_id\":"+(++event_id)+"}";

        String datetime2 = sdf.format(System.currentTimeMillis());
        String launch = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"monitor\",\"label\":\"launch\",\"session_id\":\""+session_id_random+"\",\"datetime\":\""+datetime2+"\",\"event_id\":"+(++event_id)+"}";

        String datetime3 = sdf.format(System.currentTimeMillis());
        String enter_launch = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"launch_app\",\"label\":\"enter_launch\",\"session_id\":\""+session_id_random+"\",\"datetime\":\""+datetime3+"\",\"event_id\":"+(++event_id)+"}";

        String datetime4 = sdf.format(System.currentTimeMillis());
        String click_feed_top_banner = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"million_pound_entrance_show\",\"label\":\"click_feed_top_banner\",\"session_id\":\""+session_id_random+"\",\"datetime\":\""+datetime4+"\",\"event_id\":"+(++event_id)+"}";

        //这里第一个时间采用加载第一个event的时间，四二个时间采用加载最后一个event的时间
        //session_id选用传入的session_id，是随机生成的，后面每个app_log都需要用到
//        session_id = "4dfd5399-3141-48b1-9b10-3323c5993f71";
        String result_launch = "{\"datetime\":\""+datetime1+"\",\"session_id\":\""+session_id_random+"\",\"is_background\":true},{\"datetime\":\""+datetime4+"\",\"session_id\":\""+session_id+"\"}";

        String magic_tag = "\"ss_app_log\"";

        //下面是对device表中获取的app_log字段进行处理用来构造header部分
        //理由：加载抖音app时发送的字段不需要那么多，没有device_id、install_id等
        //写的太糙了，需要后期进行修改，如果有时间的话
        //appLog暂代数据库获取的app_log字段

        if( appLog == null){
            appLog = "{\"event\":[{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:38\",\"event_id\":70},{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:42\",\"event_id\":71},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":72},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":104685449990,\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":73}],\"launch\":[{\"datetime\":\"2018-09-23 19:35:55\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\"}],\"magic_tag\":\"ss_app_log\",\"time_sync\":{\"server_time\":1537702562,\"local_time\":1537702561},\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"openudid\":\"586040e47a883ed4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"tengxun\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.7.6\",\"version_code\":176,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1280*720\",\"display_density\":\"xhdpi\",\"density_dpi\":320,\"mc\":\"F4:F5:DB:19:78:22\",\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"clientudid\":\"e7d7c35d-aadf-457b-a1e8-b581bcb6fb6f\",\"install_id\":\"44771193224\",\"device_id\":\"57679504084\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"MIUI-8.9.13\",\"release_build\":\"67a6344_20180308\",\"update_version_code\":1762,\"manifest_version_code\":176,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"miui_V10_8.9.13\",\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":1537702615946}";

        }
        String header = appLog.split("\"header\":")[1].split(",\"_gen_time\"")[0];

        String []list = header.split(",");
        String result_header = "";
        for(int i = 0;i < list.length;i ++){
            String []temp_line = list[i].split(":");
            if(temp_line[0].equals("\"carrier\"") || temp_line[0].equals("\"mcc_mnc\"") || temp_line[0].equals("\"install_id\"") || temp_line[0].equals("\"device_id\"") || temp_line[0].equals("\"sim_region\"")){
                continue;
            }else{
                result_header += (i!=list.length - 2)? list[i]+",":list[i];
            }
        }
        result_header += "}";

        //gen_time采用最后一次加载的系统时间戳
        String _gen_time = String.valueOf(System.currentTimeMillis());

        String result = "{\"event\": ["+terminate+allow_on+","+launch+","+enter_launch+","+click_feed_top_banner+"],\"launch\": ["+result_launch+"],\"magic_tag\":"+magic_tag+",\"header\":"+result_header+",\"_gen_time\":"+_gen_time+"}";

        ArrayList<String> resultToReturn = new ArrayList<>();
        resultToReturn.add(String.valueOf(event_id));
        resultToReturn.add(result);
        return resultToReturn;
    }

    /**
     * 这个方法在applaunch后调用
     * @param appLog
     * @param session_id
     * @param event_id
     * @return
     */
    public static ArrayList<String> alertApp(String appLog, String session_id, int event_id){

        //session_id选用传入的，这里写死做测试
        session_id = "4dfd5399-3141-48b1-9b10-3323c5993f71";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time1 = System.currentTimeMillis();
        String datetime1 = sdf.format(time1);
        String app_alert = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"monitor\",\"label\":\"app_alert\",\"session_id\":\""+session_id+"\",\"datetime\":\""+datetime1+"\",\"event_id\":"+(++event_id)+"}";

        Random rand = new Random();
        String datetime2 = sdf.format(time1 + rand.nextInt(50) + 80);
        String stay_time = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"stay_time\",\"label\":\"homepage_hot\",\"value\":102,\"session_id\":\""+session_id+"\",\"datetime\":\""+datetime2+"\",\"event_id\":"+(++event_id)+"}";


        String result_launch = "{\"datetime\": \""+datetime1+"\",\"session_id\": \""+session_id+"\"}";

        String time_sync = "{\"server_time\": "+(System.currentTimeMillis()/1000)+",\"local_time\": "+(System.currentTimeMillis()/1000 + 1)+"}";

        String magic_tag = "\"ss_app_log\"";

        //这里的applog选用传入参数，临时使用数据库截取内容代替
        appLog = "{\"event\":[{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:38\",\"event_id\":70},{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:42\",\"event_id\":71},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":72},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":104685449990,\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":73}],\"launch\":[{\"datetime\":\"2018-09-23 19:35:55\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\"}],\"magic_tag\":\"ss_app_log\",\"time_sync\":{\"server_time\":1537702562,\"local_time\":1537702561},\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"openudid\":\"586040e47a883ed4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"tengxun\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.7.6\",\"version_code\":176,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1280*720\",\"display_density\":\"xhdpi\",\"density_dpi\":320,\"mc\":\"F4:F5:DB:19:78:22\",\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"clientudid\":\"e7d7c35d-aadf-457b-a1e8-b581bcb6fb6f\",\"install_id\":\"44771193224\",\"device_id\":\"57679504084\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"MIUI-8.9.13\",\"release_build\":\"67a6344_20180308\",\"update_version_code\":1762,\"manifest_version_code\":176,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"miui_V10_8.9.13\",\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":1537702615946}";

        String header = appLog.split("\"header\":")[1].split(",\"_gen_time\"")[0];
        String []list = header.split(",");
        String result_header = "";
        for(int i = 0;i < list.length;i ++){
            String []temp_line = list[i].split(":");
            if(temp_line[0].equals("\"carrier\"") || temp_line[0].equals("\"mcc_mnc\"") || temp_line[0].equals("\"sim_region\"")){
                continue;
            }else{
                result_header += (i!=list.length - 2)? list[i]+",":list[i];
            }
        }
        result_header += "}";

        //gen_time采用最后一次加载的系统时间戳
        String _gen_time = String.valueOf(System.currentTimeMillis() + 1000);

        String result = "{\"event\": ["+app_alert+","+stay_time+"],\"launch\": ["+result_launch+"],\"magic_tag\":"+magic_tag+",\"time_sync\": "+time_sync+",\"header\":"+result_header+",\"_gen_time\":"+_gen_time+"}";

        ArrayList<String> resultToReturn = new ArrayList<>();
        resultToReturn.add(String.valueOf(event_id));
        resultToReturn.add(result);
        return resultToReturn;
    }

    /**
     * 账号注册完成后发送
     * @param appLog appLog截取自数据库
     * @param session_id session_id为本次操作通用的session_id
     * @param event_id event_id取自数据库
     * @param server_time serer_time为本次操作launchapp时的时间
     * @param send_code_time send_code_time就是发送send_code的url时候的时间戳
     * @param user_id 是登录用户的user_id
     * @return
     */
    public static ArrayList<String> register(String appLog, String session_id, int event_id, String server_time, String send_code_time, String user_id){

        //session_id选用传入的，这里写死做测试

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sign_in = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\""+session_id+"\",\"datetime\":\""+sdf.format(Long.parseLong(send_code_time))+"\",\"event_id\":"+(++event_id)+"}";
        long time = System.currentTimeMillis() - Long.parseLong(send_code_time);
        String verification_in = "{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\""+session_id+"\",\"datetime\":\""+sdf.format(Long.parseLong(send_code_time + time / 30))+"\",\"event_id\":"+(++event_id)+"}";
        String registered_success = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\""+session_id+"\",\"datetime\":\""+sdf.format(System.currentTimeMillis())+"\",\"event_id\":"+(++event_id)+"}";
        String sign_in_success = "{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":"+user_id+",\"session_id\":\""+session_id+"\",\"datetime\":\""+sdf.format(System.currentTimeMillis())+"\",\"event_id\":"+(++event_id)+"}";

        String result_launch = "{\"datetime\": \""+server_time+"\",\"session_id\": \""+session_id+"\"}";

        String magic_tag = "\"ss_app_log\"";

        String time_sync = "{\"server_time\": "+(Long.parseLong(send_code_time) /1000 - time /10)+",\"local_time\": "+(Long.parseLong(send_code_time) /1000 - time /10)+"}";

        //这里的applog选用传入参数，临时使用数据库截取内容代替
        //appLog = "{\"event\":[{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:38\",\"event_id\":70},{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:42\",\"event_id\":71},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":72},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":104685449990,\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":73}],\"launch\":[{\"datetime\":\"2018-09-23 19:35:55\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\"}],\"magic_tag\":\"ss_app_log\",\"time_sync\":{\"server_time\":1537702562,\"local_time\":1537702561},\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"openudid\":\"586040e47a883ed4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"tengxun\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.7.6\",\"version_code\":176,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1280*720\",\"display_density\":\"xhdpi\",\"density_dpi\":320,\"mc\":\"F4:F5:DB:19:78:22\",\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"clientudid\":\"e7d7c35d-aadf-457b-a1e8-b581bcb6fb6f\",\"install_id\":\"44771193224\",\"device_id\":\"57679504084\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"MIUI-8.9.13\",\"release_build\":\"67a6344_20180308\",\"update_version_code\":1762,\"manifest_version_code\":176,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"miui_V10_8.9.13\",\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":1537702615946}";

        String header = appLog.split("\"header\":")[1].split(",\"_gen_time\"")[0];
        String []list = header.split(",");
        String result_header = "";
        for(int i = 0;i < list.length;i ++){
            String []temp_line = list[i].split(":");
            if(temp_line[0].equals("\"carrier\"") || temp_line[0].equals("\"mcc_mnc\"") || temp_line[0].equals("\"sim_region\"")){
                continue;
            }else{
                result_header += (i!=list.length - 2)? list[i]+",":list[i];
            }
        }
        result_header += "}";

        //gen_time采用最后一次加载的系统时间戳
        String _gen_time = String.valueOf(System.currentTimeMillis());

        String result = "{\"event\": ["+sign_in+","+verification_in+","+registered_success+","+sign_in_success+"],\"launch\": ["+result_launch+"],\"magic_tag\":"+magic_tag+",\"time_sync\": "+time_sync+",\"header\":"+result_header+",\"_gen_time\":"+_gen_time+"}";

        ArrayList<String> resultToReturn = new ArrayList<>();
        resultToReturn.add(String.valueOf(event_id));
        resultToReturn.add(result);
        return resultToReturn;
    }

    /**
     * 点赞后发送
     * @param appLog appLog截取自数据库
     * @param session_id session_id为本次操作通用的session_id
     * @param event_id event_id取自数据库
     * @param server_time serer_time为本次操作launchapp时的时间
     * @param digg_time digg_time就是点赞的url时候的时间戳
     * @param user_id 是登录用户的user_id
     * @param aweme_id 是被点赞视频的id
     * @return
     */
    public static ArrayList<String> digg(String appLog, String session_id, int event_id, String server_time, String digg_time, String user_id, String aweme_id, String request_id){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String like = "{\"request_id\":\""+request_id+"\",\"order\":0,\"enter_from\":\"homepage_hot\",\"enter_method\":\"click\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"like\",\"label\":\"homepage_hot\",\"value\":"+aweme_id+",\"user_id\":"+user_id+",\"session_id\":\""+session_id+"\",\"datetime\":\""+sdf.format(Long.parseLong(digg_time))+"\",\"event_id\":"+(++event_id)+"}";

        String result_launch = "{\"datetime\": \""+server_time+"\",\"session_id\": \""+session_id+"\"}";

        String magic_tag = "\"ss_app_log\"";

        Long time = System.currentTimeMillis() - Long.parseLong(digg_time);
        String time_sync = "{\"server_time\": "+(Long.parseLong(digg_time) /1000 - time /10)+",\"local_time\": "+(Long.parseLong(digg_time) /1000 - time /10)+"}";

        //这里的applog选用传入参数，临时使用数据库截取内容代替
        if(appLog==null){
            appLog = "{\"event\":[{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:38\",\"event_id\":70},{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:42\",\"event_id\":71},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":72},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":104685449990,\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":73}],\"launch\":[{\"datetime\":\"2018-09-23 19:35:55\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\"}],\"magic_tag\":\"ss_app_log\",\"time_sync\":{\"server_time\":1537702562,\"local_time\":1537702561},\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"openudid\":\"586040e47a883ed4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"tengxun\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.7.6\",\"version_code\":176,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1280*720\",\"display_density\":\"xhdpi\",\"density_dpi\":320,\"mc\":\"F4:F5:DB:19:78:22\",\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"clientudid\":\"e7d7c35d-aadf-457b-a1e8-b581bcb6fb6f\",\"install_id\":\"44771193224\",\"device_id\":\"57679504084\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"MIUI-8.9.13\",\"release_build\":\"67a6344_20180308\",\"update_version_code\":1762,\"manifest_version_code\":176,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"miui_V10_8.9.13\",\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":1537702615946}";
        }

        String header = appLog.split("\"header\":")[1].split(",\"_gen_time\"")[0];
        String []list = header.split(",");
        String result_header = "";
        for(int i = 0;i < list.length;i ++){
            String []temp_line = list[i].split(":");
            if(temp_line[0].equals("\"carrier\"") || temp_line[0].equals("\"mcc_mnc\"") || temp_line[0].equals("\"sim_region\"")){
                continue;
            }else{
                result_header += (i!=list.length - 2)? list[i]+",":list[i];
            }
        }
        result_header += "}";

        //gen_time采用最后一次加载的系统时间戳
        String _gen_time = String.valueOf(System.currentTimeMillis());

        String result = "{\"event\": ["+like+"],\"launch\": ["+result_launch+"],\"magic_tag\":"+magic_tag+",\"time_sync\": "+time_sync+",\"header\":"+result_header+",\"_gen_time\":"+_gen_time+"}";

        ArrayList<String> resultToReturn = new ArrayList<>();
        resultToReturn.add(String.valueOf(event_id));
        resultToReturn.add(result);
        return resultToReturn;
    }

    /**
     * 这个方法用在关注后发送
     * @param appLog 数据库获取
     * @param session_id 通用的session_id
     * @param event_id 数据库获取
     * @param server_time launchApp时候的时间戳
     * @param follow_time 发送关注请求时的时间戳
     * @param user_id1 被关注的用户id
     * @param aweme_id 被关注的用户的视频id
     * @param user_id2 关注的用户id
     * @return
     */
    public static ArrayList<String> follow(String appLog, String session_id, int event_id, String server_time, String follow_time, String user_id1, String aweme_id, String user_id2, String request_id){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String request_id = "20180925231116010015068167639ECF";
        //server_time = "1537966750000";
        //follow_time = "1537967450000";



        String follow = "{\"enter_from\":\"homepage_hot\",\"request_id\":\""+request_id+"\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"follow\",\"label\":\"homepage_hot\",\"value\":"+user_id1+",\"ext_value\":"+aweme_id+",\"user_id\":"+user_id2+",\"session_id\":\""+session_id+"\",\"datetime\":\""+follow_time+"\",\"event_id\":"+(++event_id)+"}";

        String result_launch = "{\"datetime\": \""+server_time+"\",\"session_id\": \""+session_id+"\"}";

        String magic_tag = "\"ss_app_log\"";

        Long time = System.currentTimeMillis() - Long.parseLong(follow_time);
        String time_sync = "{\"server_time\": "+(Long.parseLong(follow_time) /1000 - time /10)+",\"local_time\": "+(Long.parseLong(follow_time) /1000 - time /10)+"}";

        //这里的applog选用传入参数，临时使用数据库截取内容代替
        //appLog = "{\"event\":[{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:38\",\"event_id\":70},{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:42\",\"event_id\":71},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":72},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":104685449990,\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":73}],\"launch\":[{\"datetime\":\"2018-09-23 19:35:55\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\"}],\"magic_tag\":\"ss_app_log\",\"time_sync\":{\"server_time\":1537702562,\"local_time\":1537702561},\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"openudid\":\"586040e47a883ed4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"tengxun\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.7.6\",\"version_code\":176,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1280*720\",\"display_density\":\"xhdpi\",\"density_dpi\":320,\"mc\":\"F4:F5:DB:19:78:22\",\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"clientudid\":\"e7d7c35d-aadf-457b-a1e8-b581bcb6fb6f\",\"install_id\":\"44771193224\",\"device_id\":\"57679504084\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"MIUI-8.9.13\",\"release_build\":\"67a6344_20180308\",\"update_version_code\":1762,\"manifest_version_code\":176,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"miui_V10_8.9.13\",\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":1537702615946}";

        String header = appLog.split("\"header\":")[1].split(",\"_gen_time\"")[0];
        String []list = header.split(",");
        String result_header = "";
        for(int i = 0;i < list.length;i ++){
            String []temp_line = list[i].split(":");
            if(temp_line[0].equals("\"carrier\"") || temp_line[0].equals("\"mcc_mnc\"") || temp_line[0].equals("\"sim_region\"")){
                continue;
            }else{
                result_header += (i!=list.length - 2)? list[i]+",":list[i];
            }
        }
        result_header += "}";

        //gen_time采用最后一次加载的系统时间戳
        String _gen_time = String.valueOf(System.currentTimeMillis());

        String result = "{\"event\": ["+follow+"],\"launch\": ["+result_launch+"],\"magic_tag\":"+magic_tag+",\"time_sync\": "+time_sync+",\"header\":"+result_header+",\"_gen_time\":"+_gen_time+"}";

        ArrayList<String> resultToReturn = new ArrayList<>();
        resultToReturn.add(String.valueOf(event_id));
        resultToReturn.add(result);
        return resultToReturn;
    }


    public static ArrayList<String> digg_temp(String appLog, String session_id, int event_id, String server_time, String digg_time, ArrayList<String> like_list){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String like = like_list.get(0);
        for(int i = 1;i < like_list.size();i++){
           like += ","+like_list.get(i);
        }
        String result_launch = "{\"datetime\": \""+server_time+"\",\"session_id\": \""+session_id+"\"}";

        String magic_tag = "\"ss_app_log\"";

        Long time = System.currentTimeMillis() - Long.parseLong(digg_time);
        String time_sync = "{\"server_time\": "+(Long.parseLong(digg_time) /1000 - time /10)+",\"local_time\": "+(Long.parseLong(digg_time) /1000 - time /10)+"}";

        //这里的applog选用传入参数，临时使用数据库截取内容代替
//        appLog = "{\"event\":[{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:38\",\"event_id\":70},{\"enter_from\":\"sign_in\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"verification_in\",\"label\":\"verification_code\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:42\",\"event_id\":71},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"registered_success\",\"label\":\"phone\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":72},{\"nt\":4,\"category\":\"umeng\",\"tag\":\"sign_in_success\",\"label\":\"phone\",\"user_id\":104685449990,\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\",\"datetime\":\"2018-09-23 19:36:53\",\"event_id\":73}],\"launch\":[{\"datetime\":\"2018-09-23 19:35:55\",\"session_id\":\"e36a3165-d7fe-47a8-b520-5f79ea0929fa\"}],\"magic_tag\":\"ss_app_log\",\"time_sync\":{\"server_time\":1537702562,\"local_time\":1537702561},\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"openudid\":\"586040e47a883ed4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"tengxun\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.7.6\",\"version_code\":176,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"7.1.2\",\"os_api\":25,\"device_model\":\"Redmi 4X\",\"device_brand\":\"Xiaomi\",\"device_manufacturer\":\"Xiaomi\",\"language\":\"zh\",\"resolution\":\"1280*720\",\"display_density\":\"xhdpi\",\"density_dpi\":320,\"mc\":\"F4:F5:DB:19:78:22\",\"carrier\":\"中国移动\",\"mcc_mnc\":\"46000\",\"clientudid\":\"e7d7c35d-aadf-457b-a1e8-b581bcb6fb6f\",\"install_id\":\"44771193224\",\"device_id\":\"57679504084\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"MIUI-8.9.13\",\"release_build\":\"67a6344_20180308\",\"update_version_code\":1762,\"manifest_version_code\":176,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"6d16cfb7d440\",\"serial_number\":\"6d16cfb7d440\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"miui_V10_8.9.13\",\"region\":\"CN\",\"tz_name\":\"Asia/Shanghai\",\"tz_offset\":28800000,\"sim_region\":\"cn\"},\"_gen_time\":1537702615946}";

        String header = appLog.split("\"header\":")[1].split(",\"_gen_time\"")[0];
        String []list = header.split(",");
        String result_header = "";
        for(int i = 0;i < list.length;i ++){
            String []temp_line = list[i].split(":");
            if(temp_line[0].equals("\"carrier\"") || temp_line[0].equals("\"mcc_mnc\"") || temp_line[0].equals("\"sim_region\"")){
                continue;
            }else{
                result_header += (i!=list.length - 2)? list[i]+",":list[i];
            }
        }
        result_header += "}";

        //gen_time采用最后一次加载的系统时间戳
        String _gen_time = String.valueOf(System.currentTimeMillis());

        String result = "{\"event\": ["+like+"],\"launch\": ["+result_launch+"],\"magic_tag\":"+magic_tag+",\"time_sync\": "+time_sync+",\"header\":"+result_header+",\"_gen_time\":"+_gen_time+"}";

        ArrayList<String> resultToReturn = new ArrayList<>();
        resultToReturn.add(String.valueOf(event_id));
        resultToReturn.add(result);
        return resultToReturn;
    }

    /**
     * 用来构造随机生成的sessionId的方法
     * @return
     */
    public static String constructRandomSessionId(){

        String time = String .valueOf(System.currentTimeMillis());
        String time_md = new MD5Code().getMD5ofStr(time);
        String session_id = "";
        String []temp = time_md.split("");
        for(int i = 0;i < temp.length;i ++){
            if(i == 8 || i == 12 || i == 16 || i == 20){
                session_id += "-";
            }
            session_id += temp[i];
        }
        return session_id.toLowerCase();
    }


}
