package com.tree;

import java.util.LinkedList;

public class HFMTree {

	static LinkedList<HfNode> _list;
	static HfNode root;

	public static void main(String[] args) {
//		_list = new LinkedList<>();
		HFMTree hftree = new HFMTree();
		String s = "qqqqqqqiillllllllllllloooovvvvvvvvvvvvvvvvvvvvvvvvvveeeeeeeeeeepp";
		// ͳ�ƴ�Ƶ
		int[] arr = hftree.calcWordFrequent(s);
		// �������
		_list = hftree.createHfNode(arr);
		// ��ӡ���
		hftree.printList(_list);
		System.out.println("------------------------------");
		// ���б��������
		 sortList(_list);
		System.out.println("------------------------------");
		// ��ӡ�б�
		hftree.printList(_list);
		System.out.println("------------------------------");
		// ʹ���������б�����������
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
	 * ͳ�ƴ�Ƶ ����ʱֻ֧��Ӣ���ַ��Ĺ����������������Բ���int[256]��������д洢��Ƶͳ�����
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
	 * ��ӡ����
	 * 
	 * @param array
	 */
	public void printArray(int[] array) {

	}

	/**
	 * �����������
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
			 sortList(sortlist);// ����

		}
		root = sortlist.getLast();

//		return this;
	}

	public LinkedList<HfNode> createHfNode(int[] array) {
		LinkedList<HfNode> lis = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				// ������Ԫ�ز�Ϊ0����ascii���Ӧ���ַ�����ʱ���������������
				HfNode node = new HfNode((char) i + "", array[i]);
				lis.add(node);
			}
		}
		return lis;
	}

	/**
	 * ���б�����
	 * 
	 * @param list
	 */
	public static void sortList(LinkedList<HfNode> list) {

		// ѡ������
		for (int i = 0; i < list.size(); i++) {
			int min = i;// ���ڱ������СȨֵ�Ľ��
			for (int j = i + 1; j < list.size(); j++) {
				HfNode minNode = list.get(min);
				HfNode jNode = list.get(j);
				// ÿ�αȽ϶���С��Ȩֵ��������������
				if (minNode.w > jNode.w) {
					min = j;
				}
			}
			// ���min��Ϊiʱ����i֮����СȨֵ�Ľ��������ȡ�����򽻻�
			if (min != i) {
				HfNode h = list.get(i);
				list.set(i, list.get(min));
				list.set(min, h);
			}

		}
//		return list;
	}

	/**
	 * ��ӡ�б�
	 * 
	 * @param list
	 */
	public void printList(LinkedList<HfNode> list) {
		for (HfNode node : list) {
			System.out.println(node.toString());
		}
	}

	/**
	 * �������ӽڵ㴴�����ڵ�
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
