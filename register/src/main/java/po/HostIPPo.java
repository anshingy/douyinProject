package po;

/**
 * @program: protool
 * @description: 存储ip与端口的po类
 * @author: Mr.gao
 * @create: 2018-09-19 14:05
 **/
public class HostIPPo {

    public String host;
    public int port;

    public HostIPPo(){

    }

    public HostIPPo(String host,int port){
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
