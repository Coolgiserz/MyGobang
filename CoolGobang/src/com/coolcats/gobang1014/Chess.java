package com.coolcats.gobang1014;

import java.awt.Color;
import java.awt.Graphics;

public class Chess {
	public int _code;
	public int _col;
	public int _row;
	public int _x;
	public int _y;
	public static int TABLE_COL = 20;
	public static int TABLE_ROW = 20;
	public static int INTERVAL = 40;
	public static int OriX = 100;
	public static int OriY = 100;
	public static int EndX = OriX + INTERVAL*TABLE_COL;
	public static int EndY = OriY + INTERVAL*TABLE_ROW;

	public Chess() {
	}
	
	public Chess(int _col,int _row,int _code) {
		this._code = _code;
		this._col = _col;
		this._row = _row;
	}
	
	private static void printTable() {
		System.out.println(EndX+" "+EndY);
	}
	public static void drawTable(Graphics g) {
		printTable();
		System.out.println("®‹¹P3£º"+g);
		
	}
	
}
