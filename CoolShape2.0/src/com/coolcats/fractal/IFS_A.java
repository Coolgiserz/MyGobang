package com.coolcats.fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class IFS_A extends Fractal {

	public IFS_A() {
		this._type = IFS_A;
	}

	public IFS_A(int x0, int y0) {
		this._type = IFS_A;
		this.delta_x = x0;
		this.delta_x = y0;
	}

	public IFS_A(int a, int b, int c, int d) {
		this();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public void drawIFS_A(Graphics g) {
		double x = 0f;
		double y = 0f;
//		double x = this.x0;
//		double y = this.y0;
		for (int i = 0; i < 25500; i++) {
			double temx = Math.sin(a * y) + c * Math.cos(a * x);
			double temy = Math.sin(b * x) + d * Math.cos(b * y);
			int x1 = (int) (temx * 130 + 500);
			int y1 = (int) (temy * 130 + 400);
//			System.out.println(new Point(x1, y1));
			g.setColor(new Color(0, i/100, i / 100));
			g.drawLine(x1+this.delta_x, y1+this.delta_y, x1+this.delta_x, y1+this.delta_y);
			x = temx;
			y = temy;
		}
	}

	public String toString() {
		return "µü´ú·ÖÐÎA";
	}
}
