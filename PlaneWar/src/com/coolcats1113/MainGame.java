package com.coolcats1113;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGame extends JFrame{
	private JPanel gamePanel;
	private ImageIcon bgImg;
	private int sleeptime = 1000;
	public static void main(String[] args) {
		MainGame game = new MainGame();
		game.initUI();
		
	}
	private void initUI() {
		this.setTitle("»Ò»ú´óÕ½");
		this.setSize(600, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(3);
		bgImg = new ImageIcon("gamebg1.jpg");

//		JLabel lbBg = new JLabel(bgImg);
//		lbBg.setPreferredSize(new Dimension(1000,800));
//		this.add(lbBg);
		gamePanel = new JPanel();
		
//		gamePanel.add(lbBg);
		this.add(gamePanel);
		this.setVisible(true);
		
	
		PlaneAI planeAI = new PlaneAI(gamePanel,bgImg);
		planeAI.start();
//		this.setIconImage(new ImageIcon(""));
//		this.setBackground();
	}
	public MainGame() {
		
	}
}
