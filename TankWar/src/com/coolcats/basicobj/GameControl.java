package com.coolcats.basicobj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameControl implements Runnable {
	public volatile ArrayList<CoolTank> _tanks = new ArrayList<>();
	public static boolean isStop = false;
	// 图片资源数组
	public ImageIcon[] _myTankIconArr;

	public ImageIcon[] _lowTankIconArr;
	public ImageIcon[] _highTankIconArr;
	public ImageIcon[] _myBulletIconArr;
	public ImageIcon[] _enemyBulletIconArr;

	// 概率控制参数
//	private Random _ran;
	public double lowProb = 0.8f;
	public Graphics _g;
	EnemyThread _enemyThread;

	// 坦克参数设置
	public  int TANK_RADUS = 40;
	public  int BULLET_RADUS = 10;
	private MyTank _myTank;
	private JFrame frame;

	public GameControl(JFrame frame, Graphics g) {
		this._g = g;
		this.frame = frame;
		initImageResource();

		initOtherObject();
	}

	private void initOtherObject() {
		 _myTank = new MyTank(Game.GAME_WIDTH/2, Game.GAME_HEIGHT-50, this.TANK_RADUS, 5, 5, _myTankIconArr, _g);
		_enemyThread = new EnemyThread(this);
	}

	@Override
	public void run() {
		_enemyThread.start();
		BufferedImage _img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics _bfg = _img.getGraphics();
		// 游戏运行时
		while (!GameControl.isStop) {
			_bfg.setColor(Color.BLACK);

			// 绘制坦克
			for (int i = 0; i < _tanks.size(); i++) {
				if (_tanks.get(i) != null) {
					_tanks.get(i).drawGameObject(_bfg);
					_tanks.get(i).moveGameObject();
				}

			}
			_myTank.drawGameObject(_bfg);
			frame.addKeyListener(_myTank);
			_g.drawImage(_img, 0, 0, null);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			_bfg.setColor(Color.BLACK);
			_bfg.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		}
	}

	private class MyTank extends CoolTank implements KeyListener{

		public MyTank(int _x, int _y, int _r, int _speedX, int _speedY, ImageIcon[] _objIcon, Graphics g) {
			super(_x, _y, _r, _speedX, _speedY, _objIcon, g);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_DOWN:
				
				this.moveDown();
				System.out.println("下");
				//				this._y += this._speedY;
				break;
			case KeyEvent.VK_UP:
//				this._y -= this._speedY;
				System.out.println("上");

				this.moveUp();
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("右");

//				this._x += this._speedX;
				this.moveRight();
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("左");

//				this._x += this._speedX;
				this.moveLeft();
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	/**
	 * 初始化游戏图片资源
	 */
	public void initImageResource() {
		_lowTankIconArr = new ImageIcon[4];
		_highTankIconArr = new ImageIcon[4];
		_myTankIconArr = new ImageIcon[4];
		_lowTankIconArr[0] = new ImageIcon("resources\\enemy2U.gif");
		_lowTankIconArr[1] = new ImageIcon("resources\\enemy2D.gif");
		_lowTankIconArr[2] = new ImageIcon("resources\\enemy2L.gif");
		_lowTankIconArr[3] = new ImageIcon("resources\\enemy2R.gif");
		_highTankIconArr[0] = new ImageIcon("resources\\enemy3U.gif");
		_highTankIconArr[1] = new ImageIcon("resources\\enemy3D.gif");
		_highTankIconArr[2] = new ImageIcon("resources\\enemy3L.gif");
		_highTankIconArr[3] = new ImageIcon("resources\\enemy3R.gif");
		_myTankIconArr[0] = new ImageIcon("resources\\p1tankU.gif");
		_myTankIconArr[1] = new ImageIcon("resources\\p1tankD.gif");
		_myTankIconArr[2] = new ImageIcon("resources\\p1tankL.gif");
		_myTankIconArr[3] = new ImageIcon("resources\\p1tankR.gif");

//		System.out.println("初始化图片资源"+_lowTankIconArr[0].getDescription());
//		_g.drawImage(_lowTankIconArr[0].getImage(), 10, 100, 100, 100, null);
	}

}
