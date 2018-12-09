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

	// GIS��������ʵ�ֿ���һ��һ����ѡ��Ҫ�صģ�����������
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
		System.out.println("�����ѯҪ������");

	}

	private void EditFeature() {
		// TODO Auto-generated method stub
		System.out.println("�༭Ҫ��");

	}

	private void NewFeatureDialog() {
		System.out.println("��Ҫ��");
	}
}
