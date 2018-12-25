package enums.paramtable;

import enums.*;
import enums.paramtable.urltools.URLmakeTools;
import platform.main.UrlBodyCreaterTool;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: protocol
 * @description: 静态表格文件static存储
 * @author: gaoxiang
 * @create: 2018-08-26 13:32
 **/
public class DirTable {
    public static HashMap<BaseNum,String> phone_Table = new HashMap<BaseNum, String>();
    public static HashMap<BaseAppInfo,String> base_APPInfo_Table = new HashMap<BaseAppInfo,String>();
    public static Map<DeviceRegisterInfo,String> base_DeviceRegister_Info = new HashMap<DeviceRegisterInfo,String>();
    public static Map<SendMessageInfo,String> base_Sendmessage_Info = new HashMap<SendMessageInfo,String>();
    public static Map<UserRegisterInfo,String> base_UserRegister_Info = new HashMap<UserRegisterInfo,String>();
    public static Map<UserRegisterBodyInfo,String> userRegisterBodyInfoStringMap = new HashMap<UserRegisterBodyInfo,String>();
    public static Map<SendMessageBodyInfo,String> sendMessageBodyInfoStringMap = new HashMap<SendMessageBodyInfo,String>();

    //注册设备新请求
    public static String servenDeviceRegister = "https://ib.snssdk.com/service/2/device_register/?";

    //xlog 服务器获取发送短信权限
    public static String sendMessagePower = "https://xlog.snssdk.com/do/y?ver=0.4&ts=";
    public static String getSendMessagePowerHost = "https://xlog.snssdk.com/do/y?";

    public static String sendMessageUrl = "https://is.snssdk.com/passport/mobile/send_code/v1/?manifest_version_code=290&_rticket=1540008335578&ac=wifi&device_id=56588880295&iid=46822237622&os_version=8.1.0&channel=xiaomi&version_code=290&device_type=Redmi+6&language=zh&uuid=99001152148151&resolution=720*1344&openudid=f001059818406bc9&update_version_code=2902&app_name=aweme&version_name=2.9.0&os_api=27&device_brand=xiaomi&ssmix=a&device_platform=android&dpi=320&aid=1128&ts=1540008335";
    public static String sendMessageUrlHost = "https://is.snssdk.com/passport/mobile/send_code/v1/?";
    public static String sendMessageBody ="manifest_version_code=290&_rticket=1540008335578&iid=46822237622&channel=xiaomi&device_type=Redmi+6&language=zh&type=3731&uuid=99001152148151&resolution=720*1344&openudid=f001059818406bc9&update_version_code=2902&os_api=27&dpi=320&retry_type=no_retry&ac=wifi&device_id=56588880295&mix_mode=1&os_version=8.1.0&mobile=2e3d3325343d3d25353034302533303235&version_code=290&app_name=aweme&version_name=2.9.0&device_brand=xiaomi&ssmix=a&device_platform=android&aid=1128";

    public static String getOdinTT= UrlBodyCreaterTool.URLDecoderString("https://is.snssdk.com/api/ad/splash/aweme/v14/?_unused=0&carrier=中国移动&mcc_mnc=46000&ad_area=1080x1854&os_api=22&device_platform=android&os_version=5.1&display_density=1080x1920&resolution=1920x1080&dpi=480&language=zh&device_brand=Meizu&device_type=MX5&display_dpi=480&density=3.0&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&update_version_code=1762&version_code=176&version_name=1.7.6&manifest_version_code=1.7.6&iid=43717888625&device_id=41336725255&openudid=ef8ad7929c2e0994&retry_type=no_retry&iid=43717888625&device_id=41336725255&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=MX5&device_brand=Meizu&language=zh&os_api=22&os_version=5.1&uuid=867246022383583&openudid=ef8ad7929c2e0994&manifest_version_code=176&resolution=1080*1920&dpi=480&update_version_code=1762&_rticket=1536551097562&ts=1536551097");
    public static String OdinTTUrlHost = "https://is.snssdk.com/api/ad/splash/aweme/v14/?";

    public static String getRealUrlInfo ="https://i.snssdk.com/ies/antispam/upload_device_info/?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=44101659918&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536993772903&ts=1536993771";
    public static String realUrlInfoHost = "https://i.snssdk.com/ies/antispam/upload_device_info/?";
    public static String realUrlInfoBody = UrlBodyCreaterTool.URLDecoderString("device_info=188&scene=cold_start&retry_type=no_retry&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=44101659918&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536993772903");

