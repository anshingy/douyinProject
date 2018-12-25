package params;

import com.space.register.entity.DeviceEntity;
import platform.tv.DeviceTvRegister;

/**
 *           .]]]]]]`.            .]]]]`           .]]]]].            .,]]]]]`        .]]]]`
 *         ,@@@@@@@@@@^    @@@@./@@@@@@@@@^    =@@@@@@@@@@@@.      ]@@@@@@@@@@@^   ,@@@@@@@@@@`
 *        .@@@@`    .[`    @@@@@@@[`..[@@@@@   =@/`    .\@@@@    ,@@@@@[.    ,[.  /@@@/.  .\@@@\
 *        =@@@\            @@@@/.       @@@@^            @@@@   ,@@@@/           /@@@^      =@@@^
 *         \@@@@@]`        @@@@.        =@@@@        ...]@@@@   =@@@@           .@@@@]]]]]]]]@@@@
 *          ,\@@@@@@@]     @@@@.        .@@@@   ,@@@@@@@@@@@@   @@@@^           =@@@@@@@@@@@@@@@@
 *              ,\@@@@@`   @@@@.        =@@@@ ,@@@@/.    @@@@   =@@@@           .@@@@
 *                 =@@@@   @@@@.        /@@@^ @@@@.      @@@@   ,@@@@^           \@@@\
 *        =].      =@@@/   @@@@@]     ./@@@/  @@@@\    ,/@@@@`   ,@@@@@`      ,`  \@@@@`       .`
 *        =@@@@@@@@@@@/    @@@@@@@@@@@@@@@`   .@@@@@@@@@@/@@@@@^  .\@@@@@@@@@@@^   ,@@@@@@@@@@@@@
 *         ,[\@@@@@[`      @@@@..[\@@@@[.       .[@@@@[.  ,\@@@[     ,[@@@@@/[`.      ,[@@@@@/[`.
 *                         @@@@.
 *                         @@@@.
 *                         @@@@.
 *                                                                                             @ClassName CesJson
 *                                                                                             @Author: space
 *                                                                                             @Description TODO 
 *                                                                                             @Date: 2018/10/11 23:29
 **/
public class CesJson {
  public static String jsonConstruct(DeviceEntity deviceEntity){

   String part1 = "{\"p1\":\"\",\"p2\":\"\",\"pkg\":\"com.ss.android.ugc.aweme\",\"fp\":\"Xiaomi/bxr0q/bxr0q:7.1/XWJZXZ/:user/release-keys;\",";
   String hw = "\"hw\":{\"brand\":\"Xiaomi\",\"model\":\""+deviceEntity.getDevice_type()+"\",\"board\":\"bxr0q\",\"device\":\"bxr0q\",\"product\":\"bxr0q\",\"bt\":\"XWJZXZ\",\"display\":\"1280*720\",\"dpi\":320,\"bat\":3600,\"cpu\":{\"hw\":\"\",\"max\":\"1586000\",\"min\":\"442000\",\"ft\":\"half thumb fastmult vfp edsp neon vfpv3 tls vfpv4 idiva idivt lpae evtstrm aes pmull sha1 sha2 crc32\"},\"mem\":{\"ram\":\"3.47 GB\",\"rom\":\"24.76 GB\",\"sd\":\"24.74 GB\"}},";
   String id = "\"id\":{\"imei\":\""+deviceEntity.getUuid()+"\",\"imsi\":\"460021051968262\",\"adid\":\""+deviceEntity.getOpenudid()+"\",\"mac\":\"6b:d9:27:43:d5:a3\",\"serial\":\"6d16cfb7d440\"},";
   String emulator = "\"emulator\":{\"sig\":0,\"cb\":10,\"file\":[],\"prop\":[]},";
   String part2 = "\"env\":{\"ver\":\"0.5.5.29\",\"pkg\":\"com.ss.android.ugc.aweme\",\"uid\":10243,\"rebuild\":1,\"jd\":0,\"dbg\":0,\"tid\":0,\"xpd\":0,\"hk\":[],\"su\":0,\"sp\":\"\",\"ro.secure_s\":\"\",\"ro.debuggable_s\":\"\",\"click\":\"\",\"hph\":\"\",\"hpp\":\"\",\"mc\":0,\"fc\":19067,\"jexp\":0,\"xposed\":0,\"cydia\":0,\"frida\":0,\"vapp\":\"\",\"api\":[]},\"extra\":\"cold_start\"}\n";

   return  part1 + hw + id + emulator + part2;
//        System.out.println(part1 + hw + id + emulator + part2);
  }

    public static String jsonConstruct(DeviceEntity deviceEntity,String extra){
        //code start
        //login
        String part1 = "{\"p1\":\""+deviceEntity.getDeviceId()+"\",\"p2\":\""+deviceEntity.getIid()+"\",\"pkg\":\"com.ss.android.ugc.aweme\",\"fp\":\"Xiaomi/bxr0q/bxr0q:7.1/XWJZXZ/:user/release-keys;\",";
        String hw = "\"hw\":{\"brand\":\"Xiaomi\",\"model\":\""+deviceEntity.getDevice_type()+"\",\"board\":\"bxr0q\",\"device\":\"bxr0q\",\"product\":\"bxr0q\",\"bt\":\"XWJZXZ\",\"display\":\"1280*720\",\"dpi\":320,\"bat\":3600,\"cpu\":{\"hw\":\"\",\"max\":\"1586000\",\"min\":\"442000\",\"ft\":\"half thumb fastmult vfp edsp neon vfpv3 tls vfpv4 idiva idivt lpae evtstrm aes pmull sha1 sha2 crc32\"},\"mem\":{\"ram\":\"3.47 GB\",\"rom\":\"24.76 GB\",\"sd\":\"24.74 GB\"}},";
        String id = "\"id\":{\"imei\":\""+deviceEntity.getUuid()+"\",\"imsi\":\"460021051968262\",\"adid\":\""+deviceEntity.getOpenudid()+"\",\"mac\":\"6b:d9:27:43:d5:a3\",\"serial\":\"6d16cfb7d440\"},";
        String emulator = "\"emulator\":{\"sig\":0,\"cb\":10,\"file\":[],\"prop\":[]},";
        String part2 = "\"env\":{\"ver\":\"0.5.5.29\",\"pkg\":\"com.ss.android.ugc.aweme\",\"uid\":10243,\"rebuild\":1,\"jd\":0,\"dbg\":0,\"tid\":0,\"xpd\":0,\"hk\":[],\"su\":0,\"sp\":\"\",\"ro.secure_s\":\"\",\"ro.debuggable_s\":\"\",\"click\":\"\",\"hph\":\"\",\"hpp\":\"\",\"mc\":0,\"fc\":19067,\"jexp\":0,\"xposed\":0,\"cydia\":0,\"frida\":0,\"vapp\":\"\",\"api\":[]},\"extra\":\""+extra+"\"}\n";

        return  part1 + hw + id + emulator + part2;
//        System.out.println(part1 + hw + id + emulator + part2);
    }

}
