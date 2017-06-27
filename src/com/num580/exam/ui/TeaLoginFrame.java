package com.num580.exam.ui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.num580.exam.client.ExamClient;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/** ��ʦ��¼���� **/
public class TeaLoginFrame extends JFrame {
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
	private ArrayList<Map<String, String>> listTea;
	private static String[] teacherMess;
	
	/**
	 * Create the frame.
	 */
	public TeaLoginFrame() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		init();
	}
	
	/** ��ʼ������Ͳ��� **/
	public void init(){
		this.setTitle("\u767B\u5F55\u7CFB\u7EDF");
		setSize(270,188);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����û��ڴ˴����Ϸ��� "close" ʱĬ��ִ�еĲ�����ʹ�� System exit �����˳�Ӧ�ó���
		setLocationRelativeTo(null);
		setResizable(false); 
		setContentPane(createContentPane());
	}
	/** ����岼�� **/
	private Container createContentPane(){
		panellogin = new JPanel(new BorderLayout());//����BorderLayout�޲ι�����
		panellogin.setBackground(Color.WHITE);
		panellogin.setBorder(new EmptyBorder(8,8,8,8));
		labellogin = new JLabel("\u6559\u5E08\u767B\u5F55");
		labellogin.setHorizontalAlignment(SwingConstants.CENTER);
		labellogin.setBackground(Color.WHITE);
		labellogin.setFont(new Font("�����п�", Font.BOLD, 24));
		panellogin.add(BorderLayout.NORTH,labellogin);//��label��������North
		panellogin.add(BorderLayout.CENTER,createCenterPane());
		panellogin.add(BorderLayout.SOUTH,createBtnPane());
		return panellogin;
	}
	/** ����������е��м����Ĳ��� **/
	private Container createCenterPane(){
		panelCenter = new JPanel(new BorderLayout());
		panelCenter.setBackground(Color.WHITE);
		panelCenter.add(BorderLayout.NORTH,createIdPwdPane());
		labelmessage = new JLabel("\u6559\u5E08\u767B\u5F55",JLabel.CENTER);
		labelmessage.setBackground(Color.WHITE);
		panelCenter.add(labelmessage);
		return panelCenter;
	}
	/** ����ID�������������Ĳ��� **/
	private Container createIdPwdPane(){
		panelIdPwd = new JPanel(new GridLayout(2,1,0,6));
		panelIdPwd.setBackground(Color.WHITE);
		panelIdPwd.add(createIdPane());
		panelIdPwd.add(createPwdPane());
		return panelIdPwd;
	}
	/** ����ID�������Ĳ��� **/
	private Container createIdPane(){
		panelId = new JPanel(new BorderLayout(6,0));
		panelId.setBackground(Color.WHITE);
		panelId.add(BorderLayout.WEST,new JLabel("\u7F16\u53F7\uFF1A"));
		textNum = new JTextField();
		textNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelmessage.setText("��������");
			}
		});
		panelId.add(BorderLayout.CENTER,textNum);
		return panelId;
	}
	/** ���������������Ĳ��� **/
	private Container createPwdPane(){
		panelPwd = new JPanel(new BorderLayout(6,0));
		panelPwd.setBackground(Color.WHITE);
		panelPwd.add(BorderLayout.WEST,new JLabel("\u5BC6\u7801\uFF1A"));
		textPwd = new JPasswordField();
		textPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelmessage.setText("����������");
			}
		});
		textPwd.enableInputMethods(true);//ʶ�����뷨
		panelPwd.add(BorderLayout.CENTER,textPwd);
		return panelPwd;
	}
	/** �����·��İ�ť���Ĳ��� **/
	private Container createBtnPane(){
		panelSouth = new JPanel(new FlowLayout());
		panelSouth.setBackground(Color.WHITE);
		btlogin = new JButton("\u767B\u5F55");
		btlogin.setForeground(Color.BLACK);
		btlogin.setBackground(SystemColor.control);
		/** ��¼��ť�¼����� **/
		btlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** �ж��û����������Ƿ�Ϊ�� **/
				if(textNum.getText().trim().equals("")&&!textPwd.getText().trim().equals("")){
					labelmessage.setText("��Ų���Ϊ��");
				}else if(!textNum.getText().trim().equals("")&&textPwd.getText().trim().equals("")){
					labelmessage.setText("���벻��Ϊ��");
				}else if(textNum.getText().trim().equals("")&&textPwd.getText().trim().equals("")){
					labelmessage.setText("��ź����벻��Ϊ��");
				}else{
					/** ��¼ **/
					dispose();
					new TeaManagerFrame().setVisible(true);
				}
			}
		});
		
		btcancel = new JButton("\u53D6\u6D88");
		btcancel.setBackground(SystemColor.control);
		/** ȡ����ť�¼����� **/
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/** ȡ�� **/
				dispose();
				new LoginFrame().setVisible(true);
			}
		});
		panelSouth.add(btlogin);
		panelSouth.add(btcancel);
		return panelSouth;
	}
	/** ��¼��ť�¼����� **/
	private void btLoginAction(){
		/** �ж��û����������Ƿ�Ϊ�� **/
		if(textNum.getText().trim().equals("")&&!textPwd.getText().trim().equals("")){
			labelmessage.setText("ѧ�Ų���Ϊ��");
		}else if(!textNum.getText().trim().equals("")&&textPwd.getText().trim().equals("")){
			labelmessage.setText("���벻��Ϊ��");
		}else if(textNum.getText().trim().equals("")&&textPwd.getText().trim().equals("")){
			labelmessage.setText("ѧ�ź����벻��Ϊ��");
		}else{
			/** ��¼ **/				
			listTea = ExamClient.getAllTeachers();
			for(Map<String, String> map:listTea){
	        	 Iterator<Entry<String, String>> i = map.entrySet().iterator();
	        	 int count = 0;
	        	 teacherMess = new String[6];
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
	        		 teacherMess[count] = key.getValue();
	        		count++;
	        	 }
	        	 if(flagLogin==2){
	        		 dispose();
					new TeaManagerFrame().setVisible(true);
					flagLogin=0;
	        	 }else{
	        		 labelmessage.setText("��������û������������");
	        		 flagLogin=0;
	        	 }
			}
		}
	}
	public static String[] getTeacherMess(){
		return teacherMess;
	}

}
