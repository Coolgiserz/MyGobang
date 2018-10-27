package com.coolcats.control;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import com.coolcats.ui.CanvasPanel;
import com.coolcats.ui.ControlPanel;

public class GeoDesktop extends JFrame {

	CanvasPanel _canvas;
	ControlPanel _control;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeoDesktop desktop = new GeoDesktop();
		desktop.initFrame();
	}

	public void initFrame() {
		this.setTitle("CoolShape2.0");
		this.setSize(1200, 1000);
//		this.setSize(getWidth(), getHeight());
		this.setResizable(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		// ���ò���
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		_canvas = new CanvasPanel();
		_control = new ControlPanel();
		this.add(_control, BorderLayout.WEST);
		this.add(_canvas, BorderLayout.CENTER);
		this.setVisible(true);

		Graphics _g = _canvas.getGraphics();
		_canvas.setBuddy(_control);// ��������崫����������
		_canvas.getCanvasGraphics(_g);// �����ʶ��󴫸�����
		_control.setBuddy(_canvas);
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		//��֤�ı䴰�ڴ�С����Ȼ����Ч
		Graphics _g = _canvas.getGraphics();
		_canvas.getCanvasGraphics(_g);// �����ʶ��󴫸�����
	}

}