    public static String devic_Register = "http://ib.snssdk.com/service/2/device_register/?device_id=41336725255&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=MX5&device_brand=Meizu&language=zh&os_api=22&os_version=5.1&uuid=867246022383583&openudid=ef8ad7929c2e0994&manifest_version_code=176&resolution=1080*1920&dpi=480&update_version_code=1762&_rticket=1536551094457&tt_data=a";
    public static String devic_RegisterHost = "http://ib.snssdk.com/service/2/device_register/?";
    //                                      https://aweme.snssdk.com/aweme/v1/friend/register/notice/?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=44101659918&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1537112048716&ts=1537112048
    public static String friend_Register = "https://aweme.snssdk.com/aweme/v1/friend/register/notice/?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=44560628899&manifest_version_code=176&uuid=123546&dpi=320&version_code=176&app_name=aweme&version_name=1.7.6&openudid=e9167b46b85ea439&device_id=57619473569&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1537682878582&ts=1537682878";
    public static String friend_Register_Hoster = "https://aweme.snssdk.com/aweme/v1/friend/register/notice/?";
    public static String friend_Register_Body = UrlBodyCreaterTool.URLDecoderString("phone_number=%2B66947266128&login_type=0&retry_type=no_retry&os_api=23&device_type=Redmi%204&device_platform=android&ssmix=a&iid=44560628899&manifest_version_code=176&dpi=320&version_code=176&app_name=aweme&version_name=1.7.6&openudid=e9167b46b85ea439&device_id=57619473569&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1537682878582");

    //                                   https://aweme.snssdk.com/aweme/v1/abtest/param/?retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537112048834&ts=1537112048&as=a185f749404f1b97ae6489&cp=7af3b6590ae39d7de1rjph&mas=008bdf8e7a556903dc1465db392dbfa9f69c1c2c6ca686ec9c468c HTTP/1.1
    public static String abtest_Param = "https://aweme.snssdk.com/aweme/v1/abtest/param/?retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878650&ts=1537682878";
    public static String abtest_Param_Hoster = "https://aweme.snssdk.com/aweme/v1/abtest/param/?";

    public static String message_Account = "http://ib.snssdk.com/private_message/account/login_notify/?client_uid=73372799504&retry_type=no_retry&iid=43782700054&device_id=40402989481&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033510131&openudid=ea6c4b63a1678e5b&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536573923064&ts=1536573922";
    public static String message_Account_Hoster = "http://ib.snssdk.com/private_message/account/login_notify/?";

    //批量编写的get类型http请求
    public static String theme_Package = "https://aweme.snssdk.com/aweme/v1/theme/package/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478597&ts=1536674477";
    public static String theme_Package_Hoster = "https://aweme.snssdk.com/aweme/v1/theme/package/?";

    public static String live_Answer = "https://aweme.snssdk.com/aweme/v1/live/answer/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478765&ts=1536674478";
    public static String live_Answer_Hoster = "https://aweme.snssdk.com/aweme/v1/live/answer/?";

    public static String rec_New = "https://aweme.snssdk.com/aweme/v1/rec/new/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478793&ts=1536674478";
    public static String rec_New_Hoster = "https://aweme.snssdk.com/aweme/v1/rec/new/?";

    public static String NoUser_abtest_Param = "https://aweme.snssdk.com/aweme/v1/abtest/param/?retry_type=no_retry&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674476915&ts=1536674477";
    public static String NoUser_abtest_Param_Hoster = "https://aweme.snssdk.com/aweme/v1/abtest/param/?";

