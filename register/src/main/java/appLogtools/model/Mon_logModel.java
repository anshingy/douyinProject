package appLogtools.model;

/**
 * @program: hehedada
 * @description: app_log monLog信息模拟存储类
 * @author: Mr.gao
 * @create: 2018-10-24 19:12
 **/
public class Mon_logModel {

    public int id;

    public int log_type;

    public String vaule;

    public Mon_logModel(int id, int log_type, String vaule) {
        this.id = id;
        this.log_type = log_type;
        this.vaule = vaule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLog_type() {
        return log_type;
    }

    public void setLog_type(int log_type) {
        this.log_type = log_type;
    }

    public String getVaule() {
        return vaule;
    }

    public void setVaule(String vaule) {
        this.vaule = vaule;
    }
}
