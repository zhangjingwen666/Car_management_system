package com.dao;
import java.util.List;

import com.javaBean.Repair;
public interface RepairDao { 
	Integer update(String sql, Object... array); 
Repair selectBySon(String sno); 
List<Repair> selectAll(); }