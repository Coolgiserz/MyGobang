package com.coolcats1007;

import java.awt.Color;
import java.awt.Graphics;

public class ChessConfig {
	protected static int TABLE_ROW = 21;
	protected static int TABLE_COL = 21;
	protected static int CHESS_SIZE = 36;
	public String type;// 棋子类型
	public int x, y;// 棋子所在期盼行列号坐标

	public ChessConfig(int xx, int yy, String type) {
		this.type = type;
		this.x = xx;
		this.y = yy;
	}

	public void setConfig(String type) {
		this.type = type;

	}

	public static void drawchess(Graphics g, ChessConfig[][] chess) {
		for (int i = 0; i < ChessConfig.TABLE_ROW; i++) {
			for (int j = 0; j < ChessConfig.TABLE_COL; j++) {
				try {
					if (chess[i][j] != null) {
//						System.out.println(i+" "+j);
						if (chess[i][j].type.equals("黑棋")) {
							drawBlack(g, chess[i][j]);
						} else if (chess[i][j].type.equals("白棋")) {
							drawWhite(g, chess[i][j]);
						}
					}
				} catch (Exception ef) {
//					System.out.println(
//					ef.getMessage());
					// ef.printStackTrace();
				}

			}
		}

	}

	public static void drawBlack(Graphics g, ChessConfig chess) {
		for (int i = 0; i < 50; i++) {
			Color color = new Color(5 * i, 5 * i, 5 * i);
			g.setColor(color);
			g.fillArc(chess.x - (CHESS_SIZE - i) / 2, chess.y - (CHESS_SIZE - i) / 2, CHESS_SIZE - i, CHESS_SIZE - i, 0,
					360);
		}

	}

	public static void drawWhite(Graphics g, ChessConfig chess) {
		for (int i = 50; i > 0; i--) {
			Color color = new Color(255 - 5 * i, 255 - 5 * i, 255 - 5 * i);
			g.setColor(color);
			g.fillArc(chess.x - (CHESS_SIZE - i) / 2, chess.y - (CHESS_SIZE - i) / 2, CHESS_SIZE - i, CHESS_SIZE - i, 0,
					360);

		}

	}

}
