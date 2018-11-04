package com.coolcats.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class SilverThread extends Thread{
	private Graphics g;
	private MouseEvent e;
	public SilverThread(Graphics g,MouseEvent e) {
		this.g = g;
		this.e = e;
		
	}
	public void run() {
		int x = e.getX();
		int y = e.getY();
		
		for(int i=0;i<50;i++) {
			g.setColor(new Color(i+50,i,i));
			g.fillOval(x, 800-i*12, 50, 100);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
