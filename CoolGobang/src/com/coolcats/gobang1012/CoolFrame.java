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
		// 当开始游戏的按钮被点击后，才创建画布事件处理类对象，并为画布添加监听
		lis2 = new CanvasListener();
		lis2.setBuddy(chesscanvas);
		lis2.setBuddy(this);
		lis2.setBuddy(panel);
		panel.lis1.setCanvasLis(lis2);

		chesscanvas.addMouseListener(lis2);

	}

	public void initUI() {
		this.setSize(1200, 1000);
		this.setTitle("Cool五子棋");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		this.setDefaultCloseOperation(3);
		// 创建五子棋画布对象并添加监听
		chesscanvas = new ChessPanel();
		this.add(chesscanvas, BorderLayout.CENTER);

		// 创建状态面板对象
		panel = new LabelPanel(this);
		this.add(panel, BorderLayout.WEST);
		System.out.println("chesscanvas:"+chesscanvas);

		panel.setBuddy(chesscanvas);
//panel.addActionListener(lis1);
	
		this.setVisible(true);
		// 在系统绘制出组件后再获取画笔，因为此时的画笔对象才不为空
		Graphics g = chesscanvas.getGraphics();
		System.out.println("畫筆2：" + g);
		chesscanvas.get_Graphics(g);
		System.out.println(getPreferredSize());

	}
}
