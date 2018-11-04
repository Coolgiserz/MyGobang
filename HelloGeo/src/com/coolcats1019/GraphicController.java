package com.coolcats1019;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicController {

	public JFrame frame;
	int typecount = 14;
	int colorcount = 4;
	JButton[] typebutton = new JButton[typecount];
	JButton[] colorbutton = new JButton[colorcount];

	public void initUI() {
		// TODO Auto-generated method stub
		frame = new JFrame("CoolCats绘制图形1.0");
		frame.setSize(1200,700);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		DrawingListener ll = new DrawingListener(frame);

		for(int i=0;i<typecount;i++) {
			typebutton[i] = new JButton();			
			typebutton[i].setPreferredSize(new Dimension(150,50));
			typebutton[i].addActionListener(ll);
			frame.add(typebutton[i]);
			
		}
		typebutton[1].setText("直线");
		typebutton[2].setText("矩形");
		typebutton[3].setText("填充圆");
		typebutton[4].setText("填充3D矩形");
		typebutton[5].setText("图片");
		typebutton[6].setText("文字");
		typebutton[7].setText("五角星");
		typebutton[8].setText("刷子");
		typebutton[9].setText("任意多边形");
		typebutton[10].setText("等腰三角形");
		typebutton[11].setText("立方体");
		typebutton[12].setText("曲线");
		typebutton[13].setText("喷枪");
		typebutton[0].setText("橡皮");

		for(int i=0;i<colorcount;i++) {
			colorbutton[i] = new JButton();
			colorbutton[i].setPreferredSize(new Dimension(150,50));
			colorbutton[i].addActionListener(ll);
			
			frame.add(colorbutton[i]);
		
		}
		colorbutton[0].setBackground(Color.RED);
		colorbutton[1].setBackground(Color.BLUE);
		colorbutton[2].setBackground(Color.GREEN);
		colorbutton[3].setBackground(Color.BLACK);

		
		frame.addMouseListener(ll);
		frame.addMouseMotionListener(ll);
		frame.setVisible(true);
		
		
	}

	
}
