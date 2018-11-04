package com.coolcats1104_1;

import javax.swing.JFrame;
/**
 * ˫���嵯��ʹ��BufferedImage�ࣨImage��һ�����ࣩ���Ƚ�С�������ͼƬ�У��ٽ�ͼƬ�����ڴ����ϣ������˸����
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
		this.setTitle("˫���嵯��");
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
