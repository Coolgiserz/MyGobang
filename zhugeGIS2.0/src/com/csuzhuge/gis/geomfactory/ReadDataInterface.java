package com.csuzhuge.gis.geomfactory;

import com.csuzhuge.gis.geom.Geometry;

public interface ReadDataInterface {
	/**
	 * 读取mygis文件
	 * @param fpath 文件的路径
	 */
	public abstract Geometry readMygis(String fpath);
	public abstract void mygis2WKT(String fpath);
}
