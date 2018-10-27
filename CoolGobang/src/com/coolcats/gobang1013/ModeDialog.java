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
		this.setTitle("ģʽ����");
		this.setLocationRelativeTo(null);
//	    final String labels[] = { "Ȩֵ��", "������", "����ѧϰ" }; 
	    Vector<String> v = new Vector<String>();
	    v.add("Ȩֵ��");
	    v.add("������");
	    v.add("����ѧϰ");
		combo = new JComboBox(v);
		combo.setPreferredSize(new Dimension(400, 100));
		combo.setSelectedItem(v.get(0));
		this.add(combo);
		this.setVisible(true);
	}
}
