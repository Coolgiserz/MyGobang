package com.coolcats.gobang1018;

import java.awt.Point;
import java.util.ArrayList;

public class Node {
	public Node BestChild = null;//分值最高的孩子结点
	ArrayList<Node> _childs = new ArrayList<>();
	public int mark=0;//分值
	public Point _p = new Point(); 
	public Node() {
		
	}
	
	public void appendChild(Node child) {
		this._childs.add(child);
	}
	
	public int getChildLength() {
		return this._childs.size();
	}
	
	public void setPoint(Point pt) {
		this._p.x = pt.x;
		this._p.y = pt.y;
	}
}
