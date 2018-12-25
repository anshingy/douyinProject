package appLogtools.model;

/**
 * @program: hehedada
 * @description: 用来模拟applog中event的模拟类
 * @author: Mr.gao
 * @create: 2018-10-24 18:50
 **/
public class EventModel {
    //目前猜测此处与dyUser的eventID相对应
    public int id;
    //部门、种类、类别、类目
    public String category;

    public String tag;

    public String label;

    public int vaule;

    public int ext_vaule;
    //数据库中对应text类型，目测是长文本文件
    public String ext_json;

    public int user_id;
    //时间戳
    public int timestamp;

    public int session_id;

    public EventModel(int id, String category, String tag, String label, int vaule, int ext_vaule, String ext_json, int user_id, int timestamp, int session_id) {
        this.id = id;
        this.category = category;
        this.tag = tag;
        this.label = label;
        this.vaule = vaule;
        this.ext_vaule = ext_vaule;
        this.ext_json = ext_json;
        this.user_id = user_id;
        this.timestamp = timestamp;
        this.session_id = session_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getVaule() {
        return vaule;
    }

    public void setVaule(int vaule) {
        this.vaule = vaule;
    }

    public int getExt_vaule() {
        return ext_vaule;
    }

    public void setExt_vaule(int ext_vaule) {
        this.ext_vaule = ext_vaule;
    }

    public String getExt_json() {
        return ext_json;
    }

    public void setExt_json(String ext_json) {
        this.ext_json = ext_json;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }
}
