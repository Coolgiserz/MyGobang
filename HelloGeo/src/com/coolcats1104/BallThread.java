package com.coolcats1104;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class BallThread extends MouseAdapter implements Runnable {

	private MainControl _frame;
	private  ArrayList<Ball> _balls = new ArrayList<>();
	public BallThread(MainControl frame) {
		this._frame = frame;
	}

	/**
	 * ��갴�£��½�һС�����ȷ��С��뾶����ɫ���ٶ�
	 */
	public void mousePressed(MouseEvent e) {
		System.out.println("�½�����"+_balls.size());

		int x = e.getX();
		int y = e.getY();
		Random ran = new Random();
		int r = ran.nextInt(10) + 40;

		int speedx = ran.nextInt(10) + 5;
		int speedy = ran.nextInt(10) + 5;
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		Ball ball = new Ball(x, y, r, speedx, speedy, color, _frame);
		_balls.add(ball);
		
	}

	public void run() {
		Graphics g = _frame.getGraphics();
		System.out.println("666"+g);
		while(true) {
			g.setColor(_frame.getContentPane().getBackground());
			g.fillRect(0, 0, _frame.getWidth(), _frame.getHeight());
			if(_balls!=null) {
//				System.out.println("666"+_balls.size());

				for(int i=0;i<_balls.size();i++) {
					Ball ball = _balls.get(i);
					ball.drawBall(g);
					ball.crash(_balls);

				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
