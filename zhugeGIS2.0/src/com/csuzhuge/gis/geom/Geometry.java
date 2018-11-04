package com.csuzhuge.gis.geom;

public class Geometry {
	/*
	 * 几何类型常量
	 */
	protected final static int NULL_TYPE = 0;
	protected final static int POINT_TYPE = 1;
	protected final static int LINESTRING_TYPE = 2;
	protected final static int LINERING_TYPE = 3;
	protected final static int POLYGON_TYPE = 4;
	protected final static int MUTILPOLYGON_TYPE = 4;
	
	protected int _type;
	
	public Geometry() {
		this._type = NULL_TYPE;
	}
	public int getType() {
		return this._type;
	}
	
	public String toWKT() {
		return "";
		
	}
	
	public String toRawWKT() {
		return "";
	}
	
	public String toString() {
		return "Geometry";
		
	}
}
