package com.coolcats1104_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class BallThread extends MouseAdapter implements Runnable {

	private MainControl _frame;
	private  ArrayList<Ball> _balls = new ArrayList<>();
	public BallThread(MainControl frame) {
		this._frame = frame;
	}

	/**
	 * 鼠标按下，新建一小球，随机确定小球半径、颜色、速度
	 */
	public void mousePressed(MouseEvent e) {
		System.out.println("新建球球："+_balls.size());

		int x = e.getX();
		int y = e.getY();
		Random ran = new Random();
		int r = ran.nextInt(10) + 20;

		int speedx = ran.nextInt(10) + 5;
		int speedy = ran.nextInt(10) + 5;
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		Ball ball = new Ball(x, y, r, speedx, speedy, color, _frame);
		_balls.add(ball);
		
	}
	private BufferedImage bfimg;
	private Graphics bfg;
	public void run() {
		Graphics g = _frame.getGraphics();

//		System.out.println("666"+g);
		while(true) {
			bfimg = new BufferedImage(_frame.getWidth(), _frame.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
			bfg = bfimg.getGraphics();
			bfg.setColor(_frame.getContentPane().getBackground());
			bfg.fillRect(0, 0, _frame.getWidth(), _frame.getHeight());
		
			if(_balls!=null) {
//				System.out.println("666"+_balls.size());

				for(int i=0;i<_balls.size();i++) {
					Ball ball = _balls.get(i);
					ball.drawBall(bfg);
//					ball.crash(_balls);
					ball.crash1(_balls);

				}
				g.drawImage(bfimg, 0, 0, _frame);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
