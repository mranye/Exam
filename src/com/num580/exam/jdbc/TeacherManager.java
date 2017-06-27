package com.num580.exam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherManager {

	public JdbcConnect jdbcConnect = new JdbcConnect();
	private static Connection con = JdbcConnect.getConnection();
	public static PreparedStatement ps = JdbcConnect.ps;
	public static ResultSet rs = JdbcConnect.rs;
	
	/** 教师增添学生信息 **/
	public static void insertOneStudent(String num,String name,String sex,String aca,String pro){
		String passwd = num;
		//String sql= "insert into t_student(id,password,sex,name,profession,academy) values(?,?,?,'?','?','?');";
		String sql= "insert into t_student(id,password,sex,name,profession,academy) values(?,?,?,?,?,?);";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			ps.setString(2, passwd);
			ps.setString(3, sex);
			ps.setString(4, name);		
			ps.setString(5, pro);
			ps.setString(6, aca);			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/** 教师更新学生信息 **/
	public static void UpdateOneStudent(String num,String name,String sex,String aca,String pro){
		String sql= "update t_student set sex=?,name=?,profession=?,academy=? where id=?;";
		String passwd = num;
		try {
			ps = con.prepareStatement(sql);
			//ps.setString(1, passwd);
			ps.setString(1, sex);
			ps.setString(2, name);
			ps.setString(3, pro);
			ps.setString(4, aca);
			ps.setString(5, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/** 根据ID查询学生信息 **/
	public static ResultSet QueryStudentById(String num){
		String sql= "select * from t_student where id=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	/** 根据学院查询学生信息 **/
	public static ResultSet QueryStudentByPro(String pro){
		String sql= "select * from t_student where pro=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/** 根据ID删除学生信息 **/
	public static void DeleteStudentById(String id){
		String sql= "delete from t_student where id=?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
