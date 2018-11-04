package com.coolcats.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Random;

public class BallThread extends Thread {
	private Graphics g;
	private MouseEvent e;
	TestFrame frame;

	public BallThread(Graphics g, MouseEvent e) {
		this.g = g;
		this.e = e;

	}

	public BallThread(Graphics g) {
		this.g = g;

	}

	public BallThread(Graphics g, TestFrame frame) {
		this.g = g;
		this.frame = frame;
	}

	public void run() {

		Random ran = new Random();

		int x = ran.nextInt(800) + 100;
		int y = ran.nextInt(800) + 100;

		for (int j = 0; j < 50; j++) {

			g.setColor(new Color(255 - j, 255 - j * 4, j * 4 + 4));

			g.fillOval(x, y, 20, 20);
//					frame.repaint();
//					i = i+10;
			try {
				Thread.sleep((long) (200 + Math.random() * 50));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//					g.setColor(Color.BLACK);
//					g.fillOval(x, i-10, 50, 50);

		}

	}
}
