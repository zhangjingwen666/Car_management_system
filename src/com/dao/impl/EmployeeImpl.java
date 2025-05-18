package com.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaBean.Temployee;

public class EmployeeImpl {
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
	     * 通过id查询某员工
	     */
	    public static Temployee selectBySon(String sno) {
	        connection = MysqlJDBC.getConnection();
	        String sql = "SELECT * FROM t_employee where number = ?";
	        Temployee temployee = null;
	        try {
	            statement = connection.prepareStatement(sql);
	            statement.setObject(1, sno);//将sql中的“？”替换为对应的参数
	            resultSet = statement.executeQuery();
	            //处理查询到的数据
	            if (resultSet.next()) {
	                temployee = new Temployee();//实例化对象
	                temployee.setNumber(resultSet.getString("number"));
	                temployee.setName(resultSet.getString("name"));
	                temployee.setIDCard(resultSet.getString("IDCard"));
	                temployee.setPhone(resultSet.getString("phone"));
	                temployee.setPosition(resultSet.getString("position"));
	                temployee.setSeniority(resultSet.getString("seniority"));
	                temployee.setDep_id(resultSet.getInt("dep_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeAll(resultSet, statement, connection);//关闭资源
	        }
	        return temployee;//返回departmentList对象
	    }

	    /**
	     * 查询全部员工
	     */
	    public static List<Temployee> selectAll() {
	        connection = MysqlJDBC.getConnection();
	        String sql = "SELECT * FROM t_employee";
	        List<Temployee> temployeeArrayList = new ArrayList<>();
	        try {
	            statement = connection.prepareStatement(sql);
	            resultSet = statement.executeQuery();
	            //处理查询到的数据
	            while (resultSet.next()) {
	                Temployee temployee = new Temployee();
	                temployee.setNumber(resultSet.getString("number"));
	                temployee.setName(resultSet.getString("name"));
	                temployee.setIDCard(resultSet.getString("IDCard"));
	                temployee.setPhone(resultSet.getString("phone"));
	                temployee.setPosition(resultSet.getString("position"));
	                temployee.setSeniority(resultSet.getString("seniority"));
	                temployee.setDep_id(resultSet.getInt("dep_id"));
	                temployeeArrayList.add(temployee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeAll(resultSet, statement, connection);//关闭资源
	        }
	        return temployeeArrayList;//返回对象
	    }

	}






