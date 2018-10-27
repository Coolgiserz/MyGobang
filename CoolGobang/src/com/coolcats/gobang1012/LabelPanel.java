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
		vsLabel.setText("��ǰ��սģʽ��"+mode);
		roundLabel.setText("��ǰ�غ�:"+round);
		turnLabel.setText("�������ӷ���"+side);
//		P2LAB = new JLabel("�׷�");
	}
	public void setStatusLabel(String mode,String AI,int round,String side) {
		vsLabel.setText("��ǰ��սģʽ��"+mode);
		aiLabel.setText("��ǰ��սģʽ��"+AI);

		roundLabel.setText("��ǰ�غ�:"+round);
		turnLabel.setText("�������ӷ���"+side);
//		P2LAB = new JLabel("�׷�");
	}
	
	public void initUI() {
		this.setPreferredSize(new Dimension(200, 1000));
//		this.setBackground(Color.GREEN);
		btn1 = new JButton("��ʼ����Ϸ");
		btn2 = new JButton("����");
		rabtn1 = new JRadioButton("���˶�ս");
		rabtn2 = new JRadioButton("�˻���ս");
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
//		System.out.println("LabelPabel's chesspanel����:"+this._chesspanel);
	}
}
