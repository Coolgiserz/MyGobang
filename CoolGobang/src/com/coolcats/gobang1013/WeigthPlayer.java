package com.coolcats.gobang1013;

import java.awt.Point;
import java.util.HashMap;

/**
 * 权重法AI玩家
 * 
 * @author CoolCats
 *
 */
public class WeigthPlayer extends AIplayer {

	private final static int HUO_1 = 10;
	private final static int HUO_2 = 100;
	private final static int HUO_3 = 10000;
	private final static int HUO_4 = 20000;
	private final static int MIAN_1 = 1;
	private final static int MIAN_2 = 50;
	private final static int MIAN_3 = 5500;
	private final static int MIAN_4 = 20000;
	private final static int SI_1 = 1;
	private final static int SI_2 = 5;
	private final static int SI_3 = 8;
	private final static int SI_4 = 10;
	int[][] _chesstable;
	// 定义权值与棋形的HashMap
	static HashMap<String, Integer> map = new HashMap<String, Integer>();// 存储棋子相连情况以及对应的权值

	static {
		map.put("010", HUO_1); // 活1连

		map.put("012", MIAN_1); // 眠1连
		map.put("210", MIAN_1); // 眠1连

		map.put("0110", HUO_2); // 活2连
		map.put("01010", HUO_2); // 活2连

		map.put("0112", MIAN_2); // 眠2连
		map.put("0110", MIAN_1); // 眠2连
		map.put("2110", MIAN_1); // 眠2连

		map.put("01110", HUO_3); // 活3连
		map.put("011010", HUO_3); // 活3连
		map.put("010110", HUO_3); // 活3连
		map.put("02220", HUO_3); // 活3连

		
		map.put("01112", MIAN_3); // 眠3连
		map.put("21110", MIAN_3); // 眠3连

		map.put("011110", HUO_4); // 活4连
		map.put("022220", HUO_3); // 活4连

		map.put("011112", MIAN_4); // 眠4连
		map.put("211110", MIAN_4); // 眠4连
		
		map.put("0111010", MIAN_4); // 眠4连
		map.put("0111012", MIAN_4); // 眠4连
		map.put("2111010", MIAN_4); // 眠4连
		
		map.put("0101110", MIAN_4); // 眠4连
		map.put("2101110", MIAN_4); // 眠4连
		map.put("0101112", MIAN_4); // 眠4连
		map.put("2110110", MIAN_4); // 眠4连
		map.put("0110112", MIAN_4); // 眠4连


		map.put("21112", SI_3); // 死3连

		map.put("211112", SI_4); // 死4连


	}

	int[][] _weightTable = new int[Chess.TABLE_ROW+1][Chess.TABLE_COL+1];// 权值数组，用于存储棋盘可落子位置的权值

	public WeigthPlayer() {
		this._mode = AIplayer.Weight_Player;
		_chesstable = new int[Chess.TABLE_ROW][Chess.TABLE_COL];
	}

