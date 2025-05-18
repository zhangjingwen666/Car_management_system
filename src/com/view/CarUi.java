package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.dao.impl.AccidentImpl;
import com.dao.impl.CallImpl;
import com.dao.impl.CarImpl;
import com.dao.impl.DepartmentImpl;
import com.dao.impl.EmployeeImpl;
import com.dao.impl.RepairImpl;
import com.excel.AccidentExcel;
import com.excel.CallExcel;
import com.excel.CarExcel;
import com.excel.DepartmentExcel;
import com.excel.EmployeeExcel;
import com.excel.RepairExcel;
import com.javaBean.Accident;
import com.javaBean.Call;
import com.javaBean.Car;
import com.javaBean.Department;
import com.javaBean.Repair;
import com.javaBean.Temployee;
import com.monitor.AddAccidentMonitor;
import com.monitor.AddCallMonitor;
import com.monitor.AddCarMonitor;
import com.monitor.AddDepartmentMonitor;
import com.monitor.AddEmployeeMonitor;
import com.monitor.AddRepairMonitor;
import com.monitor.UpdateAccidentMonitor;
import com.monitor.UpdateCallMonitor;
import com.monitor.UpdateCarMonitor;
import com.monitor.UpdateDepartmentMonitor;
import com.monitor.UpdateEmployeeMonitor;
import com.monitor.UpdateRepairMonitor;
import com.view.*;

public class CarUi {
	
	private static JFrame rootContainerzjw = new JFrame("企业汽车管理系统");
	private static JPanel jPanelLeftzjw = new JPanel(new FlowLayout());
    private static JPanel jPanelRightzjw = new JPanel(new BorderLayout()); 
    
