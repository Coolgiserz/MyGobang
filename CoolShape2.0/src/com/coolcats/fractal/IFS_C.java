package com.coolcats.fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class IFS_C extends Fractal {
	public IFS_C() {
		this._type = IFS_C;
		delta_x = 0;
		delta_y = 0;
		this.a = 1;
		this.b = 4;
		this.c = 60;
	}

	public IFS_C(int delx, int dely) {
		this();
		this.a = 1;
		this.b = 4;
		this.c = 60;

		this.delta_x = delx;
		this.delta_y = dely;
	}

	public IFS_C(double x0,double y0,int delx, int dely) {
		this();
		this.a = 1;
		this.b = 4;
		this.c = 60;

		this.delta_x = delx;
		this.delta_y = dely;
		this.x0 = x0;
		this.y0 = y0;
	}


	public void setPram(double a,double b,double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void drawIFS_C(Graphics g) {
//		double x = 1.2f;//0.5¡¢0.8
//		double y = 1.2f;
		double x = this.x0;
		double y = this.y0;
//		System.out.println(x+","+y);
		for (int i = 0; i < 25500; i++) {
			double temx = y - Math.signum(x)*Math.sqrt(Math.abs(b*x-c));
			double temy = a - x;
			int x1 = (int) (temx  + 500);
			int y1 = (int) (temy  + 500);
//			System.out.println(temx + "," + temy);

			// System.out.println(new Point(x1, y1));
			g.setColor(new Color(i/100, 255 - i / 100, i / 100));
			g.drawLine(x1+this.delta_x, y1+this.delta_y, x1+this.delta_x, y1+this.delta_y);
			x = temx;
			y = temy;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String toString() {
		return "µü´ú·ÖÐÎC";
	}
}
