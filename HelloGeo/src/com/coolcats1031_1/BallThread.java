package com.coolcats1031_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

public class BallThread extends MouseAdapter implements Runnable {

	private volatile ArrayList<Ball> _balls = new ArrayList<>();
	private JFrame _frame;
	private Color bgColor;
	private Graphics g;

	public BallThread(JFrame frame, Graphics g) {
		this._frame = frame;
		bgColor = this._frame.getBackground();
		this.g = g;
	}

	@Override
	public void run() {
//		System.out.println("按下");

		while (true) {
			if (_balls != null) {
//				System.out.println("動啊"+_balls.size());

				for (int i = 0; i < _balls.size(); i++) {
//					if (_balls.get(i) != null) {
//					System.out.println("下" + g);

					_balls.get(i).MoveBall(g, bgColor);

//					}
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("新建球球" + _frame);
		Color color = new Color(e.getX() % 255, e.getY() % 255, e.getX() % 255);
		Random ran = new Random();
		int speedx = ran.nextInt(10) + 50;
		int speedy = ran.nextInt(20) + 40;
		Ball ball = new Ball(e.getX(), e.getY(), speedx, speedy, color);
		ball.r = ran.nextInt(5)+20;
		_balls.add(ball);
	}

}