    //                                     https://api.amemv.com/aweme/v1/settings/?retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537078121727&ts=1537078121&as=a165eff9d9f60bc32d2050&cp=fa65b45396d2903ce1ztrh&mas=00822584aa96b134df9fa46bfd3a866bc40cac0c4c264cccc6460c HTTP/1.1
    public static String v1_Settings = "https://aweme.snssdk.com/aweme/v1/settings/?retry_type=no_retry&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674476906&ts=1536674476";
    public static String v1_Settings_Hoster = "https://aweme.snssdk.com/aweme/v1/settings/?";
    public static String v1_Settings_User = "https://aweme.snssdk.com/aweme/v1/settings/?retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878720&ts=1537682878";
    public static String v1_Settings_User_Hoster = "https://aweme.snssdk.com/aweme/v1/settings/?";
    //                                        https://api.amemv.com/aweme/v1/lucky/money/newuser/?code=&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674479290&ts=1536674479
    public static String money_New_User = "https://aweme.snssdk.com/aweme/v1/lucky/money/newuser/?code=&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674477755&ts=1536674477";
    public static String money_New_User_Hoster = "https://aweme.snssdk.com/aweme/v1/lucky/money/newuser/?";
    public static String money_New_User1 = "https://aweme.snssdk.com/aweme/v1/lucky/money/newuser/?code=&retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878725&ts=1537682879";
    public static String money_New_User1_Hoster = "https://aweme.snssdk.com/aweme/v1/lucky/money/newuser/?";

    //                                        https://api.amemv.com/aweme/v1/lucky/money/settings/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674479299&ts=1536674479
    //                                        https://api.amemv.com/aweme/v1/lucky/money/settings/?retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537078121730&ts=1537078121&as=a155ff79f9d67b637d2789&cp=fd60b85590d39a33e1vfsm&mas=005bd3e46853f2a79cddc156756fe4e0649c1cec4c26eccc6c46ec HTTP/1.1
    public static String money_Settings = "https://aweme.snssdk.com/aweme/v1/lucky/money/settings/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674477755&ts=1536674477";
    public static String money_Settings_Hoster = "https://aweme.snssdk.com/aweme/v1/lucky/money/settings/?";
    //                                      https://aweme.snssdk.com/aweme/v1/lucky/money/settings/?retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878724&ts=1537682879&as=a175a23abf8b6b9da73827&cp=23b5b957ff74aed4e1devl&mas=00cd203becffc8e4dbb5e2f43344c5f630ec4c1cccec86269c466c HTTP/1.1
    public static String money_Settings1 = "https://aweme.snssdk.com/aweme/v1/lucky/money/settings/?retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878724&ts=1537682879";
    public static String money_Settings1_Hoster = "https://aweme.snssdk.com/aweme/v1/lucky/money/settings/?";
    //                                    https://api.amemv.com/aweme/v1/license/?retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537078122253&ts=1537078122&as=a115af59da769be36d7052&cp=fa6bb450afde903ee1havs&mas=00e630cd6a7fa86cdb9fa2bda525f70c044cac0cec266ccca6469c HTTP/1.1
    public static String v1_License = "https://api.amemv.com/aweme/v1/license/?retry_type=no_retry&iid=44136317660&device_id=40402989481&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033510131&openudid=ea6c4b63a1678e5b&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537261925331&ts=1537261924";
    public static String v1_License_Hoster = "https://aweme.snssdk.com/aweme/v1/license/?";

    public static String setting_V2 = "https://lf.snssdk.com/service/settings/v2/?app=1&default=1&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478838&ts=1536674478";
    public static String setting_V2_Hoster = "https://lf.snssdk.com/service/settings/v2/?";
                                                                          //https://is.snssdk.com/api/ad/splash/aweme/v14/
    public static String aweme_V14 = UrlBodyCreaterTool.URLDecoderString("https://ib.snssdk.com/api/ad/splash/aweme/v14/?_unused=0&carrier=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8&mcc_mnc=46000&ad_area=720x1232&os_api=23&device_platform=android&os_version=6.0.1&display_density=720x1280&resolution=1280x720&dpi=320&language=zh&device_brand=Xiaomi&device_type=Redmi%204X&display_dpi=320&density=2.0&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&update_version_code=1762&version_code=176&version_name=1.7.6&manifest_version_code=1.7.6&iid=43781427613&device_id=49921025034&openudid=b43cbd9293e9f6da&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478821&ts=1536674478");
    public static String aweme_V14_Hoster = "https://ib.snssdk.com/api/ad/splash/aweme/v14/?";

    public static String screen_Ad = "https://aweme.snssdk.com/aweme/v1/screen/ad/?_unused=0&display_density=720x1280&access=wifi&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478868&ts=1536674478";
    public static String screen_Ad_Hoster = "https://aweme.snssdk.com/aweme/v1/screen/ad/?";

