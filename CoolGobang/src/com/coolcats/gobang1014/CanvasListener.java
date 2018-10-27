package com.coolcats.gobang1014;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.JOptionPane;


/**
 * �����ʼ��Ϸ��ť�󣬿�ʼʵ��������Ķ��� �����������飬ÿ����һ�AI���Ӽ������Ӽ��뵽���������У���¼���ӵ����кš��ڰ���
 * 
 * @author CoolCats
 *
 */
public class CanvasListener extends MouseAdapter {
	final static int BLACK_SIDE = 1;
	final static int WHITE_SIDE = -1;
	private int _x, _y;// ���ڼ�¼�����������
	public static  int[][] _chesstable;// �������飬����Ϊ0����գ�1������壬2�������
	public static int turnState = BLACK_SIDE;// ���ڱ�ʾ��ǰ�ֵ���һ�����ӣ�1����ڷ�
	ChessPanel _buddyChessPanel;
	LabelPanel _buddyLabPanel;
	CoolFrame _buddyFrame;
	private AIplayer ai_player;
	private WeigthPlayer weightAI;
//	public static Stack<Point> tmpchess = new Stack<>();

	public CanvasListener() {
		

	}
//	public void initChessTable() {
//		System.out.println("initTable:"+this._chesstable+"�����ȣ�");
//		for(int i=0;i<this._chesstable.length;i++) {
//			for(int j=0;j<this._chesstable.length;j++) {
//				_chesstable[i][j] = 0;
//			}
//		}
//	}
//	
	public static void initChessTable() {
		_chesstable = new int[Chess.TABLE_ROW + 1][Chess.TABLE_COL + 1];

		System.out.println("initTable:"+_chesstable+"�����ȣ�");
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
	 * ����������¼���
	 * Ҫ�ڿ�ʼ����Ϸ��ť���������ܱ�����
	 * ���ݵ�ǰ��ѡ�����Ϸģʽ���������߼�
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
		// ��ʱ��������Ϊtrue���Ժ������ֺ��ֵ�����
		if (true) {
			// ������ѡ���ģʽ�����˶�ս or �˻���ս��������ʵ��
			switch (LabelListener._mode) {
			// ���˶�սģʽ
			case LabelListener.MODE_PP:
//				System.out.println("���˶�սģʽ����");
				
				if (turnState == BLACK_SIDE && _chesstable[chessR][chessC] == 0) {
					_chesstable[chessR][chessC] = 1;
					this._buddyChessPanel.drawBlack(chessR, chessC);
					//���������鴫��ChessPanel���Ա�����ӽ����ػ�
					this._buddyChessPanel.setBuddyTable(_chesstable);
					LabelListener._tmpchess.add(new Point(chessR,chessC));
					/*
					 * �ж��Ƿ����Ӯ��
					 */          
					boolean status = checkWin(chessR, chessC, _chesstable);
					if (status == true) {
//						System.out.println("����Ӯ");
						JOptionPane.showMessageDialog(this._buddyFrame, "����ʤ");
					} else {
						System.out.println("�ֵ�����");
						turnState = WHITE_SIDE;
						_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener._turn,LabelListener.WHITE_SIDE);
//						System.exit(0);

					}

				} else if (turnState == WHITE_SIDE && _chesstable[chessR][chessC] == 0) {
					_chesstable[chessR][chessC] = 2;
					this._buddyChessPanel.drawWhite(chessR, chessC);
					LabelListener._tmpchess.add(new Point(chessR,chessC));

					/*
					 * �ж��Ƿ����Ӯ��
					 */
					boolean status = checkWin(chessR, chessC, _chesstable);
					if (status == true) {
						System.out.println("����Ӯ");
						JOptionPane.showMessageDialog(this._buddyFrame, "����ʤ");

					} else {
						turnState = BLACK_SIDE;
						LabelListener._turn++;
						System.out.println(_buddyLabPanel);
						_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener._turn,LabelListener.BLACK_SIDE);
						System.out.println("�ֵ�����");

					}
//						System.exit(0);

				}

				break;
			// �˻���սģʽ
			case LabelListener.MODE_PM:
//				System.out.println("�˻���սģʽ����");
				System.out.println(LabelListener.MODE_AISECOND);
				if(LabelListener.ai_mode.equals(LabelListener.MODE_AISECOND)) {
				//AI����ʱ
					switch(LabelListener.selectedValue) {
					case "Ȩֵ��":
						weightAI = new WeigthPlayer();// ʵ����Ȩֵ��AI����

						if (turnState == BLACK_SIDE && _chesstable[chessR][chessC] == 0) {
							_chesstable[chessR][chessC] = 1;
							this._buddyChessPanel.drawBlack(chessR, chessC);
							LabelListener._tmpchess.add(new Point(chessR,chessC));

							//���������鴫��ChessPanel���Ա�����ӽ����ػ�
							this._buddyChessPanel.setBuddyTable(_chesstable);
							/*
							 * �ж��Ƿ����Ӯ��
							 */
							boolean status = checkWin(chessR, chessC, _chesstable);
							if (status == true) {
//								System.out.println("����Ӯ");
								JOptionPane.showMessageDialog(this._buddyFrame, "����ʤ");
							} else {//����AI�㷨
								System.out.println("�ֵ�����");
								turnState = WHITE_SIDE;
								_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener.selectedValue,LabelListener._turn,LabelListener.WHITE_SIDE);
								System.out.println("...Ȩֵ��AI˼����...");
								weightAI.getCurrentTable(_chesstable);
								Point pt = weightAI.CalcRC();
								_chesstable[pt.x][pt.y] = 2;
								this._buddyChessPanel.drawWhite(pt.x, pt.y);
								this._buddyChessPanel.setBuddyTable(_chesstable);
								LabelListener._tmpchess.add(new Point(pt.x,pt.y));

								status = checkWin(pt.x, pt.y, _chesstable);
								if (status == true) {
//									System.out.println("����Ӯ");
									JOptionPane.showMessageDialog(this._buddyFrame, "����ʤ");
								}

								turnState = BLACK_SIDE;
								LabelListener._turn++;
							}
							_buddyLabPanel.setStatusLabel(LabelListener._mode,LabelListener.selectedValue,LabelListener._turn,LabelListener.BLACK_SIDE);


						} 
						
						break;
					case "������":
						System.out.println("...������AI˼����...");

						break;
					case "����ѧϰ":
						break;
					}
				}else if(LabelListener.ai_mode.equals(LabelListener.MODE_AIFIRST)) {
				//AI����ʱ
					
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
	 * ���ĸ��������ж��Ƿ����ͬɫ����������
	 * 
	 * @param chessR           ��ǰ���������к�
	 * @param chessC           ��ǰ���������к�
	 * @param chesstable��ǰ���̾���
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
//					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
//					System.out.println("״̬<-��" + chesstable[row][col].type + " " + "��" + count);

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
//					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
//					System.out.println("״̬<-��" + chesstable[row][col].type + " " + "��" + count);

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
//					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row + i][col + i]==chesstable[row][col]) {
					count++;
//					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

				} else {
					break;
				}
			}

		
		
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col - i) < 0) {
//					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row - i][col - i]==(chesstable[row][col])) {
					count++;
//					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

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
//					System.out.println("״̬�жϣ�"+chesstable[row][col].type+" "+"��"+count);

				break;
			}
			if (chesstable[row + i][col - i] == chesstable[row][col]) {
				count++;
//					System.out.println("״̬->��"+chesstable[row][col].type+" "+"��"+count);

			} else {
				break;
			}
		}

	
			for (int i = 1; i < 5; i++) {
				if (Math.min(row - i, col + i) < 0 || Math.max(row - i, col + i) > Chess.TABLE_ROW) {
//					System.out.println("״̬�жϣ�" + chesstable[row][col].type + " " + "��" + count);

					break;
				}
				if (chesstable[row - i][col + i]==chesstable[row][col]) {
					count++;
//					System.out.println("״̬->��" + chesstable[row][col].type + " " + "��" + count);

				} else {
					break;
				}
			}
		
		return count;
	}
}
