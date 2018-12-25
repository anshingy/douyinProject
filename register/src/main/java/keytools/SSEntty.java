package keytools;

import jsonreader.tools.GzipGetteer;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: protool
 * @description: 某平台简单的entty模拟算法
 * @author: Mr.gao
 * @create: 2018-09-25 20:31
 **/
public class SSEntty {
    //加密对照表
    public static int[] byteTable;
    //默认加密字段内容
    public static String r1 = "fde58f8f";

    public static String r2 = "fdcf434d";

    public static String r3 = "33ef9d50";

    public static String r4 = "3f929618";

    public static String all = r1+r2+r3+r4;
    static{
        byteTable = getBytesFromString();
    }

    /**
     * 正则表达式匹配两个指定字符串中间的内容
     * @param soap
     * @return
     */
    public static List<String> getSubUtil(String soap, String rgex){
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }

    //从IDA的内存存储里提取数字的方法：
    public static int[] getBytesFromString(){
        //想要使用正则表达式，请手动在末尾添加\n
        String nCString = "DCB 0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5, 0x30\n" +
                ".data:00004110                                         ; DATA XREF: LOAD:0000025C↑o\n" +
                ".data:00004110                                         ; ss_encrypt+68↑o ...\n" +
                ".data:00004110                 DCB 1, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76, 0xCA, 0x82\n" +
                ".data:00004110                 DCB 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0, 0xAD, 0xD4, 0xA2\n" +
                ".data:00004110                 DCB 0xAF, 0x9C, 0xA4, 0x72, 0xC0, 0xB7, 0xFD, 0x93, 0x26\n" +
                ".data:00004110                 DCB 0x36, 0x3F, 0xF7, 0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71\n" +
                ".data:00004110                 DCB 0xD8, 0x31, 0x15, 4, 0xC7, 0x23, 0xC3, 0x18, 0x96\n" +
                ".data:00004110                 DCB 5, 0x9A, 7, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75\n" +
                ".data:00004110                 DCB 9, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0, 0x52\n" +
                ".data:00004110                 DCB 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84, 0x53, 0xD1\n" +
                ".data:00004110                 DCB 0, 0xED, 0x20, 0xFC, 0xB1, 0x5B, 0x6A, 0xCB, 0xBE\n" +
                ".data:00004110                 DCB 0x39, 0x4A, 0x4C, 0x58, 0xCF, 0xD0, 0xEF, 0xAA, 0xFB\n" +
                ".data:00004110                 DCB 0x43, 0x4D, 0x33, 0x85, 0x45, 0xF9, 2, 0x7F, 0x50\n" +
                ".data:00004110                 DCB 0x3C, 0x9F, 0xA8, 0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D\n" +
                ".data:00004110                 DCB 0x38, 0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3\n" +
                ".data:00004110                 DCB 0xD2, 0xCD, 0xC, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17\n" +
                ".data:00004110                 DCB 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73, 0x60\n" +
                ".data:00004110                 DCB 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88, 0x46, 0xEE\n" +
                ".data:00004110                 DCB 0xB8, 0x14, 0xDE, 0x5E, 0xB, 0xDB, 0xE0, 0x32, 0x3A\n" +
                ".data:00004110                 DCB 0xA, 0x49, 6, 0x24, 0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91\n" +
                ".data:00004110                 DCB 0x95, 0xE4, 0x79, 0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5\n" +
                ".data:00004110                 DCB 0x4E, 0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE\n" +
                ".data:00004110                 DCB 8, 0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6\n" +
                ".data:00004110                 DCB 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A, 0x70\n" +
                ".data:00004110                 DCB 0x3E, 0xB5, 0x66, 0x48, 3, 0xF6, 0xE, 0x61, 0x35, 0x57\n" +
                ".data:00004110                 DCB 0xB9, 0x86, 0xC1, 0x1D, 0x9E, 0xE1, 0xF8, 0x98, 0x11\n" +
                ".data:00004110                 DCB 0x69, 0xD9, 0x8E, 0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE\n" +
                ".data:00004110                 DCB 0x55, 0x28, 0xDF, 0x8C, 0xA1, 0x89, 0xD, 0xBF, 0xE6\n" +
                ".data:00004110                 DCB 0x42, 0x68, 0x41, 0x99, 0x2D, 0xF, 0xB0, 0x54, 0xBB\n" +
                ".data:00004110                 DCB 0x16\n";
        String rgex = "DCB(.*?)\n";
        List<String> allPattern = getSubUtil(nCString,rgex);
        ArrayList<Integer> integers = new ArrayList<>();
        for(String nums:allPattern){
            String[] intNums = nums.split(",");
            for(int i =0;i<intNums.length;i++){
                if(intNums[i].length()>2){
                    integers.add(Integer.parseInt(intNums[i].substring(3).trim(),16));
                }
                else{
                    integers.add(Integer.parseInt(intNums[i].trim()));
                }
            }
        }
        int[] resultByte = new int[integers.size()];
        int hehe =0;
        for(Integer num:integers){
            resultByte[hehe] = num;
            hehe++;
        }
        return resultByte;
    }

