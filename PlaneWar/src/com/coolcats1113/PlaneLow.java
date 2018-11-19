package com.coolcats1113;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

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

	public PlaneLow(int genX, int genY, int r, int speedx, int speedy, int blood, ImageIcon planeLow, JPanel gamePanel,
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
//		System.out.println("r:"+r);

	}

	public void drawPlane(Graphics g) {
		System.out.println("®‹" + x + "," + y + "," + this.obgimg);

		g.drawImage(this.obgimg.getImage(), x-r, y-r, null);
		g.setColor(Color.green);
		g.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		g.fillRect(x+r/2, y-r-2, blood*50-r/2, 10);
	}

	public void movePlane(Graphics g) {

		y = y + speedy;
		if (y-r-10 > gamePanel.getHeight()) {
			if(this!=null) {
				ArrayList<FlyingObject> sa = planeAI.get_flyObjs();
				System.out.println("planeAI.get_flyObjs()"+sa+" "+planeAI.get_flyObjs().size());
				if(planeAI.get_flyObjs()!=null) {
					planeAI.get_flyObjs().remove(this);

				}

			}
		}
	}
}
