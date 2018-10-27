package com.coolcats.shape;

import java.awt.Color;

public class PointShape extends Shape {
	public int x,y;
	
	public PointShape() {
		this._type = Shape.POINTSHAPE;
	}
	public PointShape(PointShape pt) {
		this();
		this.x = pt.x;
		this.y = pt.y;
		this._color = pt._color;
	}
	
	public PointShape(int x,int y) {
		this();
		this.x = x;
		this.y = y;
	}
	public PointShape(int x,int y,Color color) {
		this();
		this.x = x;
		this.y = y;
		this._color = color;
	}
	
	public String toString() {
		return "POINTSHAPE";
	}
}
