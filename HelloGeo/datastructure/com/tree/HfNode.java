package com.tree;

/**
 * ���������������
 * @author CoolCats
 *
 */
public class HfNode {
	String str;//     �ַ�
	int w;	//  Ȩ��/Ƶ��
	HfNode left,right;//���ҽڵ�
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
