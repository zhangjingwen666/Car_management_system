package com.monitor; 
import com.dao.impl.CallImpl;
import com.dao.impl.CarImpl;
import com.dao.impl.EmployeeImpl;
import com.javaBean.Call;
import com.javaBean.Car;
import com.javaBean.Temployee;
import com.monitor.*;
import com.view.*;
import javax.swing.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.time.LocalDate; 
/** * */ 
public class AddCallMonitor implements ActionListener { 
	private JButton jButton1; 
	private JButton jButton2; 
	private JRadioButton jRadioButton1; 
	private JTextField[] jTextFields; 
	public AddCallMonitor(JButton jButton1, JButton jButton2, JTextField[] jTextFields) { 
		this.jButton1 = jButton1; 
		this.jButton2 = jButton2; 
		this.jTextFields = jTextFields; 
		} 
	@Override 
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == jButton1) {
			//点击了提交按钮 
			if (jTextFields[0].getText().isEmpty()) {
				//判断id是否为空 
				JOptionPane.showMessageDialog(jButton1, "id不能为空！！！\n调用车辆失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE); return; } Call call=CallImpl.selectBySon(jTextFields[0].getText()); if(call != null){ JOptionPane.showMessageDialog(jButton1, "该调用id已存在！\n调用车辆失败！", "警告", JOptionPane.WARNING_MESSAGE); return; 
				} 
				Temployee temployee= EmployeeImpl.selectBySon(jTextFields[1].getText()); if(temployee == null){ JOptionPane.showMessageDialog(jButton1, "该员工不存在！\n调用车辆失败！", "警告", JOptionPane.WARNING_MESSAGE); return; 
				} 
				Car car = CarImpl.selectBySon(jTextFields[2].getText()); 
				if(car.getIs_unused() == 0){ 
					JOptionPane.showMessageDialog(jButton1, "该车辆已被调用！\n调用车辆失败！", "警告", JOptionPane.WARNING_MESSAGE); 
					return; } else {
				} 
				//实例化对象 
				call = new Call(Integer.parseInt(jTextFields[0].getText()), jTextFields[1].getText(), Integer.parseInt(jTextFields[2].getText()),jTextFields[3].getText(),jTextFields[4].getText()); 
				String sql = "INSERT INTO t_call_car_record(id,responsible,car_id," + "date_time,is_return) VALUES (?,?,?,?,?)"; 
				CallImpl.update(sql,call.getId(),call.getResponsible(),call.getCar_id(), LocalDate.now(),0); 
				CarUi.initSelectAllCall();//更新右侧表格数据 
				JOptionPane.showMessageDialog(jButton1, "调用成功！！！", "提示", JOptionPane.PLAIN_MESSAGE); 
				} else {//点击了清除按钮 
					for (JTextField jTextField : jTextFields) { jTextField.setText(""); } } } 
			}
	
	

