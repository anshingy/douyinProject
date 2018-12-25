package platform.main;

import com.space.register.entity.DeviceEntity;
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
 * @description: 设备权限获取post方法实现类
 * @author: Mr.gao
 * @create: 2018-09-13 10:51
 **/
public class DevicerAblePostter {

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
    public static Request getAIRealDeviceRequsets(String hoster, String allVauleUrl,String allVauleBody,DeviceEntity deviceEntity, Boolean needKey){
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host", hoster.split("/")[2]);
        headers.put("Cookie",deviceEntity.getCookie()+";"+"qh[360]=1");
        Map<String,String> deviceMap = new HashMap<String,String>();
        deviceMap = deviceEntity.getDeviceMap();
        return getRealDeviceRequsets(hoster,allVauleUrl,allVauleBody,headers,deviceMap,needKey);
    }

    /**
     * 自动添加Host主地址的 http请求
     * @param hoster
     * @param allVauleUrl
     * @param deviceEntity
     * @param needKey
     * @return
     */
    public static Request getRealDeviceRequsetsOnlyHost(String hoster,String allVauleUrl,String allVauleBody,DeviceEntity deviceEntity,Boolean needKey){
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host", hoster.split("/")[2]);
        Map<String,String> deviceMap = new HashMap<String,String>();
        deviceMap = deviceEntity.getDeviceMap();
        return getRealDeviceRequsets(hoster,allVauleUrl,allVauleBody,headers,deviceMap,needKey);
    }
    /**
     *  header,url,body包含特殊信息时调用的方法，此时需要手动加入特殊的属性值。一般是特殊的cookie和host
     * @param hoster
     * @param allVauleUrl
     * @param headers
     * @param deviceInfoMap
     * @param needKey
     * @return
     */
    public static Request getRealDeviceRequsets(String hoster,String allVauleUrl,String allVauleBody, Map<String,String> headers, Map<String,String> deviceInfoMap,Boolean needKey){
        Map<String,String> allVaule = URLmakeTools.url_split(allVauleUrl);
        String url = UrlBodyCreaterTool.getUrlFromMapAndMap(hoster,allVaule,deviceInfoMap);
        if(needKey){
            url+= KeyControler.getKeyForUse();
        }
        headers.put("Host", hoster.split("/")[2]);
        headers = UrlBodyCreaterTool.getMyHeaders(headers);
        allVaule = URLmakeTools.url_split(allVauleBody);
        String newBody = UrlBodyCreaterTool.getBodyByMapAndMap(allVaule,deviceInfoMap);
        Map<String,String> bodyMaps = URLmakeTools.url_split(newBody);
        RequestTokenVo requestTokenVo = new RequestTokenVo();
        requestTokenVo.setUrl(url);
        requestTokenVo.setHeader(headers);
        requestTokenVo.setBody(bodyMaps);
        return ConstructRequest.constructPost(requestTokenVo);
    }

    /**
     * 手动传入设备信息自动添加host 和 cookie http头，
     * @param hoster
     * @param allVauleUrl
     * @param deviceMap
     * @param needKey
     * @return
     */
    public static Request getRealDeviceRequsetsWithBody(String hoster, String allVauleUrl,String allVauleBody,Map<String,String> deviceMap, Boolean needKey){
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host", hoster.split("/")[2]);
        headers.put("Cookie",deviceMap.get("cookie")+";"+"qh[360]=1");
        return getRealDeviceRequsets(hoster,allVauleUrl,allVauleBody,headers,deviceMap,needKey);
    }

    /**
     * 自动添加Host主地址的 http请求
     * @param hoster
     * @param allVauleUrl
     * @param deviceMap
     * @param needKey
     * @return
     */
    public static Request getRealDeviceRequsetsOnlyHost(String hoster,String allVauleUrl,String allVauleBody,Map<String,String> deviceMap,Boolean needKey){
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Host", hoster.split("/")[2]);
        return getRealDeviceRequsets(hoster,allVauleUrl,allVauleBody,headers,deviceMap,needKey);
    }

}
