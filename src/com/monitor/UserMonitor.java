package com.monitor;

import com.dao.impl.UserImpl;
import com.javaBean.User;
import com.view.CarUi;
import com.view.RegisterFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMonitor implements ActionListener {

    private JFrame signIn;//登录界面
    private JButton jButton1;//登录按钮
    private JButton jButton2;//注册按钮
    private JTextField jTextField;//登录界面中的文本框,用于用户输入用户名。
    private JPasswordField jPasswordField;//登录界面中的密码框,用于用户输入密码

    public UserMonitor(JFrame signIn, JButton jButton1, JButton jButton2, JTextField jTextField, JPasswordField jPasswordField) {
        this.signIn = signIn;
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
        this.jTextField = jTextField;
        this.jPasswordField = jPasswordField;
    }

    public void actionPerformed(ActionEvent e) {//点击登录按钮
        UserImpl userImplzjw = new UserImpl(); 
        if (e.getSource() == jButton1) {
            String userName = jTextField.getText();//获得用户名
            String userPassword = new String(jPasswordField.getPassword());//获得密码
            User user = userImplzjw.selectByUserName(userName); 
            if (user != null) {
                if (user.getUserPassword().equals(userPassword)) 
                {
                    JOptionPane.showMessageDialog(
                            jButton1,
                            "登录成功!\n欢迎使用企业汽车管理系统！",
                            "提示",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    signIn.dispose();//关闭登录界面，释放资源
                    CarUi.initializeRootContainerzjw();//初始化操作界面
                } else {
                    JOptionPane.showMessageDialog(
                            null,//默认显示在屏幕的中央位置
                            "密码错误！\n请重新输入！",
                            "警告",
                            JOptionPane.WARNING_MESSAGE//在用户输入密码错误时显示一个警告消息对话框
                    );
                }
            } else {
                JOptionPane.showMessageDialog(
                        jButton1,
                        "未查询到当前用户！\n请先注册！",
                        "提示",
                        JOptionPane.INFORMATION_MESSAGE//在未查询到用户信息时显示一个提示消息对话框
                );
            }
        } else {
        	RegisterFrame.getInstance().initRegister();
        }
    }
}