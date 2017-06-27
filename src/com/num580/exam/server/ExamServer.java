package com.num580.exam.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.num580.exam.jdbc.*;
import com.num580.exam.ui.*;

public class ExamServer {
	
	private static JdbcConnect jdbcConnect;
	private static QueryAllMessage queryAllMessage;
	private static ServerSocket ss;
	private static Socket socket;
	private static InputStream is;
	private static OutputStream os;
	private static BufferedReader br;
	private static BufferedWriter bw;
	private static PrintWriter pw;
	private static DataInputStream di;
	private static ObjectOutputStream obos;
	

	public static void main(String[] args) {
		
		/** 链接数据库 **/
		jdbcConnect = new JdbcConnect();
		boolean jdbccon = jdbcConnect.connect();
		if(jdbccon==false) return;
		
		/** 建立Socket链接 **/
		try {
			ss = new ServerSocket(5000);
			// 监听连接
			while(true){
				socket = ss.accept();
				System.out.println("Server Socket Connected Successfully!");
				// 获得服务器端的输入，从客户端接收信息
		        is = socket.getInputStream();

		        // 服务器端的输出，向客户端发送信息
		        os = socket.getOutputStream();
		        obos = new ObjectOutputStream(os);
		        //传送学生数据库信息
		        queryAllMessage = new QueryAllMessage();
		        ArrayList<Map<String, String>> listStu = new ArrayList<Map<String, String>>();
		        listStu = queryAllMessage.QueryAllStudents();
		        obos.writeObject(listStu);
		        //传送教师数据库信息
		        ArrayList<Map<String, String>> listTea = new ArrayList<Map<String, String>>();
		        listTea = queryAllMessage.QueryAllTeachers();
		        obos.writeObject(listTea);
		        //TeacherManager.DeleteStudentById("2014560902");
		        //关闭资源
		        //closeSocket();
			}
			
		} catch (IOException e) {
			System.out.println("创建服务器端的socket对象失败！");
			e.printStackTrace();
		}
	}
	/** 关闭资源 **/
	public static void closeSocket(){
		try {
			pw.close();
			bw.close();
			os.close();
			br.close();
			is.close();
	        socket.close();
	        ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Server Socket Closed Successfully!");
	}
}
