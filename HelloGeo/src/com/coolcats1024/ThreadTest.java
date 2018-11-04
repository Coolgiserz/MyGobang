package com.coolcats1024;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreadTest extends JFrame implements ActionListener{

	
	Graphics _g;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest test = new ThreadTest();
		test.initUI();
	}
	
	public void initUI() {
		this.setTitle("∂‡œﬂ≥ÃªÊÕº");
		this.setSize(800, 800);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLACK);

		this.setLocationRelativeTo(null);
		JButton btn = new JButton("Start");
		btn.setPreferredSize(new Dimension(200, 50));
		btn.addActionListener(this);
		this.setLayout(new FlowLayout());
		this.add(btn);
		this._g = this.getGraphics();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		for(int i=0;i<=60;i++) {
//			this._g.setColor(new Color(255,i*3,i*3));
//			this._g.fillArc(400, 400, 100, 100, 0, i*6);
//
//		}
		
		DrawThread thread = new DrawThread(_g,e);
		thread.start();
		
	}

}
