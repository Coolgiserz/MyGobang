package com.coolcats1107_1;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	public MainControl canvas;
	private Ball father;
	protected int x, y, r, speedX, speedY;
	private Color color;

	public Bullet(Ball father) {
		this.x = father.x;
		this.y = father.y +200;
		this.color = father.color;
		this.speedX = 0;
		this.speedY = father.speedY + 100;
		this.r = father.r / 2;
		this.canvas = father.canvas;
		this.father = father;
	}

	public void drawBullet(Graphics g) {
//		System.out.println("绘制小球");

		g.setColor(Color.RED);
		g.fillOval(x - r, y - r, 2 * r, 2 * r);
		moveBullet();
		updateSpeed(20);
	}

	public void updateSpeed(int delta) {
		speedY = speedY + delta;
	}
	public void moveBullet() {
//		System.out.println("子弹移动中");
		if (y - r < 5 || y + r > canvas.getHeight()) {
//			speedY *= -1;
			this.r = 0;
			return;
		}
		y = y + 2*speedY;
		
	}
}
