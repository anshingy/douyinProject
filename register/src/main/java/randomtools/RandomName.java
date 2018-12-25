package randomtools;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import static randomtools.OptionalString.Surname;
import static randomtools.OptionalString.namesEn;

public class RandomName {

    //获取中文随机名
    public static String getCname(){
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(Surname.length-1);
        String name1 = Surname[index];
        if(random.nextBoolean()){
            name1 += getChinese() + getChinese();
        }else {
            name1 += getChinese();
        }
        return name1;
    }

    //获取英文随机名
    public static String getEname(){
        int num = new Random().nextInt(569);
        String name2 = namesEn[num];
        return name2;
    }

    //获取完整昵称，中+英+随机数字
    public static String getName(){
        String name1 = getCname();
        String name2 = getEname();
        int tag = new Random().nextInt(100);
        String name = name1 + name2 + String.valueOf(tag);
        return name;
    }


    private static String getChinese() {
        String str = null;
        int highPos, lowPos;
        Random random = new Random();
        highPos = (176 + Math.abs(random.nextInt(71)));
        random = new Random();
        lowPos = 161 + Math.abs(random.nextInt(94));

        byte[] bArr = new byte[2];
        bArr[0] = (new Integer(highPos)).byteValue();
        bArr[1] = (new Integer(lowPos)).byteValue();
        try {
            str = new String(bArr, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
