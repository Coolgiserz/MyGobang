package com.csuzhuge.gis.geomfactory;

import com.csuzhuge.gis.geom.Geometry;

public interface ReadDataInterface {
	/**
	 * ��ȡmygis�ļ�
	 * @param fpath �ļ���·��
	 */
	public abstract Geometry readMygis(String fpath);
	public abstract void mygis2WKT(String fpath);
}
