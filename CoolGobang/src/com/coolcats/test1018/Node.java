package com.coolcats.test1018;

import java.util.ArrayList;

public class Node {
	private int chess;//�洢������
	private Node parent;//���ڵ�
	private int score;//�����÷�
	private int key;
	private ArrayList<Node> _childs= new ArrayList<>();//�ӽڵ����
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
	 * ��Ӻ��ӽڵ�
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
