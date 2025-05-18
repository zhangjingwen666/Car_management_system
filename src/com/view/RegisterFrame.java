package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame {
    private static JFrame register = new JFrame("注册");//注册的容器
    private static RegisterFrame instance;

    public static RegisterFrame getInstance() {
        if (instance == null) {
            instance = new RegisterFrame();
        }
        return instance;
    }
    public void initRegister() {
        register.getContentPane().removeAll();//清空容器
        register.setSize(250, 160);//窗口大小
        register.setLayout(new FlowLayout());//流式布局
        register.setResizable(false);//禁止用户调整注册窗口的大小。
        register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭窗口且释放资源
        JLabel jLabel1 = new JLabel("用户名：");
        JLabel jLabel2 = new JLabel("密  码：");
        JTextField jTextField = new JTextField(10);//文本框，输入框的长度为10列
        JPasswordField jPasswordField = new JPasswordField(10);//密码框
        jPasswordField.setEchoChar('*');//设置密码框显示为*
        Font font = new Font("宋体", Font.BOLD, 18);//字体宋体，加粗，字号18
        jLabel1.setFont(font);
        jLabel2.setFont(font);
        JButton jButton1 = new JButton("提交");//按钮
        jButton1.setFont(font);
        register.add(jLabel1);//加入容器中
        register.add(jTextField);
        register.add(jLabel2);
        register.add(jPasswordField);
        register.add(jButton1);
        register.setLocationRelativeTo(null);//窗口居中
        register.setVisible(true);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = jTextField.getText();//获得用户名
                String userPassword = new String(jPasswordField.getPassword());//获得密码
                
                JOptionPane.showMessageDialog(
                        jButton1,
                        "注册成功!",
                        "提示",
                        JOptionPane.INFORMATION_MESSAGE//信息提示
                );
                register.dispose();
            }
        });
    }
    public static void main(String[] args) {
        RegisterFrame.getInstance().initRegister();
    }
}