    public static String service_2_app_Alert = UrlBodyCreaterTool.URLDecoderString("https://lf.snssdk.com/service/2/app_alert/?has_market=1&lang=zh&carrier=%E4%B8%AD%E5%9B%BD%E7%A7%BB%E5%8A%A8&mcc_mnc=46000&access=wifi&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478843&ts=1536674478");
    public static String service_2_app_Alert_Hoster = "https://lf.snssdk.com/service/2/app_alert/?";

    public static String sdk_Log = "https://api.amemv.com/aweme/v1/crawl/sdk/log/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674479561&ts=1536674479";
    public static String sdk_Log_Hoster = "https://api.amemv.com/aweme/v1/crawl/sdk/log/?";

    public static String v1_feed = UrlBodyCreaterTool.URLDecoderString("https://aweme.snssdk.com/aweme/v1/feed/?type=0&max_cursor=0&min_cursor=0&count=6&volume=0.13333333333333333&pull_type=0&ts=1536674479&app_type=normal&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674479755");
    public static String v1_feed_Hoster = "https://aweme.snssdk.com/aweme/v1/feed/?";

    public static String account_logout_notify = "http://ib.snssdk.com/private_message/account/logout_notify/?retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674480692&ts=1536674479";
    public static String account_logout_notify_Hoster = "http://ib.snssdk.com/private_message/account/logout_notify/?";

    public static String private_message_account_logout_notify = "http://ib.snssdk.com/private_message/account/login_notify/?client_uid=104550819602&retry_type=no_retry&iid=44136317660&device_id=40402989481&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033510131&openudid=ea6c4b63a1678e5b&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537261925804&ts=1537261925";
    public static String private_message_account_logout_notify_Hoster = "http://ib.snssdk.com/private_message/account/login_notify/?";

    public static String appmonitor_Settings_noSrckey = "http://mon.snssdk.com/monitor/appmonitor/v2/settings?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674488880&encrypt=close";
    public static String appmonitor_Settings_noSrckey_Hoster = "http://mon.snssdk.com/monitor/appmonitor/v2/settings?";

    public static String app_notice_status = "http://ib.snssdk.com/service/1/app_notice_status/?os_api=23&device_type=Redmi+4X&dpi=320&system_notify_status=1&version_code=176&rom=MIUI-7.5.19&app_name=aweme&os=android&version_name=1.7.6&package=com.ss.android.ugc.aweme&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&notice=0&aid=1128&channel=tengxun&retry_type=no_retry&iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674491486&ts=1536674490";
    public static String app_notice_status_Hoster = "http://ib.snssdk.com/service/1/app_notice_status/?";

    public static String check_In_Str = "https://aweme.snssdk.com/aweme/v1/check/in/?retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878716&ts=1537682878";
    public static String cheak_In_Hoster = "https://aweme.snssdk.com/aweme/v1/check/in/?";

    //                               https://aweme.snssdk.com/aweme/v1/user/?retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537112048874&ts=1537112048&as=a19587a9c0effbb7be3371&cp=7ef4bb5302e79c7ee1encz&mas=00949f9e6d72415d824372ab5f614e8ec08ceccccca646ec464666 HTTP/1.1
    public static String v1_User_Str = "https://aweme.snssdk.com/aweme/v1/user/?retry_type=no_retry&iid=44560628899&device_id=57619473569&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&openudid=e9167b46b85ea439&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537682878717&ts=1537682878";
    public static String v1_User_Str_Hoster = "https://aweme.snssdk.com/aweme/v1/user/?";
    //                                         https://aweme.snssdk.com/aweme/v1/spotlight/relation/?count=1000&with_fstatus=1&max_time=1537682878773&min_time=0&ts=1537682879&app_type=normal&os_api=23&device_type=Redmi%204&device_platform=android&ssmix=a&iid=44560628899&manifest_version_code=176&dpi=320&version_code=176&app_name=aweme&version_name=1.7.6&openudid=e9167b46b85ea439&device_id=57619473569&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1537682878882&as=a105f2ba2fbbcbdd671640&cp=29b7b151fa77aadde1yjcl&mas=0089125a7c7175a6dceec1cefb59612b060c2c6c8cec6c262646c6 HTTP/1.1
    public static String spotlight_relation = "https://aweme.snssdk.com/aweme/v1/spotlight/relation/?count=1000&with_fstatus=1&max_time=1537261925105&min_time=0&ts=1537261924&app_type=normal&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=44136317660&manifest_version_code=176&dpi=320&uuid=866709033510131&version_code=176&app_name=aweme&version_name=1.7.6&openudid=ea6c4b63a1678e5b&device_id=40402989481&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1537261925259";
    public static String spotlight_relation_Hoster = "https://aweme.snssdk.com/aweme/v1/spotlight/relation/?";

