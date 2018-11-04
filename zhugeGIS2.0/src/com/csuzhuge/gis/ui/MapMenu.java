package com.csuzhuge.gis.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.csuzhuge.gis.uievent.FeatureEvent;
import com.csuzhuge.gis.uievent.FileEvent;

public class MapMenu extends JMenuBar {

	/*
	 * 
	 * 主菜单项
	 */
	public static String Menu_file = "文件";
	protected JMenu menu_1;
	public static String Menu_tool = "工具";
	protected JMenu menu_2;
	public static String Menu_feature = "要素";
	protected JMenu menu_3;
	/*
	 * 
	 * 子菜单项
	 */
	public final static String SUBMENU_OPEN = "打开";
	protected JMenuItem filemenu_1;

	public final static String SUBMENU_BASIC = "基础工具";
	protected JMenuItem basic_1;

	public final static String SUBMENU_NEWFEATURE = "新要素";
	protected JMenuItem feature_new;
	public final static String SUBMENU_EDITFEATURE = "编辑属性";
	protected JMenuItem feature_edit;

	public final static String SUBMENU_CHECKFEATURE = "查看属性";
	protected JMenuItem feature_check;

	/*
	 * 兄弟控件
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
		 * 创建菜单对象
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
		 * 配置菜单控件
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
		 * 文件类菜单项事件
		 */
		FileEvent ev = new FileEvent(this._controlpanel);
		filemenu_1.addActionListener(ev);
		/*
		 * 要素类菜单项事件
		 */
		FeatureEvent fv = new FeatureEvent();
		feature_new.addActionListener(fv);
		feature_edit.addActionListener(fv);
		feature_check.addActionListener(fv);

	}
}
