package com.coolcats20181220;

/**
 * ¹ş·òÂüÊ÷¶ş²æÊ÷½Úµã
 * @author CoolCats
 *
 */
public class Node {

	public Node left,right;
	public int weight;
	public String data;
	
	public Node() {
		
	}
	
	public Node(String data,int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	public String toString() {
		return this.data+":"+this.weight;
	}
}
