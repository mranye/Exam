package com.num580.exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcConnect {
	
	
	private static String url = "jdbc:mysql://localhost:3306/examtest";
	private static String username = "root";
	private static String password = "";
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	/** 数据库链接 **/
	public boolean connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败！");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.out.println("数据库连接失败!");    
			e.printStackTrace();
            return false;
		}
		return true;
	}
	
	public static Connection getConnection(){
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return con;
		}
	}
	
}
