package appLogtools.model;

/**
 * @program: hehedada
 * @description: app_log模拟page 数据存储类,从逻辑上看page与session有对应关系，每次更新session后，都会有插入page的操作
 * @author: Mr.gao
 * @create: 2018-10-24 18:57
 **/
public class PageModel {

    public int id;

    public String name;
    //持续时间
    public int duration;

    public int session_id;

    public PageModel(int id, String name, int duration, int session_id) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.session_id = session_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }
}
