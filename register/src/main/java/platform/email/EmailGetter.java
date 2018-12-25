//package platform.email;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import po.PhonePo;
//
//import java.io.IOException;
//
///**
// * @program: protocol
// * @description: 获取短信验证码操作类
// * @author: gaoxiang
// * @create: 2018-08-02 18:04
// **/
//
//public class EmailGetter {
//    /**
//     * 变量依次为：账号、密码、项目类型
//     */
//    //api_qianbaiwan_rrgr,qianbaiwan
//    private String userName ="api_qianbaiwan_o1o";
//    private String password ="qianbaiwan";
//    private String projectID ="1003";
//    private String projectPasswordID = "1004";
//    private String Login_url ;
//    public String Usertoken ="5eb9541386e913d9d0bfccbd212e081b";
//    private String errorStr = "0";
//    private String successStr = "1";
//    /**
//     * 登陆平台初始化方法
//     */
//    public void loginIT(){
//        loginIT(userName,password);
//    }
//
//    public void loginIT(String user,String password){
//        this.userName = user;
//        this.password = password;
//        String tag = errorStr;
//        int errTime =0;
//        String[] buffers = null;
//        //http://api0.wmisms.com/yhapi.ashx?act=login&ApiName=api_yh001_0fk&PassWord=yh001
//        Login_url = "http://api0.wmisms.com/yhapi.ashx?act=login&ApiName="+userName+"&PassWord="+password;
//
//        try {
//
//            while (tag.equals(errorStr)&&errTime<3){
//                Document document = Jsoup.connect(Login_url).timeout(3000).get();
//                // System.out.println(document.body().text());
//                String buff=document.body().text();
//                buffers = buff.split("\\|");
//                tag = buffers[0];
//                if(tag.equals(successStr)){
//                    System.out.println("登录成功");
//                    break;
//                }
//                System.out.println("尝试登陆错误"+errTime+"次");
//                errTime++;
//                //因为感觉这方面错误只有网络延迟的可能，所以就120秒吧
//                Thread.sleep(120000);
//            }
//            Usertoken =buffers[1];
//            if(errTime==3){
//                System.out.println("账号可能存在问题，还是别进行下一步操作了");
//            }else{
//                System.out.println("用户标识Token为："+Usertoken);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 提取手机号方法实现,注意提取之前要去主动发送短信
//     * 返回包含手机号码信息的po类型
//     */
//    public PhonePo getPhoneNumber(){
//        return getPhoneNumber("随机");
//    }
//
//    /**
//     *
//     * @param phoneNum 指定要获取的手机号
//     * @return 存储号码对象的po
//     */
//    public PhonePo getPhoneNumber(String phoneNum){
//        String tag =errorStr;
//        String phone_url;
//        if(phoneNum.equals("随机")){
//            //http://api0.wmisms.com/yhapi.ashx?act=getPhone&token=ad718214bdf8e7ad80344bf9743ec307&iid=1001&did=&operator=&city=&mobile=
//            phone_url="http://api0.wmisms.com/yhapi.ashx?act=getPhone&token="+Usertoken+"&iid="+projectID+"&did=&operator=&city=泰国&mobile=";
//
//        }else{
//            phone_url="http://api0.wmisms.com/yhapi.ashx?act=getPhone&token="+Usertoken+"&iid="+projectPasswordID+"&did=&operator=&city=&mobile="+phoneNum;
//        }
//        Document document = null;
//        String[] buffers = null;
//        int worryTime =0;
//        while(tag.equals(errorStr)&&worryTime<2){
//            try {
//                document = Jsoup.connect(phone_url).get();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String buff=document.body().text();
//            buffers = buff.split("\\|");
//            tag =buffers[0];
//            if(tag.equals(successStr)){
//                System.out.println("成功获取手机号: "+buffers[4]+" "+buffers[1]+" "+buffers[6]);
//                break;
//            }else{
//                System.out.print("发生错误，错误信息为: "+buff);
//            }
//            worryTime++;
//        }
//        if(worryTime==2){
//            System.out.println("获取手机号码失败，将返回空值");
//            return null;
//        }else{
//                PhonePo phonePo = new PhonePo(buffers[1],buffers[2],buffers[3],buffers[4],buffers[6]);
//                return phonePo;
//        }
//
//    }
//    /**
//     *
//     * @param P_ID 监听验证码的参数
//     * @return 获取的验证码
//     */
//    public String getIdentCode(String P_ID){
//        //              http://api0.wmisms.com/yhapi.ashx?act=getPhoneCode&token=ad718214bdf8e7ad80344bf9743ec307&pid=100118456007026
//        String infoUrl ="http://api0.wmisms.com/yhapi.ashx?act=getPhoneCode&token="+Usertoken+"&pid="+P_ID;
//        Document document =null;
//        String buff = null;
//        String[] buffers;
//        String tag =errorStr;
//        String result = 0+"";
//        int buffer_Num =0;
//        while(tag.equals(errorStr)&buffer_Num<15){
//            try {
//                Thread.sleep(10000);
//                document =Jsoup.connect(infoUrl).get();
//                System.out.println(document);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            buff = document.body().text();
//            buffers = buff.split("\\|");
//            tag = buffers[0];
//            result = buffers[1];
//            if(tag.equals(successStr)){
//                return buffers[1];
//            }
//            else if(result.equals("-4")){
//                System.out.println("号码已经强制释放");
//                return "请求超时";
//            }else{
//               // System.out.println("nimei: "+buffers[0]+" "+buffers[1]);
//            }
//            buffer_Num++;
//            //System.out.println("tag : "+tag);
//        }
//        System.out.print("获取验证码失败");
//        makePhoneBlank(P_ID);
//        return "请求超时";
//    }
//
//    public void makePhoneBlank(String phone_PID){
////        String tag =errorStr;
////        //http://api0.wmisms.com/yhapi.ashx?act=addBlack&token=ad718214bdf8e7ad80344bf9743ec307&pid=100118456007026&reason=cannotgetCode
////        String blankList = "http://api0.wmisms.com/yhapi.ashx?act=addBlack&token="+Usertoken+"&pid="+phone_PID+"&reason=cannotgetCode";
////        Document document = null;
////        String[] buffers = null;
////        try {
////            document = Jsoup.connect(blankList).get();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        String buff=document.body().text();
////        buffers = buff.split("\\|");
////        tag =buffers[0];
////        if(tag.equals(successStr)){
////            System.out.println("成功加黑手机号: "+tag);
////        }else{
////            System.out.print("发生错误，错误信息为: "+buff);
////        }
////        System.out.println("成功加黑手机号: "+tag);
//    }
//
//    public static void main(String[] args) {
//        EmailGetter emailGetter = new EmailGetter();
//        emailGetter.loginIT();
//        PhonePo phonePo = emailGetter.getPhoneNumber();
//        System.out.println(phonePo.getPhone_Num());
//        System.out.println(phonePo.getP_ID());
//        System.out.println(emailGetter.getIdentCode(phonePo.getP_ID()));
//
//    }
//}


