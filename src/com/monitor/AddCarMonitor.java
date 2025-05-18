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
public class AddCarMonitor implements ActionListener {

    private  JRadioButton jRadioButton2;
    private JButton jButton1;
    private JButton jButton2;
    private JRadioButton jRadioButton1;
    private JTextField[] jTextFields;
    private int is_unused;

    public AddCarMonitor(JButton jButton1, JButton jButton2, JRadioButton jRadioButton1, JRadioButton jRadioButton2, JTextField[] jTextFields) {
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
        this.jRadioButton1 = jRadioButton1;
        this.jRadioButton2 = jRadioButton2;
        this.jTextFields = jTextFields; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {//点击了提交按钮
            if(e.getSource() == jRadioButton1){
                is_unused=1;
            }else{
                is_unused=0;
            }
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！\n添加车辆失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Car car = CarImpl.selectBySon(jTextFields[0].getText());
            if(car != null){
                JOptionPane.showMessageDialog(jButton1,
                        "车号重复！\n添加车辆失败！", "警告",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            //实例化Car对象
            car = new Car(Integer.parseInt(jTextFields[0].getText()),jTextFields[1].getText(),jTextFields[2].getText(), Integer.parseInt(jTextFields[3].getText()),jTextFields[4].getText(),is_unused);
            String sql = "INSERT INTO t_car(id,car_number,model," +
                    "car_age,color,is_unused) VALUES (?,?,?,?,?,?)";
            CarImpl.update(sql, car.getId(),car.getCar_number(),car.getModel(),car.getCar_age(),car.getColor(),is_unused);
            CarUi.initSelectAllCar();//更新右侧表格数据
            JOptionPane.showMessageDialog(jButton1, "添加车辆成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
        } else {//点击了清除按钮
            for (JTextField jTextField : jTextFields) {
                jTextField.setText("");
            }
        }
    }
}
