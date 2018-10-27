package com.coolcats.gobang1018;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GameTreePlayer extends AIplayer{
	
//	int[][] _chesstable;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();// �洢������������Լ���Ӧ��Ȩֵ
	public HashSet<Point> _possiblePt = new HashSet<>();
	private int[] d_col = {0,0,1,-1,-1,1,-1,1};	//�з�������
	private int[] d_row = {1,-1,0,0,-1,1,1,-1};	//�з�������
	private static int Neighbor = 8;
	private final int MAXN = 2<<28;//�ٶ���ֵΪ���޴�alpha�ĳ�ʼֵ
	private final int MINN = -MAXN;//����С��beta�ĳ�ʼֵ
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
	//��ȡ��ǰ������ӵĵ�
	public void getPoint(Point pt)
	{
		this._pt = pt;
	}
	/**
	 * ���ݽ��ܵ����������飬����������ƣ�����������������������ӵ�
	 * @return
	 */
	public void updateSet() {
		// TODO Auto-generated method stub
		//���������ӵ����ڴ��жϼ����У��򽫸õ�Ӽ������Ƴ�
		if(this._possiblePt.contains(this._pt)) {
			this._possiblePt.remove(this._pt);
		}
		//���������߽���û�����ӵ��������뵽���жϼ�����
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
		//���������ӵ����ڴ��жϼ����У��򽫸õ�Ӽ������Ƴ�
		Node node = new Node();
		DeepFirstSearch(0,node,MAXN,MINN);
	
		Point p = node.BestChild._p;
		return p;
	}
	
	public int getWeight() {
		int weight = 0;
		for(int r=0;r<=Chess.TABLE_ROW;r++) {
			for(int c=0;c<Chess.TABLE_COL;c++) {
				//���(r,c)��������
				if(this._chesstable[r][c]!=0) {
					int r1 = r,c1 = c;
					int chess = 1;//���ڼ�¼������Ŀ
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
			//�ݹ���ֹ��������������������
			root.mark = getWeight();
			return;
		}
	}
	
}
