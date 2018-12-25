package jsonreader.tools;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @program: protocol
 * @description: gzip文件解析类
 * @author: gaoxiang
 * @create: 2018-08-28 10:57
 **/
public class GzipGetteer {

    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";

    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    /**
     * 字符串压缩为GZIP字节数组
     *
     * @param str
     * @return
     */
    public static byte[] compress(String str) {
        return compress(str, GZIP_ENCODE_UTF_8);
    }

    /**
     * 字符串压缩为GZIP字节数组
     *
     * @param str
     * @param encoding
     * @return 经过GZIP压缩之后的字节流
     */
    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    /**
     * GZIP解压缩
     *
     * @param bytes
     * @return
     */
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }

    /**
     *
     * @param bytes
     * @return
     */
    public static String uncompressToString(byte[] bytes) {
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
    }

    /**
     *
     * @param bytes
     * @param encoding
     * @return
     */
    public static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void testGzipByFile(){

        FileInputStream fis= null;
        try {
            fis = new FileInputStream("D:\\protocol\\web\\src\\main\\resources\\tyty");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("读取文件错误，文件路径为："+fis.toString());
        }
        //System.out.println(fis.toString());

        BufferedInputStream bis=new BufferedInputStream(fis);

        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        //System.out.println();
        int c= 0;//读取bis流中的下一个字节
        try {
            c = bis.read();
            while(c!=-1){

                baos.write(c);
                //System.out.print(c+" ");
                c=bis.read();

            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("缓冲流备份出现问题");
        }
        System.out.println();
        byte retArr[]=baos.toByteArray();
        for(int i=0;i<retArr.length;i++){
            System.out.print(retArr[i]+" ");
        }
        //System.out.println();
        //System.out.println(uncompressToString(retArr,"utf-8"));
    }
    public static byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }

    public static void main(String[] args) {
        String input = "{\"event_v3\":[{\"nt\":4,\"event\":\"plugin_upload_json\",\"params\":{\"retry_count\":\"0\",\"content\":\"{\\\"plugin\\\":[{\\\"packagename\\\":\\\"com.ss.android.ugc.aweme.ffmpeg_so\\\",\\\"versioncode\\\":0},{\\\"packagename\\\":\\\"com.ss.android.ugc.aweme.shortvideo_so\\\",\\\"versioncode\\\":0}],\\\"patch\\\":[]}\"},\"event_id\":97,\"session_id\":\"fd9ebe88-8efb-4dd9-bf97-550d1a452fe2\",\"datetime\":\"2018-09-01 16:34:23\"},{\"nt\":4,\"event\":\"plugin_response_json\",\"params\":{\"retry_count\":\"2\",\"is_success\":\"1\",\"content\":\"[]\"},\"event_id\":98,\"session_id\":\"fd9ebe88-8efb-4dd9-bf97-550d1a452fe2\",\"datetime\":\"2018-09-01 16:34:23\"}],\"launch\":[{\"datetime\":\"2018-09-01 16:34:23\",\"session_id\":\"fd9ebe88-8efb-4dd9-bf97-550d1a452fe2\",\"is_background\":true}],\"magic_tag\":\"ss_app_log\",\"header\":{\"appkey\":\"57bfa27c67e58e7d920028d3\",\"udid\":\"865166024287115\",\"openudid\":\"06e7aa24d4d4c8a4\",\"sdk_version\":201,\"package\":\"com.ss.android.ugc.aweme\",\"channel\":\"baidu\",\"display_name\":\"抖音短视频\",\"app_version\":\"1.8.3\",\"version_code\":183,\"timezone\":8,\"access\":\"wifi\",\"os\":\"Android\",\"os_version\":\"5.1.1\",\"os_api\":22,\"device_model\":\"f103\",\"device_brand\":\"gionee\",\"device_manufacturer\":\"gionee\",\"language\":\"zh\",\"resolution\":\"900x1600\",\"display_density\":\"hdpi\",\"density_dpi\":240,\"mc\":\"00:81:41:de:1e:56\",\"carrier\":\"CHINA MOBILE\",\"mcc_mnc\":\"46000\",\"clientudid\":\"71cfb1e8-ca28-447b-9acf-0b5c4033cb88\",\"device_id\":\"39262138748\",\"sig_hash\":\"aea615ab910015038f73c47e45d21466\",\"aid\":1128,\"push_sdk\":[1,2,6,7,8,9],\"rom\":\"V9.5.2.0.LACCNFA\",\"release_build\":\"61b8304_20180522\",\"update_version_code\":1832,\"manifest_version_code\":183,\"cpu_abi\":\"armeabi-v7a\",\"build_serial\":\"00c7c516\",\"serial_number\":\"00c7c516\",\"sim_serial_number\":[],\"not_request_sender\":0,\"rom_version\":\"LMY48Z\",\"region\":\"CN\",\"tz_name\":\"Asia\\/Shanghai\",\"tz_offset\":28800,\"sim_region\":\"cn\"},\"_gen_time\":1535791855231}";
        byte[] kao = GzipGetteer.compress(input);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<kao.length;i++){
            stringBuilder.append(kao[i]+" ");
        }
        System.out.println(stringBuilder.toString());
    }


}
/**
 String result = "116 99 2 1 61 63 63 168 172 63 63 32 46 15 2 116 51 59 166 204 63 80 55 161 192 126 67 23 161 164 108 67 6 112 67 87 33 89 63 31 63 63 63 63 50 89 63 12 168 178 38 63 63 168 164 94 63 63 122 50 126 20 63 75 121 8 63 63 161 165 106 63 63 116 13 120 63 61 125 63 91 30 4 89 117 3 53 31 60 63 63 76 56 168 174 106 74 168 176 101 122 63 70 6 68 98 63 120 63 63 168 180 85 63 63 63 110 33 63 63 121 20 168 180 114 81 94 101 63 7 54 61 63 168 185 89 63 161 193 51 70 168 185 109 63 116 168 180 168 185 63 63 21 50 37 53 51 60 63 168 166 22 44 63 63 63 68 113 63 161 192 96 54 19 63 63 45 123 78 63 63 168 186 118 96 63 51 63 34 101 161 194 121 114 63 63 81 63 22 91 88 35 1 19 46 63 77 87 25 63 87 123 161 232 78 24 66 110 168 162 63 4 63 89 63 68 63 168 185 95 63 63 119 63 29 63 103 63 78 76 111 63 63 52 121 63 63 63 124 42 63 12 63 40 116 44 63 125 63 111 63 63 96 27 168 174 107 63 45 63 49 168 185 109 63 108 161 193 64 43 84 73 111 39 82 118 82 111 4 23 45 63 87 38 87 63 168 164 50 89 168 176 85 32 82 36 63 63 111 10 97 168 178 40 14 111 55 94 168 180 111 63 168 186 97 63 118 17 109 161 194 7 63 63 47 52 13 35 87 44 63 163 164 63 112 113 103 161 227 63 34 54 14 51 69 161 193 168 166 168 164 63 61 68 15 10 168 170 26 111 122 117 16 89 21 71 168 186 107 63 63 161 234 97 63 55 9 63 33 168 185 55 50 63 75 123 63 161 167 161 228 63 105 69 63 118 4 63 29 63 126 63 63 97 111 63 63 63 168 185 98 63 63 99 88 168 166 63 63 63 63 63 96 168 172 89 3 127 22 85 65 97 63 168 178 63 63 63 63 63 51 111 32 161 193 63 118 31 168 172 168 164 51 63 18 110 63 63 30 63 168 172 63 63 11 125 40 63 24 73 118 163 164 48 51 63 168 176 76 73 6 102 63 7 112 57 79 63 53 63 84 49 90 68 63 31 63 22 29 28 168 178 99 91 63 120 168 174 63 168 170 63 10 30 89 26 54 110 96 77 69 83 13 116 76 168 172 63 66 168 164 124 168 178 42 16 63 76 107 63 168 170 97 63 51 161 167 97 108 161 164 33 42 161 232 108 34 63 63 69 63 87 63 63 23 101 2 35 46 168 164 116 44 96 81 52 161 194 63 63 168 174 101 161 164 17 23 16 168 178 109 44 63 21 121 99 168 164 71 106 161 167 63 26 8 121 168 178 2 63 161 167 91 168 176 168 178 44 63 112 168 186 58 168 172 67 71 4 9 121 110 95 161 227 63 89 11 168 166 64 38 97 22 9 63 168 176 13 63 62 90 161 227 27 46 25 49 118 63 57 63 51 119 8 63 168 162 100 63 47 63 63 32 63 113 75 87 119 38 63 63 47 63 168 166 63 22 23 75 116 57 101 161 164 161 164 10 56 58 106 122 161 228 45 76 168 185 101 168 185 12 161 234 21 28 168 162 161 167 63 111 59 63 98 63 168 185 63 50 108 63 63 63 35 56 63 69 121 107 168 180 63 120 63 106 50 70 63 110 52 20 68 63 5 92 \n";
 byte[] contentString = null;
 try {
 contentString = getContent("D:\\protocol\\web\\src\\main\\resources\\tyty");
 } catch (IOException e) {
 e.printStackTrace();
 }
 System.out.println(result);
 for()
 System.out.println(contentString);
 System.out.println(uncompressToString(contentString));
 //testGzipByFile();
 **/