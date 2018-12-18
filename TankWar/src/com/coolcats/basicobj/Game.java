package com.coolcats.basicobj;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame{

	public final static int GAME_WIDTH = 800;
	public final static int GAME_HEIGHT = 600;
	private  Graphics g;

	public static void main(String[] args) {
		
		Game game = new Game();
		game.initUI();
		GameControl control = new GameControl(game,game.g);
		Thread t = new Thread(control);
		t.start();
	}
	
	public void initUI() {
		this.setTitle("Ì¹¿ËÐ¡Õ½");
		this.setDefaultCloseOperation(3);
//		this.getContentPane().setBackground(Color.BLACK);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		g = this.getGraphics();
		System.out.println(g);
//		g.drawImage(new ImageIcon("resources/enemy2D.gif").getImage()	, 100, 100, null);
	}
	

}
