package com.monitor;


import javax.swing.*;

import com.dao.impl.DepartmentImpl;
import com.dao.impl.EmployeeImpl;
import com.javaBean.Department;
import com.javaBean.Temployee;
import com.monitor.*;
import com.view.CarUi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class AddEmployeeMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JTextField[] jTextFields;

    public AddEmployeeMonitor(JButton jButton1, JButton jButton2,  JTextField[] jTextFields) {
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
        this.jTextFields = jTextFields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！\n添加员工失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Department department= DepartmentImpl.selectBySon(jTextFields[6].getText());
            if(department == null){
                JOptionPane.showMessageDialog(jButton1,
                        "该部门不存在！\n请重新填写！", "警告",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            Temployee employeeDao = EmployeeImpl.selectBySon(jTextFields[0].getText());
            if(employeeDao != null){
                JOptionPane.showMessageDialog(jButton1,
                        "员工编号重复！\n添加员工失败！", "警告",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            //实例化Car对象
            employeeDao = new Temployee(jTextFields[0].getText(), jTextFields[1].getText(),
                    jTextFields[2].getText(), jTextFields[3].getText(),jTextFields[4].getText(),jTextFields[5].getText(),Integer.parseInt(jTextFields[6].getText()));
            String sql = "INSERT INTO t_employee(number,name,IDCard," +
                    "phone,position,seniority,dep_id) VALUES (?,?,?,?,?,?,?)";
            EmployeeImpl.update(sql, employeeDao.getNumber(),employeeDao.getName(),employeeDao.getIDCard(),employeeDao.getPhone(),employeeDao.getPosition(),
                    employeeDao.getSeniority(),employeeDao.getDep_id());
            CarUi.initSelectAllTemployee();//更新右侧表格数据
            JOptionPane.showMessageDialog(jButton1, "添加员工成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
        } else {//点击了清除按钮
            for (JTextField jTextField : jTextFields) {
                jTextField.setText("");
            }
        }
    }
}
