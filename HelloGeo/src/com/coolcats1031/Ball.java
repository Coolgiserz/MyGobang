package com.coolcats1031;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	public int x, y;
	public int r;
	public int speedX, speedY;
	public int direction;
	public Color color;
	private MainThread _frame;

	public Ball() {

	}

	public Ball(int x, int y, int speedx, int speedy) {
		this.x = x;
		this.y = y;
		this.speedX = speedx;
		this.speedY = speedy;
		this.direction = 1;
		Random ran = new Random();

		this.r = ran.nextInt(20) + 40;

	}

	public Ball(int x, int y, int speedx, int speedy, Color color) {
		this(x, y, speedx, speedy);
		this.color = color;

	}

	public void getFrame(MainThread thread) {
		this._frame = thread;
	}

	public void MoveBall(Graphics g) {
		g.setColor(color);
		this.x = this.x + direction * speedX;
		this.y = this.y + direction * speedY;
//		System.out.println("move");
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.fillOval(this.x, this.y, this.r, this.r);
		if (x < 0 || x > _frame.getWidth()) {
//			direction = -direction;
			speedX = -speedX;
		}
		if (y < 0 || y > _frame.getHeight()) {
//			direction = -direction;
			speedY = -speedY;
		}
	}

	public void clearBall(Graphics g) {
		g.setColor(_frame.getBackground());
		int tmpx = this.x - direction * speedX;
		int tmpy = this.y - direction * speedY;
		g.fillOval(tmpx, tmpy, r, r);
	}
}
