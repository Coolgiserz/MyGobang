package com.tree;

import java.util.LinkedList;

public class HFMTree {

	static LinkedList<HfNode> _list;
	static HfNode root;

	public static void main(String[] args) {
//		_list = new LinkedList<>();
		HFMTree hftree = new HFMTree();
		String s = "qqqqqqqiillllllllllllloooovvvvvvvvvvvvvvvvvvvvvvvvvveeeeeeeeeeepp";
		// 统计词频
		int[] arr = hftree.calcWordFrequent(s);
		// 创建结点
		_list = hftree.createHfNode(arr);
		// 打印结点
		hftree.printList(_list);
		System.out.println("------------------------------");
		// 对列表进行排序
		 sortList(_list);
		System.out.println("------------------------------");
		// 打印列表
		hftree.printList(_list);
		System.out.println("------------------------------");
		// 使用排序后的列表创建哈夫曼树
		constructHftree(_list);
		preOrder(root);
	}

	public static void preOrder(HfNode tree) {
		System.out.println(tree.toString());
		if (tree.left != null)
			preOrder(tree.left);
		if (tree.right != null)
			preOrder(tree.right);
	}

	/**
	 * 统计词频 因暂时只支持英文字符的哈夫曼树构建，所以采用int[256]的数组进行存储词频统计情况
	 * 
	 * @param s
	 * @return
	 */
	public int[] calcWordFrequent(String s) {
		int[] array = new int[256];
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			array[ch]++;
		}
		return array;
	}

	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public void printArray(int[] array) {

	}

	/**
	 * 构造哈夫曼树
	 * 
	 * @param sortlist
	 * @return
	 */
	public static void constructHftree(LinkedList<HfNode> sortlist) {
//		LinkedList<HfNode> tmpList = new LinkedList<>();
		int i = 0;
		while (sortlist.size() > 1) {
			HfNode father = createParent(sortlist.removeFirst(), sortlist.removeFirst());
			sortlist.addFirst(father);
			 sortList(sortlist);// 排序

		}
		root = sortlist.getLast();

//		return this;
	}

	public LinkedList<HfNode> createHfNode(int[] array) {
		LinkedList<HfNode> lis = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				// 当数组元素不为0，即ascii码对应的字符存在时，创建二叉树结点
				HfNode node = new HfNode((char) i + "", array[i]);
				lis.add(node);
			}
		}
		return lis;
	}

	/**
	 * 对列表排序
	 * 
	 * @param list
	 */
	public static void sortList(LinkedList<HfNode> list) {

		// 选择排序法
		for (int i = 0; i < list.size(); i++) {
			int min = i;// 用于保存带最小权值的结点
			for (int j = i + 1; j < list.size(); j++) {
				HfNode minNode = list.get(min);
				HfNode jNode = list.get(j);
				// 每次比较都把小的权值的索引保存下来
				if (minNode.w > jNode.w) {
					min = j;
				}
			}
			// 如果min不为i时，即i之后最小权值的结点索引被取出，则交换
			if (min != i) {
				HfNode h = list.get(i);
				list.set(i, list.get(min));
				list.set(min, h);
			}

		}
//		return list;
	}

	/**
	 * 打印列表
	 * 
	 * @param list
	 */
	public void printList(LinkedList<HfNode> list) {
		for (HfNode node : list) {
			System.out.println(node.toString());
		}
	}

	/**
	 * 由两个子节点创建父节点
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public static HfNode createParent(HfNode left, HfNode right) {
		HfNode parent = new HfNode(left.str + right.str, left.w + right.w);
		parent.left = left;
		parent.right = right;
		return parent;
	}

}
