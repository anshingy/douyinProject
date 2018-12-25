package util.database.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @program: web
 * @description: 数据库信息基础类
 * @author: gaoxiang
 * @create: 2018-06-03 23:54
 **/
public class InfoTools {

    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://120.24.189.68:3306/Protocol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC\n";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "root";
    private static InfoTools catTools;

    public Connection connection = null;

    public static InfoTools getInstance(){
        if(catTools!=null){

        }
        else{
            catTools = new InfoTools();
        }
        return catTools;
    }
    //应对不时之需
    public InfoTools(){
        init();
    }
    public void init(){
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reGetConnection(){
        if (connection == null) {
            try {
                connection = connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeConnection(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String [] args){
        InfoTools infoTools = new InfoTools();
    }
}
