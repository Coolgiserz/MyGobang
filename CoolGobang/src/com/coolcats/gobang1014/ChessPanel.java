package com.coolcats.gobang1014;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ChessPanel extends JPanel {

	Graphics _g;
	public static int[][] _chesstable;

	public ChessPanel() {
		initUI();
		_chesstable = new int[Chess.TABLE_ROW][Chess.TABLE_COL];
		printTable(_chesstable);
	}

	public void initTable() {
//		_chesstable = new int[Chess.TABLE_ROW][Chess.TABLE_COL];
		
			for(int i=0;i<_chesstable.length;i++) {
				for(int j=0;j<_chesstable.length;j++) {
					if(_chesstable[i][j]!=0) {
						_chesstable[i][j] = 0;

					}
				}
			
		}
		
	}
	public void initUI() {
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(800, 1000));

	}

	public void repaintTable() {
		for (int r = 0; r < _chesstable.length; r++) {
			for (int c = 0; c < _chesstable.length; c++) {
				if (_chesstable[r][c] == 0) {
					continue;
				}
				if (_chesstable[r][c] == 1) {
					this.drawBlack(r, c);
				}
				if (_chesstable[r][c] == 2) {
					this.drawWhite(r, c);
				}
			}
		}
	}

	public void setBuddyTable(int[][] chesstable) {
		this._chesstable = chesstable;
	}

	private void printTable(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				System.out.print(table[i][j] + " ");

			}
			System.out.println();
		}
	}

	public void get_Graphics(Graphics g) {
		this._g = g;
//		g.setColor(Color.BLACK);

	}

	/**
	 * 重写paint函数，直接再paint函数中绘制棋盘比特地调用一个绘制棋盘的函数要快
	 */
	public void paint(Graphics g) {
		super.paint(g);
//		Chess.drawTable(this._g);

		g.setColor(Color.BLACK);
		for (int i = 0; i <= Chess.TABLE_ROW; i++) {
			g.drawLine(Chess.OriX, Chess.INTERVAL * i + Chess.OriY, Chess.EndX, Chess.INTERVAL * i + Chess.OriY);
		}

		for (int j = 0; j <= Chess.TABLE_COL; j++) {
			g.drawLine(Chess.INTERVAL * j + Chess.OriX, Chess.OriY, Chess.INTERVAL * j + Chess.OriX, Chess.EndY);

		}
//		repaintTable();
		for (int r = 0; r < _chesstable.length; r++) {
			for (int c = 0; c < _chesstable.length; c++) {
				if (_chesstable[r][c] == 0) {
					continue;
				}
				if (_chesstable[r][c] == 1) {
					this.drawBlack(r, c);
				}
				if (_chesstable[r][c] == 2) {
					this.drawWhite(r, c);
				}
			}
		}
	}

	public void drawBlack(int chessR, int chessC) {
		int x = chessC * Chess.INTERVAL + Chess.OriX;
		int y = chessR * Chess.INTERVAL + Chess.OriY;
		this._g.setColor(Color.BLACK);
		this._g.fillOval(x - Chess.INTERVAL / 2, y - Chess.INTERVAL / 2, Chess.INTERVAL, Chess.INTERVAL);
	}

	public void drawWhite(int chessR, int chessC) {
		int x = chessC * Chess.INTERVAL + Chess.OriX;
		int y = chessR * Chess.INTERVAL + Chess.OriY;
		this._g.setColor(Color.WHITE);
		this._g.fillOval(x - Chess.INTERVAL / 2, y - Chess.INTERVAL / 2, Chess.INTERVAL, Chess.INTERVAL);
	}

//	public void repaint(Graphics g) {
//		repaintTable();
//	}
}
