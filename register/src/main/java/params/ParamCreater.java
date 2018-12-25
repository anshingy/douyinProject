package params;

import enums.BaseNum;
import enums.paramtable.DirTable;

/**
 * @program: protocol
 * @description: 生成变化参数的方法，封装了并模拟了抖音生成用户参数的过程
 * @author: gaoxiang
 * @create: 2018-08-26 12:59
 **/
public class ParamCreater {


    public static String get_Rticket(){

        return String.valueOf(System.currentTimeMillis());
    }

    public static String get_Ts(String _rticket){
        double rticket = Double.valueOf(_rticket);
        rticket = rticket/1000;
        int buff = (int)rticket -1 ;
        return  String.valueOf(buff);
    }

    public static String get_Mobile(String area,String phoneNum){
        StringBuilder result = new StringBuilder();
        result.append("+");
        //result.append(area+" ");
        result.append(area);
//        String phoneNew = null;
//        if(phoneNum.length()==11){
//            phoneNew = phoneNum.substring(0,3)+" "+phoneNum.substring(3,7)+" "+phoneNum.substring(7);
//
//        }
//        else if(phoneNum.length()==9){
//            phoneNew = phoneNum.substring(0,2)+" "+phoneNum.substring(2,5)+" "+phoneNum.substring(5);
//        }
//        if(!phoneNew.isEmpty()){
//            result.append(phoneNew);
//        }
        result.append(phoneNum);
        //ystem.out.println(result);
        return change_Mobile_to_Src(result.toString());

    }

    /**
     *
     * @param mobile 转换数字到字母的方法
     * @return 转换结果
     */
    public static String change_Mobile_to_Src(String mobile){
        int length = mobile.length();
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<length;i++){
            String buff = String.valueOf(mobile.charAt(i));
            for(BaseNum baseNum:BaseNum.values()){
                if(baseNum.isEquals(buff)){
                    result.append(DirTable.phone_Table.get(baseNum));
                    break;
                }
            }
        }
        return result.toString();
    }

    public static String paramsControler(String area,String phoneNum){
        if(area.equals("null")&&phoneNum.equals("null")){
            return get_Rticket();
        }
        else if(phoneNum.equals("null")){
            return get_Ts(area);
        }else{
            return get_Mobile(area,phoneNum);
        }
    }


    public static void main(String [] args){
        ParamCreater paramCreater = new ParamCreater();

        System.out.println(ParamCreater.change_Mobile_to_Src("asd123456"));

        /**
        String rticket = paramCreater.get_Rticket();

        System.out.println(rticket);
        System.out.println(paramCreater.get_Ts(rticket));
         **/
    }
}
