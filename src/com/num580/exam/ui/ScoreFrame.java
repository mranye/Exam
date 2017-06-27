package com.num580.exam.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.lang.reflect.Array;

import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

import com.num580.exam.client.MyTime;
import javax.swing.JScrollPane;

public class ScoreFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelBorder;
	private JPanel panelScoreSearch;
	private JLabel lblNewLabel;
	private JPanel panelScoreTh;
	private JLabel labelTestName;
	private JLabel labelNum;
	private JLabel labelTestTime;
	private JLabel labelTestScore;
	private JPanel panelScoreShow;
	private JLabel TextTestName;
	private JLabel ladbNum;
	private JLabel laTime;
	private JLabel laScore;
	private JPanel panelCenter;
	private JPanel panelQuestion;
	private JLabel labelQuestion;
	private JPanel panel;
	private JPanel panelQuesTitle;
	private JPanel panelQues1;
	private JLabel labelType;
	private JLabel labelCount;
	private JLabel yourAnswer;
	private JLabel correctAnswer;
	private JLabel textType1;
	private JLabel textCount1;
	private JLabel textYourAnswer1;
	private JLabel textCorrectAnswer1;
	private JPanel panelQuest;
	private JPanel panelQues2;
	private JPanel panelQues3;
	private JPanel panelQues4;
	private JPanel panelQues5;
	private JPanel panelQues6;
	private JPanel panelQues7;
	private JPanel panelQues8;
	private String[] answer;
	private String[] stuAnswer;
	private String[] studentMess = null;
	private String date;
	private JLabel textType2;
	private JLabel textCount2;
	private JLabel textYourAnswer2;
	private JLabel textCorrectAnswer2;
	private JLabel textType3;
	private JLabel textCount3;
	private JLabel textYourAnswer3;
	private JLabel textCorrectAnswer3;
	private JLabel textType4;
	private JLabel textCount4;
	private JLabel textYourAnswer4;
	private JLabel textCorrectAnswer4;
	private JLabel textType5;
	private JLabel textCount5;
	private JLabel textYourAnswer5;
	private JLabel textCorrectAnswer5;
	private JLabel textType6;
	private JLabel textCount6;
	private JLabel textYourAnswer6;
	private JLabel textCorrectAnswer6;
	private JLabel textType7;
	private JLabel textCount7;
	private JLabel textYourAnswer7;
	private JLabel textCorrectAnswer7;
	private JLabel textType8;
	private JLabel textCount8;
	private JLabel textYourAnswer8;
	private JLabel textCorrectAnswer8;
	private JPanel[] panelQues;
	private JLabel[] textType;
	private JLabel[] textCount;
	private JLabel[] textYourAnswer;
	private JLabel[] textCorrectAnswer;
	
	/**
	 * Create the frame.
	 */
	public ScoreFrame() {
		setTitle("\u6210\u7EE9\u9519\u9898\u67E5\u8BE2");
		/** 本套题正确答案 **/
		answer = new String[]{"D","A","B","D","C","继承","true","static"};
		/** 学生答案 **/
		stuAnswer = ExamFrame.getAnswers();
		/** 登录的学生信息 **/
		studentMess = StuLoginFrame.getStudentMess();
		/** 考试时间 **/
		date = MyTime.currentTime();
		
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(700,500);
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new LineBorder(new Color(224, 255, 255)));
		contentPane.setBorder(new EmptyBorder(8,8,8,8));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//设置值为总成绩
		String str = caculateScore()+"";
		
		panelBorder = new JPanel();
		contentPane.add(panelBorder, BorderLayout.NORTH);
		panelBorder.setBackground(Color.WHITE);
		panelBorder.setLayout(new BorderLayout(0, 0));
		
		panelScoreSearch = new JPanel();
		panelBorder.add(panelScoreSearch, BorderLayout.NORTH);
		panelScoreSearch.setBackground(Color.WHITE);
		panelScoreSearch.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("\u6210\u7EE9\u67E5\u8BE2");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelScoreSearch.add(lblNewLabel, BorderLayout.NORTH);
		
		panelScoreTh = new JPanel();
		panelScoreTh.setBackground(SystemColor.menu);
		panelScoreSearch.add(panelScoreTh, BorderLayout.CENTER);
		panelScoreTh.setLayout(new GridLayout(1, 0, 0, 0));
		
		labelTestName = new JLabel("\u8003\u8BD5\u540D\u79F0");
		labelTestName.setFont(new Font("宋体", Font.PLAIN, 14));
		labelTestName.setBackground(SystemColor.menu);
		labelTestName.setHorizontalAlignment(SwingConstants.CENTER);
		labelTestName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreTh.add(labelTestName);
		
		labelNum = new JLabel("\u8003\u751F\u5B66\u53F7");
		labelNum.setFont(new Font("宋体", Font.PLAIN, 14));
		labelNum.setBackground(new Color(230, 230, 250));
		labelNum.setHorizontalAlignment(SwingConstants.CENTER);
		labelNum.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreTh.add(labelNum);
		
		labelTestTime = new JLabel("\u8003\u8BD5\u65F6\u95F4");
		labelTestTime.setFont(new Font("宋体", Font.PLAIN, 14));
		labelTestTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelTestTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreTh.add(labelTestTime);
		
		labelTestScore = new JLabel("\u8003\u8BD5\u6210\u7EE9");
		labelTestScore.setFont(new Font("宋体", Font.PLAIN, 14));
		labelTestScore.setHorizontalAlignment(SwingConstants.CENTER);
		labelTestScore.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreTh.add(labelTestScore);
		
		
		panelScoreShow = new JPanel();
		panelScoreShow.setBackground(Color.WHITE);
		panelScoreSearch.add(panelScoreShow, BorderLayout.SOUTH);
		panelScoreShow.setLayout(new GridLayout(1, 0, 0, 0));
		
		TextTestName = new JLabel("Java\u4E0A\u673A\u8003\u8BD5");
		TextTestName.setBackground(new Color(255, 245, 238));
		TextTestName.setHorizontalAlignment(SwingConstants.CENTER);
		TextTestName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreShow.add(TextTestName);
		
		ladbNum = new JLabel("\u6570\u636E\u5E93\u83B7\u53D6");
		ladbNum.setBackground(new Color(255, 245, 238));
		ladbNum.setHorizontalAlignment(SwingConstants.CENTER);
		ladbNum.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreShow.add(ladbNum);
		//设置成学生的ID
		ladbNum.setText(studentMess[0]);
		
		laTime = new JLabel("\u83B7\u53D6\u5F53\u524D\u65F6\u95F4");
		laTime.setBackground(new Color(255, 245, 238));
		laTime.setHorizontalAlignment(SwingConstants.CENTER);
		laTime.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreShow.add(laTime);
		//设置成提交试卷的时间
		laTime.setText(date);
		
		laScore = new JLabel("\u8BA1\u7B97\u6210\u7EE9");
		laScore.setBackground(new Color(255, 245, 238));
		laScore.setHorizontalAlignment(SwingConstants.CENTER);
		laScore.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelScoreShow.add(laScore);
		laScore.setText(str);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.WHITE);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		panelQuestion = new JPanel();
		panelQuestion.setBackground(Color.WHITE);
		panelCenter.add(panelQuestion, BorderLayout.NORTH);
		panelQuestion.setLayout(new BorderLayout(0, 0));
		
		labelQuestion = new JLabel("\u9519\u9898\u67E5\u8BE2");
		labelQuestion.setFont(new Font("华文行楷", Font.BOLD, 26));
		labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		panelQuestion.add(labelQuestion, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelQuestion.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panelQuesTitle = new JPanel();
		panel.add(panelQuesTitle, BorderLayout.NORTH);
		panelQuesTitle.setLayout(new GridLayout(1, 0, 0, 0));
		
		labelType = new JLabel("\u9898\u76EE\u7C7B\u578B");
		labelType.setHorizontalAlignment(SwingConstants.CENTER);
		labelType.setFont(new Font("宋体", Font.PLAIN, 14));
		labelType.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuesTitle.add(labelType);
		
		labelCount = new JLabel("\u9898\u53F7");
		labelCount.setHorizontalAlignment(SwingConstants.CENTER);
		labelCount.setFont(new Font("宋体", Font.PLAIN, 14));
		labelCount.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuesTitle.add(labelCount);
		
		yourAnswer = new JLabel("\u8003\u751F\u7B54\u6848");
		yourAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		yourAnswer.setFont(new Font("宋体", Font.PLAIN, 14));
		yourAnswer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuesTitle.add(yourAnswer);
		
		correctAnswer = new JLabel("\u6B63\u786E\u7B54\u6848");
		correctAnswer.setFont(new Font("宋体", Font.PLAIN, 14));
		correctAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		correctAnswer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuesTitle.add(correctAnswer);
		
		panelQuest = new JPanel();
		panelQuest.setBackground(Color.WHITE);
		panel.add(panelQuest, BorderLayout.CENTER);
		panelQuest.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelQues1 = new JPanel();
		panelQuest.add(panelQues1);
		panelQues1.setBackground(Color.WHITE);
		panelQues1.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		textType1 = new JLabel("");
		textType1.setHorizontalAlignment(SwingConstants.CENTER);
		textType1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues1.add(textType1);
		
		textCount1 = new JLabel("");
		textCount1.setHorizontalAlignment(SwingConstants.CENTER);
		textCount1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues1.add(textCount1);
		
		textYourAnswer1 = new JLabel("");
		textYourAnswer1.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues1.add(textYourAnswer1);
		
		textCorrectAnswer1 = new JLabel("");
		textCorrectAnswer1.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues1.add(textCorrectAnswer1);
		
		panelQues2 = new JPanel();
		panelQues2.setBackground(Color.WHITE);
		panelQuest.add(panelQues2);
		panelQues2.setLayout(new GridLayout(1, 1, 0, 0));
		
		textType2 = new JLabel("");
		textType2.setHorizontalAlignment(SwingConstants.CENTER);
		textType2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues2.add(textType2);
		
		textCount2 = new JLabel("");
		textCount2.setHorizontalAlignment(SwingConstants.CENTER);
		textCount2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues2.add(textCount2);
		
		textYourAnswer2 = new JLabel("");
		textYourAnswer2.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues2.add(textYourAnswer2);
		
		textCorrectAnswer2 = new JLabel("");
		textCorrectAnswer2.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues2.add(textCorrectAnswer2);
		
		panelQues3 = new JPanel();
		panelQues3.setBackground(Color.WHITE);
		panelQuest.add(panelQues3);
		panelQues3.setLayout(new GridLayout(1, 0, 0, 0));
		
		textType3 = new JLabel("");
		textType3.setHorizontalAlignment(SwingConstants.CENTER);
		textType3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues3.add(textType3);
		
		textCount3 = new JLabel("");
		textCount3.setHorizontalAlignment(SwingConstants.CENTER);
		textCount3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues3.add(textCount3);
		
		textYourAnswer3 = new JLabel("");
		textYourAnswer3.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues3.add(textYourAnswer3);
		
		textCorrectAnswer3 = new JLabel("");
		textCorrectAnswer3.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues3.add(textCorrectAnswer3);
		
		panelQues4 = new JPanel();
		panelQues4.setBackground(Color.WHITE);
		panelQuest.add(panelQues4);
		panelQues4.setLayout(new GridLayout(1, 0, 0, 0));
		
		textType4 = new JLabel("");
		textType4.setHorizontalAlignment(SwingConstants.CENTER);
		textType4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues4.add(textType4);
		
		textCount4 = new JLabel("");
		textCount4.setHorizontalAlignment(SwingConstants.CENTER);
		textCount4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues4.add(textCount4);
		
		textYourAnswer4 = new JLabel("");
		textYourAnswer4.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues4.add(textYourAnswer4);
		
		textCorrectAnswer4 = new JLabel("");
		textCorrectAnswer4.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues4.add(textCorrectAnswer4);
		
		panelQues5 = new JPanel();
		panelQues5.setBackground(Color.WHITE);
		panelQuest.add(panelQues5);
		panelQues5.setLayout(new GridLayout(1, 0, 0, 0));
		
		textType5 = new JLabel("");
		textType5.setHorizontalAlignment(SwingConstants.CENTER);
		textType5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues5.add(textType5);
		
		textCount5 = new JLabel("");
		textCount5.setHorizontalAlignment(SwingConstants.CENTER);
		textCount5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues5.add(textCount5);
		
		textYourAnswer5 = new JLabel("");
		textYourAnswer5.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues5.add(textYourAnswer5);
		
		textCorrectAnswer5 = new JLabel("");
		textCorrectAnswer5.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues5.add(textCorrectAnswer5);
		
		panelQues6 = new JPanel();
		panelQues6.setBackground(Color.WHITE);
		panelQuest.add(panelQues6);
		panelQues6.setLayout(new GridLayout(1, 0, 0, 0));
		
		textType6 = new JLabel("");
		textType6.setHorizontalAlignment(SwingConstants.CENTER);
		textType6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues6.add(textType6);
		
		textCount6 = new JLabel("");
		textCount6.setHorizontalAlignment(SwingConstants.CENTER);
		textCount6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues6.add(textCount6);
		
		textYourAnswer6 = new JLabel("");
		textYourAnswer6.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues6.add(textYourAnswer6);
		
		textCorrectAnswer6 = new JLabel("");
		textCorrectAnswer6.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues6.add(textCorrectAnswer6);
		
		panelQues7 = new JPanel();
		panelQues7.setBackground(Color.WHITE);
		panelQuest.add(panelQues7);
		panelQues7.setLayout(new GridLayout(1, 0, 0, 0));
		
		textType7 = new JLabel("");
		textType7.setHorizontalAlignment(SwingConstants.CENTER);
		textType7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues7.add(textType7);
		
		textCount7 = new JLabel("");
		textCount7.setHorizontalAlignment(SwingConstants.CENTER);
		textCount7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues7.add(textCount7);
		
		textYourAnswer7 = new JLabel("");
		textYourAnswer7.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues7.add(textYourAnswer7);
		
		textCorrectAnswer7 = new JLabel("");
		textCorrectAnswer7.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues7.add(textCorrectAnswer7);
		
		panelQues8 = new JPanel();
		panelQues8.setBackground(Color.WHITE);
		panelQuest.add(panelQues8);
		panelQues8.setLayout(new GridLayout(1, 0, 0, 0));
		
		textType8 = new JLabel("");
		textType8.setHorizontalAlignment(SwingConstants.CENTER);
		textType8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues8.add(textType8);
		
		textCount8 = new JLabel("");
		textCount8.setHorizontalAlignment(SwingConstants.CENTER);
		textCount8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues8.add(textCount8);
		
		textYourAnswer8 = new JLabel("");
		textYourAnswer8.setHorizontalAlignment(SwingConstants.CENTER);
		textYourAnswer8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues8.add(textYourAnswer8);
		
		textCorrectAnswer8 = new JLabel("");
		textCorrectAnswer8.setHorizontalAlignment(SwingConstants.CENTER);
		textCorrectAnswer8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQues8.add(textCorrectAnswer8);
		
		/** 没有错题时，错题面板消失 **/
		panelQues = new JPanel[]{panelQues1,panelQues2,panelQues3,panelQues4,panelQues5,panelQues6,panelQues7,panelQues8};
		for(int i=0;i<8;i++){
			setVisibleFalse(panelQues[i]);
		}
		
		textType = new JLabel[]{textType1,textType2,textType3,textType4,textType5,textType6,textType7,textType8};
		textCount = new JLabel[]{textCount1,textCount2,textCount3,textCount4,textCount5,textCount6,textCount7,textCount8};
		textYourAnswer = new JLabel[]{textYourAnswer1,textYourAnswer2,textYourAnswer3,textYourAnswer4,textYourAnswer5,textYourAnswer6,textYourAnswer7,textYourAnswer8};
		textCorrectAnswer = new JLabel[]{textCorrectAnswer1,textCorrectAnswer2,textCorrectAnswer3,textCorrectAnswer4,textCorrectAnswer5,textCorrectAnswer6,textCorrectAnswer7,textCorrectAnswer8};
		showProblems();
	}
	/** 获取正确答案 **/
	public String[] getCorrAnswers(){
		return answer;
	}
	/** 计算总分 **/
	public int caculateScore(){
		int allScore = 0;
		//计算选择题
		for(int i=0;i<5;i++){
			if(answer[i].trim().equals(stuAnswer[i].trim())){
				allScore += 14;
			}
		}
		for(int i=5;i<8;i++){
			if(answer[i].trim().equals(stuAnswer[i].trim())){
				allScore += 10;
			}
		}
		return allScore;
	}
	/** 没有错题时，错题面板消失 **/
	public void setVisibleFalse(JPanel panel){
		panel.setVisible(false);
	}
	/** 错题显示 **/
	public void showProblems(){
		int j = 0;
		for(int i=0;i<5;i++){
			if(!answer[i].trim().equals(stuAnswer[i].trim())){
				panelQues[j].setVisible(true);
				textType[j].setText("选择题");
				textCount[j].setText(i+1+"");
				textYourAnswer[j].setText(stuAnswer[i]);
				textCorrectAnswer[j].setText(answer[i]);
				j++;
				}
		}
		for(int i=5;i<8;i++){
			if(!answer[i].trim().equals(stuAnswer[i].trim())){
				panelQues[j].setVisible(true);
				textType[j].setText("填空题");
				textCount[j].setText(i-4+"");
				textYourAnswer[j].setText(stuAnswer[i]);
				textCorrectAnswer[j].setText(answer[i]);
				j++;
				}
		}
	}
	
	
}
