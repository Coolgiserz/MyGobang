package com.coolcats.framecompare;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 两个队列实现栈
 * @author CoolCats
 *
 */
public class QueueToStacks {

	private Queue<Integer> queue1;
	private Queue<Integer> queue2;

	/**
	 * Queue是接口，Stack是類 LinkList和ArrayList實現了Queue
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueToStacks stacks = new QueueToStacks();
		stacks.push(4);
		stacks.push(7);
		stacks.push(5);
		stacks.push(3);
		stacks.printStack();
		System.out.println("弹出"+stacks.pop());
		stacks.printStack();
		stacks.push(9);
		stacks.push(25);
		stacks.push(123);
		stacks.printStack();

		System.out.println("弹出"+stacks.pop());
		System.out.println("弹出"+stacks.pop());
		stacks.printStack();


	}

	public QueueToStacks() {
		queue1 = new LinkedList();
		queue2 = new LinkedList();

	}

	/**
	 * 打印棧中元素
	 */
	public void printStack() {
		if (queue1.isEmpty()) {
			Integer t = queue2.size() - 1;
			while (t >=0) {
				System.out.println(queue2.toArray()[t]);

				t--;
			}
		}
		if (queue2.isEmpty()) {
			Integer t = queue1.size() - 1;
			while (t >=0) {
				System.out.println(queue1.toArray()[t]);

				t--;
			}
		}
//		if (queue1.isEmpty()) {
//			Integer t = 0;
//			while (t < queue2.size() - 1) {
//				queue1.add(queue2.remove());
//				t++;
//			}
//			System.out.println(queue2.remove()); 
//		} else {
//			Integer t = 0;
//			while (t < queue1.size() - 1) {
//				queue2.add(queue1.remove());
//				t++;
//			}
//			System.out.println(queue1.remove()); 
//
//		}
	}

	/**
	 * 進棧
	 * 
	 * @param val
	 */
	public void push(Integer val) {
		if (queue2.isEmpty()) {
			queue1.add(val);
		} else {
			queue2.add(val);
		}

	}

	/**
	 * 出棧
	 * 
	 * @return
	 */
	public Integer pop() {
		if (queue2.isEmpty()) {
			int i = queue1.size() - 1;
			while (i >= 1) {
				queue2.add(queue1.remove());
				i--;
			}
			return queue1.remove();
		} else {
			int i = queue2.size() - 1;
			while (i >= 1) {
				queue1.add(queue2.remove());
				i--;
			}
			return queue2.remove();
		}
	}

}
