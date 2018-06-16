package servletPackage;


import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSet;

public class FindPsw {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/javaTest";
    static final String USER = "root";
    static final String PSW = "Gzm20125";
    public String getPsw(String name) {
        Connection conn;
        Statement stmt;
        String psw;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PSW);
            stmt = conn.createStatement();
            String stmtToExec = String.format("select psw from testUser where name = '%s';", name);
            System.out.println("exec string is " + stmtToExec);
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


