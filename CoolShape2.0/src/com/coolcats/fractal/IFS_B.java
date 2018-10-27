package com.coolcats.fractal;

import java.awt.Color;
import java.awt.Graphics;

public class IFS_B extends Fractal {
	public IFS_B() {
		this._type = IFS_B;
		this.delta_x = 0;
		this.delta_y = 0;
	}

	public IFS_B(int x0, int y0) {
		this();
		this.delta_x = x0;
		this.delta_y = y0;
	}

	public IFS_B(int a, int b, int c, int d) {
		this();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public void drawIFS_B(Graphics g) {
//		double x = 0f;
//		double y = 0f;
		double x = this.x0;
		double y = this.y0;
		for (int i = 0; i < 25400; i++) {
			double temx = Math.sin(a * y) + b * Math.cos(x);
			double temy = Math.sin(c * x) + Math.cos(d * y);
			int x1 = (int) (temx * 130 + 500);
			int y1 = (int) (temy * 130 + 400);
//			System.out.println(new Point(x1, y1));
			g.setColor(new Color(255 - i / 100, 255 - i / 100, i / 100));
			g.drawLine(x1 + this.delta_x, y1 + this.delta_y, x1 + this.delta_x, y1 + this.delta_y);
			x = temx;
			y = temy;
		}
	}

	public String toString() {
		return "µü´ú·ÖÐÎB";
	}
}
