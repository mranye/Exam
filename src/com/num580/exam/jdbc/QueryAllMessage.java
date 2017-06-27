package com.num580.exam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QueryAllMessage {
	public JdbcConnect jdbcConnect = new JdbcConnect();
	private Connection con = JdbcConnect.con;
	public PreparedStatement ps = JdbcConnect.ps;
	public ResultSet rs = JdbcConnect.rs;

	/** ��ѯ����ѧ����Ϣ **/
	public ArrayList<Map<String, String>> QueryAllStudents(){
		String sql= "select * from (t_student)";
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//���ResultSetMetaData����
			ResultSetMetaData rsmd=rs.getMetaData();
			//��÷��ش� ResultSet �����е�����
			int count = rsmd.getColumnCount();
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				for(int j=1;j<=count;j++){
					//��ȡָ���еı�Ŀ¼����
					String label=rsmd.getColumnLabel(j);
					//��ȡ�� ResultSet����ĵ�ǰ����ָ���е�ֵ
					String stu= rs.getString(j);
					//�����ݿ��е��ֶ�����ֵ��ӦΪһ��map�����е�һ����ֵ��
					map.put(label.toLowerCase(), stu);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	/** ��ѯ���н�ʦ��Ϣ **/
	public ArrayList<Map<String, String>> QueryAllTeachers(){
		String sql= "select * from (t_teacher)";
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//���ResultSetMetaData����
			ResultSetMetaData rsmd=rs.getMetaData();
			//��÷��ش� ResultSet �����е�����
			int count = rsmd.getColumnCount();
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				for(int j=1;j<=count;j++){
					//��ȡָ���еı�Ŀ¼����
					String label=rsmd.getColumnLabel(j);
					//��ȡ�� ResultSet����ĵ�ǰ����ָ���е�ֵ
					String teac= rs.getString(j);
					//�����ݿ��е��ֶ�����ֵ��ӦΪһ��map�����е�һ����ֵ��
					map.put(label.toLowerCase(), teac);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
