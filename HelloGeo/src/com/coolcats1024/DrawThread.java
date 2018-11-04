package com.coolcats1024;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawThread extends Thread {
	private Graphics g;

	public DrawThread(Graphics g, ActionEvent e) {
		this.g = g;
	}

//	public void run() {
//
//		Random ran = new Random();
//
//		int x = ran.nextInt(800);
//		int y = ran.nextInt(700)+100;
//		for (int i = 0; i < 255; i++) {
//			this.g.setColor(new Color(255, 255-i, i));
//			this.g.fillArc(x-i/2, y-i/2, 100+i, 100+i, 0, i * 6);
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
//	public void run() {
//		System.out.println("xxx");
//
//		Random ran = new Random();
//
////		int x = ran.nextInt(800);
////		int y = ran.nextInt(700)+100;
//		for (int i = 0; i < 50; i++) {
//			this.g.setColor(new Color(255-5*i, 255-5*i, 255-5*i));
//			this.g.fillOval(300, 300, 500-10*i, 500-10*i);
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
//	public void run() {
//
//		Random ran = new Random();
//
//	
//		for (int i = 0; i < 255; i++) {
//			this.g.setColor(new Color(255, i, i));
//			this.g.fillOval(400, 400, 100+i, 100+i);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
