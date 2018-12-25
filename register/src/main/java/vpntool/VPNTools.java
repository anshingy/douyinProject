package vpntool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 此类用于连接vpn
 */
public class VPNTools {


    public static void main(String[] args) throws Exception{
//        executeCmd("ping www.qq.com");
//        connectVPN("vpn46","vpn46","123");
        disConnectVPN("vpn46");
    }

    /**
     * 用于执行cmd命令行的
     * @param strCmd
     * @return
     * @throws Exception
     */
    private static String executeCmd(String strCmd) throws Exception {
        System.out.println("cmd /c " + strCmd);
        Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
        StringBuilder sbCmd = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));

        String line;
        while ((line = br.readLine()) != null) {
            sbCmd.append(line + '\n');
        }
        return sbCmd.toString();
    }

    /**
     * 连接vpn
     * @return
     */
    public static boolean connectVPN(String VPNName, String VPNAccount, String VPNPwd){
        String cmdStr = "rasdial " + VPNName + " " + VPNAccount + " " + VPNPwd;
        String result = null;
        try {
            result = executeCmd(cmdStr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接vpn报错");
            return false;
        }
//        System.out.println(result);
        String[] line = result.split("\\n");
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        if (line[line.length-1].equals("命令已完成。")) {
            System.out.println("VPN connect id DONE");
            return true;

        } else {
            System.out.println("vpn ERROR");
            return false;
        }
    }

    public static boolean disConnectVPN(String VPNName) {
        String cmdStr = "rasdial "+VPNName+" /disconnect";
        System.out.println(cmdStr);
        String result = null;
        try {
            result = executeCmd(cmdStr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("断开连接报错");
            return false;
        }
//        System.out.println(result);
        String[] line = result.split("\\n");
        for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
        }
        if (line[line.length-1].equals("命令已完成。")) {
            System.out.println("断开vpn成功");
            return true;
        } else {
            System.out.println("断开vpn失败");
            return false;
        }
    }
}
