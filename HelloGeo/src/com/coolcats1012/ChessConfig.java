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
	public String type;// ��������
	public int x, y;// ���������������к�����
	public int row, col;// ���ӵ����кţ���0����
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
		this.setConfig("��");

	}

	/*
	 * ע����Ļ����ϵ����ѧ��Ĭ�ϵĵѿ�������ϵ�������᷽��ͬ ��Ļ���������Ͻ�Ϊԭ��
	 */
	public ChessConfig(String type, int row, int col) {
		this.type = type;
		this.row = row;
		this.col = col;
		this.x = oriX + col * INTERVAL;
		this.y = oriY + row * INTERVAL;

		if (this.type.equals("����")) {
			this.code = 1;
		} else if (this.type.equals("����")) {
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
				 * chess������Ȼ�Ѿ��������ڴ棬�����е�����Ԫ��Ĭ���������ȻΪ�ն����ܷ�ʹ��try catch�����쳣�ұ����׳��쳣��
				 */
//				try {
				if (chess != null) {
					if (chess[i][j] != null) {
//							System.out.println(i+" "+j);
						if (chess[i][j].type.equals("����")) {
							drawBlack(g, chess[i][j]);
						} else if (chess[i][j].type.equals("����")) {
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
	 * ����Ƿ����Ӯ�ң�ͨ���ж��ĸ��������Ƿ������������ͬ��ɫȡ��������ʵ��
	 * 
	 * @param row
	 * @param col
	 * @param chesstable
	 * @return ����false����û����Ӯ�ң�����true�����ѳ���Ӯ��
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
	 * ���ͬһ�����Ƿ������������ͬ��ɫ������
	 * 
	 * @param row        ��ʼ���ӵ��к�
	 * @param col        ��ʼ���ӵ��к�
	 * @param chesstable ���Ӷ�ά����
	 * @return
	 */
	public static int checkRow(int row, int col, ChessConfig[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = col + 1; i < TABLE_COL; i++) {
				if (chesstable[row][i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
					System.out.println("״̬<-��" + chesstable[row][col].type + " " + "��" + count);

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
					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
					System.out.println("״̬<-��" + chesstable[row][col].type + " " + "��" + count);

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
					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row + i][col + i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col - i) < 0) {
					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row - i][col - i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row + i][col - i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col + i) < 0 && Math.max(row - i, col + i) > TABLE_ROW) {
					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row - i][col + i].type.equals(chesstable[row][col].type)) {
					count++;
					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
