package com.monitor;
import com.dao.impl.CallImpl;
import com.dao.impl.CarImpl;
import com.javaBean.Call;
import com.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class UpdateCallMonitor implements ActionListener {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField[] jTextFields;
    public UpdateCallMonitor(JButton jButton1, JButton jButton3, JButton jButton4,  JTextField[] jTextFields) {
        this.jButton1 = jButton1;
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
            Call call = CallImpl.selectBySon(jTextFields[0].getText());
            if (call != null) {
                JOptionPane.showMessageDialog(jButton1,
                        "记录存在！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;//结束
            }
            //未查询到当前id
            JOptionPane.showMessageDialog(jButton1, "未查询到当前记录！！!",
                    "消息提示", JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == jButton2) {//点击了清除按钮
            jTextFields[0].setText("");
        } else if (e.getSource() == jButton3) {//点击了提交按钮
            if (jTextFields[0].getText().isEmpty()) {//判断id是否为空
                JOptionPane.showMessageDialog(jButton1,
                        "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Call call = CallImpl.selectBySon(jTextFields[0].getText());
            if (call.getIs_return().equals("0") ) {

                String sql = "UPDATE t_call_car_record SET is_return=? where " +
                        "id = ?";
                CarImpl.update(sql, 1,call.getId());
                CarUi.initSelectAllCall();//更新右侧表格数据
                //提示
                JOptionPane.showMessageDialog(jButton3, "归还成功！！！",
                        "提示", JOptionPane.PLAIN_MESSAGE);
            }else if(call.getIs_return().equals("1")){
                JOptionPane.showMessageDialog(jButton3, "当前车辆已归还！！！！",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            }else{
                //未查询到此人
                JOptionPane.showMessageDialog(jButton3, "未查询到当前记录！！！\n归还失败！！！",
                        "消息提示", JOptionPane.WARNING_MESSAGE);
            }
        } else {//点击了清除按钮
            for (int i = 1; i < jTextFields.length; i++) {
                jTextFields[i].setText("");
            }
        }
    }
}
