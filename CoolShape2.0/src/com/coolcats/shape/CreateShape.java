package com.coolcats.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class CreateShape extends Shape {
	public CreateShape() {

	}

	public CreateShape(Color color) {
		this();
		this._color = color;
	}

	/**
	 * 绘制等边三角形
	 * @param xpoints
	 * @param ypoints
	 * @param g
	 */
	public void drawTriangle(int[] xpoints, int[] ypoints, Graphics g) {
		g.drawPolygon(xpoints, ypoints, 3);
		int[] x1points = new int[3];
		int[] y1points = new int[3];
		x1points[0] = (xpoints[0] + xpoints[1]) / 2;
		x1points[1] = (xpoints[0] + xpoints[2]) / 2;
		x1points[2] = (xpoints[1] + xpoints[2]) / 2;

		y1points[0] = (ypoints[0] + ypoints[1]) / 2;
		y1points[1] = (ypoints[0] + ypoints[2]) / 2;
		y1points[2] = (ypoints[1] + ypoints[2]) / 2;
		g.fillPolygon(x1points, y1points, 3);

	}

	/**
	 * 绘制斐波那契数列 斐波那契数列1，1，2，3，5，8，13，21...... 递推式：f(n) = f(n-1)+f(n-2) 问题：超出屏幕后无法换行
	 * 
	 * @param g
	 * @param i
	 * @param j
	 */
	public int drawFib(Graphics g, int n, int x0, int y0, int count, int height) {

		if (n == 0) {
			g.drawString(1 + "", x0, y0);

			return 1;
		}
		if (n == 1) {
			g.drawString(1 + "", x0, y0 + 30);

			return 1;
		}
		int y = y0 + n * 30;

//		if(y/height>1) {
//			count--;
//			y = y0;
////			x = x0 + iter*30;
//		}

		int x = x0 + (y / height) * 30;
		System.out.println("递推数列：" + n);
		int res = drawFib(g, n - 1, x0, y0, count, height) + drawFib(g, n - 2, x0, y0, count, height);
		System.out.println("回归数列：" + n);

		g.drawString(res + "", x, y);
		return res;
	}

	public long Fib(int i) {
		if (i == 1) {
			return 1;

		}
		if (i == 0) {
			return 1;
		}
//		System.out.println(i);
		return Fib(i - 2) + Fib(i - 1);

	}

	public long StackFib(int i) {
		if (i == 1) {
			return 1;

		}
		if (i == 0) {
			return 1;
		}
//		System.out.println(i);
		return Fib(i - 2) + Fib(i - 1);

	}

	/**
	 * 递归求和
	 * 
	 * @param i
	 * @param e
	 * @return
	 */
	public int drawSumTable(int i, MouseEvent e) {
		if (i <= 100 && i > 1) {
//			g.drawString((i+j)+"", e.getX(), e.getY());

			return i + drawSumTable(i - 1, e);
		} else {
			return 1;

		}

	}

	/**
	 * 九九乘法表递归
	 * 
	 * @param g
	 * @param i
	 */
	public void drawMutilTable(Graphics g, int i, MouseEvent e) {
		if (i == 1) {
//			System.out.println("1*1=1");
			g.drawString("1*1=1", e.getX(), e.getY());

		}else {
			drawMutilTable(g, i-1, e);
			for(int j=1;j<=i;j++) {
//				System.out.print(j+"*"+i+"="+j*i);
				g.drawString(j+"*"+i+"="+j*i, e.getX()+(j-1)*80, e.getY()+(i-1)*80);
			}
			System.out.println();

		}
	}
}
