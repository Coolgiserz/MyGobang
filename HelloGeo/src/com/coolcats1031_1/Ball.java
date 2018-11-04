package com.coolcats1031_1;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public int x, y;
	public int speedx, speedy;
	public int direction;
	public Color color;
	public int r;

	public Ball() {

	}

	public Ball(int x, int y, int speedX, int speedY, Color color) {
		this.x = x;
		this.y = y;
		this.speedx = speedX;
		this.speedy = speedY;
		this.color = color;

	}

	public void MoveBall(Graphics g, Color defau) {
//		System.out.println("move"+g.getColor());

		g.setColor(color);
		x = x + speedx;
		y = y + speedy;
		if (x+r <= 0 || x-r > 800) {
			speedx = -speedx;
		}
		if (y+r <= 0 || y-r > 800) {
			speedy = -speedy;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.fillOval(x, y, r, r);

		g.setColor(defau);
//		g.fillOval(0, 0, 800,800);

		g.fillOval(x - speedx, y - speedy, r, r);

	}
}
