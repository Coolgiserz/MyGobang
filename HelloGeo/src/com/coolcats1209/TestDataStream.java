package com.coolcats1209;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuBar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class TestDataStream extends JFrame {

	JMenuItem openItem;
	JMenuItem saveItem;

	JTextField textName;
	JComboBox<Character> cbSex;
	JComboBox<Integer> cbAge;
	JTextField textScore;

	public static void main(String[] args) {
		TestDataStream main = new TestDataStream();
		main.initUI();
	}

	private void setListener() {
		DataListener lis = new DataListener(this,textName, cbSex, cbAge, textScore);
		openItem.addActionListener(lis);
		saveItem.addActionListener(lis);
	}

	public void initUI() {
		this.setTitle("����������");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(3);

		// �˵�
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("�ļ�");
		openItem = new JMenuItem("��");
		saveItem = new JMenuItem("����");
		menu.add(openItem);
		menu.add(saveItem);
		bar.add(menu);
		this.setJMenuBar(bar);
//		bar.add(menu);

		// ���ñ��ؼ�
		JLabel labelName = new JLabel("����");
		labelName.setPreferredSize(new Dimension(50, 30));
		textName = new JTextField();
		textName.setPreferredSize(new Dimension(320, 30));
		this.add(labelName);
		this.add(textName);

		JLabel labelSex = new JLabel("�Ա�");
		labelSex.setPreferredSize(new Dimension(50, 30));
		Character[] chs = { '��', 'Ů' };
		cbSex = new JComboBox<>(chs);
		cbSex.setPreferredSize(new Dimension(320, 30));
		this.add(labelSex);
		this.add(cbSex);

		JLabel labelAge = new JLabel("����");
		labelAge.setPreferredSize(new Dimension(50, 30));
		Integer[] ags = { 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		cbAge = new JComboBox<>(ags);
		cbAge.setPreferredSize(new Dimension(320, 30));
		this.add(labelAge);
		this.add(cbAge);

		JLabel labelScore = new JLabel("����");
		labelScore.setPreferredSize(new Dimension(50, 30));
		textScore = new JTextField();
		textScore.setPreferredSize(new Dimension(320, 30));
		this.add(labelScore);
		this.add(textScore);
		// Ϊ�˵������ü���
		setListener();
		
		this.setVisible(true);
	}
}
