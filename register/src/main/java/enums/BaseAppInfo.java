package enums;

/**
 * @program: protocol
 * @description: 与应用有关的基本不变信息的存储位置
 * @author: gaoxiang
 * @create: 2018-08-26 14:57
 **/
public enum BaseAppInfo {
    //与号码有关的枚举类型变量
    version_name("version_name"),version_code("version_code"),update_version_code("update_version_code"),
    unbind_exist("unbind_exist"),type("type"),ticket("ticket"),ssmix("ssmix"),scene("scene"),retry_type("retry_type"),
    resolution("resolution"),os_version("os_version"),os_api("os_api"),openudid("openudid"),mix_mode("mix_mode"),
    manifest_version_code("manifest_version_code"),language("language"),iid("iid"),dpi("dpi"),device_platform("device_platform"),
    device_id("device_id"),channel("channel"),captcha("captcha"),app_name("app_name"),aid("aid"),ac("ac");


    private String vaule;

    private BaseAppInfo(String vaule){
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
