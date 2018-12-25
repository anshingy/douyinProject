package enums;

/**
 * @program: protocol
 * @description: 基本的请求类型枚举类
 * @author: gaoxiang
 * @create: 2018-08-27 14:36
 **/
public enum BaseRequestTpyeInfo {

    registerMessage("registerMessage"),registerEnd("registerEnd"),sendPassword("sendPassword"),
    sendPasswordMessage("sendPasswordMessage"),sendPasswordEnd("sendPasswordEnd");

    private String vaule;

    private BaseRequestTpyeInfo(String vaule){
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
