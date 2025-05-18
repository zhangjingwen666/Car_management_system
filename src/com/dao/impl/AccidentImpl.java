package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaBean.Accident;

public class AccidentImpl {
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
     * 通过id查询
     */
    public static Accident selectBySon(String sno) {
        connection = MysqlJDBC.getConnection();
        String sql = "SELECT * FROM t_accident_record where id = ?";
        Accident accident = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sno);//将sql中的“？”替换为对应的参数
            resultSet = statement.executeQuery();
            //处理查询到的数据
            if (resultSet.next()) {
                 accident= new Accident();//实例化对象
                accident.setId(resultSet.getInt("id"));
                accident.setDate_time(resultSet.getString("date_time"));
                accident.setLocation(resultSet.getString("location"));
                accident.setAccident_type(resultSet.getString("accident_type"));
                accident.setAccident_level(resultSet.getString("accident_level"));
                accident.setResponsible(resultSet.getString("responsible"));
                accident.setCar_id(resultSet.getInt("car_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);//关闭资源
        }
        return accident;//返回departmentList对象
    }

    /**
     * 查询全部部门
     */
    public static List<Accident> selectAll() {
        connection = MysqlJDBC.getConnection();
        String sql = "SELECT * FROM t_accident_record";
        List<Accident> accidentArrayList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //处理查询到的数据
            while (resultSet.next()) {
                Accident accident = new Accident();
                accident.setId(resultSet.getInt("id"));
                accident.setDate_time(resultSet.getString("date_time"));
                accident.setLocation(resultSet.getString("location"));
                accident.setAccident_type(resultSet.getString("accident_type"));
                accident.setAccident_level(resultSet.getString("accident_level"));
                accident.setResponsible(resultSet.getString("responsible"));
                accident.setCar_id(resultSet.getInt("car_id"));
                accidentArrayList.add(accident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);//关闭资源
        }
        return accidentArrayList;//返回对象
    }

}


