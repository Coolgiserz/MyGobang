package com.coolcats.shape;

import java.awt.Color;

public class LineShape extends Shape {
	public int x1, y1, x2, y2;// 用于存储直线的两个端点的坐标
	public Color color;

	public LineShape() {
		this._type = LINESHAPE;
	}

	public LineShape(int x1, int y1, int x2, int y2, Color color) {
		this();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public LineShape(LineShape ls) {
		this.x1 = ls.x1;
		this.x2 = ls.x2;
		this.y1 = ls.y1;
		this.y2 = ls.y2;
		this._color = ls._color;
	}

	public LineShape(int _orix, int _oriy, int _endx, int _endy) {
		this.x1 = _orix;
		this.y1 = _oriy;
		this.x2 = _endx;
		this.y2 = _endy;
		
	}

	public String toString() {
		return "LINE";
	}

}