    public static byte[] getTTEnttyResult(byte[] ttEnttyString){
        int[] enttyString = new int[ttEnttyString.length];
        for(int i = 0;i<enttyString.length;i++){
            if(i<ttEnttyString.length){
                enttyString[i] = ttEnttyString[i];
            }
            else{
                enttyString[i] = 32;
            }
        }
        ArrayList<Integer> newBytes = new ArrayList<>();
        for(int i = 0;i<ttEnttyString.length;i++){
            newBytes.add(byteTable[enttyString[i]&0xff]);

        }
        return getFinallResult(newBytes);
    }

    public static byte[] getFinallResult(ArrayList<Integer> tableEntty){
        int shortNum = 16 - tableEntty.size()%16;
        if(shortNum==16){
            shortNum =0;
        }
        for(int i =0;i<shortNum;i++){
            tableEntty.add(32);
        }
        byte[] result = new byte[tableEntty.size()+4];
        result[0] = 116;
        result[1] = 99;
        result[2] = 2;
        result[3] = (byte) (shortNum&0xff);
        for(int z=0;z*16<tableEntty.size();z++){
            int[] myself = new int[16];
            for(int k =0;k<16;k++){
                myself[k] = tableEntty.get(z*16+k);
            }
            byte[] kao = dofinalEntty(myself);
            for(int i=0;i<16;i++){
                result[z*16+i+4] = kao[i];
            }
        }
        return result;
    }

    public static byte[] dofinalEntty(int[] waitString){
        if(waitString.length!=16){
            System.out.println("加密的数组长度不为16");
            return null;
        }
        //很煞笔，但是不得不这样写
        int[] resulrString = new int[waitString.length];
        int key=-1;
        int buff;
        for(int i =0;i<waitString.length;i++){
            if(i%4==0){
                key++;
            }
            int z = i-key;
            if(z<4*key){
                z+=4;
            }else{

            }
            resulrString[z] = waitString[i];
        }
        byte[] resultByte = new byte[resulrString.length];
        for(int i= 0;i<resulrString.length;i++){
            resultByte[i]=xor(resulrString[i],all.substring(2*i,2*i+2));
        }
        return  resultByte;
    }

    private static byte xor(int strHex_X,String strHex_Y){
        //将x、y转成二进制形式
        String anotherBinary=Integer.toBinaryString(strHex_X);
        String thisBinary=Integer.toBinaryString(Integer.valueOf(strHex_Y,16));
        String result = "";
        //判断是否为8位二进制，否则左补零
        if(anotherBinary.length() != 8){
            for (int i = anotherBinary.length(); i <8; i++) {
                anotherBinary = "0"+anotherBinary;
            }
        }
        if(thisBinary.length() != 8){
            for (int i = thisBinary.length(); i <8; i++) {
                thisBinary = "0"+thisBinary;
            }
        }
        //异或运算
        for (int i=0;i<anotherBinary.length();i++){
            //如果相同位置数相同，则补0，否则补1
            if(thisBinary.charAt(i)==anotherBinary.charAt(i))
                result+="0";
            else{
                result+="1";
            }
        }
        return (byte)(Integer.parseInt(result, 2)&(0xFF));
    }
    public static void main(String[]args){
        int[] kao = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String kaohe =  "0123456789ab";
        byte[] hehe = getTTEnttyResult(kaohe.getBytes());
        for(int k=0;k<hehe.length;k++){
            System.out.print(hehe[k]+" ");
        }
        System.out.println();
    }
}