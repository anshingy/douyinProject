package com.space.register.controller;

import com.mysql.cj.x.protobuf.Mysqlx;
import com.space.register.dao.DYUserRepository;
import com.space.register.dao.OrderRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.entity.OrderEntity;
import com.space.register.entity.UrlRequestEntity;
import com.space.register.service.DYRegisterService;
import com.space.register.service.DeviceService;
import com.space.register.service.UrlRequestService;
import httpmaker.ConstructRequest;
import jsonreader.tools.GzipGetteer;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import params.*;
import platform.email.HostIPGetter;
import po.HostIPPo;
import po.RequestTokenVo;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static params.SupportAccountMaker.getAwemeIdList;

@RestController
@RequestMapping("/main")
public class MainController {

    @Resource
    UrlRequestService urlRequestService;

    @Resource
    DeviceService deviceService;

    @Resource
    DYRegisterService dyRegisterService;

    @Resource
    DYUserRepository dyUserRepository;

    @Resource
    OrderRepository orderRepository;

    private static int id = 1100;
    private static int event_id = 0;
    private static String session_id = "";
    private static long serverTime = 0;
    /**
     * 点赞模块
     * @return
     */
    @RequestMapping("/thumbsUp")
    public ArrayList<String> thumbsUpMaker(String aweme_id, OkHttpClient okHttpClient) {

        //这个是视频id，需要参数传入
        //String aweme_id = "6597344642847477000";
        //String aweme_id = "6596873554115955971";
        //String aweme_id = "6602797333635665156";
        //String aweme_id = "6599566234746883335";
//        String aweme_id = "6599758421971438862";
        //String aweme_id = "6598666622192323844";

//        ArrayList<String> aaaa = new ArrayList<String>();
//        aaaa.add("6601079867616267528");
//        aaaa.add("6602390827073277197");
//        aaaa.add("6601800939487628558");
//        aaaa.add("6599566234746883335");
//        aaaa.add("6601500048515665166");

        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = dyRegisterService.findById(id);
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));

        //获取并构建url信息，包括host、msg、token
        UrlRequestEntity urlRequestEntity = urlRequestService.getUrlRequest(3);

        long time = System.currentTimeMillis();
