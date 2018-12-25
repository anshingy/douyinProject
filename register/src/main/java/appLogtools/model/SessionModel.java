package appLogtools.model;

/**
 * @program: hehedada
 * @description: app_log中session类型模拟实现类
 * @author: Mr.gao
 * @create: 2018-10-24 19:01
 **/
public class SessionModel {

    public int id;

    public String vaule;
    //时间戳
    public int timestamp;
    //持续时间
    public int duration;
    //目前还不知道是做什么的，猜测可能是树结构的子树类型
    public int non_page;
    //应用版本
    public String app_version;

    public int version_code;
    //停顿时间，目前还不了解他和持续时间之间的区别
    public int pausetime;
    //还不知道是做什么的，大概就是登录时候发送的什么东西的表示吧
    public int launch_sent;

    public SessionModel(int id, String vaule, int timestamp, int duration, int non_page, String app_version, int version_code, int pausetime, int launch_sent) {
        this.id = id;
        this.vaule = vaule;
        this.timestamp = timestamp;
        this.duration = duration;
        this.non_page = non_page;
        this.app_version = app_version;
        this.version_code = version_code;
        this.pausetime = pausetime;
        this.launch_sent = launch_sent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaule() {
        return vaule;
    }

    public void setVaule(String vaule) {
        this.vaule = vaule;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNon_page() {
        return non_page;
    }

    public void setNon_page(int non_page) {
        this.non_page = non_page;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public int getVersion_code() {
        return version_code;
    }

    public void setVersion_code(int version_code) {
        this.version_code = version_code;
    }

    public int getPausetime() {
        return pausetime;
    }

    public void setPausetime(int pausetime) {
        this.pausetime = pausetime;
    }

    public int getLaunch_sent() {
        return launch_sent;
    }

    public void setLaunch_sent(int launch_sent) {
        this.launch_sent = launch_sent;
    }
}
