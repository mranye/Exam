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
		
		/** �������ݿ� **/
		jdbcConnect = new JdbcConnect();
		boolean jdbccon = jdbcConnect.connect();
		if(jdbccon==false) return;
		
		/** ����Socket���� **/
		try {
			ss = new ServerSocket(5000);
			// ��������
			while(true){
				socket = ss.accept();
				System.out.println("Server Socket Connected Successfully!");
				// ��÷������˵����룬�ӿͻ��˽�����Ϣ
		        is = socket.getInputStream();

		        // �������˵��������ͻ��˷�����Ϣ
		        os = socket.getOutputStream();
		        obos = new ObjectOutputStream(os);
		        //����ѧ�����ݿ���Ϣ
		        queryAllMessage = new QueryAllMessage();
		        ArrayList<Map<String, String>> listStu = new ArrayList<Map<String, String>>();
		        listStu = queryAllMessage.QueryAllStudents();
		        obos.writeObject(listStu);
		        //���ͽ�ʦ���ݿ���Ϣ
		        ArrayList<Map<String, String>> listTea = new ArrayList<Map<String, String>>();
		        listTea = queryAllMessage.QueryAllTeachers();
		        obos.writeObject(listTea);
		        //TeacherManager.DeleteStudentById("2014560902");
		        //�ر���Դ
		        //closeSocket();
			}
			
		} catch (IOException e) {
			System.out.println("�����������˵�socket����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/** �ر���Դ **/
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
