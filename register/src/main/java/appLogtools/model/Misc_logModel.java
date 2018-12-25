package appLogtools.model;

/**
 * @program: hehedada
 * @description: appLog misclog信息模拟存储类
 * @author: Mr.gao
 * @create: 2018-10-24 19:14
 **/
public class Misc_logModel {

    public int id;

    public String log_type;

    public String value;

    public int session_id;

    public Misc_logModel(int id, String log_type, String value, int session_id) {
        this.id = id;
        this.log_type = log_type;
        this.value = value;
        this.session_id = session_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLog_type() {
        return log_type;
    }

    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }
}
