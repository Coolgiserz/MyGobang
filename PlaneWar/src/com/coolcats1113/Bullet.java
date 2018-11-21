package com.coolcats1113;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bullet extends FlyingObject{
	protected int attack = 1;
	protected JPanel gamePanel;
	private PlaneAI planeAI;
	public Bullet() {
		this.TYPE = FlyingObject.BULLET;
		
	}
	public Bullet(int x, int y, int r, int speedx, int speedy, ImageIcon obgimg,JPanel gamePanel,PlaneAI planeAI) {
		this();
		this.x = x;
		this.y = y;
		this.r = r;
		this.speedx = speedx;
		this.speedy = speedy;
		this.obgimg = obgimg;
		this.gamePanel = gamePanel;
		this.planeAI = planeAI;
	}
	
	public void drawBullet(Graphics g) {
		g.drawImage(this.obgimg.getImage(), x-r, y-r, null);
//		g.setColor(Color.green);
	}
	
	public void moveBullet(Graphics g) {
		y = y + speedy;
		if (y > gamePanel.getHeight()) {
			planeAI.get_flyObjs().remove(this);

		}
	}
}
