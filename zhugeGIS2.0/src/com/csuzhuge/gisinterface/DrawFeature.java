package com.csuzhuge.gisinterface;

import java.awt.Graphics;

public interface DrawFeature {
	
	public void drawPoint(Graphics g);
	public void drawLineString(Graphics g);
	public void drawPolygon(Graphics g);
}
