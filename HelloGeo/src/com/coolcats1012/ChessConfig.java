package com.coolcats1012;

import java.awt.Color;
import java.awt.Graphics;

public class ChessConfig {
	protected static int TABLE_ROW = 21;
	protected static int TABLE_COL = 21;
	protected static int CHESS_SIZE = 36;
	private static int oriX = 100;
	private static int oriY = 100;
	private static int endX = 900;
	private static int endY = 900;
	private static int INTERVAL = 40;
//	private ChessConfig[][] chesstable;
	public String type;// 棋子类型
	public int x, y;// 棋子所在期盼行列号坐标
	public int row, col;// 棋子的行列号，从0起算
	public int code;

	public ChessConfig(int xx, int yy, String type) {
		this.type = type;
		this.x = xx;
		this.y = yy;
		this.row = (yy - oriY) / INTERVAL;
		this.col = (xx - oriX) / INTERVAL;

	}

	public ChessConfig(int code) {
		this.code = code;
		this.setConfig("空");

	}

	/*
	 * 注意屏幕坐标系与数学上默认的笛卡尔坐标系的坐标轴方向不同 屏幕坐标以左上角为原点
	 */
	public ChessConfig(String type, int row, int col) {
		this.type = type;
		this.row = row;
		this.col = col;
		this.x = oriX + col * INTERVAL;
		this.y = oriY + row * INTERVAL;

		if (this.type.equals("黑棋")) {
			this.code = 1;
		} else if (this.type.equals("白棋")) {
			this.code = 2;
		} else {
			this.code = 0;
		}

	}

	public String toString() {
		return this.type+":"+this.row+","+this.col;
	}
	
	public void setConfig(String type) {
		this.type = type;

	}

	public static void drawchess(Graphics g, ChessConfig[][] chess) {
		for (int i = 0; i < ChessConfig.TABLE_ROW; i++) {
			for (int j = 0; j < ChessConfig.TABLE_COL; j++) {
				/*
				 * chess数组虽然已经分配了内存，但其中的数组元素默认情况下仍然为空对象，能否不使用try catch捕获异常且避免抛出异常？
				 */
//				try {
				if (chess != null) {
					if (chess[i][j] != null) {
//							System.out.println(i+" "+j);
						if (chess[i][j].type.equals("黑棋")) {
							drawBlack(g, chess[i][j]);
						} else if (chess[i][j].type.equals("白棋")) {
							drawWhite(g, chess[i][j]);
						}
					}
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

	/**
	 * 检查是否出现赢家，通过判断四个方向上是否有连续五个相同颜色取得棋子来实现
	 * 
	 * @param row
	 * @param col
	 * @param chesstable
	 * @return 返回false代表还没出现赢家，返回true代表已出现赢家
	 */
	public static boolean checkWin(int row, int col, ChessConfig[][] chesstable) {
		int count_row = checkRow(row, col, chesstable);
		int count_col = checkCol(row, col, chesstable);
		int count_right_down = checkRightDown(row, col, chesstable);
		int count_left_down = checkLeftDown(row, col, chesstable);
		if (count_row >= 5 || count_col >= 5 || count_right_down >= 5 || count_left_down >= 5) {
			return true;
		}
		return false;

	}

	/**
	 * 检查同一行上是否有连续五颗相同颜色的棋子
	 * 
	 * @param row        起始棋子的行号
	 * @param col        起始棋子的列号
	 * @param chesstable 棋子二维数组
	 * @return
	 */
	public static int checkRow(int row, int col, ChessConfig[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = col + 1; i < TABLE_COL; i++) {
				if (chesstable[row][i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = col - 1; i >= 0; i--) {
				if (chesstable[row][i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态<-：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		} catch (Exception ef) {

		}

		return count;
	}

	public static int checkCol(int row, int col, ChessConfig[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = row + 1; i < TABLE_ROW; i++) {
				if (chesstable[i][col].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = row - 1; i >= 0; i--) {
				if (chesstable[i][col].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态<-：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		} catch (Exception ef) {

		}
		return count;
	}

	public static int checkRightDown(int row, int col, ChessConfig[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = 1; i < 5; i++) {
				if (Math.max(row + i, col + i) > TABLE_ROW) {
					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row + i][col + i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col - i) < 0) {
					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row - i][col - i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		} catch (Exception ef) {

		}
		return count;
	}

	public static int checkLeftDown(int row, int col, ChessConfig[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = 1; i < 5; i++) {
				if (Math.max(row + i, col - i) > TABLE_ROW && Math.min(row + i, col - i) < 0) {
					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row + i][col - i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col + i) < 0 && Math.max(row - i, col + i) > TABLE_ROW) {
					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row - i][col + i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		} catch (Exception ef) {

		}
		return count;
	}

	public void setCoord(int xx, int yy) {
		this.x = xx;
		this.y = yy;
		this.row = (yy - oriY) / INTERVAL;
		this.col = (xx - oriX) / INTERVAL;
	}

}
