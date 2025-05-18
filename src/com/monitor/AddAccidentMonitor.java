package com.monitor;

import com.dao.impl.AccidentImpl;
import com.javaBean.Accident;
import com.view.CarUi;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.time.LocalDate.now;

/**
 *
 */
public class AddAccidentMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JRadioButton jRadioButton1;
    private JTextField[] jTextFields;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AddAccidentMonitor(JButton jButton1, JButton jButton2, JTextField[] jTextFields) {
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
        this.jTextFields = jTextFields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！\n添加事故失败！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Accident accident = AccidentImpl.selectBySon(jTextFields[0].getText());
            if(accident != null){
                JOptionPane.showMessageDialog(jButton1,
                        "事故id重复！\n添加事故失败！", "警告",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            //实例化对象
            accident = new Accident(Integer.parseInt(jTextFields[0].getText()), jTextFields[1].getText(),
                    jTextFields[2].getText(), jTextFields[3].getText(),jTextFields[4].getText(),jTextFields[5].getText(),Integer.parseInt(jTextFields[6].getText()));
            String sql = "INSERT INTO t_accident_record(id,date_time,location," +
                    "accident_type,accident_level,responsible,car_id) VALUES (?,?,?,?,?,?,?)";
            AccidentImpl.update(sql,accident.getId(),accident.getDate_time(),accident.getLocation(),accident.getAccident_type(),accident.getAccident_level(),
                    accident.getResponsible(),accident.getCar_id());
            CarUi.initSelectAllAccident();//更新右侧表格数据
            JOptionPane.showMessageDialog(jButton1, "添加事故成功！！！", "提示", JOptionPane.PLAIN_MESSAGE);
        } else {//点击了清除按钮
            for (JTextField jTextField : jTextFields) {
                jTextField.setText("");
            }
        }
    }
}
