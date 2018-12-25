package params.tools;

import java.util.Iterator;
import java.util.Map;

/**
 * @program: register
 * @description: 用于生成request请求
 * @author: Mr.Jia
 * @create: 2018-09-01 13:54
 **/
public class ConstructRequestUrl {

    /**
     * 通过输入参数：host，requestMsg，requestToken构造用于请求的url,很傻逼的方法，tm老子要知道所有参数还要给你弄成map才能拿到结果，你妹
     * @param host
     * @param requestMsg
     * @param requestToken
     * @return
     */
    public static String constructUrl(String host, String requestMsg, Map<String, String> requestToken){

        String url = "";
        url += host;
        url += requestMsg;
        url += MapToString(requestToken);

        return url;
    }

    /**
     *
     * @param map 含参数的map，保存参数键值对
     * @return http请求的参数部分
     */
    public static String MapToString(Map map){
        Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
        {
            entry = (Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "=" ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? "&" : "");
        }
        return sb.toString();
    }
}
