package com.num580.exam.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

/** �����ӭ���� **/
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelWel;
	private JLabel labelWel;
	private JPanel panelSelect;
	private JPanel panelTea;
	private JButton btnTea;
	private JPanel panelStu;
	private JButton btnStu;
	private JPanel panelCan;
	private JButton btnCan;
	private JPanel panelMess;
	private JLabel TextSelect;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("\u767B\u5F55\u7CFB\u7EDF");
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
		setSize(270,188);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����û��ڴ˴����Ϸ��� "close" ʱĬ��ִ�еĲ�����ʹ�� System exit �����˳�Ӧ�ó���
		setLocationRelativeTo(null);
		setResizable(false); 
		setContentPane(createContentPane());
	}
	/** ����岼�� **/
	public Container createContentPane(){
		panelWel = new JPanel();
		panelWel.setBackground(Color.WHITE);
		//getContentPane().add(panelWel, BorderLayout.NORTH);
		panelWel.setLayout(new BorderLayout(0, 0));

		labelWel = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u6D4B\u8BD5\u7CFB\u7EDF");
		labelWel.setFont(new Font("���Ŀ���", Font.BOLD, 24));
		labelWel.setHorizontalAlignment(SwingConstants.CENTER);
		panelWel.add(labelWel, BorderLayout.NORTH);
		panelWel.add(BorderLayout.CENTER,createCenterPane());
		panelWel.add(BorderLayout.SOUTH,createBtnPane());
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelSelect.add(panel, BorderLayout.SOUTH);
		
		lblNewLabel = new JLabel("\u897F\u5317\u519C\u6797\u79D1\u6280\u5927\u5B66");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 8));
		panel.add(lblNewLabel);
		return panelWel;
	}
	/** �����·���ť���Ĳ��� **/
	private Container createBtnPane() {
		panelSelect = new JPanel();
		//getContentPane().add(panelSelect, BorderLayout.SOUTH);
		panelSelect.setLayout(new BorderLayout(0, 1));
		panelSelect.add(createTeaPane(),BorderLayout.NORTH);
		panelSelect.add(createStuPane(),BorderLayout.CENTER);
		//panelSelect.add(createCanPane(),BorderLayout.SOUTH);
		return panelSelect;
	}

	/*private Container createCanPane() {
		panelCan = new JPanel();
		//panelSelect.add(panelCan, BorderLayout.SOUTH);
		btnCan = new JButton("\u5173\u95ED\u7CFB\u7EDF");
		panelCan.add(btnCan);
		
		return panelCan;
	}*/
	/** ������ť�����ѧ����¼��ť�Ĳ��� **/
	private Container createStuPane() {
		panelStu = new JPanel();
		panelStu.setBackground(Color.WHITE);
		//panelSelect.add(panelStu, BorderLayout.CENTER);
		btnStu = new JButton("\u5B66\u751F\u767B\u5F55");
		btnStu.setBackground(SystemColor.control);
		btnStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StuLoginFrame().setVisible(true);
				setVisible(false);
			}
		});
		panelStu.add(btnStu);
		return panelStu;
	}
	/** ������ť����н�ʦ��¼��ť�Ĳ��� **/
	private Container createTeaPane() {
		panelTea = new JPanel();
		panelTea.setBackground(Color.WHITE);
		//panelSelect.add(panelTea, BorderLayout.NORTH);
		btnTea = new JButton("\u6559\u5E08\u767B\u5F55");
		btnTea.setBackground(SystemColor.control);
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeaLoginFrame().setVisible(true);
				setVisible(false);
			}
		});
		panelTea.add(btnTea);
		return panelTea;
	}
	/** ����������е��м����Ĳ��� **/
	private Container createCenterPane() {
		panelMess = new JPanel();
		panelMess.setBackground(Color.WHITE);
		panelMess.setForeground(SystemColor.menu);
		FlowLayout flowLayout = (FlowLayout) panelMess.getLayout();
		flowLayout.setVgap(4);
		//getContentPane().add(panelMess, BorderLayout.CENTER);
		TextSelect = new JLabel("\u8BF7\u9009\u62E9\u767B\u5F55\u65B9\u5F0F");
		TextSelect.setBackground(Color.WHITE);
		TextSelect.setFont(new Font("����", Font.PLAIN, 14));
		panelMess.add(TextSelect);
		return panelMess;
	}

}
