package com.coolcats20181113;
/**
 * Á´±í½á¹¹
 * @author CoolCats
 *
 */
public class ListNode {
	
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
	
	void printList(ListNode node) {
		while(node!=null) {
			System.out.print(node.val);
			node = node.next;
		}
		System.out.println();

	}
}
