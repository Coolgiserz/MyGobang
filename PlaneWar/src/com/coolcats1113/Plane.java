package com.coolcats1113;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Plane extends FlyingObject {
	protected int _planeType;
	protected final static int Plane_low = 1;
	protected final static int Plane_mid = 5;
	protected final static int Plane_high = 10;
	protected JPanel gamePanel;
	protected PlaneAI planeAI;

	public Plane() {

	}

	public Plane(int x, int y, int r, int speedx, int speedy, int blood, ImageIcon obgimg, JPanel gamePanel,
			PlaneAI planeAI) {
		super();
		this.TYPE = PLANE;
		this.gamePanel = gamePanel;
		this.planeAI = planeAI;
	}

	public void drawPlane(Graphics g) {
//		System.out.println("®‹"+x+","+y+","+this.obgimg  );

		g.drawImage(this.obgimg.getImage(), x, y, null);
		g.setColor(Color.green);
		g.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		g.fillRect(x-2*r, y-2*r, blood, 20);
	}

	public void movePlane(Graphics g) {

		y = y + speedy;
		if (y > gamePanel.getHeight()) {
			planeAI.get_flyObjs().remove(this);
		}
	}

	public int getPlane_low() {
		return Plane_low;
	}

	public int getPlane_mid() {
		return Plane_mid;
	}

	public int getPlane_high() {
		return Plane_high;
	}

//	public int getBullet_low() {
//		return Bullet_low;
//	}
}
