package com.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.monitor.UserMonitor;

public class LoginFrame {
    private static JFrame signIn = new JFrame("登录");
    private static JFrame register = new JFrame("注册");//注册的容器

    public static void initSignIn() {
        signIn.setSize(250, 160);//窗口大小
        signIn.setLayout(new FlowLayout());//设置登录窗口使用流式布局，组件会按照添加的顺序从左到右排列
        signIn.setResizable(false);
        signIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel1 = new JLabel("用户名：");//标签
        JLabel jLabel2 = new JLabel("密  码：");
        JTextField jTextField = new JTextField(10);//文本框
        JPasswordField jPasswordField = new JPasswordField(10);//密码框
        jPasswordField.setEchoChar('*');
        Font font = new Font("宋体", Font.BOLD, 18);
        jLabel1.setFont(font);//设置标签和按钮的字体样式为宋体、加粗、字号18。
        jLabel2.setFont(font);
        JButton jButton1 = new JButton("登录");//按钮组件
        JButton jButton2 = new JButton("注册");
        jButton1.setFont(font);
        jButton2.setFont(font);
        signIn.add(jLabel1);//添加各个组件到登录窗口中进行显示。
        signIn.add(jTextField);
        signIn.add(jLabel2);
        signIn.add(jPasswordField);
        signIn.add(jButton1);
        signIn.add(jButton2);
        signIn.setLocationRelativeTo(null);//将登录窗口居中显示。
        signIn.setVisible(true);//设置登录窗口可见，即显示登录界面。

        UserMonitor userMonitorzjw = new UserMonitor(signIn, jButton1, jButton2, jTextField, jPasswordField);
        jButton1.addActionListener(userMonitorzjw);
        jButton2.addActionListener(userMonitorzjw);
    }
}