    //                                   https://api.amemv.com/aweme/v1/story/?cursor=0&count=20&page_id=2&retry_type=no_retry&iid=44136317660&device_id=40402989481&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033510131&openudid=ea6c4b63a1678e5b&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537265990048&ts=1537265990&as=a115dd1a06f4bb91c03050&cp=d64bba526101ad16e1eagn&mas=0057572a3e262b659e24fea335cc1c53d80cac0ccc0cc68c9c4646 HTTP/1.1
    public static String v1_Story_Str = "https://api.amemv.com/aweme/v1/story/?cursor=0&count=20&page_id=2&retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537078124285&ts=1537078123";
    public static String v1_Story_Str_Hoster = "https://api.amemv.com/aweme/v1/story/?";

    //                                    https://api.amemv.com/aweme/v1/story/list/?user_id=104555110002&retry_type=no_retry&iid=44136317660&device_id=40402989481&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033510131&openudid=ea6c4b63a1678e5b&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537265990029&ts=1537265990&as=a1d55ddae6c48b81b07350&cp=df4fb8526605ab16e1fedp&mas=0052a99f2b290b41cfd77592711f885a4e0cacccec0c468c1c461c HTTP/1.1
    public static String v1_Story_List = "https://api.amemv.com/aweme/v1/story/list/?user_id=104501827511&retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537078124292&ts=1537078123";
    public static String v1_Story_List_Hoster = "https://api.amemv.com/aweme/v1/story/list/?";

    public static String lucky_Money_Str = "https://api.amemv.com/aweme/v1/lucky/money/newuser/?code=&retry_type=no_retry&iid=44101659918&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1537078121729&ts=1537078121";
    public static String lucky_Money_Str_Hoster = "https://api.amemv.com/aweme/v1/lucky/money/newuser/?";

    public static String im_Chatlist ="https://aweme.snssdk.com/aweme/v1/im/chatlist/?aid=1128&device_id=40402989481&index=0";
    public static String im_Chatlist_Hoster = "https://aweme.snssdk.com/aweme/v1/im/chatlist/?";

    //批量编写的post类型的https请求
    public static String z_App_Stats_Nosrekey = "https://lf.snssdk.com/service/1/z_app_stats/?iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478883&_apps=1&_recent=1&rom=MIUI-7.5.19&time_first_send_install_app=1536674478885";
    public static String z_App_Stats_Nosrekey_Hoster = "https://lf.snssdk.com/service/1/z_app_stats/?";

    //                                                    http://log.snssdk.com/service/2/log_settings/?iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478008&tt_data=a&config_retry=b
    public static String service_Log_Settings_Nosrekey = "http://log.snssdk.com/service/2/log_settings/?iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674477730&tt_data=a";
    public static String service_Log_Settings_Nosrekey_Hoster = "http://log.snssdk.com/service/2/log_settings/?";
    public static String service_Log_Settings_Nosrekey1 = "http://log.snssdk.com/service/2/log_settings/?iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674478008&tt_data=a&config_retry=b";

    public static String config_V1_Nosrekey = "https://lf.snssdk.com/api/plugin/config/v1/?iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674477821";
    public static String config_V1_Nosrekey_Hoster = "https://lf.snssdk.com/api/plugin/config/v1/?";

    public static String cloudpush_Updata_Sender = "http://ib.snssdk.com/cloudpush/update_sender/?os_api=23&device_type=Redmi+4X&dpi=320&system_notify_status=1&version_code=176&rom=MIUI-7.5.19&app_name=aweme&os=android&version_name=1.7.6&package=com.ss.android.ugc.aweme&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&notice=0&aid=1128&channel=tengxun&os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=43782700054&manifest_version_code=176&dpi=320&uuid=866709033510131&version_code=176&app_name=aweme&version_name=1.7.6&openudid=ea6c4b63a1678e5b&device_id=40402989481&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536816801873&ts=1536816803";
    public static String cloudpush_Updata_Sender_Hoster = "http://ib.snssdk.com/cloudpush/update_sender/?";
    public static String cloudpush_Updata_Sender_Body = UrlBodyCreaterTool.URLDecoderString("push_sdk=%5B1%2C2%2C6%2C7%2C8%2C9%5D&retry_type=no_retry&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674477983");

