package com.coolcats.shape;

import java.awt.Color;

public class Shape {
	public final static String UNKNOWN = "未知";
	public final static String POINTSHAPE = "点";

	public final static String LINESHAPE = "直线";
	public final static String CURSESHAPE = "曲线";
	public final static String FAKEPOLYGONSHAPE = "假多边形";
	public final static String TRIANGLE = "等边三角形";
	public final static String FIBONACCI = "斐波那契数列";
	public final static String GAUSSSUM = "高斯求和";
	public final static String MUTILTABLE = "九九乘法表";


	protected String _type;
	public Color _color;
	public Shape() {
		this._type = UNKNOWN;
	}
	
	public String getType() {
		return _type;
	}

	
	public String toString() {
		return "Shape";
	}
}
