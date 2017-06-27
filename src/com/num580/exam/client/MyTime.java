package com.num580.exam.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import com.num580.exam.ui.CheckStudentFrame;
import com.num580.exam.ui.ExamFrame;
import com.num580.exam.ui.ScoreFrame;

public class MyTime {
	static int h1 = 0, m1 = 0, m2 = 0, s1 = 0, s2 = 0;
	static int hh = 0,mm = 1,ss = 0;

	/** 获取系统当前时间 **/
	public static String currentTime() {
		Date date = new Date();
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String str = df.format(date);
		return str;
	}

	/** 正计时 **/
	public static void timeHasTaken(final JLabel label) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				s1++;
				if (s1 == 10) {
					s1 = 0;
					s2++;
				}
				if (s2 == 6) {
					s2 = 0;
					m1++;
				}
				if (m1 == 10) {
					m1 = 0;
					m2++;
				}
				if (m2 == 6) {
					m2 = 0;
					h1++;
				}
				String str = m2 + "" + m1 + ":" + s2 + s1;
				label.setText(str);
			}
		}, 1000, 1000);
	}

	/** 倒计时 **/
	public static void timeWillTake(final JLabel label) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run(){  
				String strm = null,strs = null,str=null;
				if(mm!=0&&ss==0){
					mm--;
					ss=59;
				}else if(mm==0&&ss==0){
					CheckStudentFrame.getExamFrame().dispose();
					new ScoreFrame().setVisible(true);
					this.cancel();
				}else{
					ss--;
				}
				if(mm<10){
					strm = "0"+mm;
				}else{
					strm = mm+"";
				}
				if(ss<10){
					strs = "0"+ss;
				}else{
					strs = ss+"";
				}
				str = strm+":"+strs;
				label.setText(str);
			}
		}, 1000, 1000);

	}

}
