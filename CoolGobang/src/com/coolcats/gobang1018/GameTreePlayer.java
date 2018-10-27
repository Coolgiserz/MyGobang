package com.coolcats.gobang1018;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GameTreePlayer extends AIplayer{
	
//	int[][] _chesstable;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();// 存储棋子相连情况以及对应的权值
	public HashSet<Point> _possiblePt = new HashSet<>();
	private int[] d_col = {0,0,1,-1,-1,1,-1,1};	//列方向向量
	private int[] d_row = {1,-1,0,0,-1,1,1,-1};	//行方向向量
	private static int Neighbor = 8;
	private final int MAXN = 2<<28;//假定该值为无限大。alpha的初始值
	private final int MINN = -MAXN;//无限小。beta的初始值
	private final int searchDepth = 5;
	public GameTreePlayer() {
		this._mode = AIplayer.Tree_Player;

	}

	public void PrintSet() {
		Iterator it = _possiblePt.iterator();
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
	}
	public Point MaxMinSearch() {
		// TODO Auto-generated method stub
		return null;
	}
	//获取当前玩家落子的点
	public void getPoint(Point pt)
	{
		this._pt = pt;
	}
	/**
	 * 根据接受到的棋盘数组，评估棋局形势，构建博弈树，返回最佳落子点
	 * @return
	 */
	public void updateSet() {
		// TODO Auto-generated method stub
		//如果玩家落子点落在待判断集合中，则将该点从集合中移出
		if(this._possiblePt.contains(this._pt)) {
			this._possiblePt.remove(this._pt);
		}
		//将不超出边界且没有棋子的邻域点加入到待判断集合中
		for(int i=0;i<Neighbor;i++) {
			Point tmpPt = new Point(this._pt.x+d_row[i],this._pt.y+d_col[i]);
			if(tmpPt.x>=0&&tmpPt.x<Chess.TABLE_COL&&tmpPt.y>=0&&tmpPt.y<Chess.TABLE_ROW) {
				if(ChessPanel._chesstable[tmpPt.x][tmpPt.y]==0) {
					this._possiblePt.add(tmpPt);
				}
			}
		}
	}
	public Point GetBestPt() {
		// TODO Auto-generated method stub
		//如果玩家落子点落在待判断集合中，则将该点从集合中移出
		Node node = new Node();
		DeepFirstSearch(0,node,MAXN,MINN);
	
		Point p = node.BestChild._p;
		return p;
	}
	
	public int getWeight() {
		int weight = 0;
		for(int r=0;r<=Chess.TABLE_ROW;r++) {
			for(int c=0;c<Chess.TABLE_COL;c++) {
				//如果(r,c)处有棋子
				if(this._chesstable[r][c]!=0) {
					int r1 = r,c1 = c;
					int chess = 1;//用于记录棋子数目
					int row = r1;
					int col = c1-1;
					while(col>0 && this._chesstable[row][col]==this._chesstable[r1][c1]) {
						col--;
						++chess;
					}
				}
			}
		}
		
		return 0;
		
	}
	public void DeepFirstSearch(int deep,Node root,int alpha,int beta) {
		if(deep == searchDepth) {
			//递归终止条件：到达最大搜索深度
			root.mark = getWeight();
			return;
		}
	}
	
}
