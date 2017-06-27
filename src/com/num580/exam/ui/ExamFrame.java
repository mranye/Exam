package com.num580.exam.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

import com.num580.exam.client.MyTime;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamFrame extends JFrame {

	private JPanel panelTitle;
	private static JTextField textFill1;
	private static JTextField textFill2;
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	private final ButtonGroup buttonGroup4 = new ButtonGroup();
	private final ButtonGroup buttonGroup5 = new ButtonGroup();
	private static JTextField textFill3;
	private JPanel panelTitleUp;
	private JLabel lavelTitle;
	private JPanel panelTitleCenter;
	private JLabel labelNum;
	private JLabel lbdbNum;
	private JLabel labelName;
	private JLabel lbdbName;
	private JLabel labelTime;
	private JLabel ladbTime;
	private JPanel panelTitleDown;
	private JLabel labelTimeTaken;
	private JLabel lbdbTimeTaken;
	private JLabel labelTimeLeft;
	private JLabel lbdbTimeLeft;
	private JScrollPane scrollPane;
	private JPanel panelSelect;
	private JLabel labelSelect;
	private JLabel select1;
	private static JRadioButton rbSelect11;
	private static JRadioButton rbSelect12;
	private static JRadioButton rbSelect13;
	private static JRadioButton rbSelect14;
	private JLabel select2;
	private static JRadioButton rbSelect21;
	private static JRadioButton rbSelect22;
	private static JRadioButton rbSelect23;
	private static JRadioButton rbSelect24;
	private JLabel select3;
	private static JRadioButton rbSelect31;
	private static JRadioButton rbSelect32;
	private static JRadioButton rbSelect33;
	private static JRadioButton rbSelect34;
	private JLabel select4;
	private static JRadioButton rbSelect41;
	private static JRadioButton rbSelect42;
	private static JRadioButton rbSelect43;
	private static JRadioButton rbSelect44;
	private JLabel select5;
	private static JRadioButton rbSelect51;
	private static JRadioButton rbSelect52;
	private static JRadioButton rbSelect53;
	private static JRadioButton rbSelect54;
	private JLabel labelFill;
	private JLabel labelFill1;
	private JLabel labelFillPlea1;
	private JLabel labelFill2;
	private JLabel labelFill3;
	private JLabel labelFillPlea3;
	private JPanel panelBtn;
	private JButton btnsubmit;
	private static String btselect1;
	private static String btselect2;
	private static String btselect3;
	private static String btselect4;
	private static String btselect5;
	private String[] studentMess = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamFrame frame = new ExamFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExamFrame() {
		/** 登录的学生信息 **/
		studentMess = StuLoginFrame.getStudentMess();
		
		setTitle("\u6B63\u5728\u6D4B\u8BD5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false); 
		panelTitle = new JPanel();
		panelTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(700,900);
		setContentPane(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		panelTitleUp = new JPanel();
		panelTitleUp.setBackground(Color.WHITE);
		panelTitle.add(panelTitleUp, BorderLayout.NORTH);
		panelTitleUp.setLayout(new BorderLayout(0, 0));
		
		lavelTitle = new JLabel("\u4E0A\u673A\u6D4B\u8BD5");
		lavelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lavelTitle.setFont(new Font("华文行楷", Font.BOLD, 28));
		lavelTitle.setBackground(SystemColor.menu);
		panelTitleUp.add(lavelTitle, BorderLayout.NORTH);
		
		panelTitleCenter = new JPanel();
		panelTitleCenter.setBackground(Color.WHITE);
		panelTitleUp.add(panelTitleCenter, BorderLayout.CENTER);
		panelTitleCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		labelNum = new JLabel("\u5B66\u53F7\uFF1A");
		labelNum.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitleCenter.add(labelNum);
		
		lbdbNum = new JLabel("\u6570\u636E\u5E93\u83B7\u53D6");
		panelTitleCenter.add(lbdbNum);
		//设置成登录的学生学号
		lbdbNum.setText(studentMess[0]);
		
		labelName = new JLabel("\u59D3\u540D\uFF1A");
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitleCenter.add(labelName);
		
		lbdbName = new JLabel("\u6570\u636E\u5E93\u83B7\u53D6");
		panelTitleCenter.add(lbdbName);
		//设置成登录的学生姓名
		lbdbName.setText(studentMess[2]);
		
		labelTime = new JLabel("\u8003\u8BD5\u65F6\u95F4\uFF1A");
		labelTime.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitleCenter.add(labelTime);
		
		ladbTime = new JLabel("1\u5206\u949F");
		panelTitleCenter.add(ladbTime);
		
		panelTitleDown = new JPanel();
		panelTitleDown.setBackground(Color.WHITE);
		panelTitleUp.add(panelTitleDown, BorderLayout.SOUTH);
		panelTitleDown.setLayout(new GridLayout(1, 0, 0, 0));
		
		labelTimeTaken = new JLabel("\u5DF2\u8003\u65F6\u95F4\uFF1A");
		labelTimeTaken.setBackground(Color.WHITE);
		labelTimeTaken.setFont(new Font("宋体", Font.PLAIN, 14));
		labelTimeTaken.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTitleDown.add(labelTimeTaken);
		
		lbdbTimeTaken = new JLabel("");
		lbdbTimeTaken.setForeground(Color.RED);
		lbdbTimeTaken.setFont(new Font("宋体", Font.PLAIN, 14));
		panelTitleDown.add(lbdbTimeTaken);
		//正计时
		MyTime.timeHasTaken(lbdbTimeTaken);
		
		labelTimeLeft = new JLabel("\u8FD8\u5269\u65F6\u95F4\uFF1A");
		labelTimeLeft.setFont(new Font("宋体", Font.PLAIN, 14));
		labelTimeLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTitleDown.add(labelTimeLeft);
		
		lbdbTimeLeft = new JLabel("");
		lbdbTimeLeft.setForeground(Color.RED);
		lbdbTimeLeft.setFont(new Font("宋体", Font.PLAIN, 14));
		panelTitleDown.add(lbdbTimeLeft);
		//倒计时
		MyTime.timeWillTake(lbdbTimeLeft);
		
		scrollPane = new JScrollPane();
		panelTitle.add(scrollPane, BorderLayout.CENTER);
		
		panelSelect = new JPanel();
		panelSelect.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelSelect);
		panelSelect.setLayout(new GridLayout(0, 1, 0, 0));
		
		labelSelect = new JLabel("\u4E00\u3001\u9009\u62E9\u9898");
		panelSelect.add(labelSelect);
		
		select1 = new JLabel("1.\u4E0B\u5217\u4E0D\u53EF\u4F5C\u4E3Ajava\u8BED\u8A00\u4FEE\u9970\u7B26\u7684\u662F\uFF1F");
		panelSelect.add(select1);
		
		rbSelect11 = new JRadioButton("A. a1");
		btselect1 ="未答";
		rbSelect11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btselect1 = getSelect1();
			}
		});
		buttonGroup1.add(rbSelect11);
		panelSelect.add(rbSelect11);
		
		rbSelect12 = new JRadioButton("B. $1");
		btselect1 ="未答";
		rbSelect12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect1 = getSelect1();
			}
		});
		buttonGroup1.add(rbSelect12);
		panelSelect.add(rbSelect12);
		
		rbSelect13 = new JRadioButton("C. _1");
		btselect1 ="未答";
		rbSelect13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect1 = getSelect1();
			}
		});
		buttonGroup1.add(rbSelect13);
		panelSelect.add(rbSelect13);
		
		rbSelect14 = new JRadioButton("D .11");
		btselect1 ="未答";
		rbSelect14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect1 = getSelect1();
			}
		});
		buttonGroup1.add(rbSelect14);
		panelSelect.add(rbSelect14);
		
		select2 = new JLabel("2.\u6709\u4E00\u6BB5java\u5E94\u7528\u7A0B\u5E8F\uFF0C\u5B83\u7684\u4E3B\u7C7B\u540D\u662Fa1\uFF0C\u90A3\u4E48\u4FDD\u5B58\u5B83\u7684\u6E90\u6587\u4EF6\u540D\u53EF\u4EE5\u662F\uFF1F");
		panelSelect.add(select2);
		
		rbSelect21 = new JRadioButton("A. a1.java");
		btselect2 ="未答";
		rbSelect21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btselect2 = getSelect2();
			}
		});
		buttonGroup2.add(rbSelect21);
		panelSelect.add(rbSelect21);
		
		rbSelect22 = new JRadioButton("B. a.class");
		btselect2 ="未答";
		rbSelect22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect2 = getSelect2();
			}
		});
		buttonGroup2.add(rbSelect22);
		panelSelect.add(rbSelect22);
		
		rbSelect23 = new JRadioButton("C. a1");
		btselect2 ="未答";
		rbSelect23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect2 = getSelect2();
			}
		});
		buttonGroup2.add(rbSelect23);
		panelSelect.add(rbSelect23);
		
		rbSelect24 = new JRadioButton("D. \u90FD\u53EF\u4EE5");
		btselect2 ="未答";
		rbSelect24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect2 = getSelect2();
			}
		});
		buttonGroup2.add(rbSelect24);
		panelSelect.add(rbSelect24);
		
		select3 = new JLabel("3.\u4E0B\u9762\u6B63\u786E\u58F0\u660E\u4E00\u4E2A\u4E00\u7EF4\u6570\u7EC4\u7684\u662F\uFF1F");
		panelSelect.add(select3);
		
		rbSelect31 = new JRadioButton("A. String a");
		btselect3 ="未答";
		rbSelect31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect3 = getSelect3();
			}
		});
		buttonGroup3.add(rbSelect31);
		panelSelect.add(rbSelect31);
		
		rbSelect32 = new JRadioButton("B. String a[]");
		btselect3 ="未答";
		rbSelect32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect3 = getSelect3();
			}
		});
		buttonGroup3.add(rbSelect32);
		panelSelect.add(rbSelect32);
		
		rbSelect33 = new JRadioButton("C. char a[][]");
		btselect3 ="未答";
		rbSelect33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect3 = getSelect3();
			}
		});
		buttonGroup3.add(rbSelect33);
		panelSelect.add(rbSelect33);
		
		rbSelect34 = new JRadioButton("D. String a[10]");
		btselect3 ="未答";
		rbSelect34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect3 = getSelect3();
			}
		});
		buttonGroup3.add(rbSelect34);
		panelSelect.add(rbSelect34);
		
		select4 = new JLabel("4.\u4E0B\u9762\u5173\u4E8E\u7EE7\u627F\u7684\u53D9\u8FF0\u54EA\u4E9B\u662F\u6B63\u786E\u7684\uFF1F");
		panelSelect.add(select4);
		
		rbSelect41 = new JRadioButton("A. \u5728java\u4E2D\u4E0D\u5141\u8BB8\u5355\u7EE7\u627F\u3002");
		btselect4 ="未答";
		rbSelect41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect4 = getSelect4();
			}
		});
		buttonGroup4.add(rbSelect41);
		panelSelect.add(rbSelect41);
		
		rbSelect42 = new JRadioButton("B. \u5728java\u4E2D\u4E00\u4E2A\u7C7B\u53EA\u80FD\u5B9E\u73B0\u4E00\u4E2A\u63A5\u53E3\u3002");
		btselect4 ="未答";
		rbSelect42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect4 = getSelect4();
			}
		});
		buttonGroup4.add(rbSelect42);
		panelSelect.add(rbSelect42);
		
		rbSelect43 = new JRadioButton("C. \u5728java\u4E2D\u4E00\u4E2A\u7C7B\u4E0D\u80FD\u540C\u65F6\u7EE7\u627F\u4E00\u4E2A\u7C7B\u548C\u5B9E\u73B0\u4E00\u4E2A\u63A5\u53E3\u3002");
		btselect4 ="未答";
		rbSelect43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect4 = getSelect4();
			}
		});
		buttonGroup4.add(rbSelect43);
		panelSelect.add(rbSelect43);
		
		rbSelect44 = new JRadioButton("D. java\u7684\u5355\u4E00\u7EE7\u627F\u4F7F\u4EE3\u7801\u66F4\u53EF\u9760\u3002");
		btselect4 ="未答";
		rbSelect44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect4 = getSelect4();
			}
		});
		buttonGroup4.add(rbSelect44);
		panelSelect.add(rbSelect44);
		
		select5 = new JLabel("5.\u4E0B\u5217\u5173\u4E8EJava\u8BED\u8A00\u7684\u7279\u70B9\uFF0C\u63CF\u8FF0\u9519\u8BEF\u7684\u662F\uFF1F");
		panelSelect.add(select5);
		
		rbSelect51 = new JRadioButton("A. Java\u662F\u8DE8\u5E73\u53F0\u7684\u7F16\u7A0B\u8BED\u8A00");
		btselect5 ="未答";
		rbSelect51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect5 = getSelect5();
			}
		});
		buttonGroup5.add(rbSelect51);
		panelSelect.add(rbSelect51);
		
		rbSelect52 = new JRadioButton("B. Java\u652F\u6301\u5206\u5E03\u5F0F\u8BA1\u7B97");
		btselect5 ="未答";
		rbSelect52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect5 = getSelect5();
			}
		});
		buttonGroup5.add(rbSelect52);
		panelSelect.add(rbSelect52);
		
		rbSelect53 = new JRadioButton("C. Java\u662F\u9762\u5411\u8FC7\u7A0B\u7684\u7F16\u7A0B\u8BED\u8A00");
		btselect5 ="未答";
		rbSelect53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect5 = getSelect5();
			}
		});
		buttonGroup5.add(rbSelect53);
		panelSelect.add(rbSelect53);
		
		rbSelect54 = new JRadioButton("D. Java\u662F\u9762\u5411\u5BF9\u8C61\u7684\u7F16\u7A0B\u8BED\u8A00");
		btselect5 ="未答";
		rbSelect54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btselect5 = getSelect5();
			}
		});
		buttonGroup5.add(rbSelect54);
		panelSelect.add(rbSelect54);
		
		labelFill = new JLabel("\u4E8C\u3001\u586B\u7A7A\u9898");
		panelSelect.add(labelFill);
		
		labelFill1 = new JLabel("1. \u9762\u5411\u5BF9\u8C61\u7A0B\u5E8F\u8BBE\u8BA1\u7684\u4E09\u4E2A\u7279\u5F81\u662F\uFF1A\u5C01\u88C5\u3001\u591A\u6001\u548C\u4EC0\u4E48\uFF1F");
		labelFill1.setBackground(SystemColor.menu);
		panelSelect.add(labelFill1);
		
		labelFillPlea1 = new JLabel("\u8BF7\u5728\u4E0B\u65B9\u8F93\u5165\u7B54\u6848\uFF1A");
		panelSelect.add(labelFillPlea1);
		
		textFill1 = new JTextField();
		textFill1.setHorizontalAlignment(SwingConstants.LEFT);
		panelSelect.add(textFill1);
		textFill1.setColumns(10);
		
		labelFill2 = new JLabel("2.\u5E03\u5C14\u578B\u5E38\u91CF\u6709\u4E24\u4E2A\u503C\uFF0C\u5B83\u4EEC\u5206\u522B\u662Ffalse\u548C\u4EC0\u4E48\uFF1F");
		panelSelect.add(labelFill2);
		
		JLabel labelFillPlea2 = new JLabel("\u8BF7\u5728\u4E0B\u65B9\u8F93\u5165\u7B54\u6848\uFF1A");
		panelSelect.add(labelFillPlea2);
		
		textFill2 = new JTextField();
		panelSelect.add(textFill2);
		textFill2.setColumns(10);
		
		labelFill3 = new JLabel("3.\u7528\u4EC0\u4E48\u4FEE\u9970\u7684\u53D8\u91CF\u53EB\u9759\u6001\u53D8\u91CF\uFF1F");
		panelSelect.add(labelFill3);
		
		labelFillPlea3 = new JLabel("\u8BF7\u5728\u4E0B\u65B9\u8F93\u5165\u7B54\u6848\uFF1A");
		panelSelect.add(labelFillPlea3);
		
		textFill3 = new JTextField();
		panelSelect.add(textFill3);
		textFill3.setColumns(10);
		
		panelBtn = new JPanel();
		panelBtn.setBackground(Color.WHITE);
		panelTitle.add(panelBtn, BorderLayout.SOUTH);
		
		btnsubmit = new JButton("\u8003\u8BD5\u63D0\u4EA4");
		/** “开始考试”按钮事件处理 **/
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//提交时间
				btnSubmitAction();			
			}
		});
		btnsubmit.setFont(new Font("宋体", Font.PLAIN, 14));
		panelBtn.add(btnsubmit);
	}
	
	/** “开始考试”按钮事件处理 **/
	private void btnSubmitAction(){
		dispose();
		new ScoreFrame().setVisible(true);
	}
	/** 获取第一道选择题的答案 **/
	private static String getSelect1(){
		String select1 = null;
		if(rbSelect11.isSelected()){
			select1 = rbSelect11.getText();
		}else if(rbSelect12.isSelected()){
			select1 = rbSelect12.getText();
		}else if(rbSelect13.isSelected()){
			select1 = rbSelect13.getText();
		}else if(rbSelect14.isSelected()){
			select1 = rbSelect14.getText();
		}
		return select1;
	}
	/** 获取第二道选择题的答案 **/
	private static String getSelect2(){
		String select2 = null;
		if(rbSelect21.isSelected()){
			select2 = rbSelect21.getText();
		}else if(rbSelect22.isSelected()){
			select2 = rbSelect22.getText();
		}else if(rbSelect23.isSelected()){
			select2 = rbSelect23.getText();
		}else if(rbSelect24.isSelected()){
			select2 = rbSelect24.getText();
		}
		return select2;
	}
	/** 获取第三道选择题的答案 **/
	private static String getSelect3(){
		String select3 = null;
		if(rbSelect11.isSelected()){
			select3 = rbSelect31.getText();
		}else if(rbSelect32.isSelected()){
			select3 = rbSelect32.getText();
		}else if(rbSelect33.isSelected()){
			select3 = rbSelect33.getText();
		}else if(rbSelect34.isSelected()){
			select3 = rbSelect34.getText();
		}
		return select3;
	}
	/** 获取第四道选择题的答案 **/
	private static String getSelect4(){
		String select4 = null;
		if(rbSelect41.isSelected()){
			select4 = rbSelect41.getText();
		}else if(rbSelect42.isSelected()){
			select4 = rbSelect42.getText();
		}else if(rbSelect43.isSelected()){
			select4 = rbSelect43.getText();
		}else if(rbSelect44.isSelected()){
			select4 = rbSelect44.getText();
		}
		return select4;
	}
	/** 获取第五道选择题的答案 **/
	private static String getSelect5(){
		String select5 = null;
		if(rbSelect51.isSelected()){
			select5 = rbSelect51.getText();
		}else if(rbSelect52.isSelected()){
			select5 = rbSelect52.getText();
		}else if(rbSelect53.isSelected()){
			select5 = rbSelect53.getText();
		}else if(rbSelect54.isSelected()){
			select5 = rbSelect54.getText();
		}
		return select5;
	}
	/** 获取学生答案 
	 *  选择题的答案包含完整的选项内容**/
	public static String[] getAllAnswers(){
		String[] answers = new String[8];
		answers[0] = btselect1;
		answers[1] = btselect2;
		answers[2] = btselect3;
		answers[3] = btselect4;
		answers[4] = btselect5;
		answers[5] = textFill1.getText();
		if(answers[5].equals("")){
			answers[5] = "未答";
		}
		answers[6] = textFill2.getText();
		if(answers[6].equals("")){
			answers[6] = "未答";
		}
		answers[7] = textFill3.getText();
		if(answers[7].equals("")){
			answers[7] = "未答";
		}
		return answers;
	}
	/** 获取学生答案 
	 *  选择题的答案只包含选项的选号**/
	public static String[] getAnswers(){
		String[] allAnswers = getAllAnswers();
		String[] answers = new String[8];
		for(int i=0;i<5;i++){
			if(allAnswers[i].equals("未答")){
				answers[i] = allAnswers[i];
			}else{
				answers[i] = allAnswers[i].substring(0, 1);
			}
		}
		for(int i=5;i<8;i++){
			answers[i] = allAnswers[i];
		}
		return answers;
	}

	

}
