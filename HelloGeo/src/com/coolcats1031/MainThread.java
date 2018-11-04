package com.coolcats1031;

import java.awt.Graphics;

import javax.swing.JFrame;

public class MainThread extends JFrame{

	private static Graphics g;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainThread main = new MainThread();
		main.initUI();
		CartoonThread newThread = new CartoonThread(main,g);
		Thread thre = new Thread(newThread);

		newThread.setBuddy(thre);
		main.addMouseListener(newThread);
//		thre.run();
	}

	public void initUI() {
		setTitle("Ïß³Ì¶¯»­");
		setDefaultCloseOperation(3);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setVisible(true);
		g = getGraphics();
		
	}
}
