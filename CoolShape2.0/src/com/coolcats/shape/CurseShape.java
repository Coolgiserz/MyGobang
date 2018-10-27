package com.coolcats.shape;

import java.awt.Color;
import java.util.ArrayList;

public class CurseShape extends Shape{
	public ArrayList<PointShape> _points = new ArrayList<>();
	public CurseShape() {
		this._type = CURSESHAPE;
		
	}
	public CurseShape(Color color) {
		this._type = CURSESHAPE;
		this._color = color;
		
	}
	public CurseShape(CurseShape cur) {
		this();
		for(int i=0;i<cur._points.size();i++) {
			this._points.add(cur._points.get(i));
		}
		this._color = cur._color;
	}
	
	public void append(CurseShape cur) {
		for(int i=0;i<cur._points.size();i++) {
			this._points.add(cur._points.get(i));
		}
		
	}
	
	public void add(PointShape pt) {
		this._points.add(pt);
	}
	public String toString() {
		return "CurseShape";
	}
	
	public int getLength() {
		return this._points.size();
	}
}
