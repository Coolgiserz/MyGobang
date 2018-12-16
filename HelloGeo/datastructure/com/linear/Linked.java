package com.linear;

import com.dsinterface.LinkedInterface;

public class Linked<E> implements LinkedInterface<E> {

	private Node<E> root;// 头结点
	private Node<E> tail;// 尾节点
	private int size;// 计算链表长度

	public Linked() {
		root = new Node<>();
	}

	/**
	 * 添加结点
	 */
	@Override
	public void add(E e) {
//		Node node = root;//获取根节点：链表的起点
		if (root.next == null) {
			// 如果链表为空，则增加一个节点
			Node<E> node = new Node<>(e);
			root.next = node;
			tail = node;
//			tail.next = node;
		} else {
			// 链表不为空，则往后增加
			Node<E> node = tail;// 通过尾指针索引到最后一个节点
			node.next = new Node<>(e);// 添加指针
			tail = node.next;
//			tail.next = node;

		}
		size++;
	}

	/**
	 * 移除链表中的元素
	 */
	@Override
	public E remove(int index) {
		// 处理边界情况
		if (index < 0 || index > size - 1) {
			System.out.println("越界错误");
			return null;
		}
		E e = null;
		if (index == size - 1) {
			// 移除的是最后一个节点
			Node<E> node = getNode(size - 1);// 获取倒数第二个节点
//			Node<E> removeNode = tail;
			e = node.next.e;
			node.next = null;

			tail = node;

		} else if (index == 0) {
			// 移除的是第一个节点
			Node<E> node = root.next;// 获取倒数第一个节点
			root.next = node.next;
			e = node.e;
			node.next = null;
		} else {
			Node<E> node = getNode(index - 1);// 获取倒数第二个节点
			Node<E> removeNode = node.next;
			node.next = node.next.next;
			e = removeNode.e;
			removeNode.next = null;
		}
		size--;
		return e;
	}

	/**
	 * 按索引取出链表中的节点
	 */
	public Node<E> getNode(int index) {
		Node<E> node = root;
		// 判断边界情况
		if (index < 0 || index > size()) {
			System.out.println("越界");
			return null;
		}
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * 按索引取出链表中的值
	 */
	@Override
	public E get(int index) {
		Node<E> node = root.next;
		// 判断边界情况
		if (index < 0 || index > size()-1) {
			System.out.println("越界");
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
		// 边界判断
		if (index < 0 || index > size - 1) {
			System.out.println("越界");
			return;
		}
		if (index == 0) {
			Node<E> node = new Node<>(e);
			node.next = root.next;
			root.next = node;
		} else if (index == size - 1) {
			// 插入到末尾
			add(e);
		} else {
			// 插入到中间
			Node<E> lastNode = getNode(index - 1);// 获取index-1索引处的节点
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
	 * 链表反转
	 */
	public void reverse() {
		Node<E> node = root.next;//取出第一个节点
		Node<E> preNode = null;
		Node<E> nextNode = null;
		while(node!=null) {
			nextNode = node.next;
			if(nextNode == null) {
				//如果已经到达了原链表的尾，则使得头结点指向当前节点
				root.next = node;
			}
			node.next = preNode;
			preNode = node;
			node = nextNode;
			
		}
	}
}
