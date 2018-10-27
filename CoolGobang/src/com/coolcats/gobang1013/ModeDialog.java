package com.coolcats.gobang1013;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JDialog;

public class ModeDialog extends JDialog{
	JComboBox combo;
	
	public ModeDialog() {
		super();
		this.initUI();
	}
	
	public void initUI() {
		this.setSize(400, 400);
//		this.setPreferredSize(new Dimension(400, 400));
		this.setTitle("模式设置");
		this.setLocationRelativeTo(null);
//	    final String labels[] = { "权值法", "博弈树", "机器学习" }; 
	    Vector<String> v = new Vector<String>();
	    v.add("权值法");
	    v.add("博弈树");
	    v.add("机器学习");
		combo = new JComboBox(v);
		combo.setPreferredSize(new Dimension(400, 100));
		combo.setSelectedItem(v.get(0));
		this.add(combo);
		this.setVisible(true);
	}
}
