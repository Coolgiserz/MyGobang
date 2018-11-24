package com.coolcats.framecompare;

import java.util.ArrayList;

public class MyQueue {

	ListNode head;
	ListNode tail;

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.add(new ListNode(5));
		q.add(new ListNode(6));
		q.add(new ListNode(7));
		q.add(new ListNode(8));
		q.printQueue();
		q.remove();
		q.remove();
		q.printQueue();
		q.add(new ListNode(9));
		q.add(new ListNode(10));
		q.add(new ListNode(11));
		q.remove();

		q.printQueue();
		
		MyQueue q1 = new MyQueue();
		q1.add(new ListNode(1));
		q1.add(new ListNode(2));
		q1.add(new ListNode(3));
		q1.add(new ListNode(4));
		q.add(q1);
		q.printQueue();

	}

	public MyQueue() {
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.next = null;

	}

	public void printQueue() {
		System.out.println("*******∂”¡–¥Ú”°*********");

		ListNode cur = head.next;
		while (cur.next != null) {
			cur = cur.next;

			System.out.println(cur.val);
			
		}
	}

	public void add(ListNode node) {

		tail.next = node;
		node.next = null;
		tail = node;
	}

	public ListNode remove() {
		if (head != null) {
			ListNode cu = head;
			head = head.next;
			return cu;
		}
		return null;
	}
	public void add(MyQueue q) {
		this.tail.next = q.head.next.next;
//		this.tail.next = q.head.next;

		
	}
	
}
