package com.coolcats.fractal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import com.coolcats.ui.ControlPanel;

public class RecursionFrac extends Fractal implements Runnable {
	private ControlPanel control;
	private MouseEvent e;
	Graphics g;

	public RecursionFrac(ControlPanel control, MouseEvent e, Graphics g) {
		this(control);
		this.e = e;
		this.g = g;
	}

	public RecursionFrac(ControlPanel control) {
		this();
		this.control = control;

	}

	public RecursionFrac() {

	}

	/**
	 * 递归绘制谢尔宾斯基三角形
	 * 
	 * @param g 画笔对象
	 * @param n 递归次数
	 */
	public void drawSierpinski(Graphics g, Point p1, Point p2, Point p3, Point tp1, Point tp2, Point tp3, int n) {

		if (n == 1) {
			return;
		} else {
//			g.drawPolygon(xpoints, ypoints, 3);

			int[] x1points = new int[3];
			int[] y1points = new int[3];
//			x1points[0] = (xpoints[0] + xpoints[1]) / 2;
//			x1points[1] = (xpoints[0] + xpoints[2]) / 2;
//			x1points[2] = (xpoints[1] + xpoints[2]) / 2;
//
//			y1points[0] = (ypoints[0] + ypoints[1]) / 2;
//			y1points[1] = (ypoints[0] + ypoints[2]) / 2;
//			y1points[2] = (ypoints[1] + ypoints[2]) / 2;
//
////			g.fillPolygon(x1points, y1points, 3);
//			xpoints[1] = (xpoints[0] + x1points[1]) / 2;;
//			xpoints[0] = (xpoints[0] + x1points[0]) / 2;
//			xpoints[2] = (x1points[2] + x1points[1]) / 2;
//			ypoints[1] = (ypoints[0] + y1points[0]) / 2;;
//
//			ypoints[0] = (y1points[0] + y1points[1]) / 2;
//			ypoints[2] = (ypoints[2] + y1points[1]) / 2;

//			ypoints = y1points;
//			drawSierpinski(g, p1,tp2,tp1 ypoints, n - 1);
//			drawSierpinski(g, xpoints, ypoints, n - 1);
//			drawSierpinski(g, xpoints, ypoints, n - 1);

		}

	}

