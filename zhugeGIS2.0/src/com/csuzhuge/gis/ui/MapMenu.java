package com.csuzhuge.gis.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.csuzhuge.gis.uievent.FeatureEvent;
import com.csuzhuge.gis.uievent.FileEvent;

public class MapMenu extends JMenuBar {

	/*
	 * 
	 * ���˵���
	 */
	public static String Menu_file = "�ļ�";
	protected JMenu menu_1;
	public static String Menu_tool = "����";
	protected JMenu menu_2;
	public static String Menu_feature = "Ҫ��";
	protected JMenu menu_3;
	/*
	 * 
	 * �Ӳ˵���
	 */
	public final static String SUBMENU_OPEN = "��";
	protected JMenuItem filemenu_1;

	public final static String SUBMENU_BASIC = "��������";
	protected JMenuItem basic_1;

	public final static String SUBMENU_NEWFEATURE = "��Ҫ��";
	protected JMenuItem feature_new;
	public final static String SUBMENU_EDITFEATURE = "�༭����";
	protected JMenuItem feature_edit;

	public final static String SUBMENU_CHECKFEATURE = "�鿴����";
	protected JMenuItem feature_check;

	/*
	 * �ֵܿؼ�
	 */
	MapControl _controlpanel;
	public MapMenu() {
		super();
		initMenu();
		setListener();
	}

	public MapMenu(MapControl panel) {
	
		this._controlpanel = panel;
		initMenu();
		setListener();

	}
	public void initMenu() {
		/*
		 * �����˵�����
		 */
		menu_1 = new JMenu(Menu_file);
		filemenu_1 = new JMenuItem(SUBMENU_OPEN);
		menu_2 = new JMenu(Menu_tool);
		basic_1 = new JMenuItem(SUBMENU_BASIC);
		menu_3 = new JMenu(Menu_feature);
		feature_new = new JMenuItem(SUBMENU_NEWFEATURE);
		feature_edit = new JMenuItem(SUBMENU_EDITFEATURE);
		feature_check = new JMenuItem(SUBMENU_CHECKFEATURE);
		/*
		 * ���ò˵��ؼ�
		 */
		menu_1.add(filemenu_1);
		menu_2.add(basic_1);
		menu_3.add(feature_new);
		menu_3.add(feature_edit);
		menu_3.add(feature_check);

		this.add(menu_1);
		this.add(menu_2);
		this.add(menu_3);
	}

	public void setListener() {
		System.out.println(this._controlpanel);
		/*
		 * �ļ���˵����¼�
		 */
		FileEvent ev = new FileEvent(this._controlpanel);
		filemenu_1.addActionListener(ev);
		/*
		 * Ҫ����˵����¼�
		 */
		FeatureEvent fv = new FeatureEvent();
		feature_new.addActionListener(fv);
		feature_edit.addActionListener(fv);
		feature_check.addActionListener(fv);

	}
}
