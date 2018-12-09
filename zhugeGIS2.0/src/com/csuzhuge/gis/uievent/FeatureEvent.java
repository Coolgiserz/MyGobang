package com.csuzhuge.gis.uievent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JMenuItem;

import com.csuzhuge.gis.ui.MapMenu;

public class FeatureEvent extends MouseAdapter implements ActionListener {
	private int _type;
	private JMenuItem srcitem;

	public FeatureEvent() {
		srcitem = new JMenuItem();
	}

	// GIS软件是如何实现可以一个一个地选中要素的？？？？？？
	public void actionPerformed(ActionEvent e) {
		srcitem = (JMenuItem) e.getSource();
		String type = srcitem.getText();
		switch (type) {
		case MapMenu.SUBMENU_NEWPOINT:
			//create point feature
			NewFeatureDialog();
			break;
		case MapMenu.SUBMENU_NEWLINE:
			//create line feature

			NewFeatureDialog();
			break;
		case MapMenu.SUBMENU_NEWPOLYGON:
			//create polygon feature
			break;
		case MapMenu.SUBMENU_EDITFEATURE:
			EditFeature();
			break;
		case MapMenu.SUBMENU_CHECKFEATURE:
			ActivateCheckFeature();
			break;

		}
	}

	private void ActivateCheckFeature() {
		// TODO Auto-generated method stub
		System.out.println("激活查询要素属性");

	}

	private void EditFeature() {
		// TODO Auto-generated method stub
		System.out.println("编辑要素");

	}

	private void NewFeatureDialog() {
		System.out.println("新要素");
	}
}
