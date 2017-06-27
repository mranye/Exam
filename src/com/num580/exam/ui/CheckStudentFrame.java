package com.num580.exam.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.border.CompoundBorder;

import com.num580.exam.client.ExamClient;

public class CheckStudentFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelall;
	private JPanel paneltitle;
	private JLabel labeltitle;
	private JPanel panelCenter;
	private JPanel panelBtn;
	private JButton btnStart;
	private JButton btnFalse;
	private JLabel lbdaId;
	private JLabel labelId;
	private JLabel labelName;
	private JLabel lbdaName;
	private JLabel labelAca;
	private JLabel lbdaAca;
	private JLabel labelPro;
	private JLabel lbdaPro;
	private String[] studentMess;
	private static ExamFrame exam;

	/**
	 * Create the frame.
	 */
	public CheckStudentFrame() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		init();
		searcgDb();
	}
	/** 初始化界面和布局 **/
	public void init(){
		this.setTitle("\u6838\u5BF9\u4FE1\u606F");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置用户在此窗体上发起 "close" 时默认执行的操作：使用 System exit 方法退出应用程序
		setLocationRelativeTo(null);
		setResizable(false); 
		setContentPane(createContentPane());
	}
	/** 主面板布局 **/
	private Container createContentPane(){
		panelall = new JPanel(new BorderLayout());//调用BorderLayout无参构造器
		panelall.setBackground(Color.WHITE);
		panelall.setBorder(new EmptyBorder(15,25,15,25));
		paneltitle = new JPanel();
		paneltitle.setBackground(Color.WHITE);
		labeltitle = new JLabel("\u6838\u5BF9\u8003\u751F\u4FE1\u606F");
		labeltitle.setFont(new Font("华文行楷", Font.BOLD, 32));
		paneltitle.add(labeltitle);

		panelall.add(paneltitle, BorderLayout.NORTH);
		panelall.add(createCenterPane(), BorderLayout.CENTER);
		
		JPanel panelAo = new JPanel();
		panelAo.setBackground(SystemColor.menu);
		panelCenter.add(panelAo);
		panelAo.setLayout(null);
		//panelAo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelAo.setBorder(new CompoundBorder());
		lbdaId = new JLabel("\u5B66\u53F7\uFF1A");
		lbdaId.setBounds(78, 23, 48, 19);
		panelAo.add(lbdaId);
		lbdaId.setHorizontalAlignment(SwingConstants.CENTER);
		lbdaId.setFont(new Font("宋体", Font.PLAIN, 16));
		
		labelId = new JLabel("\u6570\u636E\u5E93\u4E2D\u83B7\u53D6");
		labelId.setBounds(171, 23, 154, 19);
		panelAo.add(labelId);
		labelId.setFont(new Font("宋体", Font.PLAIN, 16));
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		
		labelName = new JLabel("\u59D3\u540D\uFF1A");
		labelName.setVerticalAlignment(SwingConstants.TOP);
		labelName.setBounds(78, 54, 48, 19);
		panelAo.add(labelName);
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setFont(new Font("宋体", Font.PLAIN, 16));
		
		lbdaName = new JLabel("\u6570\u636E\u5E93\u4E2D\u83B7\u53D6");
		lbdaName.setBounds(171, 54, 154, 19);
		panelAo.add(lbdaName);
		lbdaName.setFont(new Font("宋体", Font.PLAIN, 16));
		
		labelAca = new JLabel("\u5B66\u9662\uFF1A");
		labelAca.setBounds(78, 80, 48, 32);
		panelAo.add(labelAca);
		labelAca.setHorizontalAlignment(SwingConstants.CENTER);
		labelAca.setFont(new Font("宋体", Font.PLAIN, 16));
		
		lbdaAca = new JLabel("\u6570\u636E\u5E93\u4E2D\u83B7\u53D6");
		lbdaAca.setBounds(171, 87, 154, 19);
		panelAo.add(lbdaAca);
		lbdaAca.setFont(new Font("宋体", Font.PLAIN, 16));
		
		labelPro = new JLabel("\u4E13\u4E1A\uFF1A");
		labelPro.setBounds(78, 114, 48, 32);
		panelAo.add(labelPro);
		labelPro.setHorizontalAlignment(SwingConstants.CENTER);
		labelPro.setFont(new Font("宋体", Font.PLAIN, 16));
		
		lbdaPro = new JLabel("\u6570\u636E\u5E93\u4E2D\u83B7\u53D6");
		lbdaPro.setBounds(171, 121, 154, 19);
		panelAo.add(lbdaPro);
		lbdaPro.setFont(new Font("宋体", Font.PLAIN, 16));
		panelall.add(createBtnPane(), BorderLayout.SOUTH);
		return panelall;
	}
	/** 创建主面板中的中间面板的布局 **/
	private Container createCenterPane(){
		panelCenter = new JPanel();
		panelCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCenter.setLayout(new BorderLayout(0, 0));
		return panelCenter;
	}
	
	/** 创建下方的按钮面板的布局 **/
	private Container createBtnPane(){
		panelBtn = new JPanel();
		panelBtn.setBackground(Color.WHITE);
		//panelall.add(panelBtn, BorderLayout.SOUTH);
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnStart = new JButton("\u5F00\u59CB\u8003\u8BD5");
		btnStart.setBackground(SystemColor.control);
		/** “开始考试”按钮事件 **/
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				exam = new ExamFrame();
				exam.setVisible(true);
			}
		});
		btnStart.setFont(new Font("宋体", Font.PLAIN, 12));
		panelBtn.add(btnStart);
		
		btnFalse = new JButton("\u4FE1\u606F\u6709\u8BEF");
		btnFalse.setBackground(SystemColor.control);
		/** “信息有误”按钮事件 **/
		btnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StuLoginFrame().setVisible(true);
			}
		});
		btnFalse.setFont(new Font("宋体", Font.PLAIN, 12));
		panelBtn.add(btnFalse);
		return panelBtn;
	}
	/** 调用学生信息 **/
	private void searcgDb(){
        studentMess = StuLoginFrame.getStudentMess();
        labelId.setText(studentMess[0]);
        lbdaName.setText(studentMess[2]);
        lbdaAca.setText(studentMess[5]);
        lbdaPro.setText(studentMess[3]);
	}
	/** 获取考试界面对象 **/
	public static ExamFrame getExamFrame(){
		return exam;
	}
}
