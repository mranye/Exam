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

	/** 查询所有学生信息 **/
	public ArrayList<Map<String, String>> QueryAllStudents(){
		String sql= "select * from (t_student)";
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//获得ResultSetMetaData对象
			ResultSetMetaData rsmd=rs.getMetaData();
			//获得返回此 ResultSet 对象中的列数
			int count = rsmd.getColumnCount();
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				for(int j=1;j<=count;j++){
					//获取指定列的表目录名称
					String label=rsmd.getColumnLabel(j);
					//获取此 ResultSet对象的当前行中指定列的值
					String stu= rs.getString(j);
					//把数据库中的字段名和值对应为一个map对象中的一个键值对
					map.put(label.toLowerCase(), stu);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	/** 查询所有教师信息 **/
	public ArrayList<Map<String, String>> QueryAllTeachers(){
		String sql= "select * from (t_teacher)";
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//获得ResultSetMetaData对象
			ResultSetMetaData rsmd=rs.getMetaData();
			//获得返回此 ResultSet 对象中的列数
			int count = rsmd.getColumnCount();
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				for(int j=1;j<=count;j++){
					//获取指定列的表目录名称
					String label=rsmd.getColumnLabel(j);
					//获取此 ResultSet对象的当前行中指定列的值
					String teac= rs.getString(j);
					//把数据库中的字段名和值对应为一个map对象中的一个键值对
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