//        OkHttpClient okHttpClient = new OkHttpClient();
        ArrayList<String> result = ThumbsUpMaker.thumbsUpMaker(okHttpClient, aweme_id, deviceEntity, dyUserEntity);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        event_id = dyUserEntity.getEvent_id();
        ArrayList<String> body_msg = AllAppLogConstruct.digg(dyUserEntity.getAppLog(), session_id, event_id, String.valueOf(serverTime), String.valueOf(time), dyUserEntity.getUid(), aweme_id, result.get(1));

        event_id = Integer.valueOf(body_msg.get(0));
        String appLogResult = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, body_msg.get(1));
        System.out.println("点赞的applog：" + appLogResult);
        dyUserEntity.setEvent_id(event_id);
        dyUserRepository.save(dyUserEntity);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String like = "{\"request_id\":\""+result.get(1)+"\",\"order\":0,\"enter_from\":\"homepage_hot\",\"enter_method\":\"click\",\"nt\":4,\"category\":\"umeng\",\"tag\":\"like\",\"label\":\"homepage_hot\",\"value\":"+aweme_id+",\"user_id\":"+ dyUserEntity.getUid()+",\"session_id\":\""+session_id+"\",\"datetime\":\""+sdf.format(Long.parseLong(String.valueOf(time)))+"\",\"event_id\":"+(++event_id)+"}";
        result.add(like);

        return result;
    }

    @RequestMapping("/follow")
    public String followMaker(){

        //这个是视频id，需要参数传入
     //   String user_id = "101947485841";
        String user_id = "59024460599";
        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = dyRegisterService.findById(id);
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));

        long time = System.currentTimeMillis();
        OkHttpClient okHttpClient = new OkHttpClient();
        ArrayList<String> follow_result = FollowMaker.FollowMaker(okHttpClient, user_id, dyUserEntity, deviceEntity);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = SupportAccountMaker.getAwemeId(okHttpClient, deviceEntity, dyUserEntity, user_id);

        ArrayList<String> body_msg = AllAppLogConstruct.follow(dyUserEntity.getAppLog(), session_id, event_id, String.valueOf(serverTime), String.valueOf(time), user_id, result, dyUserEntity.getUid(),follow_result.get(2));;

        event_id = Integer.valueOf(body_msg.get(0));
        System.out.println("关注的applog:");
        String appLogResult = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, body_msg.get(1));
        System.out.println(appLogResult);
        dyUserEntity.setEvent_id(event_id);
        dyUserRepository.save(dyUserEntity);

        return null;
    }

    @RequestMapping("/modify")
    public String modificationMaker(){

        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = dyRegisterService.findById(id);
        String user_cookie = dyUserEntity.getUserCookie();
        String simulationId = dyUserEntity.getSimulationID();
        String uid = dyUserEntity.getUid();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));
        String cookie = deviceEntity.getCookie();
        cookie += (";"+ user_cookie);
        deviceEntity.setCookie(cookie);

        //获取并构建url信息，包括host、msg、token
        UrlRequestEntity urlRequestEntity1 = urlRequestService.getUrlRequest(5);


        UrlRequestEntity urlRequestEntity2 = urlRequestService.getUrlRequest(8);

        OkHttpClient okHttpClient = new OkHttpClient();
        ModifyInfoMaker.modifyInfoMaker(okHttpClient, uid, deviceEntity, urlRequestEntity1, urlRequestEntity2);


        return null;
    }

    @RequestMapping("/support")
    public String supportAccountMaker(){

        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = dyRegisterService.findById(id);
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));

        //获取并构建url信息，包括host、msg、token
        UrlRequestEntity urlRequestEntity = urlRequestService.getUrlRequest(6);

        OkHttpClient okHttpClient = new OkHttpClient();
        ArrayList<String> awemeList =  SupportAccountMaker.getAwemeListMaker(okHttpClient, deviceEntity, dyUserEntity);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        awemeList.add("6602390827073277197");
        UrlRequestEntity urlRequestEntity1 = urlRequestService.getUrlRequest(7);

        try {
            for(int i = 0;i < awemeList.size();i++){
                SupportAccountMaker.getVideoMaker(okHttpClient, awemeList.get(i),deviceEntity, dyUserEntity);
                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping("/launchApp")
    public String launchApp() throws InterruptedException {

        //通过id获取t_dy_user中的数据
        DYUserEntity dyUserEntity = dyRegisterService.findById(id);
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));

        //随机生成的session_id
        session_id = AllAppLogConstruct.constructRandomSessionId();
        ArrayList<String> body_msg = AllAppLogConstruct.launchApp(dyUserEntity.getAppLog(), session_id, dyUserEntity.getEvent_id());
        //修改全部变量event_id
        event_id = Integer.valueOf(body_msg.get(0));
        //修改数据库中event_id的值
        dyUserEntity.setEvent_id(event_id);
        dyUserRepository.save(dyUserEntity);
        //修改全局变量serverTime
        serverTime = System.currentTimeMillis();

        OkHttpClient okHttpClient = new OkHttpClient();
        String result = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, body_msg.get(1));
        System.out.println(result);
        return null;
    }


    @RequestMapping("/test")
    public void testStart() throws InterruptedException {

        System.out.println("开始");

//        ArrayList<DYUserEntity> dyUserEntity_list = dyRegisterService.findAll();
//        int site = 0;
//        for(int i = 0;i < dyUserEntity_list.size();i++){
//            if(dyUserEntity_list.get(i).getId() == 3000){
//                site = i;
//                break;
//            }
//        }

        //获取并构建url信息，包括host、msg、token
        UrlRequestEntity urlRequestEntity = urlRequestService.getUrlRequest(6);

//        ArrayList<HostIPPo> hostIPPos = HostIPGetter.getIpByXdali(1);
//        HostIPPo hostIPPo = hostIPPos.get(0);
         OkHttpClient okHttpClient = new OkHttpClient();
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)//设置读取超时时间
//                .writeTimeout(60, TimeUnit.SECONDS)//设置写的超时时间
//                .connectTimeout(60,TimeUnit.SECONDS)//设置连接超时时间
//                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostIPPo.host, hostIPPo.port)))
//                .build();

        id = 21000;
        for(int i = 0;i < 100;i++){


            int success = 0;
            int failure = 0;
            id = id;
            System.out.println("id:" + id);
            //下面是单个id循环测试
            //通过id获取t_dy_user中的数据
            DYUserEntity dyUserEntity = dyRegisterService.findById(id);
            String simulationId = dyUserEntity.getSimulationID();

            //通过simulationid获取t_device中的数据
            DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));

            //注册帐号前需要加载appLog
            //随机生成的session_id
            session_id = AllAppLogConstruct.constructRandomSessionId();
            ArrayList<String> launch_body_msg = AllAppLogConstruct.launchApp(dyUserEntity.getAppLog(), session_id, dyUserEntity.getEvent_id());
            //修改全部变量event_id
            int event_id = Integer.valueOf(launch_body_msg.get(0));
            //修改数据库中event_id的值
            dyUserEntity.setEvent_id(event_id);
            //修改全局变量serverTime
            String launch_result = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, launch_body_msg.get(1));
            System.out.println("加载app结果：" + launch_result);

            ArrayList<String> temp = new ArrayList<>();
            ArrayList<String> temp1 = SupportAccountMaker.getAwemeListMaker(okHttpClient, deviceEntity, dyUserEntity);
            ArrayList<String> temp2 = SupportAccountMaker.getAwemeListMaker(okHttpClient, deviceEntity, dyUserEntity);

            Thread.sleep(1000);
            temp.add("6613654703920123143");
            temp.add("6599125191379389704");
            temp.add("6612536904682310926");
            temp.add("6588840155174407427");
            temp.add("6588841875958926600");
            temp.add("6588882148793519363");

