package com.csuzhuge.gis.geom;

public class CoolPoint extends Geometry{
	
	protected double _x,_y;	//默认会进行初始化为0.0
	public CoolPoint() {
		super();
		this._type = Geometry.POINT_TYPE;
	}
	
	public CoolPoint(double x,double y) {
		super();
		this._x = x;
		this._y = y;
	}
	
	public CoolPoint(CoolPoint pt) {
		this._x = pt._x;
		this._y = pt._y;
	}
	
	public String toString() {
		return "Point";
	}
	
	public String toWKT() {		
		return "POINT("+this._x+" "+this._y+")";
	}
	
	public String toRawWKT() {
		return null;
	}
	
	
}
