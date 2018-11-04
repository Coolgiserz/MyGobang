package com.coolcats1104_1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ball {
	private int x, y, r, speedX, speedY;
	private Color color;
	public MainControl canvas;
//	public static Color bg;
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
//		System.out.println("画球球"+r+","+color);
		g.setColor(color);
		g.fillOval(x - r, y - r, 2 * r, 2 * r);
		moveBall();
//		if (r > 300) {
//			canvas.setBackground(color);
//		}
	}

	public void moveBall() {
//		System.out.println("动球球");

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
	 * 判断碰撞 碰撞后交换速度
	 * 
	 * @param list
	 */
	public void crash(ArrayList<Ball> list) {
		for (int i = 0; i < list.size(); i++) {
			Ball ball = list.get(i);
			if (ball != this) {
				double distance = Math.sqrt((x - ball.x) * (x - ball.x) + (y - ball.y) * (y - ball.y));
				if (distance < r + ball.r) {// 碰撞条件
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

	public void crash1(ArrayList<Ball> list) {
		if (r > 300) {
			System.out.println("动球r"+r+","+color);
			canvas.setBackground(color);
			
			list.remove(this);

		}
		for (int i = 0; i < list.size(); i++) {
			Ball ball = list.get(i);
			if (ball != this) {
				double distance = Math.sqrt((x - ball.x) * (x - ball.x) + (y - ball.y) * (y - ball.y));
				if (distance < r + ball.r) {// 碰撞条件
					if (r > ball.r) {
						r = r + ball.r / 2;
						list.remove(i);

					} else if (r < ball.r) {
						ball.r = r / 2 + ball.r;
					} else {
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
}
