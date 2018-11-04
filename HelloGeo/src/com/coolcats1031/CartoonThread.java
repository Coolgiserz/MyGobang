package com.coolcats1031;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class CartoonThread extends MouseAdapter implements Runnable {

	private MainThread _frame;
	private ArrayList<Ball> _balls = new ArrayList<>();
	private Graphics _g;
	private Thread _cartoon;
	private Ball ball;

	public CartoonThread(MainThread thread) {
		this._frame = thread;
	}

	public CartoonThread(MainThread thread, Graphics g) {
		this._frame = thread;
		this._g = g;

	}

	public void setBuddy(Thread t) {
		this._cartoon = t;
		_cartoon.run();

	}

	@Override
	public void run() {
		System.out.println("66");
	
//		this._g.drawOval(e.getX(), e.getY(), e.getX(), e.getY());

		while(true) {
			for (int i = 0; i < _balls.size(); i++) {
				_balls.get(i).MoveBall(_g);
				_g.setColor(_frame.getBackground());
				_g.fillOval(0, 1000, 1000, 1000);
//				_balls.get(i).clearBall(_g);

			}
		}
	}

	public void mouseClicked(MouseEvent e) {

		Color color = new Color(e.getX() % 255, e.getY() % 255, e.getX() % 255);
		Random ran = new Random();
		int speedX = ran.nextInt(10) + 30;
		int speedY = ran.nextInt(15) + 30;

		ball = new Ball(e.getX(), e.getY(), speedX, speedY, color);
		ball.getFrame(_frame);
		this._balls.add(ball);

		System.out.println("new"+_frame);

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