package platform.email;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import po.PhonePo;

import java.io.IOException;

/**
 * @program: protocol
 * @description: 获取短信验证码操作类
 * @author: gaoxiang
 * @create: 2018-08-02 18:04
 **/

public class EmailGetter implements EmailPlatform{
    /**
     * 变量依次为：账号、密码、项目类型
     */
    //api_qianbaiwan_rrgr,qianbaiwan
    private String userName ="api_qianbaiwan_o1o";
    private String password ="qianbaiwan";
    private String projectID ="1003";
    private String projectPasswordID = "1004";
    private String Login_url ;
    public String Usertoken ="5eb9541386e913d9d0bfccbd212e081b";
    private String errorStr = "0";
    private String successStr = "1";

    //单例模式
    public static EmailGetter emailGetter = new EmailGetter();
    /**
     * 登陆平台初始化方法
     */
    public static EmailGetter getInstrance(){
        return emailGetter;
    }
    private EmailGetter(){
        loginIT();
    }

    public EmailGetter(String userName,String password){
        loginIT(userName,password);
    }

    private void loginIT(){
        loginIT(userName,password);
    }

    private void loginIT(String user,String password){
        this.userName = user;
        this.password = password;
        String tag = errorStr;
        int errTime =0;
        String[] buffers = null;
        //http://api0.wmisms.com/yhapi.ashx?act=login&ApiName=api_yh001_0fk&PassWord=yh001
        Login_url = "http://api0.wmisms.com/yhapi.ashx?act=login&ApiName="+userName+"&PassWord="+password;

        while (tag.equals(errorStr)&&errTime<3){
            Document document = null;
            try {
                document = Jsoup.connect(Login_url).timeout(3000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // System.out.println(document.body().text());
            String buff=document.body().text();
            buffers = buff.split("\\|");
            tag = buffers[0];
            if(tag.equals(successStr)){
                System.out.println("登录成功");
                break;
            }
            System.out.println("尝试登陆错误"+errTime+"次");
            errTime++;
        }
        Usertoken =buffers[1];
        if(errTime==3){
            System.out.println("账号可能存在问题，还是别进行下一步操作了");
        }else{
            System.out.println("用户标识Token为："+Usertoken);
        }
    }

    /**
     * 提取手机号方法实现,注意提取之前要去主动发送短信
     * 返回包含手机号码信息的po类型
     */
    public PhonePo getPhoneNumber(OkHttpClient okhttpclient) throws IOException {
        return getPhoneNumber("随机",okhttpclient);
    }

    /**
     *
     * @param phoneNum 指定要获取的手机号
     * @return 存储号码对象的po
     */
    public PhonePo getPhoneNumber(String phoneNum,OkHttpClient okhttpclient) throws IOException {
        String tag =errorStr;
        String phone_url;
        if(phoneNum.equals("随机")){
            //http://api0.wmisms.com/yhapi.ashx?act=getPhone&token=ad718214bdf8e7ad80344bf9743ec307&iid=1001&did=&operator=&city=&mobile=
            phone_url="http://api0.wmisms.com/yhapi.ashx?act=getPhone&token="+Usertoken+"&iid="+projectID+"&did=&operator=&city=泰国&mobile=";

        }else{
            phone_url="http://api0.wmisms.com/yhapi.ashx?act=getPhone&token="+Usertoken+"&iid="+projectPasswordID+"&did=&operator=&city=&mobile="+phoneNum;
        }
        Response response = null;
        String[] buffers = null;
        int worryTime =0;
        while(tag.equals(errorStr)&&worryTime<2){

            Request.Builder builder = new Request.Builder();
            builder.url(phone_url);
            Request request = builder.get().build();
            response = okhttpclient.newCall(request).execute();

            String buff= null;

            buff = response.body().string();

            buffers = buff.split("\\|");
            tag =buffers[0];
            if(tag.equals(successStr)){
                System.out.println("成功获取手机号: "+buffers[4]+" "+buffers[1]+" "+buffers[6]);
                break;
            }else{
                if(buffers[1].equals("-1")){
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("发生错误，错误信息为: "+buff);
            }
            worryTime++;
        }
        if(worryTime==2){
            System.out.println("获取手机号码失败，将返回空值");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }else{
            PhonePo phonePo = new PhonePo(buffers[1],buffers[2],buffers[3],buffers[4],buffers[6]);
            return phonePo;
        }

    }
    /**
     *
     * @param P_ID 监听验证码的参数
     * @return 获取的验证码
     */
    public String getIdentCode(String P_ID,OkHttpClient okhttpclient) throws IOException {
        //              http://api0.wmisms.com/yhapi.ashx?act=getPhoneCode&token=ad718214bdf8e7ad80344bf9743ec307&pid=100118456007026
        String infoUrl ="http://api0.wmisms.com/yhapi.ashx?act=getPhoneCode&token="+Usertoken+"&pid="+P_ID;
        Response response = null;
        String buff = null;
        String[] buffers;
        String tag =errorStr;
        String result = 0+"";
        int buffer_Num =0;
        while(tag.equals(errorStr)&buffer_Num<10){

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Request.Builder builder = new Request.Builder();
            builder.url(infoUrl);
            Request request = builder.get().build();
            response = okhttpclient.newCall(request).execute();
//                System.out.println(document);


            buff = response.body().string();
            System.out.println(buff);

            buffers = buff.split("\\|");
            tag = buffers[0];
            result = buffers[1];
            if(tag.equals(successStr)){
                return buffers[1];
            }
            else if(result.equals("-4")){
                System.out.println("号码已经强制释放");
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "请求超时";
            }else{
                // System.out.println("nimei: "+buffers[0]+" "+buffers[1]);
            }
            buffer_Num++;
            //System.out.println("tag : "+tag);
        }
        System.out.print("获取验证码失败");
        //smakePhoneBlank(P_ID);
        return "请求超时";
    }

    public void makePhoneBlank(String phone_PID) throws IOException {
        String tag =errorStr;
        //http://api0.wmisms.com/yhapi.ashx?act=addBlack&token=ad718214bdf8e7ad80344bf9743ec307&pid=100118456007026&reason=cannotgetCode
        String blankList = "http://api0.wmisms.com/yhapi.ashx?act=addBlack&token="+Usertoken+"&pid="+phone_PID+"&reason=cannotgetCode";
        Document document = null;
        String[] buffers = null;

        document = Jsoup.connect(blankList).get();

        String buff=document.body().text();
        buffers = buff.split("\\|");
        tag =buffers[0];
        if(tag.equals(successStr)){
            System.out.println("成功加黑手机号: "+tag);
        }else{
            System.out.print("发生错误，错误信息为: "+buff);
        }
        //System.out.println("成功加黑手机号: "+tag);
    }

    public static void main(String[] args) throws IOException {
        EmailGetter emailGetter = EmailGetter.getInstrance();
        OkHttpClient okHttpClient = new OkHttpClient();
        PhonePo phonePo = emailGetter.getPhoneNumber(okHttpClient);
        System.out.println(phonePo.getPhone_Num());
        System.out.println(phonePo.getP_ID());
        System.out.println(emailGetter.getIdentCode(phonePo.getP_ID(),okHttpClient));

    }
}