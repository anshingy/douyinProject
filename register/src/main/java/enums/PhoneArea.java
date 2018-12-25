package enums;

import java.util.HashMap;

public class PhoneArea {

    public static HashMap<String,String> phoneFromAddress;

    static{
        phoneFromAddress = new HashMap<>();
        phoneFromAddress.put("泰国","+66");
        phoneFromAddress.put("柬埔寨","+855");
        phoneFromAddress.put("855","+855");
        phoneFromAddress.put("66","+66");
        phoneFromAddress.put("86","+86");
        phoneFromAddress.put("中国","+86");
    }
}
