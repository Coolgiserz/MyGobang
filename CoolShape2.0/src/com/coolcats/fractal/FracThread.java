package com.coolcats.fractal;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import com.coolcats.ui.ControlPanel;

public class FracThread extends Thread {
	private Graphics g;
	private MouseEvent e;
	private ControlPanel control;
	private double x0 = 1.0f, y0 = 1.0f;

	public FracThread(ControlPanel control, Graphics g, MouseEvent e) {
		this.g = g;
		this.e = e;
		this.control = control;
	}

	public FracThread() {

	}

	public void setInitValue(double x0, double y0) {
		this.x0 = x0;
		this.y0 = y0;
	}

	public void run() {
		switch (this.control._frac) {
		case Fractal.IFS_A:
			break;
		case Fractal.IFS_B:
			break;
		case Fractal.IFS_C:
			IFS_C ifsc = new IFS_C(x0, y0, e.getX() - 500, e.getY() - 500);
			ifsc.drawIFS_C(g);
			break;
		case Fractal.IFS_D:
			break;
		case Fractal.KOCH:
			break;
		case Fractal.SIERPINSKITri:
			RecursionFrac re = new RecursionFrac();
			int centx = e.getX();
			int centy = e.getY();
			int r = 200;
			int[] xpoints = new int[3];
			int[] ypoints = new int[3];
			xpoints[0] = centx;
			ypoints[0] = centy - r;
			xpoints[1] = ((int) ((centx - Math.cos(Math.toRadians(30)) * r) * 100)) / 100;
			ypoints[1] = ((int) ((centy + Math.sin(Math.toRadians(30)) * r) * 100)) / 100;
			xpoints[2] = ((int) ((centx + Math.cos(Math.toRadians(30)) * r) * 100)) / 100;
			ypoints[2] = ((int) ((centy + Math.sin(Math.toRadians(30)) * r) * 100)) / 100;
			Point p1 = new Point(xpoints[0], ypoints[0]);
			Point p2 = new Point(xpoints[1], ypoints[1]);
			Point p3 = new Point(xpoints[2], ypoints[2]);
			g.fillPolygon(xpoints, ypoints, 3);
//			Point tp1 = new Point((p1.x+p3.x)/2,(p1.y+p3.y)/2);
//			Point tp2 = new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
//			Point tp3 = new Point((p2.x+p3.x)/2,(p2.y+p3.y)/2);
			this.g.setColor(control._color);
//
//			create.fillTriangle(_g, tp1, tp2, tp3);
			re.drawSierpinskiTri(g, p1, p2, p3, 0, 6);

//			create.drawSierpinski(_g, p1, p2,p3,tp1,tp2,tp3, 4);
			break;
		case Fractal.SIERPINSKIRec:
			break;
		}
	}
}
