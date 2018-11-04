package com.coolcats1031_1;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Cartoo {
	Graphics g;
	JFrame frame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cartoo car = new Cartoo();
		car.initUI();
		car.setListener();
	}

	public void initUI() {
		frame = new JFrame("多线程动画");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		g = frame.getGraphics();
	}

	public void setListener() {
		BallThread lis = new BallThread(frame,g);
		frame.addMouseListener(lis);
		Thread th = new Thread(lis);
//		th.run();
		th.start();

	}

}
