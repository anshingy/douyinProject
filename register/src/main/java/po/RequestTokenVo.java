package po;

import java.util.Map;

/**
 * @program: register
 * @description: request请求Url构造的VO类,创建vo对象前调用ConstructRequestUrl方法构造url
 * @author: Mr.Jia
 * @create: 2018-09-01 11:10
 **/

public class RequestTokenVo {
    private String Url;
    private Map<String, String> header;
    private Map<String, String> body;


    //setter&getter
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }

    //toString
    @Override
    public String toString() {
        return "RequestTokenVO{" +
                "Url='" + Url + '\'' +
                ", header=" + header +
                ", body=" + body +
                '}';
    }
    public RequestTokenVo(){

    }
    public RequestTokenVo(String url, Map<String, String> header, Map<String, String> body){
        this.Url = url;
        this.header = header;
        this.body = body;
    }



}
