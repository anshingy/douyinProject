package enums;

/**
 * @program: protool
 * @description: 发送验证码请求的body属性
 * @author: Mr.gao
 * @create: 2018-09-02 21:12
 **/
public enum SendMessageBodyInfo {

    mix_mode("mix_mode"),type("type"),mobile("mobile"),retry_type("retry_type"),os_api("os_api"),
    device_type("device_type"),device_platform("device_platform"),ssmix("ssmix"),iid("iid"),
    manifest_version_code("manifest_version_code"),dpi("dpi"),uuid("uuid"),version_code("version_code"),
    app_name("app_name"),version_name("version_name"),openudid("openudid"),device_id("device_id"),
    resolution("resolution"),os_version("os_version"),language("language"),device_brand("device_brand"),
    ac("ac"),update_version_code("update_version_code"),aid("aid"),channel("channel"),_rticket("_rticket");
    private String vaule;

    private SendMessageBodyInfo(String vaule){
        this.vaule = vaule;
    }
    public String getVaule(){
        return vaule;
    }

    public Boolean isEquals(String num){
        if (num.equals(vaule)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isEmpty(){
        return vaule.isEmpty();
    }
}
