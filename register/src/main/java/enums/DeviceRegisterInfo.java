package enums;

/**
 * @ Author     ：GXDTJJC
 * @ Date       ：Created in 17:08 2018/8/31/031
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public enum DeviceRegisterInfo {

    ac("ac"),channel("channel"),aid("aid"),app_name("app_name"),version_code("version_code"),version_name("version_name"),
    device_platform("device_platform"),ssmix("ssmix"),device_type("device_type"),device_brand("device_brand"),language("language"),
    os_api("os_api"),os_version("os_version"),uuid("uuid"),openudid("openudid"),manifest_version_code("manifest_version_code"),
    resolution("resolution"),dpi("dpi"),update_version_code("update_version_code"),_rticket("_rticket"),tt_data("tt_data");

    private String vaule;
    private DeviceRegisterInfo(String vaule){
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
        if(vaule==null){
            return true;
        }
        return vaule.isEmpty();
    }
}
