package com.coolcats.framecompare;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * 两个栈实现队列（入队列、出队列操作）
 * 
 * @author CoolCats
 *
 */
public class StacksToQueue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public static void main(String[] args) {
		StacksToQueue que = new StacksToQueue();
		que.add(1);
		que.add(4);
		que.add(3);
		que.add(18);
		que.add(14);
		que.printQueue();
		que.remove();
		que.remove();

		que.printQueue();
		que.add(19);
		que.add(20);
		que.printQueue();
		que.remove();
		que.printQueue();


	}

	public StacksToQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
//		stack1.push(4);
//		
//		System.out.println(stack1.size());
//		System.out.println(stack1.get(0));

	}

	public void printQueue() {
		System.out.println("輸出隊列：");
		int i = 0;
		if (stack1.empty()) {
			i = stack2.size() - 1;
			while (!stack2.empty() && i >= 0) {

				System.out.println(stack2.get(i));
				i--;
			}
		} else {

			while (!stack1.empty() && i < stack1.size()) {

				System.out.println(stack1.get(i));
				i++;
			}
		}

	}

	/**
	 * 進隊列，直接加入stack1
	 * 
	 * @param val
	 */
	public void add(Integer val) {
		if (stack2.isEmpty()) {
			stack1.push(val);

		} else {
			while (!stack2.empty()) {
				stack1.push(stack2.pop());
			}
			stack1.push(val);
		}

	}

	/**
	 * 出隊列，返回隊頭元素
	 * @return
	 */
	public Integer remove() {
		// 如果棧1為空，且棧2不爲空，直接彈出棧2的棧頂元素
		if (stack1.isEmpty()) {
			// 如果棧1不爲空
//			int i = 0;
			return stack2.pop();

		} else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}

	}
}
