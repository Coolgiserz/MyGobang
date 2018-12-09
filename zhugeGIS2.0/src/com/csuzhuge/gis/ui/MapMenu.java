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
	protected JMenu menuFile;
	public static String Menu_tool = "����";
	protected JMenu menuTool;
	public static String Menu_feature = "Ҫ��";
	protected JMenu menuFeature;
	/*
	 * 
	 * �Ӳ˵���
	 */
	public final static String SUBMENU_OPEN = "��";
	public final static String SUBMENU_BASIC = "��������";
	public final static String SUBMENU_NEWFEATURE = "��Ҫ��";
	public final static String SUBMENU_EDITFEATURE = "�༭����";
	public final static String SUBMENU_CHECKFEATURE = "�鿴����";
	public final static String SUBMENU_NEWPOINT = "�½���Ҫ��";
	public final static String SUBMENU_NEWLINE = "�½���Ҫ��";
	public final static String SUBMENU_NEWPOLYGON = "�½���Ҫ��";

	protected JMenuItem filemenu_1;		//��
	protected JMenuItem basic_1;		//��������
	protected JMenuItem feature_new;	//��Ҫ��
	protected JMenuItem featureNewPoint;	//�½���Ҫ��
	protected JMenuItem featureNewLine;	//�½���Ҫ��
	protected JMenuItem featureNewPolygon;	//�½���

	protected JMenuItem feature_edit;	//�༭����
	protected JMenuItem feature_check;	//�鿴����
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
		
		//�����˵�����
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
		 * ���ò˵��ؼ�
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
		 * �ļ���˵����¼�
		 */
		FileEvent ev = new FileEvent(this._controlpanel);
		filemenu_1.addActionListener(ev);
		/*
		 * Ҫ����˵����¼�
		 */
		FeatureEvent fv = new FeatureEvent();
		featureNewPoint.addActionListener(fv);
		featureNewLine.addActionListener(fv);
		featureNewPolygon.addActionListener(fv);
		feature_edit.addActionListener(fv);
		feature_check.addActionListener(fv);

	}
}
