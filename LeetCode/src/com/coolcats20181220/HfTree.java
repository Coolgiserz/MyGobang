package com.coolcats20181220;

import java.util.ArrayList;

/**
 * 哈夫曼二叉树-最优二叉树 带权路径之和最小
 * 
 * @author CoolCats
 *
 */
public class HfTree {

	private Node _root;
	private ArrayList<Node> _list;

	public static void main(String[] args) {

		HfTree hftree = new HfTree();
		String s = "qqqqqqqqqqqwwwwwweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeppppppppppppppptttttttttttttttttttttttttttttttttrrr";

		// 统计词频
		int[] words = hftree.calcWordFrequency(s);

		// 将统计后信息转用列表存储
		hftree._list = hftree.array2List(words);

		// 打印列表
		hftree.printList(hftree._list);

		// 对列表进行排序
		hftree.sortList(hftree._list);

		// 打印列表
		hftree.printList(hftree._list);

		// 构建哈夫曼树
		hftree.createHfTree(hftree._list);

		// 遍历哈夫曼树
		hftree.preOrder(hftree._root);
	}

	private void preOrder(Node root) {
		System.out.println(root.toString());
		if(root.left!=null)
			preOrder(root.left);
		if(root.right!=null) {
			preOrder(root.right);
		}
	}

	/**
	 * 由子节点获得父节点
	 * 
	 * @param left  左子节点
	 * @param right 右子节点
	 * @return
	 */
	private Node getParent(Node left, Node right) {
		Node father = new Node(left.data + right.data, left.weight + right.weight);
		father.left = left;
		father.right = right;
		return father;
	}

	/**
	 * 构建哈夫曼树
	 * @param sortlist
	 */
	private void createHfTree(ArrayList<Node> sortlist) {
		while(sortlist.size()>1) {
			Node father = getParent(sortlist.remove(0),sortlist.remove(0));
			sortlist.add(0,father);
			this.sortList(sortlist);
		}
		this._root = sortlist.get(0);
		
	}

	/**
	 * 列表排序
	 * 
	 * @param list
	 */
	private void sortList(ArrayList<Node> list) {
		Node minNode = null;
		Node jNode = null;

		for (int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.size(); j++) {
				minNode = list.get(min);
				jNode = list.get(j);
				if (minNode.weight > jNode.weight) {
					min = j;
				}
			}
			// 如果选择排序法中没有这一步会怎样？
			if (min != i) {
				Node tmpNode = list.get(i);
				list.set(i, list.get(min));
				list.set(min, tmpNode);
			}
		}

	}

	/**
	 * 统计词频
	 * 
	 * @param s 原始数据
	 * @return int[] 词频统计数组
	 */
	public int[] calcWordFrequency(String s) {
		int[] ascii = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			ascii[ch]++;
		}
		return ascii;
	}

	/**
	 * 数组转列表
	 * 
	 * @param words
	 * @return
	 */
	public ArrayList<Node> array2List(int[] words) {
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i] != 0) {
				list.add(new Node((char) i + "", words[i]));
			}
		}

		return list;
	}

	/**
	 * 打印列表
	 * 
	 * @param list
	 */
	private void printList(ArrayList<Node> list) {
		System.out.println("******列表打印开始*********");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("******列表打印结束*********");

	}
}
