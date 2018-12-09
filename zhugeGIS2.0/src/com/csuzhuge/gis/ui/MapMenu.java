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
	protected JMenu menuFile;
	public static String Menu_tool = "工具";
	protected JMenu menuTool;
	public static String Menu_feature = "要素";
	protected JMenu menuFeature;
	/*
	 * 
	 * 子菜单项
	 */
	public final static String SUBMENU_OPEN = "打开";
	public final static String SUBMENU_BASIC = "基础工具";
	public final static String SUBMENU_NEWFEATURE = "新要素";
	public final static String SUBMENU_EDITFEATURE = "编辑属性";
	public final static String SUBMENU_CHECKFEATURE = "查看属性";
	public final static String SUBMENU_NEWPOINT = "新建点要素";
	public final static String SUBMENU_NEWLINE = "新建线要素";
	public final static String SUBMENU_NEWPOLYGON = "新建面要素";

	protected JMenuItem filemenu_1;		//打开
	protected JMenuItem basic_1;		//基础工具
	protected JMenuItem feature_new;	//新要素
	protected JMenuItem featureNewPoint;	//新建点要素
	protected JMenuItem featureNewLine;	//新建线要素
	protected JMenuItem featureNewPolygon;	//新建面

	protected JMenuItem feature_edit;	//编辑属性
	protected JMenuItem feature_check;	//查看属性
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
		
		//创建菜单对象
		menuFile = new JMenu(Menu_file);
		filemenu_1 = new JMenuItem(SUBMENU_OPEN);
		menuTool = new JMenu(Menu_tool);
		basic_1 = new JMenuItem(SUBMENU_BASIC);
		menuFeature = new JMenu(Menu_feature);
		feature_new = new JMenu(SUBMENU_NEWFEATURE);
		feature_edit = new JMenuItem(SUBMENU_EDITFEATURE);
		feature_check = new JMenuItem(SUBMENU_CHECKFEATURE);
		featureNewPoint = new JMenuItem(SUBMENU_NEWPOINT);
		featureNewLine = new JMenuItem(SUBMENU_NEWLINE);
		featureNewPolygon = new JMenuItem(SUBMENU_NEWPOLYGON);
		/*
		 * 配置菜单控件
		 */
		menuFile.add(filemenu_1);
		menuTool.add(basic_1);
		menuFeature.add(feature_new);
		menuFeature.add(feature_edit);
		menuFeature.add(feature_check);
		feature_new.add(featureNewPoint);
		feature_new.add(featureNewLine);
		feature_new.add(featureNewPolygon);

		this.add(menuFile);
		this.add(menuTool);
		this.add(menuFeature);
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
		featureNewPoint.addActionListener(fv);
		featureNewLine.addActionListener(fv);
		featureNewPolygon.addActionListener(fv);
		feature_edit.addActionListener(fv);
		feature_check.addActionListener(fv);

	}
}
