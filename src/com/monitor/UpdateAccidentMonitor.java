package com.monitor;

import com.dao.impl.AccidentImpl;
import com.javaBean.Accident;
import com.monitor.*;
import com.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class UpdateAccidentMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField[] jTextFields;
    public UpdateAccidentMonitor(JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4,  JTextField[] jTextFields) {
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
            Accident accident = AccidentImpl.selectBySon(jTextFields[0].getText());
            if (accident != null) {
                //存在当前车，则将信息带出
                jTextFields[1].setText(accident.getDate_time());
                jTextFields[2].setText(accident.getLocation() + "");
                jTextFields[3].setText(accident.getAccident_type()+"");
                jTextFields[4].setText(accident.getAccident_level());
                jTextFields[5].setText(accident.getResponsible());
                jTextFields[6].setText(accident.getCar_id()+"");

                return;//结束
            }
            //未查询到当前id
            JOptionPane.showMessageDialog(jButton1, "未查询到当前事故！！!",
                    "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == jButton2) {//点击了清除按钮
            jTextFields[0].setText("");
        } else if (e.getSource() == jButton3) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Accident accident = AccidentImpl.selectBySon(jTextFields[0].getText());
            if (accident != null) {
                if (!jTextFields[1].getText().equals("")) {
                    accident.setDate_time(jTextFields[1].getText());
                }
                if (!jTextFields[2].getText().equals("")) {
                    accident.setLocation(jTextFields[2].getText());
                }
                if (!jTextFields[3].getText().equals("")) {
                    accident.setAccident_type(jTextFields[3].getText());
                }
                if (!jTextFields[4].getText().equals("")) {
                    accident.setAccident_level(jTextFields[4].getText());
                }
                if (!jTextFields[5].getText().equals("")) {
                    accident.setResponsible(jTextFields[5].getText());
                }
                if (!jTextFields[6].getText().equals("")) {
                    accident.setCar_id(Integer.parseInt(jTextFields[6].getText()));
                }
                String sql = "UPDATE t_accident_record SET date_time=?," +
                        "location=?,accident_type=?,accident_level=?,responsible=?,car_id=? where " +
                        "id = ?";
                AccidentImpl.update(sql,accident.getDate_time(),accident.getLocation(),accident.getAccident_type(),accident.getAccident_level(),
                        accident.getResponsible(),accident.getCar_id(),accident.getId());
                CarUi.initSelectAllAccident();//更新右侧表格数据
                //提示
                JOptionPane.showMessageDialog(jButton3, "修改信息成功！！！",
                        "提示", JOptionPane.PLAIN_MESSAGE);
            }else {
                //未查询
                JOptionPane.showMessageDialog(jButton3, "未查询到当前事故记录！！！\n修改失败！！！",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            }
        } else {//点击了清除按钮
            for (int i = 1; i < jTextFields.length; i++) {
                jTextFields[i].setText("");
            }
        }
    }
}