//            temp.add("6610128541478554887");
//            temp.add("6609527383840001294");
//            temp.add("6608257682686086414");
//            temp.add("6610152012623383815");
//            temp.add("6608377342861511950");
//            temp.add("6609950440593296644");

//            for(int j = 0;j < temp1.size();j++){
//                temp.add(temp1.get(j));
//            }
//            for(int j = 0;j < temp2.size();j++){
//                temp.add(temp2.get(j));
//            }
            for (int j = 0; j < 1; j++) {

                //ArrayList<String> temp = SupportAccountMaker.getAwemeListMaker(okHttpClient, deviceEntity, dyUserEntity);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (temp.size() == 0) {
                    System.out.println("错误：没有获取到任何视频");
                    j--;
                }

                ArrayList<String> like_list = new ArrayList<>();
                for (int k = 0; k < temp.size(); k++) {
                    SupportAccountMaker.getVideoMaker(okHttpClient, temp.get(k), deviceEntity, dyUserEntity);
                    Thread.sleep(1000);
                    ArrayList<String> digg_result = thumbsUpMaker(temp.get(k), okHttpClient);
                    String[] digg_temp = digg_result.get(0).split(",");
                    for (int m = 0; m < digg_temp.length; m++) {
                        if (digg_temp[m].split(":")[0].equals(" \"is_digg\"")) {
                            if (digg_temp[m].split(":")[1].equals(" 0")) {
                                success++;
                            } else {
                                ArrayList<String> digg_result1 = thumbsUpMaker(temp.get(j), okHttpClient);
                                String[] digg_temp1 = digg_result1.get(0).split(",");
                                if (digg_temp1[m].split(":")[1].equals(" 0")) {
                                    success++;
                                } else {
                                    failure++;
                                }
                            }
                            break;
                        }
                    }
                    like_list.add(digg_result.get(2));

                    Thread.sleep(500);
                }
