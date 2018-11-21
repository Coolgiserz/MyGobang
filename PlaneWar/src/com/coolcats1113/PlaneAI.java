package com.coolcats1113;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlaneAI extends Thread {

	private JPanel gamePanel;
	private int bgx, bgy, bgspeed;
	private boolean isStart = true, isPause = false;
	private static  ArrayList<FlyingObject> _flyObjs;
	private static  ArrayList<Bullet> _bullets;

	private ImageIcon planeLow, planeMid, planeHigh;
	private int genX, genY;
	private ImageIcon bgImg;
	private int bgys;

	public PlaneAI(JPanel gamePanel, ImageIcon bgImg) {
		this.gamePanel = gamePanel;
		this.bgImg = bgImg;
		_flyObjs = new ArrayList<>();
	}

	public PlaneAI(JPanel gamePanel) {
		this.gamePanel = gamePanel;

		_flyObjs = new ArrayList<>();

	}

	/**
	 * 飛機AI綫程
	 */
	public void run() {
		BufferedImage bfImg = new BufferedImage(gamePanel.getWidth(), gamePanel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics bfg = bfImg.getGraphics();	//畫布畫筆
		Random rand = new Random();			//隨機數對象，用於控制敵機生成概率
		Graphics g = gamePanel.getGraphics();//游戲面板畫筆
		//飛機圖片資源
		planeMid = new ImageIcon("midpimg.png");
		planeHigh = new ImageIcon("highpimg.png");
		genY = 0;
//		int speedx = rand.nextInt(bound)

		int deltay = (bgImg.getIconHeight() - gamePanel.getHeight());
		while (isStart) {
			if (!isPause) {

				bfg.drawImage(bgImg.getImage(), 0, bgys - deltay, null);
				bgys++;

				// 自動產生敵機和子彈
				genX = rand.nextInt(gamePanel.getWidth());
				if (Math.random() > 0.98) {
//					System.out.println("大飛機生成！");
				} else if (Math.random() > 0.90) {
//					System.out.println("小飛機生成！");
					int speedy = rand.nextInt(10)+5;
					ImageIcon planeLow = new ImageIcon("lowpimg.png");
					

					System.out.println("小飛機生成！" + planeLow);

					PlaneLow low = new PlaneLow(genX, genY, 30, 0, speedy, 1, planeLow, gamePanel, this);
					_flyObjs.add(low);
					Bullet bul1 = new Bullet(genX, genY, 10, 5, 2*speedy, new ImageIcon("downbullet.png"), gamePanel,this);
					Bullet bul2 = new Bullet(genX, genY, 10, 0, 2*speedy, new ImageIcon("downbullet.png"), gamePanel,this);
					Bullet bul3 = new Bullet(genX, genY, 10, -5, 2*speedy, new ImageIcon("downbullet.png"), gamePanel,this);
					_flyObjs.add(bul1);
					_flyObjs.add(bul2);
					_flyObjs.add(bul3);
				} else {
//					System.out.println("中飛機生成！！");

				}
//				System.out.println("飛機數量"+_flyObjs.size()+","+_flyObjs.get(_flyObjs.size()-1).getTYPE());
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < _flyObjs.size(); i++) {
//					FlyingObject flyobg = _flyObjs.get(i);
					if (_flyObjs.get(i).TYPE == FlyingObject.PLANE) {
						Plane flyobg = (Plane) _flyObjs.get(i);
						if (flyobg._planeType == Plane.Plane_low) {
							PlaneLow flylow = (PlaneLow) _flyObjs.get(i);
							System.out.println("小飛機" + planeLow + "," + flylow.obgimg);
							flylow.drawPlane(bfg);
							flylow.movePlane(bfg);
						}

					} else if(_flyObjs.get(i).TYPE == FlyingObject.BULLET){
						Bullet flyobg = (Bullet) _flyObjs.get(i);
							System.out.println("小飛機" + planeLow + "," + flyobg.obgimg);
							flyobg.drawBullet(bfg);
							flyobg.moveBullet(bfg);
						
					}
				}
			
				bfg.setColor(Color.white);
				g.drawImage(bfImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
//				bfg.fillRect(0, 0,gamePanel.getWidth(), gamePanel.getHeight());

			}
		}
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public static ArrayList<FlyingObject> get_flyObjs() {
		return _flyObjs;
	}

	public void set_flyObjs(ArrayList<FlyingObject> _flyObjs) {
		this._flyObjs = _flyObjs;
	}

	public static ArrayList<Bullet> get_bullets() {
		return _bullets;
	}

	public static void set_bullets(ArrayList<Bullet> _bullets) {
		PlaneAI._bullets = _bullets;
	}

}
