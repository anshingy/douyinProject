package util.database.tools;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: protocol
 * @description: 数据库对数据进行验证的方法类
 * @author: gaoxiang
 * @create: 2018-08-27 18:24
 **/
public class DataBaseTools {

    public static boolean isExistColumn(ResultSet rs, String columnName) {
        try {
            if (rs.findColumn(columnName) > 0 ) {
                return true;
            }
        }
        catch (SQLException e) {
            return false;
        }

        return false;
    }

    /**
     *
     * @param headInfo 请求数据
     * @return 不包含中文检验的数字
     */
    public static String encodeHeadInfo( String headInfo ) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0, length = headInfo.length(); i < length; i++) {
            char c = headInfo.charAt(i);
            if (c <= '\u001f' || c >= '\u007f') {
                stringBuffer.append( String.format ("\\u%04x", (int)c) );
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

}