    public static String service_2_App_Log_Nosrekey = "http://log.snssdk.com/service/2/app_log/?iid=43781427613&device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536674480464&tt_data=a";
    public static String service_2_App_Log_Nosrekey_Hoster = "http://log.snssdk.com/service/2/app_log/?";

    public static String v1_Aweme_Stats = "https://api.amemv.com/aweme/v1/aweme/stats/?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674484069&ts=1536674483";
    public static String v1_Aweme_Stats_Hoster = "https://api.amemv.com/aweme/v1/aweme/stats/?";
    public static String v1_Aweme_Stats_Body = UrlBodyCreaterTool.URLDecoderString("item_id=6599034713879350535&tab_type=0&play_delta=1&aweme_type=0&retry_type=no_retry&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674484069");

    public static String location_Sulite = "https://ib.snssdk.com/location/sulite/?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674487105&ts=1536674486";
    public static String location_Sulite_Hoster = "https://ib.snssdk.com/location/sulite/?";
    public static String location_Sulite_Body = UrlBodyCreaterTool.URLDecoderString("dwinfo=5r_x8v786fTy88L7-Pj5__z-9r-n5r_-8Pm_p62xv_H87unC9PPp-O_r_PG_p6yorqurqqmppaqxv_Hy_sL0-b-nv7-xv_Ltwunk7fi_p62xv_Ltwun08Pi_p62xv_H87unC6fTw-L-nreCxv_Hy_vzp9PLzwu746en08_q_p63g&retry_type=no_retry&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=43781427613&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1536674487105");

    public static String device_Register_String = "http://ib.snssdk.com/service/2/device_register/?device_id=49921025034&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=Redmi+4X&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0.1&uuid=866709033393413&openudid=b43cbd9293e9f6da&manifest_version_code=176&resolution=720*1280&dpi=320&update_version_code=1762&_rticket=1536992507195&tt_data=a";
    public static String device_Register_Hoster = "http://ib.snssdk.com/service/2/device_register/?";

    public static String monitor_collect_Str_NoSrcKey = "https://mon.snssdk.com/monitor/collect/?os_api=23&device_type=Redmi+4X&device_platform=android&ssmix=a&iid=44101659918&manifest_version_code=176&dpi=320&uuid=866709033393413&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b43cbd9293e9f6da&device_id=49921025034&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1537078136718";
    public static String monitor_collect_Str_Hoster = "https://mon.snssdk.com/monitor/collect/?";

    static{
        phone_Table.put(BaseNum.zero,"35");
        phone_Table.put(BaseNum.one,"34");
        phone_Table.put(BaseNum.two,"37");
        phone_Table.put(BaseNum.three,"36");
        phone_Table.put(BaseNum.four,"31");
        phone_Table.put(BaseNum.five,"30");
        phone_Table.put(BaseNum.six,"33");
        phone_Table.put(BaseNum.serven,"32");
        phone_Table.put(BaseNum.eight,"3d");
        phone_Table.put(BaseNum.nine,"3c");
        phone_Table.put(BaseNum.plus,"2e");
        phone_Table.put(BaseNum.blank,"25");
        phone_Table.put(BaseNum.star,"2f");
        //字母表对应值
        phone_Table.put(BaseNum.a,"64");
        phone_Table.put(BaseNum.s,"76");
        phone_Table.put(BaseNum.d,"61");
    }

