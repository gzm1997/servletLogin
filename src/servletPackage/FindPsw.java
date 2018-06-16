package servletPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSet;

public class FindPsw {
//    加载JDBC引擎的路径
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    数据库链接的URI
    static final String DB_URL = "jdbc:mysql://localhost:3306/javaTest";
//    连接数据库的用户名
    static final String USER = "root";
//    数据库密码
    static final String PSW = "Gzm20125";
    public String getPsw(String name) {
//        数据库连接对象
        Connection conn;
//        执行语句的statement对象 类似于python-connector的cursor
        Statement stmt;
        String psw;
        try {
//            加载JDBC引擎
            Class.forName(JDBC_DRIVER);
//            建立数据库链接
            conn = DriverManager.getConnection(DB_URL, USER, PSW);
//            获取statement
            stmt = conn.createStatement();
            String stmtToExec = String.format("select psw from testUser where name = '%s';", name);
            System.out.println("exec string is " + stmtToExec);
//            执行查询语句 返回结果
            ResultSet rs = stmt.executeQuery(stmtToExec);
            if (rs.next()) {
                psw = rs.getString("psw");
            }
            else {
                psw = "";
            }
            rs.close();
            stmt.close();
            conn.close();
            return psw;
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}


