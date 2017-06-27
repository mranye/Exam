package com.num580.exam.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import com.num580.exam.jdbc.TeacherManager;
import com.num580.exam.server.ExamServer;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeaManagerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNum;
	private JTextField textName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel labelTitle;
	private JPanel panelCenter;
	private JPanel panelCenterUp;
	private JPanel panelUp1;
	private JComboBox comboBox;
	private JPanel panelUp2;
	private JLabel labelNum;
	private JLabel lableName;
	private JLabel labelSex;
	private JPanel panelSex;
	private JRadioButton rdbtnman;
	private JRadioButton rdbtnwomen;
	private JPanel panelCenterDelete;
	private JTextField textAca;
	private JTextField textPro;
	private JPanel panelUp3;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblAca;
	private JPanel panel_3;
	private JLabel lblPro;
	private JPanel panel_1;
	private JButton btnSubmit;
	private JButton btnInOrUpReset;
	private int comboBoxFlag=0;
	private JLabel labelDelete;
	private JPanel panel_4;
	private JLabel lbDeleteNum;
	private JTextField textDeleteNum;
	private JButton btDelete;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeaManagerFrame frame = new TeaManagerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public TeaManagerFrame() {
		setTitle("\u6559\u5E08\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(500,300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		labelTitle = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		labelTitle.setFont(new Font("华文行楷", Font.BOLD, 24));
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelTitle, BorderLayout.NORTH);
		
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		panelCenterUp = new JPanel();
		panelCenterUp.setBackground(Color.WHITE);
		panelCenter.add(panelCenterUp, BorderLayout.NORTH);
		panelCenterUp.setLayout(new BorderLayout(0, 0));
		
		panelUp1 = new JPanel();
		panelUp1.setBackground(Color.WHITE);
		panelCenterUp.add(panelUp1, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		/** 选择添加还是更新 **/
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==1){
					comboBoxFlag=2;
				}else{
					comboBoxFlag=1;
				}
			}
		});
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u589E\u52A0\u5B66\u751F\u4FE1\u606F", "\u4FEE\u6539\u5B66\u751F\u4FE1\u606F"}));
		panelUp1.add(comboBox);
		
		panelUp2 = new JPanel();
		panelUp2.setBackground(Color.WHITE);
		panelCenterUp.add(panelUp2, BorderLayout.CENTER);
		panelUp2.setLayout(new GridLayout(1, 0, 0, 0));
		
		labelNum = new JLabel("\u5B66\u53F7\uFF1A");
		labelNum.setHorizontalAlignment(SwingConstants.CENTER);
		panelUp2.add(labelNum);
		
		textNum = new JTextField();
		panelUp2.add(textNum);
		textNum.setColumns(10);
		textNum.setText("");
		
		lableName = new JLabel("\u59D3\u540D\uFF1A");
		lableName.setHorizontalAlignment(SwingConstants.CENTER);
		panelUp2.add(lableName);
		
		textName = new JTextField();
		panelUp2.add(textName);
		textName.setColumns(10);
		textName.setText("");
		
		labelSex = new JLabel("\u6027\u522B\uFF1A");
		labelSex.setHorizontalAlignment(SwingConstants.CENTER);
		panelUp2.add(labelSex);
		
		panelSex = new JPanel();
		panelSex.setBackground(Color.WHITE);
		panelUp2.add(panelSex);
		panelSex.setLayout(new GridLayout(1, 1, 0, 0));
		
		rdbtnman = new JRadioButton("\u7537");
		rdbtnman.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnman);
		panelSex.add(rdbtnman);
		
		rdbtnwomen = new JRadioButton("\u5973");
		rdbtnwomen.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnwomen);
		panelSex.add(rdbtnwomen);
		
		panelUp3 = new JPanel();
		panelUp3.setBackground(Color.WHITE);
		panelCenterUp.add(panelUp3, BorderLayout.SOUTH);
		panelUp3.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelUp3.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblAca = new JLabel("\u5B66\u9662\uFF1A");
		panel_2.add(lblAca);
		lblAca.setHorizontalAlignment(SwingConstants.CENTER);
		
		textAca = new JTextField();
		panel_2.add(textAca);
		textAca.setColumns(10);
		textAca.setText("");
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblPro = new JLabel("\u4E13\u4E1A\uFF1A");
		panel_3.add(lblPro);
		lblPro.setHorizontalAlignment(SwingConstants.CENTER);
		
		textPro = new JTextField();
		panel_3.add(textPro);
		textPro.setColumns(10);
		textPro.setText("");
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panelUp3.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSubmit = new JButton("\u63D0\u4EA4");
		/** 提交按钮事件 **/
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertOrUpdate();
			}
		});
		panel_1.add(btnSubmit);
		btnSubmit.setBackground(SystemColor.control);
		
		btnInOrUpReset = new JButton("\u91CD\u7F6E");
		/** “插入或更新的重置”按钮事件 **/
		btnInOrUpReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** “插入或更新的重置”按钮事件 **/
				textNum.setText("");
				textName.setText("");
				textAca.setText("");
				textPro.setText("");
				rdbtnman.setSelected(false);
				rdbtnwomen.setSelected(false);
			}
		});
		btnInOrUpReset.setBackground(SystemColor.control);
		panel_1.add(btnInOrUpReset);
		
		panelCenterDelete = new JPanel();
		panelCenterDelete.setBackground(Color.WHITE);
		panelCenter.add(panelCenterDelete, BorderLayout.CENTER);
		panelCenterDelete.setLayout(new BorderLayout(0, 0));
		
		labelDelete = new JLabel("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		labelDelete.setHorizontalAlignment(SwingConstants.CENTER);
		labelDelete.setFont(new Font("华文行楷", Font.BOLD, 24));
		panelCenterDelete.add(labelDelete, BorderLayout.NORTH);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panelCenterDelete.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lbDeleteNum = new JLabel("\u5B66\u53F7\uFF1A");
		lbDeleteNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeleteNum.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lbDeleteNum);
		
		textDeleteNum = new JTextField();
		panel_4.add(textDeleteNum);
		textDeleteNum.setColumns(10);
		
		btDelete = new JButton("\u5220\u9664");
		/** 删除按钮事件 **/
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteOneStudent();
			}
		});
		panel_4.add(btDelete);
	}
	public void deleteOneStudent() {
		String id = textDeleteNum.getText().toString().trim();
		TeacherManager.DeleteStudentById(id);
	}
	/** 插入更新学生表 **/
	public void insertOrUpdate() {
		 //TeacherManager teacher = new TeacherManager();
		 String num,name,sex,aca,pro;
		 num = textNum.getText().toString().trim();
		 name = textName.getText().toString().trim();
		 if(rdbtnman.isSelected()){
			 sex=rdbtnman.getText().toString().trim();
		 }else if(rdbtnwomen.isSelected()){
			 sex=rdbtnwomen.getText().toString().trim();
		 }else{
			 sex="";
		 }
		 aca = textAca.getText().toString().trim();
		 pro = textPro.getText().toString().trim();
		 if (comboBox.getSelectedItem().toString().equals("增加学生信息")) {
			 //插入选项 
			 TeacherManager.insertOneStudent(num, name, sex, aca, pro);
		}else if(comboBox.getSelectedItem().toString().equals("修改学生信息")){
			//更新选项
			TeacherManager.UpdateOneStudent(num, name, sex, aca, pro);
		}
	}
}
