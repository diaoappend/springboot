package com.diao.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/tableau";
    private static String user = "root";
    private static String password = "root";

    public static void main(String[] args) throws Exception {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();
        String sql = "select * from department";
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int deptno = resultSet.getInt("deptno");
            String deptname = resultSet.getString("deptname");
            int bednum = resultSet.getInt("bednum");
            System.out.println("部门编号：".concat(String.valueOf(deptno)).concat(String.valueOf("  部门名称：")).concat(String.valueOf(deptname)));
        }

        resultSet.close();
        statement.close();
        conn.close();


    }
}
