package com.coolcats.gobang1012;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoolFrame extends JFrame {

	public LabelPanel panel;
	public ChessPanel chesscanvas;
	CanvasListener lis2;

	public CoolFrame() {
		super();
		initUI();
	}

	public void setCanvasListener() {
		// ����ʼ��Ϸ�İ�ť������󣬲Ŵ��������¼���������󣬲�Ϊ������Ӽ���
		lis2 = new CanvasListener();
		lis2.setBuddy(chesscanvas);
		lis2.setBuddy(this);
		lis2.setBuddy(panel);
		panel.lis1.setCanvasLis(lis2);

		chesscanvas.addMouseListener(lis2);

	}

	public void initUI() {
		this.setSize(1200, 1000);
		this.setTitle("Cool������");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.setDefaultCloseOperation(3);
		// ���������廭��������Ӽ���
		chesscanvas = new ChessPanel();
		this.add(chesscanvas, BorderLayout.CENTER);

		// ����״̬������
		panel = new LabelPanel(this);
		this.add(panel, BorderLayout.WEST);
		System.out.println("chesscanvas:"+chesscanvas);

		panel.setBuddy(chesscanvas);
//panel.addActionListener(lis1);
	
		this.setVisible(true);
		// ��ϵͳ���Ƴ�������ٻ�ȡ���ʣ���Ϊ��ʱ�Ļ��ʶ���Ų�Ϊ��
		Graphics g = chesscanvas.getGraphics();
		System.out.println("���P2��" + g);
		chesscanvas.get_Graphics(g);
		System.out.println(getPreferredSize());

	}
}
