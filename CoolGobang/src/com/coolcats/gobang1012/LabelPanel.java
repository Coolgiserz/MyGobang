package com.coolcats.gobang1012;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LabelPanel extends JPanel {
	
	public static boolean isBegin = false;
	LabelListener lis1 ;
	JRadioButton rabtn1;
	JRadioButton rabtn2;
	JButton btn1;
	JButton btn2;
	ButtonGroup group;
	JLabel vsLabel;
	JLabel aiLabel;
	JLabel roundLabel;
	JLabel turnLabel;
	CoolFrame _frame;
	ChessPanel _chesspanel;
	public LabelPanel() {
		super();
		initUI();
	
	}
	
	public LabelPanel(CoolFrame f) {
		super();
		this._frame = f;
		initUI();
		lis1.setBuddy(this);
//		System.out.println("LabelPanel's chesspanel:"+_chesspanel);
//		lis1.setBuddy(_chesspanel);
	}
	

	public void setStatusLabel(String mode,int round,String side) {
		vsLabel.setText("当前对战模式："+mode);
		roundLabel.setText("当前回合:"+round);
		turnLabel.setText("本轮落子方："+side);
//		P2LAB = new JLabel("白方");
	}
	public void setStatusLabel(String mode,String AI,int round,String side) {
		vsLabel.setText("当前对战模式："+mode);
		aiLabel.setText("当前对战模式："+AI);

		roundLabel.setText("当前回合:"+round);
		turnLabel.setText("本轮落子方："+side);
//		P2LAB = new JLabel("白方");
	}
	
	public void initUI() {
		this.setPreferredSize(new Dimension(200, 1000));
//		this.setBackground(Color.GREEN);
		btn1 = new JButton("开始新游戏");
		btn2 = new JButton("悔棋");
		rabtn1 = new JRadioButton("人人对战");
		rabtn2 = new JRadioButton("人机对战");
		btn1.setPreferredSize(new Dimension(150, 50));
		btn2.setPreferredSize(new Dimension(150, 50));
		rabtn1.setPreferredSize(new Dimension(150, 50));
		rabtn2.setPreferredSize(new Dimension(150, 50));
		rabtn1.setSelected(true);
		group = new ButtonGroup();
		
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		this.add(btn1);
		this.add(btn2);
		group.add(rabtn1);
		group.add(rabtn2);
		this.add(rabtn1);

		this.add(rabtn2);
		lis1 = new LabelListener();
//		lis1.setBuddy(this);
		lis1.setBuddy(this._frame);
		
		btn1.addActionListener(lis1);
		btn2.addActionListener(lis1);
		rabtn1.addActionListener(lis1);
//		rabtn1.addChangeListener(lis1);
		rabtn2.addActionListener(lis1);
//		rabtn2.addChangeListener(lis1);
		
		vsLabel = new JLabel();
		roundLabel = new JLabel();
		turnLabel = new JLabel();
		aiLabel = new JLabel();
		vsLabel.setPreferredSize(new Dimension(200, 80));	
		aiLabel.setPreferredSize(new Dimension(200, 80));
		roundLabel.setPreferredSize(new Dimension(200, 80));
		turnLabel.setPreferredSize(new Dimension(200, 80));

		this.add(vsLabel);
		this.add(roundLabel);
		this.add(turnLabel);
		this.add(aiLabel);


	}
	
	public void setBuddy(ChessPanel panel) {
		this._chesspanel = panel;
		lis1.setBuddy(this._chesspanel);
//		System.out.println("LabelPabel's chesspanel哈哈:"+this._chesspanel);
	}
}