	/**
	 * 
	 * @param g  畫筆對象
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param c
	 * @param n
	 */
	public void drawSierpinskiTri(Graphics g, Point p1, Point p2, Point p3, int c, int n) {

		if (c == n) {
			return;
		} else {

			Point tp1 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);
			Point tp2 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
			Point tp3 = new Point((p2.x + p3.x) / 2, (p2.y + p3.y) / 2);
//			g.setColor(new Color(255,255-c,255-c*10));
			fillTriangle(g, tp1, tp2, tp3);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 類似中序遍歷
			drawSierpinskiTri(g, p1, tp2, tp1, c, n - 1);
			drawSierpinskiTri(g, tp2, p2, tp3, c, n - 1);
			drawSierpinskiTri(g, tp1, tp3, p3, c, n - 1);
			c++;

		}
	}

	/**
	 * 給定三個頂點，畫出三角形
	 * 
	 * @param g
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public void fillTriangle(Graphics g, Point p1, Point p2, Point p3) {
		int[] xpoints = new int[3];
		int[] ypoints = new int[3];
		xpoints[0] = p1.x;
		ypoints[0] = p1.y;
		xpoints[1] = p2.x;
		ypoints[1] = p2.y;
		xpoints[2] = p3.x;
		ypoints[2] = p3.y;
		g.fillPolygon(xpoints, ypoints, 3);
	}

//	public void drawSierpinskiRec(Graphics g, Point p1, Point p2, Point p3, Point p4, int c, int n) {
//		if (c == n) {
//			return;
//		} else {
//
//			Point tp1 = new Point((p1.x * 2 / 3 + p2.x * 1 / 3), (p1.y * 2 / 3 + p4.y * 1 / 3));
//			Point tp2 = new Point((p1.x * 1 / 3 + p2.x * 2 / 3), (p2.y * 2 / 3 + p3.y * 1 / 3));
//			Point tp3 = new Point((p3.x * 2 / 3 + p1.x * 1 / 3), (p2.y * 1 / 3 + p3.y * 2 / 3));
//			Point tp4 = new Point((p4.x * 2 / 3 + p3.x * 1 / 3), (p1.y * 1 / 3 + p4.y * 2 / 3));
//
////			g.setColor(new Color(255,255-c,255-c*10));
//			fillRectangle(g, tp1, tp2, tp3, tp4);
//			// 類似中序遍歷
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//			drawSierpinskiRec(g, tp1, tp2, tp3, tp4, c, n - 1);
//
//			c++;
//		}
//
//	}
	public void drawSierpinskiRec(Graphics g, Point p1, Point p3, int c, int n) {
		if (c == n) {
			return;
		} else {
			Point p2 = new Point(p3.x, p1.y);
			Point p4 = new Point(p1.x, p3.y);

			Point tp1 = new Point((p1.x * 2 / 3 + p2.x * 1 / 3), (p1.y * 2 / 3 + p4.y * 1 / 3));
			Point tp2 = new Point((p1.x * 1 / 3 + p2.x * 2 / 3), (p2.y * 2 / 3 + p3.y * 1 / 3));
			Point tp3 = new Point((p3.x * 2 / 3 + p1.x * 1 / 3), (p2.y * 1 / 3 + p3.y * 2 / 3));
			Point tp4 = new Point((p4.x * 2 / 3 + p3.x * 1 / 3), (p1.y * 1 / 3 + p4.y * 2 / 3));

			Point tm1 = new Point(tp1.x, p1.y);
			Point tm2 = new Point(tp2.x, p1.y);
			Point tm3 = new Point(p2.x, tp2.y);
			Point tm4 = new Point(p2.x, tp3.y);
			Point tm5 = new Point(tp2.x, p3.y);
			Point tm6 = new Point(tp1.x, p3.y);
			Point tm7 = new Point(p1.x, tp4.y);
			Point tm8 = new Point(p1.x, tp1.y);

			g.setColor(new Color(255, 255 - c, 255 - c * 10));
			fillRectangle(g, tp1, tp3);
			// 類似中序遍歷
			drawSierpinskiRec(g, p1, tp1, c, n - 1);
			drawSierpinskiRec(g, tm1, tp2, c, n - 1);
			drawSierpinskiRec(g, tm2, tm3, c, n - 1);
			drawSierpinskiRec(g, tp2, tm4, c, n - 1);
			drawSierpinskiRec(g, tp3, p3, c, n - 1);
			drawSierpinskiRec(g, tp4, tm5, c, n - 1);
			drawSierpinskiRec(g, tm7, tm6, c, n - 1);
			drawSierpinskiRec(g, tm8, tp4, c, n - 1);

			c++;
		}

	}

	public void fillRectangle(Graphics g, Point p1, Point p2, Point p3, Point p4) {
		int[] xpoints = new int[4];
		int[] ypoints = new int[4];
		xpoints[0] = p1.x;
		ypoints[0] = p1.y;
		xpoints[1] = p2.x;
		ypoints[1] = p2.y;
		xpoints[2] = p3.x;
		ypoints[2] = p3.y;
		xpoints[3] = p4.x;
		ypoints[3] = p4.y;
//		xpoints[4] = p1.x;
//		ypoints[4] = p1.y;
		g.fillPolygon(xpoints, ypoints, 4);
	}

	public void fillRectangle(Graphics g, Point p1, Point p2) {
		int[] xpoints = new int[4];
		int[] ypoints = new int[4];
		xpoints[0] = p1.x;
		ypoints[0] = p1.y;
		xpoints[1] = p2.x;
		ypoints[1] = p1.y;
		xpoints[2] = p2.x;
		ypoints[2] = p2.y;
		xpoints[3] = p1.x;
		ypoints[3] = p2.y;

		g.fillPolygon(xpoints, ypoints, 4);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		switch (this.control._frac) {
		case Fractal.SIERPINSKIRec:
			break;
		case Fractal.SIERPINSKITri:
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
			drawSierpinskiTri(g, p1, p2, p3, 0, 6);

//			create.drawSierpinski(_g, p1, p2,p3,tp1,tp2,tp3, 4);
			break;
		}
	}

}
