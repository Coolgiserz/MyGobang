package com.coolcats.shape;

import java.awt.Color;

public class Shape {
	public final static String UNKNOWN = "δ֪";
	public final static String POINTSHAPE = "��";

	public final static String LINESHAPE = "ֱ��";
	public final static String CURSESHAPE = "����";
	public final static String FAKEPOLYGONSHAPE = "�ٶ����";
	public final static String TRIANGLE = "�ȱ�������";
	public final static String FIBONACCI = "쳲���������";
	public final static String GAUSSSUM = "��˹���";
	public final static String MUTILTABLE = "�žų˷���";


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
