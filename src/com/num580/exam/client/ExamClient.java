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

		/** �����ͻ���socket���� **/
		try {
			socket = new Socket("127.0.0.1", 5000);
			System.out.println("Client Socket Connected Successfully!");
			// �ͻ��˵������
	        os = socket.getOutputStream();
	        //DataOutputStream ds = new DataOutputStream(os);
	        // �ӷ������˽�����Ϣ
	        is = socket.getInputStream();
	        obis = new ObjectInputStream(is);
	        //����ѧ�����ݿ���Ϣ
	        listStu = new ArrayList<Map<String, String>>();
	        try {
				listStu = (ArrayList<Map<String, String>>) obis.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        //���ܽ�ʦ���ݿ���Ϣ
	        listTea = new ArrayList<Map<String, String>>();
	        try {
	        	listTea = (ArrayList<Map<String, String>>) obis.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        //����
	        LoginFrame loginframe = new LoginFrame();
	        loginframe.setVisible(true);
	        
	        //�ر���Դ
	        //closeSocket();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** �ر���Դ **/
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
	/** ��ȡȫ��ѧ������ **/
	public static ArrayList<Map<String, String>> getAllStudents(){
		return listStu;
	}
	/** ��ȡȫ����ʦ���� **/
	public static ArrayList<Map<String, String>> getAllTeachers(){
		return listTea;
	}
}
