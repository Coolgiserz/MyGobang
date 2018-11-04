package com.coolcats.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;

public class TestFrame extends JFrame implements MouseListener {

	static Graphics g;

	public static void main(String[] args) {
		TestFrame frame = new TestFrame();
		frame.initUI();
		BallThread ballthread = new BallThread(g, frame);
		for (int k = 0; k < 50; k++) {

			ballthread.start();
		}
	}

	public void initUI() {
		this.setTitle("·É»ú´óÕ½²âÊÔ");
		this.setSize(1000, 1000);

		this.getContentPane().setBackground(Color.BLACK);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.addMouseListener(this);
		g = this.getGraphics();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SilverThread thread = new SilverThread(g, e);
		thread.start();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
