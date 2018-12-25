package jsonreader.tools;


import util.MD5Code;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


public class DeviceInfoCreater {


    public static Map getResult(){
        String []type = {"oppo r11","oppo r11 plus","xiaomi 6"};
        Random rand = new Random();
        int size = rand.nextInt(type.length);
        String device_type = type[size];
        String device_brand = type[size].split(" ")[0];
        String uuid_temp = String.valueOf(new Random(System.currentTimeMillis()).nextInt(9999999));
        String []temp = uuid_temp.split("");
        String uuid = getUDIDCode();
        String line = new MD5Code().getMD5ofStr(uuid_temp);
        String openudid = "";
        char []list = line.toCharArray();
        for(int i = 0;i < 16;i ++){
            openudid += String.valueOf(list[i]).toLowerCase();
        }
        Map result = new HashMap();
        //device_type=f103&device_brand=gionee&uuid=865166024287115&openudid=06e7aa24d4d4c8a4

        result.put("device_type",device_type);
        result.put("device_brand",device_brand);
        result.put("uuid",uuid);
        result.put("openudid",openudid);
        return result;
    }

    /**
     *
     * @param data 存储键值对的map
     * @return map转url参数
     */
    public static String getWholeStr(Map data){
        String result = "";
        for(Object key : data.keySet()){
            String value = String.valueOf(data.get(key));
            result += "&"+key+"="+value;
        }
        char []array = result.toCharArray();
        String str = "";
        for(int i = 1;i< array.length;i++){
            str += array[i];
        }
        return str;
    }

    public static String getUDIDCode(){
        String line1 = "865166";
        String line2 = String.valueOf(new java.util.Random(System.currentTimeMillis()).nextInt(99999999));

        for(int i = 0;i < 8 - line2.length();i++){
            line1 += "0";
        }
        String line3 = String.valueOf(new java.util.Random(System.currentTimeMillis()).nextInt(9));

        String result = line1 + line2+line3;
        return  result;
    }


    public static void main(String[]args){
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID());
    }
}
