package enums;

/**
 * @program: protocol
 * @description: 用于电话号码索引的枚举类
 * @author: gaoxiang
 * @create: 2018-08-26 13:42
 **/
public enum BaseNum {
    //与号码有关的枚举类型变量
    zero("0"),one("1"),two("2"),three("3"),four("4"),five("5"),six("6"),serven("7"),eight("8"),nine("9"),plus("+"),blank(" "),
    star("*"),a("a"),s("s"),d("d");


    private String vaule;

    private BaseNum(String vaule){
        this.vaule = vaule;
    }
    public String getVaule(){
        return vaule;
    }

    public Boolean isEquals(String num){
        if (num.equals(vaule)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isEmpty(){
        return vaule.isEmpty();
    }
}
