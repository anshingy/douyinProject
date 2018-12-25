package httpmaker;

import okhttp3.FormBody;
import okhttp3.Request;
import po.RequestTokenVo;

import java.io.IOException;
import java.util.Map;

/**
 * @program: register
 * @description: 构造get请求的基础方法类
 * @author: Mr.Jia
 * @create: 2018-09-01 14:15
 **/
public class ConstructRequest
{

    public static Request constructGet(RequestTokenVo requestTokenVo){
        // 构建GET请求，并设置请求消息头
        //requestEntity中包含三部分，Url、Header，body为空
        Request.Builder builder = new Request.Builder();
        builder.url(requestTokenVo.getUrl());
        Map<String,String> headerParams = requestTokenVo.getHeader();
        for(String key : headerParams.keySet()){
            builder.addHeader(key, headerParams.get(key));
        }
        Request request = builder.get().build();


        return request;
    }


    public static Request constructPost(RequestTokenVo requestTokenVo){
        // 构建POST请求，并设置请求消息头
        //requestEntity中包含三部分，Url、Header和Body
        FormBody.Builder formBody = new FormBody.Builder();     //创建表单请求体

        Request.Builder builder = new Request.Builder();
        builder.url(requestTokenVo.getUrl());
        Map<String, String> headerParams = requestTokenVo.getHeader();
        Map<String, String> bodyParams = requestTokenVo.getBody();
        for(String key : headerParams.keySet()){        //添加header信息
            builder.addHeader(key, headerParams.get(key).trim());
        }
        for(String key : bodyParams.keySet()){      //添加body信息
//            builder.post(formBody.build()).build();
            formBody.add(key, bodyParams.get(key));
        }
        Request request = builder.post(formBody.build()).build();


        return request;
    }


}
