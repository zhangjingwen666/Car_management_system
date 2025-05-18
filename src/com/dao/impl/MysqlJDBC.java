package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlJDBC {

    private static final String driver = "com.mysql.cj.jdbc.Driver"; // 驱动类名称
    private static final String url = "jdbc:mysql://localhost:3306/car_management?characterEncoding=utf8&useSSL=false"; // 连接字符串格式
    private static final String user = "root"; // MySQL用户名
    private static final String password = "Z3932208hf"; // MySQL密码

    /**
     * 获得MySQL连接
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);//建立与MySQL数据库的连接。
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
