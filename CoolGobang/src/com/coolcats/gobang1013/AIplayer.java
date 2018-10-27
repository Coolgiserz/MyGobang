package com.coolcats.gobang1013;

import java.awt.Point;

public class AIplayer {
	
	Chess[][] _chesstable = new Chess[Chess.TABLE_ROW][Chess.TABLE_COL];
	protected final static int UNKNOWN = 0;

	protected final static int Weight_Player = 1;
	protected final static int Tree_Player = 2;
	protected final static int ML_Player = 3;
	protected static int _mode;
	Point _pt;
	public AIplayer() {
		
	}
	
	public void getTable(Chess[][] table) {
		this._chesstable = table;
	}
	/**
	 * 
	 * @param table 当前棋盘表
	 * @return 返回下棋的坐标点
	 */
	public Point CalcRC(Chess[][] table) {
		return _pt;
		
	}
}
