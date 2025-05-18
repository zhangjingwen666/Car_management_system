package com.monitor;

import com.dao.impl.DepartmentImpl;
import com.javaBean.Department;
import com.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class UpdateDepartmentMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField[] jTextFields;
    public UpdateDepartmentMonitor(JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4, JTextField[] jTextFields) {
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
        this.jButton3 = jButton3;
        this.jButton4 = jButton4;
        this.jTextFields = jTextFields;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {//点击了查询按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Department departmentldy= DepartmentImpl.selectBySon(jTextFields[0].getText());
            if (departmentldy != null) {
                //存在当前部门，则将信息带出
                jTextFields[1].setText(departmentldy.getName());
                jTextFields[2].setText(departmentldy.getManager_num() );
                jTextFields[3].setText(departmentldy.getTelephone());

                return;//结束
            }
            //未查询到当前id
            JOptionPane.showMessageDialog(jButton1, "未查询到当前部门！！!",
                    "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == jButton2) {//点击了清除按钮
            jTextFields[0].setText("");
        } else if (e.getSource() == jButton3) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Department departmentldy = DepartmentImpl.selectBySon(jTextFields[0].getText());
            if (departmentldy != null) {
                if (!jTextFields[1].getText().equals("")) {
                    departmentldy.setName(jTextFields[1].getText());
                }
                if (!jTextFields[2].getText().equals("")) {
                    departmentldy.setManager_num(jTextFields[2].getText());
                }
                if (!jTextFields[3].getText().equals("")) {
                    departmentldy.setTelephone(jTextFields[3].getText());
                }

                String sql = "UPDATE t_department SET name=?," +
                        "manager_num=?,telephone=? where " +
                        "id = ?";
                DepartmentImpl.update(sql, departmentldy.getName(), departmentldy.getManager_num(),
                        departmentldy.getTelephone(),
                         departmentldy.getId());
                CarUi.initSelectAllDepartment();//更新右侧表格数据
                //提示
                JOptionPane.showMessageDialog(jButton3, "修改部门信息成功！！！",
                        "提示", JOptionPane.PLAIN_MESSAGE);
            }else {
                //未查询到此人
                JOptionPane.showMessageDialog(jButton3, "未查询到当前部门！！！\n修改失败！！！",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            }
        } else {//点击了清除按钮
            for (int i = 1; i < jTextFields.length; i++) {
                jTextFields[i].setText("");
            }
        }
    }
}
