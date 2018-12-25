package platform.main;

import com.space.register.entity.DeviceEntity;
import enums.paramtable.DirTable;
import enums.paramtable.urltools.URLmakeTools;
import httpmaker.ConstructRequest;
import okhttp3.Request;
import params.ParamCreater;
import params.tools.KeyControler;
import po.RequestTokenVo;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: protool
 * @description: 获取设备权限的get请求实现
 * @author: Mr.gao
 * @create: 2018-09-12 16:18
 **/
public class DevicerAbleGetter {
    //切割url成包含所有vaule的map的方法
    //Map map = URLmakeTools.url_split(DirTable.getOdinTT);

    /**
     * 自动添加host 和 cookie http头
     * @param hoster
     * @param allVauleUrl
     * @param deviceEntity
     * @param needKey
     * @return
     */
    public static Request getRealDeviceRequsets(String hoster,String allVauleUrl, DeviceEntity deviceEntity,Boolean needKey){
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host", hoster.split("/")[2]);
        headers.put("Cookie",deviceEntity.getCookie()+";"+"qh[360]=1");
        return getRealDeviceRequsetsWithHeads(hoster,allVauleUrl,headers,deviceEntity,needKey);
    }

    public static Request getRealDeviceRequsetsOnlyHost(String hoster,String allVauleUrl, DeviceEntity deviceEntity,Boolean needKey){
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host", hoster.split("/")[2]);
        return getRealDeviceRequsetsWithHeads(hoster,allVauleUrl,headers,deviceEntity,needKey);
    }
    /**
     *  header 比较特殊时调用的方法，此时的headers填入自己需要的变量，一般是特殊的cookie和host
     * @param hoster
     * @param allVauleUrl
     * @param headers
     * @param deviceEntity
     * @param needKey
     * @return
     */
    public static Request getRealDeviceRequsetsWithHeads(String hoster,String allVauleUrl, Map<String,String> headers, DeviceEntity deviceEntity,Boolean needKey){
        Map<String,String> allVaule = URLmakeTools.url_split(allVauleUrl);
        String url = UrlBodyCreaterTool.getUrlFromEntityAndMap(hoster,allVaule,deviceEntity);
        if(needKey){
            url+= KeyControler.getKeyForUse();
        }
        headers = UrlBodyCreaterTool.getMyHeaders(headers);
        headers.put("Host",hoster.split("/")[2]);
        RequestTokenVo requestTokenVo = new RequestTokenVo();
        requestTokenVo.setUrl(url);
        requestTokenVo.setHeader(headers);
        return ConstructRequest.constructGet(requestTokenVo);
    }

    public static Request getALLUsageRequest(String hoster,String allVauleUrl,Map<String,String> headers,Map<String,String>vaules,Boolean needKey){
        Map<String,String> allVaule = URLmakeTools.url_split(allVauleUrl);
        String url = UrlBodyCreaterTool.getUrlFromMapAndMap(hoster,allVaule,vaules);
        if(needKey){
            url+= KeyControler.getKeyForUse();
        }
        headers.put("Host",hoster.split("/")[2]);
        headers = UrlBodyCreaterTool.getMyHeaders(headers);
        RequestTokenVo requestTokenVo = new RequestTokenVo();
        requestTokenVo.setUrl(url);
        requestTokenVo.setHeader(headers);
        return ConstructRequest.constructGet(requestTokenVo);
    }
}