    public static void initializeRootContainerzjw() {
        rootContainerzjw.setSize(1000, 500);//窗口大小,宽度为1000像素，高度为500像素。
        rootContainerzjw.setLayout(new BorderLayout(2, 0));
        rootContainerzjw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        JMenu men1 = new JMenu("车辆管理");//创建菜单。
        JMenu men3 = new JMenu("部门管理");
        JMenu men4 = new JMenu("员工管理");
        JMenu men5 = new JMenu("事故记录");
        JMenu men6 = new JMenu("维修记录");
        JMenu men7 = new JMenu("调用记录");//多个菜单
        JMenuItem item1 = new JMenuItem("添加车辆");//子菜单，菜单项
        JMenuItem item2 = new JMenuItem("修改车辆");
        JMenuItem item3 = new JMenuItem("删除车辆");
        JMenuItem item4 = new JMenuItem("输出全部");
        JMenuItem item5 = new JMenuItem("保存");

        JMenuItem item12 = new JMenuItem("添加部门");//子菜单，菜单项
        JMenuItem item22 = new JMenuItem("修改部门");
        JMenuItem item32 = new JMenuItem("删除部门");
        JMenuItem item42 = new JMenuItem("输出全部");
        JMenuItem item52 = new JMenuItem("保存");

        JMenuItem item13 = new JMenuItem("添加员工");//子菜单，菜单项
        JMenuItem item23 = new JMenuItem("修改员工");
        JMenuItem item33 = new JMenuItem("删除员工");
        JMenuItem item43 = new JMenuItem("输出全部");
        JMenuItem item53 = new JMenuItem("保存");

        JMenuItem item14 = new JMenuItem("添加事故");//子菜单，菜单项
        JMenuItem item24 = new JMenuItem("修改事故");
        JMenuItem item34 = new JMenuItem("删除事故");
        JMenuItem item44 = new JMenuItem("输出全部");
        JMenuItem item54 = new JMenuItem("保存");

        JMenuItem item15 = new JMenuItem("添加维修");//子菜单，菜单项
        JMenuItem item25 = new JMenuItem("修改维修");
        JMenuItem item35 = new JMenuItem("删除维修");
        JMenuItem item45 = new JMenuItem("输出全部");
        JMenuItem item55 = new JMenuItem("保存");

        JMenuItem item16 = new JMenuItem("调用");//子菜单，菜单项
        JMenuItem item26 = new JMenuItem("归还");
        JMenuItem item36 = new JMenuItem("删除记录");
        JMenuItem item46 = new JMenuItem("输出全部");
        JMenuItem item56 = new JMenuItem("保存");
        Font font = new Font("黑体", Font.PLAIN, 18);//黑体，普通，18磅。
        men1.setFont(font);//设置菜单字体
        men3.setFont(font);
        men4.setFont(font);
        men5.setFont(font);
        men6.setFont(font);
        men7.setFont(font);
        item1.setFont(font);
        item2.setFont(font);
        item3.setFont(font);
        item4.setFont(font);
        item5.setFont(font);
        item12.setFont(font);
        item22.setFont(font);
        item32.setFont(font);
        item42.setFont(font);
        item52.setFont(font);
        item13.setFont(font);
        item23.setFont(font);
        item33.setFont(font);
        item43.setFont(font);
        item53.setFont(font);
        item14.setFont(font);
        item24.setFont(font);
        item34.setFont(font);
        item44.setFont(font);
        item54.setFont(font);
        item15.setFont(font);
        item25.setFont(font);
        item35.setFont(font);
        item45.setFont(font);
        item55.setFont(font);
        item16.setFont(font);
        item26.setFont(font);
        item36.setFont(font);
        item46.setFont(font);
        item56.setFont(font);
        men1.add(item1);//将子菜单加入菜单,加入车辆管理菜单
        men1.add(item2);
        men1.add(item3);
        men1.add(item4);
        men1.add(item5);
        men3.add(item12);//将子菜单加入菜单，加入部门管理菜单
        men3.add(item22);
        men3.add(item32);
        men3.add(item42);
        men3.add(item52);
        men4.add(item13);//将子菜单加入菜单，加入员工管理菜单
        men4.add(item23);
        men4.add(item33);
        men4.add(item43);
        men4.add(item53);

        men5.add(item14);//将子菜单加入菜单，加入事故记录菜单
        men5.add(item24);
        men5.add(item34);
        men5.add(item44);
        men5.add(item54);


        men6.add(item15);//将子菜单加入菜单，加入维修记录菜单
        men6.add(item25);
        men6.add(item35);
        men6.add(item45);
        men6.add(item55);

        men7.add(item16);//将子菜单加入菜单，加入调用记录菜单
        men7.add(item26);
        men7.add(item36);
        men7.add(item46);
        men7.add(item56);
        bar.add(men1);
        bar.add(men3);
        bar.add(men4);
        bar.add(men5);
        bar.add(men6);
        bar.add(men7);
        rootContainerzjw.setJMenuBar(bar);
        jPanelLeftzjw.setBackground(Color.LIGHT_GRAY);
        jPanelRightzjw.setBackground(Color.LIGHT_GRAY);
        jPanelLeftzjw.setPreferredSize(new Dimension(200, 0));
        rootContainerzjw.add(jPanelLeftzjw, BorderLayout.WEST);
        rootContainerzjw.add(jPanelRightzjw, BorderLayout.CENTER);
        initAddCar();
        initSelectAllCar();

        rootContainerzjw.setLocationRelativeTo(null); //窗口居中
        rootContainerzjw.setVisible(true);//窗口显示

        //输出全部部门
        item42.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddDepartment();//初始化添加部门
                initSelectAllDepartment();//初始化选择所有部门
            }
        });
        //添加部门监听
        item12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddDepartment();
                initSelectAllDepartment();
            }
        });

        //注册修改部门按钮的监听
        item22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initUpdateDepartment();
                initSelectAllDepartment();//初始化右侧表格数据
            }
        });

        //注册删除部门按钮的监听
        item32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDeleteDepartment();
                initSelectAllDepartment();
            }
        });


        //输出全部员工
        item43.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddTemployee();//
                initSelectAllTemployee();
            }
        });
        //添加员工监听
        item13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddTemployee();
                initSelectAllTemployee();
            }
        });

        //注册修改员工按钮的监听
        item23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initUpdateTemployee();
                initSelectAllTemployee();;//初始化右侧表格数据
            }
        });

        //注册删除员工按钮的监听
        item33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDeleteTemployee();
                initSelectAllTemployee();
            }
        });


        //输出全部事故
        item44.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddAccident();
                initSelectAllAccident();
            }
        });
        //添加事故监听
        item14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddAccident();
                initSelectAllAccident();
            }
        });

        //注册修改事故按钮的监听
        item24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initUpdateAccident();
                initSelectAllAccident();//初始化右侧表格数据
            }
        });

        //注册删除事故按钮的监听
        item34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDeleteAccident();
                initSelectAllAccident();
            }
        });


        //输出全部维修
        item45.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddRepair();
                initSelectAllRepair();
            }
        });
        //添加维修监听
        item15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddRepair();
                initSelectAllRepair();
            }
        });

        //注册修改维修按钮的监听
        item25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initUpdateRepair();
                initSelectAllRepair();;//初始化右侧表格数据
            }
        });

        //注册删除维修按钮的监听
        item35.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDeleteRepair();
                initSelectAllRepair();
            }
        });

        //输出全部调用
        item46.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddCall();
                initSelectAllCall();
            }
        });
        //添加调用监听
        item16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddCall();
                initSelectAllCall();
            }
        });

        //注册修改调用按钮的监听
        item26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initUpdateCall();
                initSelectAllCall();;//初始化右侧表格数据
            }
        });

        //注册删除调用按钮的监听
        item36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDeleteCall();
                initSelectAllCall();
            }
        });

        //注册添加车辆按钮的监听
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddCar();
                initSelectAllCar();//初始化右侧表格数据
            }
        });
        //注册修改车辆按钮的监听
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initUpdateStudent();
                initSelectAllCar();//初始化右侧表格数据
            }
        });
        //注册删除车辆按钮的监听
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDeleteCar();
                initSelectAllCar();//初始化右侧表格数据
            }
        });
        //注册输出全部车辆按钮的监听
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddCar();
                initSelectAllCar();
            }
        });
       
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddCar();//初始化一个用于添加汽车的操作
                initSelectAllCar();//初始化右侧表格数据,使用户能够一次性选择所有汽车，而不必一个个地进行选择
                try {
                    CarExcel.excelExport();//用于将数据保存为Excel文件。
                    JOptionPane.showMessageDialog(item5, "导出成功！\n路径：D://car.xsl", "提示", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        item52.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddDepartment();//初始化部门
                initSelectAllDepartment();
                try {
                    DepartmentExcel.excelExport();//保存为excel
                    JOptionPane.showMessageDialog(item52, "导出成功！\n路径：D://department.xsl", "提示", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        item53.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddTemployee();//初始化员工
                initSelectAllTemployee();
                try {
                    EmployeeExcel.excelExport();//保存为excel
                    JOptionPane.showMessageDialog(item53, "导出成功！\n路径：D://employee.xsl", "提示", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        item54.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddAccident();//初始化事故记录
                initSelectAllAccident();
                try {
                    AccidentExcel.excelExport();//保存为excel
                    JOptionPane.showMessageDialog(item54, "导出成功！\n路径：D://accient.xsl", "提示", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        item55.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddRepair();//初始化维修记录
                initSelectAllRepair();
                try {
                    RepairExcel.excelExport();//保存为excel
                    JOptionPane.showMessageDialog(item55, "导出成功！\n路径：D://repair.xsl", "提示", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        item56.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initAddCall();//初始化调用记录
                initSelectAllCall();
                try {
                    CallExcel.excelExport();//保存为excel
                    JOptionPane.showMessageDialog(item56, "导出成功！\n路径：D://call.xsl", "提示", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    /**
     * 初始化添加车辆界面
     */
    public static void initAddCar() {
        jPanelLeftzjw.removeAll();
        jPanelLeftzjw.updateUI();//刷新容器以确保界面更新。
        String[] allClass = {"id：", "车牌号：", "车型：", "车龄：", "颜色："};
        JTextField[] jTextFields = new JTextField[allClass.length];
        JRadioButton jRadioButton1 = new JRadioButton("      是      ");//单选按钮
        JRadioButton jRadioButton2 = new JRadioButton("      否      ");
        jRadioButton1.setSelected(true);//第一个单选按钮默认选中
        
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        btnGroup.add(jRadioButton1);
        btnGroup.add(jRadioButton2);
        
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);
            jLabel.setSize(230, 20);//设置标签的大小
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(12);//创建一个新的文本框
            jPanelLeftzjw.add(jTextFields[i]);
            if (i == 4) {
                jPanelLeftzjw.add(jRadioButton1);
                jPanelLeftzjw.add(jRadioButton2);
            }
        }
        JButton jButton1 = new JButton("提交");//按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//加入按钮
        jPanelLeftzjw.add(jButton2);
        AddCarMonitor addCarListen = new AddCarMonitor(jButton1, jButton2, jRadioButton1, jRadioButton2, jTextFields);
        jButton1.addActionListener(addCarListen);
        jButton2.addActionListener(addCarListen);
    }

    /**
     * 初始化添加部门界面
     */
    public static void initAddDepartment() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"      id：", "   部门名称：", "主管人工号：", "   部门电话："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框

        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);
            jPanelLeftzjw.add(jTextFields[i]);
        }
        JButton jButton1 = new JButton("提交");//按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//加入按钮
        jPanelLeftzjw.add(jButton2);
        AddDepartmentMonitor addDepartmentMonitor = new AddDepartmentMonitor(jButton1,jButton2,jTextFields);
        jButton1.addActionListener(addDepartmentMonitor);//注册监听
        jButton2.addActionListener(addDepartmentMonitor);
    }

    /**
     * 初始化添加员工界面
     */
    public static void initAddTemployee() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"员工编号：", "员工姓名：", "身份证号：", "   手机号：","   职位：","   工龄：","所属部门号："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框

        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);
            jPanelLeftzjw.add(jTextFields[i]);
        }
        JButton jButton1 = new JButton("提交");//按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//加入按钮
        jPanelLeftzjw.add(jButton2);
        AddEmployeeMonitor addEmployeeMonitor = new AddEmployeeMonitor(jButton1,jButton2,jTextFields);
        jButton1.addActionListener(addEmployeeMonitor);//注册监听
        jButton2.addActionListener(addEmployeeMonitor);
    }

    /**
     * 初始化添加事故界面
     */
    public static void initAddAccident() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"      id：", "   发生时间：", "发生地点：", "   事故类型：","   严重等级：","负责人工号：","   车辆ID："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框

        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为9
            jPanelLeftzjw.add(jTextFields[i]);
        }
        JButton jButton1 = new JButton("提交");//按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//加入按钮
        jPanelLeftzjw.add(jButton2);
        AddAccidentMonitor addAccidentMonitor = new AddAccidentMonitor(jButton1,jButton2,jTextFields);
        jButton1.addActionListener(addAccidentMonitor);//注册监听
        jButton2.addActionListener(addAccidentMonitor);
    }

    /**
     * 初始化添加维修界面
     */
    public static void initAddRepair() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"      id：", "   维修时间：", "   维修地址：", "   维修项目：","     费用：","负责人工号：","   车辆ID："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框

        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为9
            jPanelLeftzjw.add(jTextFields[i]);
        }
        JButton jButton1 = new JButton("提交");//按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//加入按钮
        jPanelLeftzjw.add(jButton2);
        AddRepairMonitor addRepairMonitor = new AddRepairMonitor(jButton1,jButton2,jTextFields);
        jButton1.addActionListener(addRepairMonitor);//注册监听
        jButton2.addActionListener(addRepairMonitor);
    }

    /**
     * 初始化添加调用界面
     */
    public static void initAddCall() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"id：", " 调用人工号：", "调用车辆ID：","调用时间：","调用状态："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框

        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为9。
            jPanelLeftzjw.add(jTextFields[i]);//加入文本框
        }
        JButton jButton1 = new JButton("提交");//按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//加入按钮
        jPanelLeftzjw.add(jButton2);
        AddCallMonitor addCallMonitor = new AddCallMonitor(jButton1,jButton2,jTextFields);
        jButton1.addActionListener(addCallMonitor);//注册监听
        jButton2.addActionListener(addCallMonitor);
    }

    /**
     * 初始化修改车辆界面
     */
    public static void initUpdateStudent() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器以确保界面更新
        String[] allClass = {"id：", "车牌号：", "车型：", "车龄：", "颜色："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框
        JRadioButton jRadioButton1 = new JRadioButton("      是      ");//单选按钮
        JRadioButton jRadioButton2 = new JRadioButton("      否      ");
        jRadioButton1.setSelected(true);//第一个单选按钮默认选中
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        btnGroup.add(jRadioButton1);
        btnGroup.add(jRadioButton2);
        JButton jButton1 = new JButton("   查询   ");
        JButton jButton2 = new JButton("   清除   ");
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);//设置标签的大小为230x20
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(12);//实例化文本框，初始大小为12
            jPanelLeftzjw.add(jTextFields[i]);
            if (i == 0) {//添加查询和清除按钮
                jPanelLeftzjw.add(jButton1);
                jPanelLeftzjw.add(jButton2);
            }
            if (i == 4) {//添加一个条件判断，当i等于4时，单独将两个单选按钮添加到面板中。
                jPanelLeftzjw.add(jRadioButton1);
                jPanelLeftzjw.add(jRadioButton2);
            }
        }
        JButton jButton3 = new JButton("提交");//按钮
        JButton jButton4 = new JButton("清除");
        jPanelLeftzjw.add(jButton3);//加入按钮
        jPanelLeftzjw.add(jButton4);
        UpdateCarMonitor updateCarListen = new UpdateCarMonitor(jButton1, jButton2, jButton3, jButton4, jRadioButton1, jRadioButton2, jTextFields);
        jButton1.addActionListener(updateCarListen);//注册监听
        jButton2.addActionListener(updateCarListen);
        jButton3.addActionListener(updateCarListen);
        jButton4.addActionListener(updateCarListen);
    }

    /**
     * 初始化修改部门界面
     */
    public static void initUpdateDepartment() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"      id：", "   部门名称：", "主管人工号：", "   部门电话："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        JButton jButton1 = new JButton("   查询   ");
        JButton jButton2 = new JButton("   清除   ");
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为9
            jPanelLeftzjw.add(jTextFields[i]);//将文本框添加到面板jPanelLeftzjw中
            if (i == 0) {//添加查询和清除按钮
                jPanelLeftzjw.add(jButton1);
                jPanelLeftzjw.add(jButton2);
            }
        }
        JButton jButton3 = new JButton("提交");//按钮
        JButton jButton4 = new JButton("清除");
        jPanelLeftzjw.add(jButton3);//加入按钮
        jPanelLeftzjw.add(jButton4);
        UpdateDepartmentMonitor updateDepartmentMonitor = new UpdateDepartmentMonitor(jButton1, jButton2, jButton3, jButton4, jTextFields);
        jButton1.addActionListener(updateDepartmentMonitor);//注册监听
        jButton2.addActionListener(updateDepartmentMonitor);
        jButton3.addActionListener(updateDepartmentMonitor);
        jButton4.addActionListener(updateDepartmentMonitor);
    }

    /**
     * 初始化修改员工界面
     */
    public static void initUpdateTemployee() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"员工编号：", "员工姓名：", "身份证号：", "手机号：","   职位：","   工龄：","所属部门号："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        JButton jButton1 = new JButton("   查询   ");
        JButton jButton2 = new JButton("   清除   ");
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为9
            jPanelLeftzjw.add(jTextFields[i]);//将文本框添加到面板jPanelLeftzjw中
            if (i == 0) {//添加查询和清除按钮
                jPanelLeftzjw.add(jButton1);
                jPanelLeftzjw.add(jButton2);
            }
        }
        JButton jButton3 = new JButton("提交");//按钮
        JButton jButton4 = new JButton("清除");
        jPanelLeftzjw.add(jButton3);//加入按钮
        jPanelLeftzjw.add(jButton4);
        UpdateEmployeeMonitor updateEmployeeMonitor = new UpdateEmployeeMonitor(jButton1, jButton2, jButton3, jButton4, jTextFields);
        jButton1.addActionListener(updateEmployeeMonitor);//注册监听
        jButton2.addActionListener(updateEmployeeMonitor);
        jButton3.addActionListener(updateEmployeeMonitor);
        jButton4.addActionListener(updateEmployeeMonitor);
    }

    /**
     * 初始化修改事故界面
     */
    public static void initUpdateAccident() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"      id：", "   发生时间：", "发生地点：", "   事故类型：","   严重等级：","负责人工号：","   车辆ID："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        JButton jButton1 = new JButton("   查询   ");
        JButton jButton2 = new JButton("   清除   ");
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为12
            jPanelLeftzjw.add(jTextFields[i]);
            if (i == 0) {//添加查询和清除按钮
                jPanelLeftzjw.add(jButton1);
                jPanelLeftzjw.add(jButton2);
            }
        }
        JButton jButton3 = new JButton("提交");//按钮
        JButton jButton4 = new JButton("清除");
        jPanelLeftzjw.add(jButton3);//加入按钮
        jPanelLeftzjw.add(jButton4);
        UpdateAccidentMonitor updateAccidentMonitor = new UpdateAccidentMonitor(jButton1, jButton2, jButton3, jButton4, jTextFields);
        jButton1.addActionListener(updateAccidentMonitor);//注册监听
        jButton2.addActionListener(updateAccidentMonitor);
        jButton3.addActionListener(updateAccidentMonitor);
        jButton4.addActionListener(updateAccidentMonitor);
    }

    /**
     * 初始化修改维修界面
     */
    public static void initUpdateRepair() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {"      id：", "   维修时间：", "   维修地址：", "   维修项目：","     费用：","负责人工号：","   车辆ID："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        JButton jButton1 = new JButton("   查询   ");
        JButton jButton2 = new JButton("   清除   ");
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为12
            jPanelLeftzjw.add(jTextFields[i]);
            if (i == 0) {//添加查询和清除按钮
                jPanelLeftzjw.add(jButton1);
                jPanelLeftzjw.add(jButton2);
            }
        }
        JButton jButton3 = new JButton("提交");//按钮
        JButton jButton4 = new JButton("清除");
        jPanelLeftzjw.add(jButton3);//加入按钮
        jPanelLeftzjw.add(jButton4);
        UpdateRepairMonitor updateRepairMonitor = new UpdateRepairMonitor(jButton1, jButton2, jButton3, jButton4, jTextFields);
        jButton1.addActionListener(updateRepairMonitor);//注册监听
        jButton2.addActionListener(updateRepairMonitor);
        jButton3.addActionListener(updateRepairMonitor);
        jButton4.addActionListener(updateRepairMonitor);
    }

    /**
     * 初始化修改调用--归还界面
     */
    public static void initUpdateCall() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        String[] allClass = {" 记录id："};
        JTextField[] jTextFields = new JTextField[allClass.length];//文本框
        ButtonGroup btnGroup = new ButtonGroup();//创建按钮组
        JButton jButton1 = new JButton("   查询   ");
        for (int i = 0; i < allClass.length; i++) {
            JLabel jLabel = new JLabel(allClass[i]);//实例化标签
            jLabel.setSize(230, 20);
            jPanelLeftzjw.add(jLabel);
            jTextFields[i] = new JTextField(9);//实例化文本框，初始大小为12
            jPanelLeftzjw.add(jTextFields[i]);
            if (i == 0) {//添加查询和清除按钮
                jPanelLeftzjw.add(jButton1);
            }
        }
        JButton jButton3 = new JButton("提交");//按钮
        JButton jButton4 = new JButton("清除");
        jPanelLeftzjw.add(jButton3);//加入按钮
        jPanelLeftzjw.add(jButton4);
        UpdateCallMonitor updateCallMonitor = new UpdateCallMonitor(jButton1, jButton3, jButton4, jTextFields);
        jButton1.addActionListener(updateCallMonitor);//注册监听
        jButton3.addActionListener(updateCallMonitor);
        jButton4.addActionListener(updateCallMonitor);
    }

    /**
     * 初始化删除车辆界面
     */
    public static void initDeleteCar() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器,相当于重置容器的显示状态。
        JLabel jLabel = new JLabel("id：");//创建一个标签,内容为 "id："。
        JTextField jTextField = new JTextField(12);//创建一个文本框，宽度为12个字符。
        jPanelLeftzjw.add(jLabel);
        jPanelLeftzjw.add(jTextField);//将标签和文本框添加到容器jPanelLeftzjw中。
        JButton jButton1 = new JButton("提交");//创建两个按钮
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);//添加到容器中
        jPanelLeftzjw.add(jButton2);
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {
                    if (jTextField.getText().isEmpty())
                    {//判断车辆id是否为空
                        JOptionPane.showMessageDialog(jButton1,
                                "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Car car = CarImpl.selectBySon(jTextField.getText());
                    if (car != null) {
                        String sql = "DELETE from t_car where id= ?";
                        CarImpl.update(sql, jTextField.getText());
                        initSelectAllCar();//刷新表格,以显示更新后的车辆信息。
                        JOptionPane.showMessageDialog(jButton1,
                                "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);//弹出一个消息对话框
                    } else {
                        ///未查询到车辆
                        JOptionPane.showMessageDialog(jButton1, "车辆！！！\n删除失败！！！",
                                "消息提示", JOptionPane.WARNING_MESSAGE);//弹出一个消息对话框
                    }
                }
            }
        });
        //为"清除"按钮（jButton2）添加一个事件监听器
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {//点击了清除按钮
                    jTextField.setText("");//文本框的内容清空。
                }
            }
        });

    }

    /**
     * 初始化删除部门界面
     */
    public static void initDeleteDepartment() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        JLabel jLabel = new JLabel("id：");
        JTextField jTextField = new JTextField(12);
        jPanelLeftzjw.add(jLabel);
        jPanelLeftzjw.add(jTextField);
        JButton jButton1 = new JButton("提交");
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);
        jPanelLeftzjw.add(jButton2);//将标签和文本框添加到容器jPanelLeftzjw中。
        
        //注册按钮的监听，为 "提交" 按钮（jButton1）添加一个事件监听器
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {//点击了提交按钮
                    if (jTextField.getText().isEmpty()) {//判断部门id是否为空
                        JOptionPane.showMessageDialog(jButton1,
                                "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Department department = DepartmentImpl.selectBySon(jTextField.getText());
                    if (department != null) {
                        String sql = "DELETE from t_department where id= ?";
                        DepartmentImpl.update(sql, jTextField.getText());
                        initSelectAllDepartment();//刷新表格
                        JOptionPane.showMessageDialog(jButton1,
                                "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ///未查询到部门
                        JOptionPane.showMessageDialog(jButton1, "部门！！！\n删除失败！！！",
                                "消息提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {//点击清除按钮
                    jTextField.setText("");
                }
            }
        });

    }

    /**
     * 初始化删除员工界面
     */
    public static void initDeleteTemployee() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        JLabel jLabel = new JLabel("员工编号：");
        JTextField jTextField = new JTextField(12);
        jPanelLeftzjw.add(jLabel);
        jPanelLeftzjw.add(jTextField);
        JButton jButton1 = new JButton("提交");
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);
        jPanelLeftzjw.add(jButton2);
        //注册按钮的监听
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {//点击了提交按钮
                    if (jTextField.getText().isEmpty()) {//判断部门id是否为空
                        JOptionPane.showMessageDialog(jButton1,
                                "员工编号不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Temployee temployee = EmployeeImpl.selectBySon(jTextField.getText());
                    if (temployee != null) {
                        String sql = "DELETE from t_employee where number= ?";
                        EmployeeImpl.update(sql, jTextField.getText());
                        initSelectAllTemployee();//刷新表格
                        JOptionPane.showMessageDialog(jButton1,
                                "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ///未查询到员工
                        JOptionPane.showMessageDialog(jButton1, "员工！！！\n删除失败！！！",
                                "消息提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {
                    jTextField.setText("");
                }
            }
        });

    }
    /**
     * 初始化删除事故界面
     */
    public static void initDeleteAccident() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        JLabel jLabel = new JLabel("id：");
        JTextField jTextField = new JTextField(12);
        jPanelLeftzjw.add(jLabel);
        jPanelLeftzjw.add(jTextField);
        JButton jButton1 = new JButton("提交");
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);
        jPanelLeftzjw.add(jButton2);
        //注册按钮的监听
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {//点击了提交按钮
                    if (jTextField.getText().isEmpty()) {//判断id是否为空
                        JOptionPane.showMessageDialog(jButton1,
                                "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Accident accident = AccidentImpl.selectBySon(jTextField.getText());
                    if (accident != null) {
                        String sql = "DELETE from t_accident_record where id= ?";
                        AccidentImpl.update(sql, jTextField.getText());
                        initSelectAllAccident();//刷新表格
                        JOptionPane.showMessageDialog(jButton1,
                                "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ///未查询到
                        JOptionPane.showMessageDialog(jButton1, "事故！！！\n删除失败！！！",
                                "消息提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {
                    jTextField.setText("");
                }
            }
        });

    }

    /**
     * 初始化删除维修界面
     */
    public static void initDeleteRepair() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        JLabel jLabel = new JLabel("id：");
        JTextField jTextField = new JTextField(12);
        jPanelLeftzjw.add(jLabel);
        jPanelLeftzjw.add(jTextField);
        JButton jButton1 = new JButton("提交");
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);
        jPanelLeftzjw.add(jButton2);
        //注册按钮的监听
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {//点击了提交按钮
                    if (jTextField.getText().isEmpty()) {//判断部门id是否为空
                        JOptionPane.showMessageDialog(jButton1,
                                "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Repair repair = RepairImpl.selectBySon(jTextField.getText());
                    if (repair != null) {
                        String sql = "DELETE from t_repair_record where id= ?";
                        CarImpl.update(sql, jTextField.getText());
                        initSelectAllRepair();//刷新表格
                        JOptionPane.showMessageDialog(jButton1,
                                "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ///未查询到
                        JOptionPane.showMessageDialog(jButton1, "维修记录！！！\n删除失败！！！",
                                "消息提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {
                    jTextField.setText("");
                }
            }
        });

    }

    /**
     * 初始化删除调用界面
     */
    public static void initDeleteCall() {
        jPanelLeftzjw.removeAll();//清空组件
        jPanelLeftzjw.updateUI();//刷新容器
        JLabel jLabel = new JLabel("id：");
        JTextField jTextField = new JTextField(12);
        jPanelLeftzjw.add(jLabel);
        jPanelLeftzjw.add(jTextField);
        JButton jButton1 = new JButton("提交");
        JButton jButton2 = new JButton("清除");
        jPanelLeftzjw.add(jButton1);
        jPanelLeftzjw.add(jButton2);
        //注册按钮的监听
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton1) {//点击了提交按钮
                    if (jTextField.getText().isEmpty()) {//判断部门id是否为空
                        JOptionPane.showMessageDialog(jButton1,
                                "id不能为空！！！", "消息提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Call call = CallImpl.selectBySon(jTextField.getText());
                    if (call != null) {
                        String sql = "DELETE from t_call_car_record where id= ?";
                        CarImpl.update(sql, jTextField.getText());
                        initSelectAllCall();//刷新表格
                        JOptionPane.showMessageDialog(jButton1,
                                "删除成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        ///未查询
                        JOptionPane.showMessageDialog(jButton1, "调用记录！！！\n删除失败！！！",
                                "消息提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jButton2) {
                    jTextField.setText("");
                }
            }
        });

    }


    /**
     * 初始化查询全部车辆界面
     */
    public static void initSelectAllCar() {
        jPanelRightzjw.removeAll();//清空组件
        jPanelRightzjw.updateUI();
        Vector tableValueV = new Vector();
        Vector columnNameV = new Vector();
        String[] columnNames = {"id", "车牌号", "车型", "车龄", "颜色", "是否闲置"};
        for (String columnName : columnNames)
        {
            columnNameV.add(columnName);
        }
        List<Car> carList = CarImpl.selectAll();     
        for (Car car : carList) {
            Vector row = new Vector();
            row.add(car.getId());
            row.add(car.getCar_number());
            row.add(car.getModel());
            row.add(car.getCar_age());
            row.add(car.getColor());
            if(car.getIs_unused()==1){
                row.add("闲置");
            }else{
                row.add("调用中");
            }

            tableValueV.add(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new MTable(tableValueV, columnNameV);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30);
        scrollPane.setViewportView(table);//将表格放入滚动窗格中。
        jPanelRightzjw.add(scrollPane);
    }

    /**
     * 初始化查询全部部门界面
     */
    public static void initSelectAllDepartment() {
        jPanelRightzjw.removeAll();//清空组件
        jPanelRightzjw.updateUI();//刷新容器，相当于重置容器的显示状态
        Vector tableValueV = new Vector();
        Vector columnNameV = new Vector();//用于存储表格的数据和列名。
        String[] columnNames = {"id", "部门名称", "主管人工号", "部门电话"};
        for (String columnName : columnNames) {
            columnNameV.add(columnName);//将列名添加到columnNameV中。
        }
        List<Department> departmentList = DepartmentImpl.selectAll();   
        for (Department  department : departmentList) {
            Vector row = new Vector();
            row.add(department.getId());
            row.add(department.getName());
            row.add(department.getManager_num());
            row.add(department.getTelephone());
            tableValueV.add(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new MTable(tableValueV, columnNameV);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        jPanelRightzjw.add(scrollPane);
    }

    /**
     * 初始化查询全部员工界面
     */
    public static void initSelectAllTemployee() {
        jPanelRightzjw.removeAll();//清空组件
        jPanelRightzjw.updateUI();//刷新容器，相当于重置容器的显示状态
        Vector tableValueV = new Vector();
        Vector columnNameV = new Vector();//用于存储表格的数据和列名。
        String[] columnNames = {"员工编号", "员工姓名", "身份证号", "手机号","职位","工龄","所属部门号"};
        for (String columnName : columnNames) {
            columnNameV.add(columnName);
        }
        List<Temployee> temployeeList = EmployeeImpl.selectAll();
        for (Temployee  temployee : temployeeList) {
            Vector row = new Vector();
            row.add(temployee.getNumber());
            row.add(temployee.getName());
            row.add(temployee.getIDCard());
            row.add(temployee.getPhone());
            row.add(temployee.getPosition());
            row.add(temployee.getSeniority());
            row.add(temployee.getDep_id());
            tableValueV.add(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new MTable(tableValueV, columnNameV);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30); 
        scrollPane.setViewportView(table);
        jPanelRightzjw.add(scrollPane);
    }

    /**
     * 初始化查询全部事故界面
     */
    public static void initSelectAllAccident() {
        jPanelRightzjw.removeAll();//清空组件
        jPanelRightzjw.updateUI();//刷新容器，相当于重置容器的显示状态
        Vector tableValueV = new Vector();
        Vector columnNameV = new Vector();//用于存储表格的数据和列名。
        String[] columnNames = {"      id：", "   发生时间：", "发生地点：", "   事故类型：","   严重等级：","负责人工号：","   车辆ID："};
        for (String columnName : columnNames) {
            columnNameV.add(columnName);
        }
        List<Accident> accidentList = AccidentImpl.selectAll();
        for (Accident  accident : accidentList) {
            Vector row = new Vector();
            row.add(accident.getId());
            row.add(accident.getDate_time());
            row.add(accident.getLocation());
            row.add(accident.getAccident_type());
            row.add(accident.getAccident_level());
            row.add(accident.getResponsible());
            row.add(accident.getCar_id());
            tableValueV.add(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new MTable(tableValueV, columnNameV);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30); 
        scrollPane.setViewportView(table);
        jPanelRightzjw.add(scrollPane);
    }

    /**
     * 初始化查询全部维修界面
     */
    public static void initSelectAllRepair() {
        jPanelRightzjw.removeAll();//清空组件
        jPanelRightzjw.updateUI();//刷新容器，相当于重置容器的显示状态
        Vector tableValueV = new Vector();
        Vector columnNameV = new Vector();//用于存储表格的数据和列名。
       
        String[] columnNames = {"      id：", "   维修时间：", "   维修地址：", "   维修项目：","     费用：","负责人工号：","   车辆ID："};
        for (String columnName : columnNames) {
            columnNameV.add(columnName);
        }
        List<Repair> repairList = RepairImpl.selectAll();
        for (Repair repair : repairList) {
            Vector row = new Vector();
            row.add(repair.getId());
            row.add(repair.getDate_time());
            row.add(repair.getRepair_address());
            row.add(repair.getRepair_project());
            row.add(repair.getCost());
            row.add(repair.getResponsible());
            row.add(repair.getCar_id());
            tableValueV.add(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new MTable(tableValueV, columnNameV);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30); 
        scrollPane.setViewportView(table);
        jPanelRightzjw.add(scrollPane);
    }

    /**
     * 初始化查询全部调用界面
     */
    public static void initSelectAllCall() {
        jPanelRightzjw.removeAll();//清空组件
        jPanelRightzjw.updateUI();//刷新容器，相当于重置容器的显示状态
        Vector tableValueV = new Vector();
        Vector columnNameV = new Vector();//用于存储表格的数据和列名。
        String[] columnNames = {"id", "调用人工号", "调用车辆ID", "调用时间","是否归还"};
        for (String columnName : columnNames) {
            columnNameV.add(columnName);
        }
        List<Call> callList = CallImpl.selectAll();
        for (Call call : callList) {
            Vector row = new Vector();
            row.add(call.getId());
            row.add(call.getResponsible());
            row.add(call.getCar_id());
            row.add(call.getDate_time());
            if(call.getIs_return().equals("1")){
                row.add("已归还");
            }else{
                row.add("未归还");
            }

            tableValueV.add(row);
        }
        JScrollPane scrollPane = new JScrollPane();
        JTable table = new MTable(tableValueV, columnNameV);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(Color.YELLOW);
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30); 
        scrollPane.setViewportView(table);
        jPanelRightzjw.add(scrollPane);
    }
    
    private static class MTable extends JTable {
        public MTable(Vector rowData, Vector columnNames)//初始化表格的行数据和列名 
        {
            super(rowData, columnNames);
        }

        @Override
        public JTableHeader getTableHeader() { // 定义表格头
            JTableHeader tableHeader = super.getTableHeader();// 获得表格头对象
            tableHeader.setReorderingAllowed(false); 
            DefaultTableCellRenderer zjw1 = (DefaultTableCellRenderer) tableHeader
                    .getDefaultRenderer(); // 获得表格头的单元格对象,即用于绘制列标题的渲染器
            
            zjw1.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// 设置列名居中显示
            return tableHeader;//方法返回修改后的表格头部对象。
        }

        @Override
        public TableCellRenderer getDefaultRenderer(Class<?> columnClass)
        {
            DefaultTableCellRenderer zjw6 = (DefaultTableCellRenderer) super
                    .getDefaultRenderer(columnClass); // 获得表格的单元格对象
            zjw6.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//将取到的单元格渲染器对象zjw6的水平对齐方式设置为居中对齐。
            return zjw6;//将设置好的单元格渲染器对象返回。
        }

        @Override
        public boolean isCellEditable(int row, int column)
        { 
            return false;
        }
    }

}

