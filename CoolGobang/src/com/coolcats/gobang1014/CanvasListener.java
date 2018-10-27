package com.coolcats.gobang1014;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JOptionPane;


/**
 * 点击开始游戏按钮后，开始实例化该类的对象 创建棋盘数组，每当玩家或AI落子即将棋子加入到棋盘数组中，记录棋子的行列号、黑白棋
 * 
 * @author CoolCats
 *
 */
public class CanvasListener extends MouseAdapter {
	final static int BLACK_SIDE = 1;
	final static int WHITE_SIDE = -1;
	private int _x, _y;// 用于记录鼠标点击的坐标
	public static  int[][] _chesstable;// 棋子数组，其中为0代表空，1代表黑棋，2代表白棋
	public static int turnState = BLACK_SIDE;// 用于表示当前轮到哪一方落子，1代表黑方
	ChessPanel _buddyChessPanel;
	LabelPanel _buddyLabPanel;
	CoolFrame _buddyFrame;
	private AIplayer ai_player;
	private WeigthPlayer weightAI;
//	public static Stack<Point> tmpchess = new Stack<>();

	public CanvasListener() {
		

	}
//	public void initChessTable() {
//		System.out.println("initTable:"+this._chesstable+"。长度：");
//		for(int i=0;i<this._chesstable.length;i++) {
//			for(int j=0;j<this._chesstable.length;j++) {
//				_chesstable[i][j] = 0;
//			}
//		}
//	}
//	
	public static void initChessTable() {
		_chesstable = new int[Chess.TABLE_ROW + 1][Chess.TABLE_COL + 1];

		System.out.println("initTable:"+_chesstable+"。长度：");
		for(int i=0;i<_chesstable.length;i++) {
			for(int j=0;j<_chesstable.length;j++) {
				_chesstable[i][j] = 0;
			}
		}
	}
	public void setAI(AIplayer player) {
		System.out.println(player);
		this.ai_player = player;
	}
	/**
	 * 处理鼠标点击事件：
	 * 要在开始新游戏按钮被点击后才能被触发
	 * 根据当前所选择的游戏模式处理落子逻辑
	 * 
	 */
	public void mouseClicked(MouseEvent e) {
		_x = e.getX();
		_y = e.getY();
		int chessR = (_y - Chess.OriY) / Chess.INTERVAL;
		int chessC = (_x - Chess.OriX) / Chess.INTERVAL;
		int modR = (_y - Chess.OriY) % Chess.INTERVAL;
		int modC = (_x - Chess.OriX) % Chess.INTERVAL;

		if (modR > Chess.INTERVAL / 2) {
			chessR++;
		}
		if (modC > Chess.INTERVAL / 2) {
			chessC++;
		}
		if(chessC<0||chessC>Chess.TABLE_COL||chessR<0||chessR>Chess.TABLE_ROW) {
			return;
		}
		System.out.println(new Point(chessR, chessC));

		System.out.println(new Point(_x, _y));
		// 暂时设置条件为true，以后考虑先手后手的问题
		if (true) {
			// 根据所选择的模式（人人对战 or 人机对战）来进行实现
			switch (LabelListener._mode) {
			// 人人对战模式
			case LabelListener.MODE_PP:
//				System.out.println("人人对战模式开启");
				
				if (turnState == BLACK_SIDE && _chesstable[chessR][chessC] == 0) {
					_chesstable[chessR][chessC] = 1;
					this._buddyChessPanel.drawBlack(chessR, chessC);
					//将棋子数组传到ChessPanel处以便对棋子进行重绘
					this._buddyChessPanel.setBuddyTable(_chesstable);
					LabelListener._tmpchess.add(new Point(chessR,chessC));
					/*
					 * 判断是否出现赢家
					 */          
					boolean status = checkWin(chessR, chessC, _chesstable);
					if (status == true) {
//						System.out.println("黑棋赢");
						JOptionPane.showMessageDialog(this._buddyFrame, "黑棋胜");
					} else {
						System.out.println("轮到白棋");
						turnState = WHITE_SIDE;
						_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener._turn,LabelListener.WHITE_SIDE);
//						System.exit(0);

					}

				} else if (turnState == WHITE_SIDE && _chesstable[chessR][chessC] == 0) {
					_chesstable[chessR][chessC] = 2;
					this._buddyChessPanel.drawWhite(chessR, chessC);
					LabelListener._tmpchess.add(new Point(chessR,chessC));

					/*
					 * 判断是否出现赢家
					 */
					boolean status = checkWin(chessR, chessC, _chesstable);
					if (status == true) {
						System.out.println("白棋赢");
						JOptionPane.showMessageDialog(this._buddyFrame, "白棋胜");

					} else {
						turnState = BLACK_SIDE;
						LabelListener._turn++;
						System.out.println(_buddyLabPanel);
						_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener._turn,LabelListener.BLACK_SIDE);
						System.out.println("轮到黑棋");

					}
//						System.exit(0);

				}

				break;
			// 人机对战模式
			case LabelListener.MODE_PM:
//				System.out.println("人机对战模式开启");
				System.out.println(LabelListener.MODE_AISECOND);
				if(LabelListener.ai_mode.equals(LabelListener.MODE_AISECOND)) {
				//AI后手时
					switch(LabelListener.selectedValue) {
					case "权值法":
						weightAI = new WeigthPlayer();// 实例化权值法AI对象

						if (turnState == BLACK_SIDE && _chesstable[chessR][chessC] == 0) {
							_chesstable[chessR][chessC] = 1;
							this._buddyChessPanel.drawBlack(chessR, chessC);
							LabelListener._tmpchess.add(new Point(chessR,chessC));

							//将棋子数组传到ChessPanel处以便对棋子进行重绘
							this._buddyChessPanel.setBuddyTable(_chesstable);
							/*
							 * 判断是否出现赢家
							 */
							boolean status = checkWin(chessR, chessC, _chesstable);
							if (status == true) {
//								System.out.println("黑棋赢");
								JOptionPane.showMessageDialog(this._buddyFrame, "黑棋胜");
							} else {//进入AI算法
								System.out.println("轮到白棋");
								turnState = WHITE_SIDE;
								_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener.selectedValue,LabelListener._turn,LabelListener.WHITE_SIDE);
								System.out.println("...权值法AI思考中...");
								weightAI.getCurrentTable(_chesstable);
								Point pt = weightAI.CalcRC();
								_chesstable[pt.x][pt.y] = 2;
								this._buddyChessPanel.drawWhite(pt.x, pt.y);
								this._buddyChessPanel.setBuddyTable(_chesstable);
								LabelListener._tmpchess.add(new Point(pt.x,pt.y));

								status = checkWin(pt.x, pt.y, _chesstable);
								if (status == true) {
//									System.out.println("白棋赢");
									JOptionPane.showMessageDialog(this._buddyFrame, "白棋胜");
								}

								turnState = BLACK_SIDE;
								LabelListener._turn++;
							}
							_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener.selectedValue,LabelListener._turn,LabelListener.BLACK_SIDE);


						} 
						
						break;
					case "博弈树":
						System.out.println("...博弈树AI思考中...");

						break;
					case "机器学习":
						break;
					}
				}else if(LabelListener.ai_mode.equals(LabelListener.MODE_AIFIRST)) {
				//AI先手时
					
				}
			
				break;
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */

	public void setBuddy(CoolFrame f) {
		this._buddyFrame = f;
	}

	public void setBuddy(LabelPanel p) {
		this._buddyLabPanel = p;
	}

	public void setBuddy(ChessPanel p) {
		this._buddyChessPanel = p;
	}

	public int getTurn() {
		return turnState;
	}

	/**
	 * 在四个方向上判断是否出现同色的五子连珠
	 * 
	 * @param chessR           当前落子所在行号
	 * @param chessC           当前落子所在列号
	 * @param chesstable当前棋盘局势
	 * @return
	 */
	public boolean checkWin(int chessR, int chessC, int[][] chesstable) {
		int count_row = checkRow(chessR, chessC, chesstable);
		int count_col = checkCol(chessR, chessC, chesstable);
		int count_right_down = checkRightDown(chessR, chessC, chesstable);
		int count_left_down = checkLeftDown(chessR, chessC, chesstable);
		if (count_row >= 5 || count_col >= 5 || count_right_down >= 5 || count_left_down >= 5) {
			return true;
		}
		return false;
	}

	public static int checkRow(int row, int col, int[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = col + 1; i < Chess.TABLE_COL; i++) {
				if (chesstable[row][i]==chesstable[row][col]) {
					count++;
//					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = col - 1; i >= 0; i--) {
				if (chesstable[row][i]==chesstable[row][col]) {
					count++;
//					System.out.println("状态<-：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		} catch (Exception ef) {

		}

		return count;
	}

	public static int checkCol(int row, int col, int[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
		try {
			for (int i = row + 1; i < Chess.TABLE_ROW; i++) {
				if (chesstable[i][col]==chesstable[row][col]) {
					count++;
//					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		} catch (Exception ef) {

		}
		try {
			for (int i = row - 1; i >= 0; i--) {
				if (chesstable[i][col]==chesstable[row][col]) {
					count++;
//					System.out.println("状态<-：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		} catch (Exception ef) {

		}
		return count;
	}

	public static int checkRightDown(int row, int col, int[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);
	
			for (int i = 1; i < 5; i++) {
				if (Math.max(row + i, col + i) > Chess.TABLE_ROW) {
//					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row + i][col + i]==chesstable[row][col]) {
					count++;
//					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}

		
		
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col - i) < 0) {
//					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row - i][col - i]==(chesstable[row][col])) {
					count++;
//					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
	
		return count;
	}

	public static int checkLeftDown(int row, int col, int[][] chesstable) {
		int count = 1;
//		System.out.println(chesstable.length);

		for (int i = 1; i < 5; i++) {
			if (Math.max(row + i, col - i) > Chess.TABLE_ROW || Math.min(row + i, col - i) < 0) {
//					System.out.println("状态中断："+chesstable[row][col].type+" "+"："+count);

				break;
			}
			if (chesstable[row + i][col - i] == chesstable[row][col]) {
				count++;
//					System.out.println("状态->："+chesstable[row][col].type+" "+"："+count);

			} else {
				break;
			}
		}

	
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col + i) < 0 || Math.max(row - i, col + i) > Chess.TABLE_ROW) {
//					System.out.println("状态中断：" + chesstable[row][col].type + " " + "：" + count);

					break;
				}
				if (chesstable[row - i][col + i]==chesstable[row][col]) {
					count++;
//					System.out.println("状态->：" + chesstable[row][col].type + " " + "：" + count);

				} else {
					break;
				}
			}
		
		return count;
	}
}
