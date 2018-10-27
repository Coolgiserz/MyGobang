package com.coolcats.test1018;

import java.util.ArrayList;

public class Node {
	private int chess;//存储的棋子
	private Node parent;//父节点
	private int score;//评估得分
	private int key;
	private ArrayList<Node> _childs= new ArrayList<>();//子节点队列
	public Node() {
		
	}
	public Node(int chess) {
		this.chess = chess;
	}
	public Node(int chess,Node parent,int score) {
		this.chess = chess;
		this.parent = parent;
		this.score = score;
	}
	/**
	 * 添加孩子节点
	 * @param node
	 */
	public void appendChild(Node node) {
		this._childs.add(node);
	}
	
	public int getChildCount(Node node) {
		return node._childs.size();
	}
	
	public void setNode(int chess,Node parent,int score) {
		this.chess = chess;
		this.parent = parent;
		this.score = score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
	public void printTree(Node node) {
		
	}
	
}
