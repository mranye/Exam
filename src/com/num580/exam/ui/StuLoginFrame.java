package com.num580.exam.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import com.num580.exam.client.ExamClient;
import com.num580.exam.server.ExamServer;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.SystemColor;

/**学生登录界面 **/
public class StuLoginFrame extends JFrame {

	private int flagLogin = 0;
	private JPanel contentPane;
	private JLabel labellogin;
	private JPanel panellogin;
	private JPanel panelCenter;
	private JPanel panelIdPwd;
	private JPanel panelId;
	private JTextField textNum;
	private JPanel panelPwd;
	private JPasswordField textPwd;
	private JLabel labelmessage;
	private JPanel panelSouth;
	private JButton btlogin;
	private JButton btcancel;
	private ArrayList<Map<String, String>> listStu;
	private static String[] studentMess;
	
	/**
	 * Create the frame.
	 */
	public StuLoginFrame() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		init();
	}
	/** 初始化界面和布局 **/
	public void init(){
		this.setTitle("\u767B\u5F55\u7CFB\u7EDF");
		setSize(270,188);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置用户在此窗体上发起 "close" 时默认执行的操作：使用 System exit 方法退出应用程序
		setLocationRelativeTo(null);
		setResizable(false); 
		setContentPane(createContentPane());
	}
	/** 主面板布局 **/
	private Container createContentPane(){
		panellogin = new JPanel(new BorderLayout());//调用BorderLayout无参构造器
		panellogin.setBackground(Color.WHITE);
		panellogin.setBorder(new EmptyBorder(8,8,8,8));//设置面板的上、左、下、右边距
		labellogin = new JLabel("\u5B66\u751F\u767B\u5F55");
		labellogin.setHorizontalAlignment(SwingConstants.CENTER);
		labellogin.setBackground(Color.WHITE);
		labellogin.setFont(new Font("华文行楷", Font.BOLD, 24));
		panellogin.add(BorderLayout.NORTH,labellogin);//将label充满整个North
		panellogin.add(BorderLayout.CENTER,createCenterPane());
		panellogin.add(BorderLayout.SOUTH,createBtnPane());
		return panellogin;
	}
	/** 创建主面板中的中间面板的布局 **/
	private Container createCenterPane(){
		panelCenter = new JPanel(new BorderLayout());
		panelCenter.setBackground(Color.WHITE);
		panelCenter.add(BorderLayout.NORTH,createIdPwdPane());
		labelmessage = new JLabel("\u5B66\u751F\u767B\u5F55",JLabel.CENTER);
		panelCenter.add(labelmessage);
		return panelCenter;
	}
	/** 创建ID和密码输入面板的布局 **/
	private Container createIdPwdPane(){
		panelIdPwd = new JPanel(new GridLayout(2,1,0,6));
		panelIdPwd.setBackground(Color.WHITE);
		panelIdPwd.add(createIdPane());
		panelIdPwd.add(createPwdPane());
		return panelIdPwd;
	}
	/** 创建ID输入面板的布局 **/
	private Container createIdPane(){
		panelId = new JPanel(new BorderLayout(6,0));
		panelId.setBackground(Color.WHITE);
		panelId.add(BorderLayout.WEST,new JLabel("\u5B66\u53F7\uFF1A"));
		textNum = new JTextField();
		textNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelmessage.setText("请输入学号");
			}
		});
		panelId.add(BorderLayout.CENTER,textNum);
		return panelId;
	}
	/** 创建密码输入面板的布局 **/
	private Container createPwdPane(){
		panelPwd = new JPanel(new BorderLayout(6,0));
		panelPwd.setBackground(Color.WHITE);
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBackground(Color.WHITE);
		panelPwd.add(BorderLayout.WEST,label);
		textPwd = new JPasswordField();
		textPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelmessage.setText("请输入密码");
			}
		});
		textPwd.enableInputMethods(true);//识别输入法
		panelPwd.add(BorderLayout.CENTER,textPwd);
		return panelPwd;
	}
	/** 创建下方的按钮面板的布局 **/
	private Container createBtnPane(){
		panelSouth = new JPanel(new FlowLayout());
		panelSouth.setBackground(Color.WHITE);
		btlogin = new JButton("\u767B\u5F55");
		btlogin.setBackground(SystemColor.control);
		/** 登录按钮事件处理 **/
		btlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btLoginAction();
			}
		});
		btcancel = new JButton("\u53D6\u6D88");
		btcancel.setBackground(SystemColor.control);
		/** 取消按钮事件处理 **/
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new LoginFrame().setVisible(true);
			}
		});
		panelSouth.add(btlogin);
		panelSouth.add(btcancel);
		return panelSouth;
	}
	/** 登录按钮事件处理 **/
	private void btLoginAction(){
		/** 判断用户名或密码是否为空 **/
		if(textNum.getText().trim().equals("")&&!textPwd.getText().trim().equals("")){
			labelmessage.setText("学号不能为空");
		}else if(!textNum.getText().trim().equals("")&&textPwd.getText().trim().equals("")){
			labelmessage.setText("密码不能为空");
		}else if(textNum.getText().trim().equals("")&&textPwd.getText().trim().equals("")){
			labelmessage.setText("学号和密码不能为空");
		}else{
			/** 登录 **/				
			listStu = ExamClient.getAllStudents();
			for(Map<String, String> map:listStu){
	        	 Iterator<Entry<String, String>> i = map.entrySet().iterator();
	        	 int count = 0;
	        	 studentMess = new String[6];
	        	 while(i.hasNext()){     
	        		 Entry<String, String> key = i.next();
	        		 if(key.getKey().toString().equals("id")){
	        			 if(textNum.getText().trim().equals(key.getValue())){
	        				 flagLogin++;
	        			 }
	        		 }
	        		 if(key.getKey().toString().equals("password")){
	        			 if(textPwd.getText().trim().equals(key.getValue())){
	        				 flagLogin++;
	        			 }
	        		 }
	        		studentMess[count] = key.getValue();
	        		count++;
	        	 }
	        	 if(flagLogin==2){
	        		 dispose();
					new CheckStudentFrame().setVisible(true);
					flagLogin=0;
					break;
	        	 }else{
	        		 labelmessage.setText("您输入的用户名或密码错误！");
	        		 flagLogin=0;
	        	 }
			}
		}
	}
	public static String[] getStudentMess(){
		return studentMess;
	}

}
