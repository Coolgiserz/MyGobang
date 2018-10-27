package com.coolcats.fractal;

import java.awt.Color;
import java.awt.Graphics;

public class MapleLeaf extends Fractal {
	public MapleLeaf() {
		this._type = MAPLELEAF;
		this.a = 0.54;
		this.b = 0.5;
		this.c = 0.9;
		this.d = 0.51;
		this.e = -0.58;
		this.f = -1.31;
	}

	public MapleLeaf(double a, double b, double c, double d, double e, double f) {
		this();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;

	}
	
	public void setPram(double x0,double y0,int delx, int dely) {
		this.x0 = x0;
		this.y0 = y0;
		this.delta_x = delx;
		this.delta_y = dely;
	}
	
	
	public void drawMapleleaf(Graphics g) {
		double x = this.x0;
		double y = this.y0;
		for (int i = 0; i < 25500; i++) {
			double temx = a*x+b*y+e;
			double temy = c*x+d*y+f;
			int x1 = (int) (temx*100  + 1200);
			int y1 = (int) (temy*100  + 1200);
			System.out.println(temx + "," + temy);

			// System.out.println(new Point(x1, y1));
			g.setColor(new Color(i/100, 255 - i / 100, i / 100));
			g.drawLine(x1+this.delta_x, y1+this.delta_y, x1+this.delta_x, y1+this.delta_y);
			x = temx;
			y = temy;
		}
		
	}
}
