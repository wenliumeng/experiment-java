package jdbc;

import java.sql.*;

/**
 * jdbc Sqlserver
 * Created by seyMour on 2017/3/6.
 * ☞seyMour☜
 */
public class SqlServer {
    public static void main(String[] args) {


//        jdbc.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
//        jdbc.url=jdbc:sqlserver://10.103.80.13:1433;DatabaseName=SSDB
//        jdbc.username=SSDB_U
//        jdbc.password=china123


        String driverName = "com.microsoft.jdbc.sqlserver.jdbc.SQLServerDriver";

        String dbURL = "jdbc:sqlserver://114.255.236.11:1433;DatabaseName=SSDB";

        String userName = "SSDB_U";

        String userPwd = "china123";

        try {

            Class.forName(driverName);

            Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

            System.out.println("连接数据库成功");

        }catch(Exception e) {
            e.printStackTrace();
            System.out.print("连接失败");

        }
    }
}
