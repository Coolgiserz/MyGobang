package com.coolcats1104;

import javax.swing.JFrame;
/**
 * �������⣺���ٵ������С��ʱ�������˸
 * ������ԭ����Ϊ�ٻ����ƶ�Ч��ʱ��ÿ�ֶ������һ�λ��������Ե�С����������ʱ �߳�sleep��ʱ�䲻�����ػ�����С��
 * ������취���Ƚ�С��������ڴ��У��ٻ��������ϣ�
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
		this.setTitle("�̵߳���");
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
