package keytools;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: protool
 * @description: 参数数值表格
 * @author: Mr.gao
 * @create: 2018-09-08 17:41
 **/
public class KeyParam {

    public static final byte a = (byte) 0;
    public static final byte b = (byte) 1;
    public static final byte c = (byte) 2;
    public static final byte d = (byte) 3;
    public static final byte e = (byte) 4;
    public static final byte f = (byte) 6;
    public static final byte g = (byte) 8;
    public static final byte h = (byte) 10;
    public static final byte i = (byte) 11;
    public static final byte j = (byte) 12;
    public static final byte k = (byte) 13;
    public static final byte l = (byte) 14;
    public static final byte m = (byte) 15;
    public static final byte n = (byte) 16;

    public static void main(String[] args) throws Exception {
        while (true){
            Scanner input = new Scanner(System.in);
            ArrayList<Integer> array = new ArrayList<>();
            String allString = input.nextLine();
            String kao ="\\{";
            String vauleString = allString.split(kao)[1];
            vauleString = vauleString.split("\\}")[0];
            String[] vaules = vauleString.split(",");
            for(int i =0;i<vaules.length;i++){
                array.add(Integer.parseInt(vaules[i].substring(3).trim(),16));
            }
            for (Integer e : array) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

    }
}
