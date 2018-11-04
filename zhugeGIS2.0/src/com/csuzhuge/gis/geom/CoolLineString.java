package com.csuzhuge.gis.geom;

import java.util.ArrayList;

public class CoolLineString extends Geometry{
	
	ArrayList<CoolPoint> _points = new ArrayList<>();
	
	public CoolLineString() {
		super();
		this._type = Geometry.LINESTRING_TYPE;
	}
	
	public CoolLineString(CoolLineString ls) {
		this.append(ls);
	}
	public String toString() {
		return "LineString";
	}
	
	public CoolPoint get(int index) {
		return this._points.get(index);
	}
	public int getLength() {
		return this._points.size();
	}
	public String toWKT() {
		StringBuilder builder = new StringBuilder();
		builder.append("LINESTRING(");
		int i;
		for(i=0;i<this.getLength()-1;i++) {
			builder.append(this.get(i)._x).append(" ").append(this.get(i)._y);
			builder.append(",");
		}
		builder.append(this.get(i)._x).append(" ").append(this.get(i)._y);
		builder.append(")");
		return builder.toString();
	}
	public void add(CoolPoint pt) {
		this._points.add(pt);
	}
	
	public void append(CoolLineString ls) {
		for(int i=0;i<ls.getLength();i++) {
			this.add(ls.get(i));
		}
	}
	
}
