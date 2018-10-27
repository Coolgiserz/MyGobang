package com.coolcats.shape;

import java.awt.Color;
import java.util.ArrayList;

public class FakePolygon extends Shape{
	public ArrayList<PointShape> _points = new ArrayList<>();
	public ArrayList<LineShape> _lines = new ArrayList<>();

	public FakePolygon() {
		this._type = Shape.FAKEPOLYGONSHAPE;
	}
	
	public FakePolygon(Color color) {
		this();
		this._color = color;
	}
	
	public void append(LineShape ls) {
		this._lines.add(ls);
	}
	public void addPoint(PointShape pt) {
		System.out.println("���һ����");
		this._points.add(pt);
		System.out.println("������"+this._points.size());

	}
	
	public PointShape get(int i) {
		return this._points.get(i);
	}
	public int getLength() {
		return this._points.size();
	}
	public String toString() {
		return "FAKESHAPE";
	}
}
