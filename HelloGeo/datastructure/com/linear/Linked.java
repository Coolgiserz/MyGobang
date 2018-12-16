package com.linear;

import com.dsinterface.LinkedInterface;

public class Linked<E> implements LinkedInterface<E> {

	private Node<E> root;// ͷ���
	private Node<E> tail;// β�ڵ�
	private int size;// ����������

	public Linked() {
		root = new Node<>();
	}

	/**
	 * ��ӽ��
	 */
	@Override
	public void add(E e) {
//		Node node = root;//��ȡ���ڵ㣺��������
		if (root.next == null) {
			// �������Ϊ�գ�������һ���ڵ�
			Node<E> node = new Node<>(e);
			root.next = node;
			tail = node;
//			tail.next = node;
		} else {
			// ����Ϊ�գ�����������
			Node<E> node = tail;// ͨ��βָ�����������һ���ڵ�
			node.next = new Node<>(e);// ���ָ��
			tail = node.next;
//			tail.next = node;

		}
		size++;
	}

	/**
	 * �Ƴ������е�Ԫ��
	 */
	@Override
	public E remove(int index) {
		// ����߽����
		if (index < 0 || index > size - 1) {
			System.out.println("Խ�����");
			return null;
		}
		E e = null;
		if (index == size - 1) {
			// �Ƴ��������һ���ڵ�
			Node<E> node = getNode(size - 1);// ��ȡ�����ڶ����ڵ�
//			Node<E> removeNode = tail;
			e = node.next.e;
			node.next = null;

			tail = node;

		} else if (index == 0) {
			// �Ƴ����ǵ�һ���ڵ�
			Node<E> node = root.next;// ��ȡ������һ���ڵ�
			root.next = node.next;
			e = node.e;
			node.next = null;
		} else {
			Node<E> node = getNode(index - 1);// ��ȡ�����ڶ����ڵ�
			Node<E> removeNode = node.next;
			node.next = node.next.next;
			e = removeNode.e;
			removeNode.next = null;
		}
		size--;
		return e;
	}

	/**
	 * ������ȡ�������еĽڵ�
	 */
	public Node<E> getNode(int index) {
		Node<E> node = root;
		// �жϱ߽����
		if (index < 0 || index > size()) {
			System.out.println("Խ��");
			return null;
		}
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * ������ȡ�������е�ֵ
	 */
	@Override
	public E get(int index) {
		Node<E> node = root.next;
		// �жϱ߽����
		if (index < 0 || index > size()-1) {
			System.out.println("Խ��");
			return null;
		}
		for (int i = 0; i <index; i++) {
			node = node.next;
		}
		return node.e;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public void insert(E e, int index) {
		// �߽��ж�
		if (index < 0 || index > size - 1) {
			System.out.println("Խ��");
			return;
		}
		if (index == 0) {
			Node<E> node = new Node<>(e);
			node.next = root.next;
			root.next = node;
		} else if (index == size - 1) {
			// ���뵽ĩβ
			add(e);
		} else {
			// ���뵽�м�
			Node<E> lastNode = getNode(index - 1);// ��ȡindex-1�������Ľڵ�
			Node<E> node = new Node<>(e);
			node.next = lastNode.next.next;
			lastNode.next = node;

		}
		size++;
	}

	@Override
	public void update(E e, int index) {

	}

	/**
	 * ����ת
	 */
	public void reverse() {
		Node<E> node = root.next;//ȡ����һ���ڵ�
		Node<E> preNode = null;
		Node<E> nextNode = null;
		while(node!=null) {
			nextNode = node.next;
			if(nextNode == null) {
				//����Ѿ�������ԭ�����β����ʹ��ͷ���ָ��ǰ�ڵ�
				root.next = node;
			}
			node.next = preNode;
			preNode = node;
			node = nextNode;
			
		}
	}
}
