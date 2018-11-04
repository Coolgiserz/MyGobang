package com.csuzhuge.gis.desktop;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import com.csuzhuge.gis.ui.LayerControl;
import com.csuzhuge.gis.ui.MapControl;
import com.csuzhuge.gis.ui.MapMenu;
import com.csuzhuge.gis.ui.StatusControl;
public class gisdesktop  extends JFrame{

	MapControl mappanel;
	MapMenu menu;
	LayerControl layercontrol;
	JSplitPane splitpanel;
	StatusControl statuscontrol;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gisdesktop desktop = new gisdesktop();
	}
	
	public gisdesktop() {
		super();
		initUI();
	}
	public void initUI() {
		
		//设置窗体基本属性
		this.setTitle("zhugeGIS2.0");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		
		//设置布局
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		
		//初始化并添加控件
		mappanel = new MapControl();
//		System.out.println(this.mappanel);

		menu = new MapMenu(mappanel);
		layercontrol = new LayerControl();
		splitpanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,layercontrol,mappanel);
		statuscontrol = new StatusControl();
		this.add(menu, BorderLayout.NORTH);
//		System.out.println(mappanel);
		this.add(splitpanel);	//拆分窗格添加存在问题
		
		this.add(mappanel,BorderLayout.CENTER);
		this.add(layercontrol, BorderLayout.WEST);
		this.add(statuscontrol,BorderLayout.SOUTH);

		this.setVisible(true);
		
	}

}
