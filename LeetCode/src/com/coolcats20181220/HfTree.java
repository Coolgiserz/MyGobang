package com.coolcats20181220;

import java.util.ArrayList;

/**
 * ������������-���Ŷ����� ��Ȩ·��֮����С
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

		// ͳ�ƴ�Ƶ
		int[] words = hftree.calcWordFrequency(s);

		// ��ͳ�ƺ���Ϣת���б�洢
		hftree._list = hftree.array2List(words);

		// ��ӡ�б�
		hftree.printList(hftree._list);

		// ���б��������
		hftree.sortList(hftree._list);

		// ��ӡ�б�
		hftree.printList(hftree._list);

		// ������������
		hftree.createHfTree(hftree._list);

		// ������������
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
	 * ���ӽڵ��ø��ڵ�
	 * 
	 * @param left  ���ӽڵ�
	 * @param right ���ӽڵ�
	 * @return
	 */
	private Node getParent(Node left, Node right) {
		Node father = new Node(left.data + right.data, left.weight + right.weight);
		father.left = left;
		father.right = right;
		return father;
	}

	/**
	 * ������������
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
	 * �б�����
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
			// ���ѡ��������û����һ����������
			if (min != i) {
				Node tmpNode = list.get(i);
				list.set(i, list.get(min));
				list.set(min, tmpNode);
			}
		}

	}

	/**
	 * ͳ�ƴ�Ƶ
	 * 
	 * @param s ԭʼ����
	 * @return int[] ��Ƶͳ������
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
	 * ����ת�б�
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
	 * ��ӡ�б�
	 * 
	 * @param list
	 */
	private void printList(ArrayList<Node> list) {
		System.out.println("******�б��ӡ��ʼ*********");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("******�б��ӡ����*********");

	}
}