    static{
        base_APPInfo_Table.put(BaseAppInfo.version_name,"2.3.0");
        base_APPInfo_Table.put(BaseAppInfo.version_code,"230");
        base_APPInfo_Table.put(BaseAppInfo.update_version_code,"2302");
        base_APPInfo_Table.put(BaseAppInfo.unbind_exist,"0");
        base_APPInfo_Table.put(BaseAppInfo.type,"3731");
        base_APPInfo_Table.put(BaseAppInfo.ticket,"");
        base_APPInfo_Table.put(BaseAppInfo.ssmix,"a");
        base_APPInfo_Table.put(BaseAppInfo.scene,"0");
        base_APPInfo_Table.put(BaseAppInfo.retry_type,"no_retry");
        base_APPInfo_Table.put(BaseAppInfo.resolution,"1400*900");
        base_APPInfo_Table.put(BaseAppInfo.os_version,"5.1.1");
        base_APPInfo_Table.put(BaseAppInfo.os_api,"22");
        base_APPInfo_Table.put(BaseAppInfo.openudid,"f8d10149126e89d9");
        base_APPInfo_Table.put(BaseAppInfo.mix_mode,"1");
        base_APPInfo_Table.put(BaseAppInfo.manifest_version_code,"230");
        base_APPInfo_Table.put(BaseAppInfo.language,"zh");
        //模拟器或者app相关属性
        base_APPInfo_Table.put(BaseAppInfo.iid,"42055406212");
        base_APPInfo_Table.put(BaseAppInfo.dpi,"240");
        base_APPInfo_Table.put(BaseAppInfo.device_platform,"android");
        //模拟器相关属性
        base_APPInfo_Table.put(BaseAppInfo.device_id,"5663125458");
        base_APPInfo_Table.put(BaseAppInfo.channel,"xiaomi");
        base_APPInfo_Table.put(BaseAppInfo.captcha,"");
        base_APPInfo_Table.put(BaseAppInfo.app_name,"aweme");
        base_APPInfo_Table.put(BaseAppInfo.aid,"1128");
        base_APPInfo_Table.put(BaseAppInfo.ac,"wifi");
    }

    static{
        String buff="ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=vivo+y51a&device_brand=vivo&language=zh&os_api=22&os_version=5.1.1&uuid=865166029262923&openudid=b52b1961bfc67907&manifest_version_code=176&resolution=720*1280&dpi=240&update_version_code=1762&_rticket=1535619578298&tt_data=a \n";
        Map map = URLmakeTools.url_split(buff);
        for(DeviceRegisterInfo deviceRegisterInfo:DeviceRegisterInfo.values()){
            String vaule_Buff = (String) map.get(deviceRegisterInfo.getVaule());
            //System.out.println(deviceRegisterInfo.getVaule()+"   "+vaule_Buff);
            base_DeviceRegister_Info.put(deviceRegisterInfo,vaule_Buff);
        }
    }

    static{
        String version = 260+"";
        String buff="https://is.snssdk.com/passport/mobile/send_code/?os_api=22&device_type=vivo+y51a&device_platform=android&ssmix=a&iid=42690885679" +
                "&manifest_version_code=260&dpi=240&uuid=865166029262923&version_code=260&app_name=aweme&version_name=2.6.0&" +
                "openudid=b52b1961bfc67907&device_id=38678816574&resolution=1280*720&os_version=5.1.1&language=zh&device_brand=vivo" +
                "&ac=wifi&update_version_code=2602&aid=1128&channel=tengxun&_rticket=1535858139263&ts=1535858138&as=a1f565a87aad5b058b3210" +
                "&cp=5dd1b15ea1be8958e1qber&mas=000cead8f97453930c880f7f9b771e31820c8c4ccc461cac0c46ac";
        Map map = URLmakeTools.url_split(buff);
        for(SendMessageInfo baseSendMessageInfo: SendMessageInfo.values()){
            String vaule_Buff = (String) map.get(baseSendMessageInfo.getVaule());
            //System.out.println(deviceRegisterInfo.getVaule()+"   "+vaule_Buff);
            base_Sendmessage_Info.put(baseSendMessageInfo,vaule_Buff);
        }
    }

    static{
        String buff="https://is.snssdk.com/passport/mobile/register/?os_api=22&device_type=vivo+y51a&device_platform=android&ssmix=a&iid=42690885679&manifest_version_code=176" +
                "&dpi=240&uuid=865166029262923&version_code=176&app_name=aweme&version_name=1.7.6&openudid=b52b1961bfc67907&device_id=38678816574&resolution=1280*720&os_version=5.1.1" +
                "&language=zh&device_brand=vivo&ac=wifi&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1535858363961&ts=1535858363&as=a1154508eb0b1b06cb2458" +
                "&cp=5db4bb5dbab18968e1wdeh&mas=00e9d5ee6bd7691f8ec958b1a3b3daf3b01cac2c4c46c66c0c468c";
        Map map = URLmakeTools.url_split(buff);
        for(UserRegisterInfo userRegisterInfo: UserRegisterInfo.values()){
            String vaule_Buff = (String) map.get(userRegisterInfo.getVaule());
            //System.out.println(deviceRegisterInfo.getVaule()+"   "+vaule_Buff);
            base_UserRegister_Info.put(userRegisterInfo,vaule_Buff);
        }
    }

