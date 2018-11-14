package com.coolcats1113;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlaneLow extends Plane {
	public PlaneLow() {
		this._planeType = Plane.Plane_low;
	}

	public PlaneLow(int genX, int genY, int r, int speedx, int speedy, int blood, ImageIcon planeLow) {
		this.TYPE = PLANE;
		this.x = genX;
		this.y = genY;
		this.r = r;
		this.speedx = speedx;
		this.speedy = speedy;
		this.blood = blood;
		this.obgimg = planeLow;
		this._planeType = Plane.Plane_low;

	}

	public PlaneLow(int genX, int genY, int i, int j, int speedy, int k, ImageIcon planeLow, JPanel gamePanel,
			PlaneAI planeAI) {
		this.TYPE = PLANE;
		this.x = genX;
		this.y = genY;
		this.r = r;
		this.speedx = speedx;
		this.speedy = speedy;
		this.blood = blood;
		this.obgimg = planeLow;
		this.gamePanel = gamePanel;
		this._planeType = Plane.Plane_low;

	}

	public void drawPlane(Graphics g) {
		System.out.println("®‹" + x + "," + y + "," + this.obgimg);

		g.drawImage(this.obgimg.getImage(), x, y, null);

	}

	public void movePlane(Graphics g) {

		y = y + speedy;
//		if (y > gamePanel.getHeight()) {
//			planeAI.get_flyObjs().remove(this);
//		}
	}
}
