package com.coolcats1104;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ball {
	private int x, y, r, speedX, speedY;
	private Color color;
	private MainControl canvas;

	public Ball(int x, int y, int r, int speedX, int speedY, Color color, MainControl canvas) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.speedX = speedX;
		this.speedY = speedY;
		this.color = color;
		this.canvas = canvas;
	}

	public void drawBall(Graphics g) {
//		System.out.println("������"+r+","+color);
		g.setColor(color);
		g.fillOval(x - r, y - r, 2 * r, 2 * r);
		moveBall();
	}

	public void moveBall() {
//		System.out.println("������");

		if (x - r < 5 || x + r > canvas.getWidth()) {
			speedX *= -1;
		}
		if (y - r < 5 || y + r > canvas.getHeight()) {
			speedY *= -1;
		}
		x = x + speedX;
		y = y + speedY;

	}

	/**
	 * �ж���ײ
	 * 
	 * @param list
	 */
	public void crash(ArrayList<Ball> list) {
		for (int i = 0; i < list.size(); i++) {
			Ball ball = list.get(i);
			if (ball != this) {
				double distance = Math.sqrt((x - ball.x) * (x - ball.x) + (y - ball.y) * (y - ball.y));
				if (distance < r + ball.r) {// ��ײ����
					int tmp_sx = ball.speedX;
					int tmp_sy = ball.speedY;
					ball.speedX = speedX;
					ball.speedY = speedY;
					speedX = tmp_sx;
					speedY = tmp_sy;
				}
			}

		}
	}
}
