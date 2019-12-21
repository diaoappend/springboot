package com.diao.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MySQLProperties {
    private static Properties prop = null;

    /*public static void main(String[] args) throws Exception {
        MySQLProperties.readProperties("mysql.properties");
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String db = prop.getProperty("db");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url + db, user, password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from department");
        while (resultSet.next()) {
            int deptno = resultSet.getInt("deptno");
            String deptname = resultSet.getString("deptname");
            int bednum = resultSet.getInt("bednum");
            System.out.println("部门编号：".concat(String.valueOf(deptno)).concat(String.valueOf("  部门名称：")).concat(String.valueOf(deptname)) + " 床位数：" + bednum);
        }

        resultSet.close();
        statement.close();
        resultSet.close();


    }*/

    public static void readProperties(String filename) {
        if (prop == null) {
            prop = new Properties();
            try {
                InputStream in = MySQLProperties.class.getResourceAsStream("/" +filename);
                InputStream input = MySQLProperties.class.getClassLoader().getResourceAsStream(filename);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
                prop.load(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
