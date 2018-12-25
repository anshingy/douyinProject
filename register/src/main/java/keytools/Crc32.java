package keytools;

import java.util.zip.CRC32;

/**
 * @program: protool
 * @description: 进行crc32位冗余检验的方法类
 * @author: Mr.gao
 * @create: 2018-09-09 20:03
 **/
public class Crc32 {



    public static String encordToCrc(String strbuff){
        return encordToCrc(strbuff.getBytes());
    }

    public static String encordToCrc(byte[] strbytes){
        CRC32 crc32 = new CRC32();
        crc32.update(strbytes);
        long value = crc32.getValue();
        return String.valueOf(value);
    }

}
