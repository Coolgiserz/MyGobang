package com.tree;

/**
 * 哈夫曼二叉树结点
 * @author CoolCats
 *
 */
public class HfNode {
	String str;//     字符
	int w;	//  权重/频率
	HfNode left,right;//左右节点
	public HfNode() {
		
	}
	
	public HfNode(String str,int w) {
		this.str = str;
		this.w = w;
	}
	
	public String toString() {
		return str+":"+w;
	}
}
