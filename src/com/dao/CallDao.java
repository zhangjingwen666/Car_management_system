package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.javaBean.Call;

public interface CallDao {
	public static void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection) {
	}
	public  Integer update(String sql, Object... array);
	 // 通过id查询某辆车的方法
    public Call selectBySon(String sno);

    // 查询全部车辆的方法
    public List<Call> selectAll();
}
