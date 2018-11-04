package com.coolcats1104_1;

import javax.swing.JFrame;
/**
 * 双缓冲弹球，使用BufferedImage类（Image的一个子类），先将小球绘制在图片中，再将图片绘制在窗体上，解决闪烁问题
 * @author CoolCats
 *
 */
public class MainControl extends JFrame {

//	private static MainControl frame;

	public static void main(String[] args) {
		MainControl frame = new MainControl();
		frame.initUI();
	}

	private void initUI() {
		this.setTitle("双缓冲弹球");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		BallThread bl = new BallThread(this);
		this.addMouseListener(bl);

		Thread tl = new Thread(bl);
		tl.start();
	}

}
