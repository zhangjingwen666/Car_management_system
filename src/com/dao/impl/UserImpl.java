
package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.javaBean.User;

public class UserImpl implements UserDao {
    @Override
    public Integer update(String sql, Object... array)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = MysqlJDBC.getConnection();//用于连接到数据库。
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < array.length; i++) {
                statement.setObject(i + 1, array[i]);
            }
            return statement.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeAll(null, statement, connection);
        }
    }
    @Override
    public User selectByUserName(String userName) {
        Connection connection = null;//存储数据库连接
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = MysqlJDBC.getConnection();//连接到MySQL数据库。
            String sql = "SELECT * FROM t_user where user_name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            if (resultSet.next()) 
            	{
                user = new User();//用于存储查询到的用户信息。
                user.setUserId(resultSet.getLong("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserPassword(resultSet.getString("user_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, statement, connection);
        }
        return user;
    }
   
    private void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection)
    {
        if (resultSet != null) {
            try {
                resultSet.close();//关闭数据库连接，释放相关的资源。
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 关闭statement
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 关闭connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}