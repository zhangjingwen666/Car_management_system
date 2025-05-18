package com.dao.impl;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javaBean.Car;

/**
 *
 */
public class CarImpl {


    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    /**
     * 关闭资源
     */
    public static void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection){
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
    public static Integer update(String sql, Object... array){
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
     * 通过id查询某辆车
     */
    public static Car selectBySon(String sno) {
        connection = MysqlJDBC.getConnection();
        String sql = "SELECT * FROM t_car where id = ?";
        Car car = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, sno);//将sql中的“？”替换为对应的参数
            resultSet = statement.executeQuery();
            //处理查询到的数据
            if (resultSet.next()) {
                car = new Car();//实例化对象
                car.setId(resultSet.getInt("id"));
                car.setCar_number(resultSet.getString("car_number"));
                car.setModel(resultSet.getString("model"));
                car.setCar_age(resultSet.getInt("car_age"));
                car.setColor(resultSet.getString("color"));
                car.setIs_unused(resultSet.getInt("is_unused"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);//关闭资源
        }
        return car;//返回car对象
    }

    /**
     * 查询全部车辆
     */
    public static List<Car> selectAll(){
        connection = MysqlJDBC.getConnection();
        String sql = "SELECT * FROM t_car";
        List<Car> carList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //处理查询到的数据
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCar_number(resultSet.getString("car_number"));
                car.setModel(resultSet.getString("model"));
                car.setCar_age(resultSet.getInt("car_age"));
                car.setColor(resultSet.getString("color"));
                car.setIs_unused(resultSet.getInt("is_unused"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);//关闭资源
        }
        return carList;//返回学生对象
    }

}



