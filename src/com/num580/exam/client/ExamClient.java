package com.num580.exam.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Map;
import com.num580.exam.ui.*;

public class ExamClient {
	
	private static Socket socket;
	private static InputStream is;
	private static OutputStream os;
	//private static DataOutputStream ds;
	private static ObjectInputStream obis;
	private static ArrayList<Map<String, String>> listStu;
	private static ArrayList<Map<String, String>> listTea;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/** 创建客户端socket对象 **/
		try {
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Client Socket Connected Successfully!");
			// 客户端的输出流
	        os = socket.getOutputStream();
	        //DataOutputStream ds = new DataOutputStream(os);
	        // 从服务器端接收信息
	        is = socket.getInputStream();
	        obis = new ObjectInputStream(is);
	        //接受学生数据库信息
	        listStu = new ArrayList<Map<String, String>>();
	        try {
				listStu = (ArrayList<Map<String, String>>) obis.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        //接受教师数据库信息
	        listTea = new ArrayList<Map<String, String>>();
	        try {
	        	listTea = (ArrayList<Map<String, String>>) obis.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        //界面
	        LoginFrame loginframe = new LoginFrame();
	        loginframe.setVisible(true);
	        
	        //关闭资源
	        //closeSocket();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 关闭资源 **/
	public static void closeSocket(){
        try {
        	obis.close();
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Client Socket Closed Successfully!");
	}
	/** 获取全部学生数据 **/
	public static ArrayList<Map<String, String>> getAllStudents(){
		return listStu;
	}
	/** 获取全部教师数据 **/
	public static ArrayList<Map<String, String>> getAllTeachers(){
		return listTea;
	}
}
