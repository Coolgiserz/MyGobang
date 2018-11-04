package com.coolcats1104;

import javax.swing.JFrame;
/**
 * 存在问题：快速点击生成小球时窗体会闪烁
 * （产生原因：因为再绘制移动效果时，每轮都清空了一次画布，所以当小球数量过多时 线程sleep的时间不足以重绘所有小球）
 * （解决办法：先将小球绘制在内存中，再画到画布上）
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
		this.setTitle("线程弹球");
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
