package com.coolcats1008;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CanvasListener implements MouseListener, ActionListener {

	DrawCanvas _frame;
	Graphics g;
	private final int chess_size = 36;
	JButton srcbtn;
	private int chessR, chessC;
	private int x, y;
	private int interval = 40;
	private int whitecount, blackcount;
	public boolean WINSIZE;

	public ChessConfig[][] chesstable = new ChessConfig[10][10];

	public CanvasListener(DrawCanvas frame) {

		this._frame = frame;
		srcbtn = new JButton();
		blackcount = 0;
		whitecount = 0;
		chesstable = new ChessConfig[ChessConfig.TABLE_ROW][ChessConfig.TABLE_COL];
		
//		System.out.println(chesstable.length);
	}

	/**
	 * 绘制棋子的函数
	 * 
	 * @param xx 落子应在坐标轴的交叉点横坐标
	 * @param yy 落子应在坐标轴的交叉点纵坐标
	 * @param g  画笔对象
	 */
	public void drawchess(int xx, int yy, Graphics g) {
		int C = (xx - this._frame.getOriX()) / interval;
		int R = (yy - this._frame.getOriY()) / interval;

		System.out.println(blackcount % 2);
		/*
		 * 如果黑棋数小于白棋，则轮到黑棋；否则轮到白棋
		 * 
		 */
		if(srcbtn.getText().equals("人人对战")) {
			ChessConfig chess = new ChessConfig(xx, yy, "空");

			if (blackcount <= whitecount && chesstable[R][C] == null) {
				chess.setConfig("黑棋");
				ChessConfig.drawBlack(g, chess);
				blackcount++;
				chesstable[R][C] = chess;
				boolean status = ChessConfig.checkWin(R, C, chesstable);
				if (status == true) {
//					System.out.println("黑棋赢");
					JOptionPane.showMessageDialog(this._frame, "黑棋胜");
				} else {
					System.out.println("轮到白棋");
//					System.exit(0);

				}

			} else if (blackcount > whitecount && chesstable[R][C] == null) {
				chess.setConfig("白棋");

				ChessConfig.drawWhite(g, chess);

				whitecount++;
				chesstable[R][C] = chess;
				/*
				 * 判断是否出现赢家
				 */
				boolean status = ChessConfig.checkWin(R, C, chesstable);
				if (status == true) {
					System.out.println("白棋赢");
					JOptionPane.showMessageDialog(this._frame, "白棋胜");

				} else {
					System.out.println("轮到黑棋");
//					System.exit(0);

				}
			}
		}
	

	}

	public void mouseClicked(MouseEvent e) {
		g = this._frame.getGraphics();

		if (srcbtn.getText().equals("五子棋模式")) {
			x = e.getX();
			y = e.getY();
			
			System.out.println(new Point(x, y));
			if (x < 100 || y < 100 || x > 900 || y > 900) {
				System.out.println("出界");
				return;
			}
			/**
			 * 计算点击位置，得到落子坐标
			 */

			int delta_x = x - this._frame.getOriX();
			int delta_y = y - this._frame.getOriY();
			int loc_xmod;
			int loc_ymod;
			chessR = delta_y / interval;
			chessC = delta_x / interval;
			loc_xmod = delta_x % interval;
			loc_ymod = delta_y % interval;
			if (loc_xmod > 20) {
				chessC++;
			}
			if (loc_ymod > 20) {
				chessR++;
			}

			int xx = this._frame.getOriX() + chessC * interval;
			int yy = this._frame.getOriY() + chessR * interval;

			g.setColor(Color.BLACK);
			System.out.println("xx:" + xx + "yy:" + yy);
			drawchess(xx, yy, g);
//	    					g.fillOval(xx-chess_size/2, yy-chess_size/2, chess_size, chess_size);
			this._frame.setTable(chesstable);
			return;
		}
//		System.out.println(e.getX()+" "+e.getY());

		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < 50; i++) {
//				Color color = new Color(255,0,0);   		

			for (int j = 0; j < 10; j++) {
				Color color = new Color(255 - i - 5 * j, 255 - 5 * i, i * 4 + 5 + j * 2);
				g.setColor(color);

				g.fillOval(x - i * 2 + 5 * j, y - i * 2 - 5 * j, 50 + i, 50 + i);
				g.fillOval(x + i * 2 + 5 * j, y - i * 2 - 5 * j, 50 + i, 50 + i);
				g.fillOval(x - i * 2 + 5 * j, y + i * 2 - 5 * j, 50 + i, 50 + i);
				g.fillOval(x + i * 2 + 5 * j, y + i * 2 - 5 * j, 50 + i, 50 + i);
			}

		}
	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		srcbtn = (JButton) e.getSource();
		if (srcbtn.getText().equals("图形")) {
			return;
		}
		if (srcbtn.getText().equals("人人对战")) {
			return;
		}

	}
}
