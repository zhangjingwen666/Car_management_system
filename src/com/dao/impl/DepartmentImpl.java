package com.dao.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javaBean.Department;



/**
 *
 */
public class DepartmentImpl {


    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    /**
     * 关闭资源
     */
    public static void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        // 关闭resultSet
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // 关闭statement
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // 关闭connection
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * 添加、修改和删除的方法
     */
    public static Integer update(String sql, Object... array) {
        try {
            connection = MysqlJDBC.getConnection();//获得MySQL连接
            statement = connection.prepareStatement(sql);//prepareStatement用于执行参数化查询
            for (int i = 0; i < array.length; i++) {//将sql中的“？”替换为对应的参数
                statement.setObject(i + 1, array[i]);
            }
            return statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeAll(null, statement, connection);//关闭资源
        }
    }

    /**
     * 通过id查询某部门
     */
    public static Department selectBySon(String sno) {
        connection = MysqlJDBC.getConnection();
        String sql = "SELECT * FROM t_department where id = ?";
        Department departmentldy = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sno);//将sql中的“？”替换为对应的参数
            resultSet = statement.executeQuery();
            //处理查询到的数据
            if (resultSet.next()) {
            	 departmentldy = new Department();//实例化对象
                 departmentldy.setId(resultSet.getInt("id"));
                 departmentldy.setManager_num(resultSet.getString("manager_num"));
                 departmentldy.setName(resultSet.getString("name"));
                 departmentldy.setTelephone(resultSet.getString("telephone"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);//关闭资源
        }
        return departmentldy;//返回departmentldyList对象
    }

    /**
     * 查询全部部门
     */
    public static List<Department> selectAll() {
        connection = MysqlJDBC.getConnection();
        String sql = "SELECT * FROM t_department";
        List<Department> departmentldyList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //处理查询到的数据
            while (resultSet.next()) {
            	Department departmentldy = new Department();
                departmentldy.setId(resultSet.getInt("id"));
                departmentldy.setName(resultSet.getString("name"));
                departmentldy.setManager_num(resultSet.getString("manager_num"));
                departmentldy.setTelephone(resultSet.getString("telephone"));
                departmentldyList.add(departmentldy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);//关闭资源
        }
        return departmentldyList;//返回学生对象
    }

}