    static{
        String buff="mix_mode=1&type=34&mobile=2e3d333032313136363436343136&retry_type=no_retry&os_api=23&device_type=Redmi%204X&device_platform=android&ssmix=a&iid=44136317660&manifest_version_code=260&dpi=320&uuid=866709033510131&version_code=260&app_name=aweme&version_name=2.6.0&openudid=ea6c4b63a1678e5b&device_id=40402989481&resolution=720*1280&os_version=6.0.1&language=zh&device_brand=Xiaomi&ac=wifi&update_version_code=2602&aid=1128&channel=tengxun&_rticket=1537003017593\n";
        Map map = URLmakeTools.url_split(buff);
        for(SendMessageBodyInfo sendMessageBodyInfo: SendMessageBodyInfo.values()){
            String vaule_Buff = (String) map.get(sendMessageBodyInfo.getVaule());
            //System.out.println(deviceRegisterInfo.getVaule()+"   "+vaule_Buff);
            sendMessageBodyInfoStringMap.put(sendMessageBodyInfo,vaule_Buff);
        }
    }

    static{
        String buff="password=3437363734363734363734363734&mix_mode=1&type=36&code=36343736&mobile=2e3d333734363437363734363734&retry_type=no_retry&os_api=22&device_type=vivo y51a" +
                "&device_platform=android&ssmix=a&iid=43016694171&manifest_version_code=176&dpi=240&uuid=865166029262923&version_code=176&app_name=aweme&version_name=1.7.6" +
                "&openudid=b52b1961bfc67907&device_id=38678816574&resolution=720*1280&os_version=5.1.1&language=zh&device_brand=vivo&ac=wifi" +
                "&update_version_code=1762&aid=1128&channel=tengxun&_rticket=1535888618988";
        Map map = URLmakeTools.url_split(buff);
        for(UserRegisterBodyInfo userRegisterBodyInfo: UserRegisterBodyInfo.values()){
            String vaule_Buff = (String) map.get(userRegisterBodyInfo.getVaule());
            //System.out.println(deviceRegisterInfo.getVaule()+"   "+vaule_Buff);
            userRegisterBodyInfoStringMap.put(userRegisterBodyInfo,vaule_Buff);
        }
    }

    static{
        String getOdinTT="https://is.snssdk.com/api/ad/splash/aweme/v14/?_unused=0&carrier=CHINA MOBILE&mcc_mnc=46000&ad_area=720x1242&os_api=22&device_platform=android&os_version=5.1.1&display_density=720x1280&resolution=1280x720&dpi=240&language=zh&device_brand=oppo&device_type=oppo r9 plustm a&display_dpi=240&density=1.5&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&update_version_code=1762&version_code=176&version_name=1.7.6&manifest_version_code=1.7.6&iid=43079687515&device_id=48541273910&openudid=a2d6c94ee4e82e0b&retry_type=no_retry&iid=43079687515&device_id=48541273910&ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=oppo+r9+plustm+a&device_brand=oppo&language=zh&os_api=22&os_version=5.1.1&uuid=865166026206394&openudid=a2d6c94ee4e82e0b&manifest_version_code=176&resolution=720*1280&dpi=240&update_version_code=1762&_rticket=1535968153157&ts=1535968152";
    }

    public static void main(String[]args){
        /**
        String buff="ac=wifi&channel=tengxun&aid=1128&app_name=aweme&version_code=176&version_name=1.7.6&device_platform=android&ssmix=a&device_type=vivo+y51a&device_brand=vivo&language=zh&os_api=22&os_version=5.1.1&uuid=865166029262923&openudid=b52b1961bfc67907&manifest_version_code=176&resolution=720*1280&dpi=240&update_version_code=1762&_rticket=1535619578298&tt_data=a \n";
        Map map = URLmakeTools.url_split(buff);
        for(Object key:map.keySet()){
            System.out.println(key+" kao "+map.get(key));
        }
         **/

        DirTable dirTable = new DirTable();
        //System.out.println(dirTable);
    }

}
