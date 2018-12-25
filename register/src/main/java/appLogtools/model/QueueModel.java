package appLogtools.model;

/**
 * @program: hehedada
 * @description: app_log 模拟中的queue类型存储类 ,猜测用于统计上个发送某某数据时的结果，包含崩溃信息，大概是对网络环境的检查
 * @author: Mr.gao
 * @create: 2018-10-24 19:06
 **/
public class QueueModel {

    public int id;
    //数据库中对应类型为text类型，推测为用户上传信息等操作的缓存数据为内容
    public String vaule;
    //标记是否崩溃，更加证实了猜想，应该是指访问、修改密码、上传文件等操作结果的指标
    public int is_crash;
    //日志类型，具体意义待定
    public int log_type;

    public int timestamp;
    //从源代码分析得，该数字最高为5（5的时候就被抛弃了）
    public int retry_count;

    public int retry_time;

    public QueueModel(int id, String vaule, int is_crash, int log_type, int timestamp, int retry_count, int retry_time) {
        this.id = id;
        this.vaule = vaule;
        this.is_crash = is_crash;
        this.log_type = log_type;
        this.timestamp = timestamp;
        this.retry_count = retry_count;
        this.retry_time = retry_time;
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

    public int getIs_crash() {
        return is_crash;
    }

    public void setIs_crash(int is_crash) {
        this.is_crash = is_crash;
    }

    public int getLog_type() {
        return log_type;
    }

    public void setLog_type(int log_type) {
        this.log_type = log_type;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getRetry_count() {
        return retry_count;
    }

    public void setRetry_count(int retry_count) {
        this.retry_count = retry_count;
    }

    public int getRetry_time() {
        return retry_time;
    }

    public void setRetry_time(int retry_time) {
        this.retry_time = retry_time;
    }
}