//                //下面这部分用于6个赞发一次appLog
//                if (like_list.size() != 0) {
//                    ArrayList<String> body_msg = AllAppLogConstruct.digg_temp(dyUserEntity.getAppLog(), session_id, event_id, String.valueOf(serverTime), String.valueOf(System.currentTimeMillis()), like_list);
//                    event_id = Integer.valueOf(body_msg.get(0));
//                    String appLogResult = AppLogMaker.app_log(okHttpClient, deviceEntity, dyUserEntity, body_msg.get(1));
//                    System.out.println(appLogResult);
//                }

            }

            System.out.println("id:" + id);
            System.out.println("success:" + success);
            System.out.println("failure:" + failure);
            System.out.println("-----------------------------------------------------");
            System.out.println("----------------------烧楼上屁股----------------------");
            System.out.println("-----------------------------------------------------");
            id++;
        }

    }

    @RequestMapping("/test1")
    public void test(){
        DYUserEntity dyUserEntity = dyRegisterService.findById(id);
        String simulationId = dyUserEntity.getSimulationID();

        //通过simulationid获取t_device中的数据
        DeviceEntity deviceEntity = deviceService.getDeviceMsg(Integer.parseInt(simulationId));

        OkHttpClient okHttpClient = new OkHttpClient();
        ArrayList<String> result = SupportAccountMaker.getAwemeListMaker(okHttpClient, deviceEntity, dyUserEntity);

        System.out.println(result);
    }

    public static String MapToString(Map map){
        Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "=" ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? ";" : "");
        }
        return sb.toString();
    }

    @RequestMapping("/insert")
    public void insertInto(){

        ArrayList<String> order_id_list = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            ArrayList<String> result = feed();
            order_id_list.addAll(result);
        }

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add("6606580437374471428");
//        resultList.add("6599125191379389704");
//        resultList.add("6612536904682310926");
//        resultList.add("6588840155174407427");
//        resultList.add("6588841875958926600");
//        resultList.add("6588882148793519363");
//        resultList.add("6614109363697093891");
//        resultList.add("6612613762224491790");
//        resultList.add("6595096011784326407");
        for(int i = 0;i < order_id_list.size();i++){
            for(int j = i;j < order_id_list.size();j++){
                if(j + 1 <order_id_list.size() && order_id_list.get(i).equals(order_id_list.get(j + 1)) ){
                    break;
                }else if(j == order_id_list.size() - 1){
                    resultList.add(order_id_list.get(i));
                }
            }
        }
        System.out.println(resultList);

        //这里设置插入多少订单
        for(int i = 0;i < 100 && i < resultList.size();i++){
            OrderEntity order_temp = new OrderEntity();
            order_temp.setStatus("1");
            Random aa = new Random();
            int rand = aa.nextInt(50);
//            order_temp.setThumbUpOrFollowNum((rand + 50)* 100);
            order_temp.setThumbUpOrFollowNum(100);
            order_temp.setTypes("dydz100");
            order_temp.setOrderNumber(String.valueOf(System.currentTimeMillis()) + "testOrder");
            order_temp.setVideoID(resultList.get(i));
            order_temp.setLangestDYId(0);
            orderRepository.save(order_temp);
        }
//        ArrayList<OrderEntity> orderList = new ArrayList<>();
//        dyUserRepository.save();

    }

    public static ArrayList<String> feed(){

        String _rticket = String.valueOf(System.currentTimeMillis());
        char []temp = _rticket.toCharArray();
        String ts = "";
        for(int i = 0;i < temp.length - 3;i++){
            ts += temp[i];
        }
        long temp_ts = Long.parseLong(ts);
        temp_ts ++;
        ts = String.valueOf(temp_ts);

        String url = "https://aweme.snssdk.com/aweme/v1/feed/?type=0&max_cursor=0&min_cursor=0&count=6&volume=0.0&pull_type=0&ts="+ts+"&app_type=normal&os_api=25&device_type=Redmi 4x&device_platform=android&ssmix=a&iid=46822775990&manifest_version_code=176&dpi=320&uuid=862515122360587&version_code=176&app_name=aweme&version_name=1.7.6&openudid=8d4b2d266cdb7b72&device_id=58322850656&resolution=1280*720&os_version=7.1.2&language=zh&device_brand=xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket="+_rticket+"&as=a1iosdfgh&cp=androide1";

        Map<String, String> header = new HashMap<String, String>();
        header.put("Accept-Encoding","gzip");
        header.put("Host","aweme.snssdk.com");
        header.put("Connection","Keep-Alive");
        //header.put("Cookie","install_id="+iid+";qh[360]=1;odin_tt="+odin_tt+";sid_guard="+sid_guard+";uid_tt="+uid_tt+";sid_tt="+sid_tt+";sessionid="+sessionid);
        header.put("User-Agent","okhttp/3.8.1");

        RequestTokenVo requestToSend = new RequestTokenVo();
        requestToSend.setUrl(url);
        requestToSend.setHeader(header);
        requestToSend.setBody(null);
        Request request = null;
        request = ConstructRequest.constructGet(requestToSend);

        OkHttpClient okHttpClient=new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        String result = "";

        try {
            Response response = call.execute();
            result = GzipGetteer.uncompressToString(response.body().bytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return getAwemeIdList(result);
    }

}
