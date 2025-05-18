package com.monitor;

import com.dao.impl.CarImpl;
import com.javaBean.Car;
import com.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class UpdateCarMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField[] jTextFields;
    public UpdateCarMonitor(JButton jButton1, JButton jButton2, JButton jButton3, JButton jButton4, JRadioButton jRadioButton1, JRadioButton jRadioButton2, JTextField[] jTextFields) {
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
        this.jButton3 = jButton3;
        this.jButton4 = jButton4;
        this.jRadioButton1 = jRadioButton1;
        this.jRadioButton2 = jRadioButton2;
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
            Car car = CarImpl.selectBySon(jTextFields[0].getText());
            if (car != null) {
                //存在当前车，则将信息带出
                jTextFields[1].setText(car.getCar_number());
                jTextFields[2].setText(car.getModel() + "");
                jTextFields[3].setText(car.getCar_age()+"");
                jTextFields[4].setText(car.getColor());
                //判断性别
                if (car.getIs_unused() == 1) {
                    jRadioButton1.setSelected(true);
                } else {
                    jRadioButton2.setSelected(true);
                }
                return;//结束
            }
            //未查询到当前id
            JOptionPane.showMessageDialog(jButton1, "未查询到当前车辆！！!",
                    "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == jButton2) {//点击了清除按钮
            jTextFields[0].setText("");
        } else if (e.getSource() == jButton3) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Car car = CarImpl.selectBySon(jTextFields[0].getText());
            if (car != null) {
                if (!jTextFields[1].getText().equals("")) {
                    car.setCar_number(jTextFields[1].getText());
                }
                if (!jTextFields[2].getText().equals("")) {
                    car.setModel(jTextFields[2].getText());
                }
                if (!jTextFields[3].getText().equals("")) {
                    car.setCar_age(Integer.parseInt(jTextFields[3].getText()));
                }
                if (!jTextFields[4].getText().equals("")) {
                    car.setColor(jTextFields[4].getText());
                }
                //判断性别
                if (jRadioButton1.isSelected()) {
                    car.setIs_unused(1);
                } else {
                    car.setIs_unused(0);
                }
                String sql = "UPDATE t_car SET car_number=?," +
                        "model=?,car_age=?,color=?,is_unused=? where " +
                        "id = ?";
                CarImpl.update(sql, car.getCar_number(), car.getModel(),
                        car.getCar_age(), car.getColor(),
                        car.getIs_unused(), car.getId());
                CarUi.initSelectAllCar();//更新右侧表格数据
                //提示
                JOptionPane.showMessageDialog(jButton3, "修改车辆信息成功！！！",
                        "提示", JOptionPane.PLAIN_MESSAGE);
            }else {
                //未查询到此人
                JOptionPane.showMessageDialog(jButton3, "未查询到当前车辆！！！\n修改失败！！！",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            }
        } else {//点击了清除按钮
            for (int i = 1; i < jTextFields.length; i++) {
                jTextFields[i].setText("");
            } 
        }
    }
}
