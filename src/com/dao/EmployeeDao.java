package com.dao; 
import java.util.List;

import com.javaBean.Temployee; 
public interface EmployeeDao { Integer update(String sql, Object... array); 
Temployee selectBySon(String sno);
List<Temployee> selectAll1(); 
 
void selectAll(); 
}