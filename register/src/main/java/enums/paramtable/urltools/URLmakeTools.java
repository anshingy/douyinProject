package enums.paramtable.urltools;

import java.util.HashMap;
import java.util.Map;

public class URLmakeTools {

    /**
     *
     * @param url
     * @param key
     * @param value
     * @return 更改url指定属性的值
     */
    public static String url_exchange(String url,String key,String value){
        String []list = url.split("&");
        String result = "";
        for(int i = 0;i < list.length;i ++){
            String []temp = list[i].split("=");
            if(temp[0].equals(key)){
                temp[1] = value;
            }
            for(int j = 0;j < temp.length;j++){
                result += temp[j];
                if(j < temp.length - 1){
                    result += "=";
                }
            }
            if(i < list.length - 1){
                result += "&";
            }
        }
        return result;
    }

    /**
     *
     * @param url_to_split
     * @return 将url 里面的键值对转化为map
     */
    public static Map url_split(String url_to_split){
        String []list1 = url_to_split.split("[?]");
        String store = list1[list1.length-1];
        String []list2 = store.split("&");
        Map result = new HashMap();
        for(int i = 0;i < list2.length;i++){
            String []temp = list2[i].split("=");
            if(temp.length == 1){
                result.put(temp[0],"");
            }else if(temp.length == 2){
                result.put(temp[0],temp[1]);
            }
        }
        return result;
    }

    /**
     *
     * @param key_value
     * @return 解析  header 内容，转化为 map数据类型
     */
    public static Map header_value_split(String key_value){

        Map result = new HashMap();
        String []list = key_value.split("\n");
        for(int i= 0;i < list.length;i ++){
            String []temp = list[i].split(":");
            result.put(temp[0],temp[1]);
        }
        return  result;
    }

}