	private void printCurrentTable() {
		for (int i = 0; i < this._chesstable.length; i++) {
			for (int j = 0; j < this._chesstable.length; j++) {
				System.out.print(this._chesstable[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void printWeightTable() {
		int count = 0;
		for (int i = 0; i < this._weightTable.length; i++) {
			System.out.print("行"+count+":");
			for (int j = 0; j < this._weightTable.length; j++) {
				System.out.print( this._weightTable[i][j] + "   ");
			}
			count++;
			System.out.println();
		}
	}
	public void getCurrentTable(int[][] table) {
		this._chesstable = table;
		printCurrentTable();
	}

	/**
	 * 计算当前棋盘局势
	 * 
	 * @return 返回落子行列号
	 */
	public Point CalcRC() {
		initWeight();
		for (int r = 0; r < this._chesstable.length; r++) {
			for (int c = 0; c < this._chesstable.length; c++) {
				// (r,c)位置没有棋子的时候
				if (_chesstable[r][c] == 0) {
					String code = "0";
					int number = 0;
					int chess = 0;
					// 从(r,c-1)开始水平向左扫描到(r,0)为止
					for(int c1=c-1;c1>=0;c1--) {
						if(this._chesstable[r][c1]==0){
							if(c==c1+1) {//往左扫描出现连续两个空格
								break;
							}else if(number==0) {//表示没有出现连续两个空格
								code = code + this._chesstable[r][c1];
								number++;
							}else if(number==1) {
								if(this._chesstable[r][c1]==this._chesstable[r][c1+1]) {
									break;
								}
								code = code + this._chesstable[r][c1];
								number++;
							}else if(number==2) {
								if(this._chesstable[r][c1]==this._chesstable[r][c1+1]) {
									break;
								}
					
							}
							
						}else{
							if(chess==0) {
								//第一次出现棋子的时候
								chess = this._chesstable[r][c1];//记录第一次出现的棋子颜色
								code = code + this._chesstable[r][c1];
							}else if(chess == this._chesstable[r][c1]) {
								//和上一次的颜色相同
								code = code + this._chesstable[r][c1];
							}else {
								//和上一位置的棋子颜色不同
								code = code + this._chesstable[r][c1];
								break;
							}
						}
					}
					Integer v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
//					
					//从(r,c+1)开始水平向右扫描到(r,maxC)为止
					for(int c1=c+1;c1<=Chess.TABLE_COL;c1++) {
						if(this._chesstable[r][c1]==0){
							if(c==c1-1) {//往右扫描出现连续两个空格
								break;
							}else if(number==0) {//表示没有出现连续两个空格
								code = code + this._chesstable[r][c1];
								number++;
							}else if(number==1) {
								if(this._chesstable[r][c1]==this._chesstable[r][c1-1]) {
									break;
								}
								code = code + this._chesstable[r][c1];
								number++;
							}else if(number==2) {
								if(this._chesstable[r][c1]==this._chesstable[r][c1-1]) {
									break;
								}
					
							}
							
						}else{
							if(chess==0) {
								//第一次出现棋子的时候
								chess = this._chesstable[r][c1];//记录第一次出现的棋子颜色
								code = code + this._chesstable[r][c1];
							}else if(chess == this._chesstable[r][c1]) {
								//和上一次的颜色相同
								code = code + this._chesstable[r][c1];
							}else {
								//和上一位置的棋子颜色不同
								code = code + this._chesstable[r][c1];
								break;
							}
						}
					}
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
//					
					//从(r-1,c)开始垂直向上扫描到(0,c)为止
					for(int r1=r-1;r1>=0;r1--) {
						if(this._chesstable[r1][c]==0){
							if(r==r1+1) {//往右扫描出现连续两个空格
								break;
							}else if(number==0) {//表示没有出现连续两个空格
								code = code + this._chesstable[r1][c];
								number++;
							}else if(number==1) {
								if(this._chesstable[r1][c]==this._chesstable[r1+1][c]) {
									break;
								}
								code = code + this._chesstable[r1+1][c];
								number++;
							}else if(number==2) {
								if(this._chesstable[r1][c]==this._chesstable[r1+1][c]) {
									break;
								}
					
							}
							
						}else{
							if(chess==0) {
								//第一次出现棋子的时候
								chess = this._chesstable[r1][c];//记录第一次出现的棋子颜色
								code = code + this._chesstable[r1][c];
							}else if(chess == this._chesstable[r1][c]) {
								//和上一次的颜色相同
								code = code + this._chesstable[r1][c];
							}else {
								//和上一位置的棋子颜色不同
								code = code + this._chesstable[r1][c];
								break;
							}
						}
					}
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
					//					
					//从(r+1,c)开始垂直向下扫描到(maxR,c)为止
					for(int r1=r+1;r1<=Chess.TABLE_ROW;r1++) {
						if(this._chesstable[r1][c]==0){
							if(r==r1-1) {//往右扫描出现连续两个空格
								break;
							}else if(number==0) {//表示没有出现连续两个空格
								code = code + this._chesstable[r1][c];
								number++;
							}else if(number==1) {
								if(this._chesstable[r1][c]==this._chesstable[r1-1][c]) {
									break;
								}
								code = code + this._chesstable[r1-1][c];
								number++;
							}else if(number==2) {
								if(this._chesstable[r1][c]==this._chesstable[r1-1][c]) {
									break;
								}
					
							}
							
						}else{
							if(chess==0) {
								//第一次出现棋子的时候
								chess = this._chesstable[r1][c];//记录第一次出现的棋子颜色
								code = code + this._chesstable[r1][c];
							}else if(chess == this._chesstable[r1][c]) {
								//和上一次的颜色相同
								code = code + this._chesstable[r1][c];
							}else {
								//和上一位置的棋子颜色不同
								code = code + this._chesstable[r1][c];
								break;
							}
						}
					}
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
					// 从(r+1,c+1)开始斜向右下扫描到边界为止

//					int delta = Math.min(Chess.TABLE_ROW - r, Chess.TABLE_COL);// 获取右下角与(r,c)垂直距离中最小那个
					for (int d = 1; d <= 6; d++) {
						if(Math.max(r+d, c+d)>Chess.TABLE_ROW) {
							break;
						}
						if (this._chesstable[r+d][c+d] == 0) {// (r+d,c+d)是空格
							if ((r==r+d-1)&&(c==c+d-1)) {// 斜向右下連續出現兩個空格
								break;
							} else if (number == 0) {// 出现第一个空格
								code = code + this._chesstable[r+d][c+d];
								number++;
							} else if (number == 1) {// 出现两个空格
								if (this._chesstable[r+d][c+d] == this._chesstable[r+d-1][c+d-1]) {
									break;
								}
								code = code + this._chesstable[r+d-1][c+d-1];
								number++;
							} else if (number == 2) {
								if (this._chesstable[r+d][c+d] == this._chesstable[r+d-1][c+d-1]) {
									break;
								}
							}
						} else {
							if (chess == 0) {
								// 第一次出现棋子的时候
								chess = this._chesstable[r + d][c + d];// 记录第一次出现的棋子颜色
								code = code + this._chesstable[r + d][c + d];
							} else if (chess == this._chesstable[r + d][c + d]) {
								// 和上一次的颜色相同
								code = code + this._chesstable[r + d][c + d];
							} else {
								// 和上一位置的棋子颜色不同
								code = code + this._chesstable[r + d][c + d];
								break;

							}
						}

					}
					
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
					// 从(r-1,c-1)开始斜向左上扫描到(0,c)为止
//					int delta = Math.min(Chess.TABLE_ROW - r, Chess.TABLE_COL);// 获取右下角与(r,c)垂直距离中最小那个
					for (int d = 1; d <= 6; d++) {
//						System.out.println(d);
						if(Math.min(r-d, c-d)<0) {
							break;
						}
						if (this._chesstable[r-d][c-d] == 0) {// (r+d,c+d)是空格
							if ((r==r-d+1)&&(c==c-d+1)) {// 斜向右下連續出現兩個空格
								break;
							} else if (number == 0) {// 出现第一个空格
								code = code + this._chesstable[r-d][c-d];
								number++;
							} else if (number == 1) {// 出现两个空格
								if (this._chesstable[r-d][c-d] == this._chesstable[r-d+1][c-d+1]) {
									break;
								}
								code = code + this._chesstable[r-d+1][c-d+1];
								number++;
							} else if (number == 2) {
								if (this._chesstable[r-d][c-d] == this._chesstable[r-d+1][c-d+1]) {
									break;
								}
							}
						} else {
							if (chess == 0) {
								// 第一次出现棋子的时候
								chess = this._chesstable[r - d][c - d];// 记录第一次出现的棋子颜色
								code = code + this._chesstable[r - d][c - d];
							} else if (chess == this._chesstable[r - d][c - d]) {
								// 和上一次的颜色相同
								code = code + this._chesstable[r - d][c - d];
							} else {
								// 和上一位置的棋子颜色不同
								code = code + this._chesstable[r - d][c - d];
								break;

							}
						}

					}
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
					// 从(r-1,c+1)开始斜向右上扫描到(0,c)为止
					for (int d = 1; d <= 5; d++) {
//						System.out.println(d);
						if(Math.min(r-d, c+d)<0 || Math.max(r-d, c+d)>Chess.TABLE_ROW) {
							break;
						}
						if (this._chesstable[r-d][c+d] == 0) {// (r+d,c+d)是空格
							if ((r==r-d+1)&&(c==c+d-1)) {// 斜向右下連續出現兩個空格
								break;
							} else if (number == 0) {// 出现第一个空格
								code = code + this._chesstable[r-d][c+d];
								number++;
							} else if (number == 1) {// 出现两个空格
								if (this._chesstable[r-d][c+d] == this._chesstable[r-d+1][c+d-1]) {
									break;
								}
								code = code + this._chesstable[r-d+1][c+d-1];
								number++;
							} else if (number == 2) {
								if (this._chesstable[r-d][c+d] == this._chesstable[r-d+1][c+d-1]) {
									break;
								}
							}
						} else {
							if (chess == 0) {
								// 第一次出现棋子的时候
								chess = this._chesstable[r - d][c + d];// 记录第一次出现的棋子颜色
								code = code + this._chesstable[r - d][c + d];
							} else if (chess == this._chesstable[r - d][c + d]) {
								// 和上一次的颜色相同
								code = code + this._chesstable[r - d][c + d];
							} else {
								// 和上一位置的棋子颜色不同
								code = code + this._chesstable[r - d][c + d];
								break;

							}
						}

					}
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
//					 从(r+1,c-1)开始斜向左下扫描到边界为止
					for (int d = 1; d <= 5; d++) {
						if(Math.min(r+d, c-d)<0 || Math.max(r+d, c-d)>Chess.TABLE_ROW) {
							break;
						}
						if (this._chesstable[r+d][c-d] == 0) {// (r+d,c-d)是空格
							if ((r==r+d-1)&&(c==c-d+1)) {// 斜向右下連續出現兩個空格
								break;
							} else if (number == 0) {// 出现第一个空格
								code = code + this._chesstable[r+d][c-d];
								number++;
							} else if (number == 1) {// 出现两个空格
								if (this._chesstable[r+d][c-d] == this._chesstable[r+d-1][c-d+1]) {
									break;
								}
								code = code + this._chesstable[r+d-1][c-d+1];
								number++;
							} else if (number == 2) {
								if (this._chesstable[r+d][c-d] == this._chesstable[r+d-1][c-d+1]) {
									break;
								}
							}
						} else {
							if (chess == 0) {
								// 第一次出现棋子的时候
								chess = this._chesstable[r+d][c-d];// 记录第一次出现的棋子颜色
								code = code + this._chesstable[r+d][c-d];
							} else if (chess == this._chesstable[r+d][c-d]) {
								// 和上一次的颜色相同
								code = code + this._chesstable[r+d][c-d];
							} else {
								// 和上一位置的棋子颜色不同
								code = code + this._chesstable[r+d][c-d];
								break;

							}
						}

					}
					v = map.get(code);
					if(v!=null) {
						_weightTable[r][c]+=v;
					}
//					if (!code.equals("0")&&!code.equals("00")) {
//						System.out.println("CODE:" + code);
//					}
//					System.out.println("NUMBER:"+number);

				}

			}
		}
		System.out.println("-------------");
		printWeightTable();
		return getRC();

	}
	private void initWeight() {
		for(int i=0;i<_weightTable.length;i++) {
			for(int j=0;j<_weightTable.length;j++) {
				_weightTable[i][j]=0;
			}
		}
	}
	private Point getRC() {
		int r = 0,c=0;
		int max = 0;
		for(int i=0;i<_weightTable.length;i++) {
			for(int j=0;j<_weightTable.length;j++) {
				if(_weightTable[i][j]>max) {
					max = _weightTable[i][j];
					r = i;
					c = j;
				}
			}
		}
		
		return new Point(r,c);
		
	}
	
}
