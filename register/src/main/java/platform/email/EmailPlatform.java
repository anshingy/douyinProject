package platform.email;

import okhttp3.OkHttpClient;
import po.PhonePo;

import java.io.IOException;

public interface EmailPlatform {

    PhonePo getPhoneNumber(OkHttpClient okhttpclient)throws IOException;

    PhonePo getPhoneNumber(String phoneNum,OkHttpClient okhttpclient) throws IOException;

    String getIdentCode(String P_ID,OkHttpClient okhttpclient) throws IOException;




}
