package com.monitor;

import com.dao.impl.EmployeeImpl;
import com.javaBean.Temployee;
import com.monitor.*;
import com.view.CarUi;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class UpdateEmployeeMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField[] jTextFields;
    public UpdateEmployeeMonitor(JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4, JTextField[] jTextFields) {
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
            Temployee temployee = EmployeeImpl.selectBySon(jTextFields[0].getText());
            if (temployee != null) {
                //存在当前车，则将信息带出
                jTextFields[1].setText(temployee.getName());
                jTextFields[2].setText(temployee.getIDCard() + "");
                jTextFields[3].setText(temployee.getPhone()+"");
                jTextFields[4].setText(temployee.getPosition());
                jTextFields[5].setText(temployee.getSeniority() + "");
                jTextFields[6].setText(temployee.getDep_id()+"");

                return;//结束
            }
            //未查询到当前id
            JOptionPane.showMessageDialog(jButton1, "未查询到当前员工！！!",
                    "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == jButton2) {//点击了清除按钮
            jTextFields[0].setText("");
        } else if (e.getSource() == jButton3) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Temployee temployee = EmployeeImpl.selectBySon(jTextFields[0].getText());
            if (temployee != null) {
                if (!jTextFields[1].getText().equals("")) {
                    temployee.setName(jTextFields[1].getText());
                }
                if (!jTextFields[2].getText().equals("")) {
                    temployee.setIDCard(jTextFields[2].getText());
                }
                if (!jTextFields[3].getText().equals("")) {
                    temployee.setPhone(jTextFields[3].getText());
                }
                if (!jTextFields[4].getText().equals("")) {
                    temployee.setPosition(jTextFields[4].getText());
                }
                if (!jTextFields[5].getText().equals("")) {
                    temployee.setSeniority(jTextFields[5].getText());
                }
                if (!jTextFields[6].getText().equals("")) {
                    temployee.setDep_id(Integer.parseInt(jTextFields[6].getText()));
                }
                String sql = "UPDATE t_employee SET name=?," +
                        "IDCard=?,phone=?,position=?,seniority=?,dep_id=? where " +
                        "number = ?";
                EmployeeImpl.update(sql,temployee.getName(),temployee.getIDCard(),temployee.getPhone(),temployee.getPosition(),
                        temployee.getSeniority(),temployee.getDep_id(), temployee.getNumber());
                CarUi.initSelectAllTemployee();//更新右侧表格数据
                //提示
                JOptionPane.showMessageDialog(jButton3, "修改员工信息成功！！！",
                        "提示", JOptionPane.PLAIN_MESSAGE);
            }else {
                //未查询到此人
                JOptionPane.showMessageDialog(jButton3, "未查询到当前员工！！！\n修改失败！！！",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            }
        } else {//点击了清除按钮
            for (int i = 1; i < jTextFields.length; i++) {
                jTextFields[i].setText("");
            }
        }
    }
}
