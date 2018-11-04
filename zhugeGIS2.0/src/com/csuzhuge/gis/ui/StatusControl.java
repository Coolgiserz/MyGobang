package com.csuzhuge.gis.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusControl extends JPanel{
	JLabel coord_geom;
	JLabel coord_screen;
	
	public StatusControl() {
		super();
//		init();
	}
	
	public void initUI() {
		coord_geom = new JLabel();
		coord_screen = new JLabel();
		
	}
	
	
}
