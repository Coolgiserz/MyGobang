package com.coolcats20181113;

import java.util.Stack;

public class MakeParenthesesValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * +1 -1 ��ʾƫб��+1�������1����ƽ�������̖��-1�������1����ƽ�������̖
	 * 
	 * @param S
	 * @return
	 */
	public int minAddToMakeValid1(String S) {
		int ans = 0, bal = 0;
		for (int i = 0; i < S.length(); ++i) {
			bal += S.charAt(i) == '(' ? 1 : -1;
			// It is guaranteed bal >= -1
			if (bal == -1) {
				ans++;
				bal++;
			}
		}

		return ans + bal;
	}

	/*
	 * �ж������Ƿ�ƽ�⣬ʹ��ջ
	 */
	public int minAddToMakeValid(String S) {
		if (S.length() == 0) {
			return 0;
		}
		Stack<Character> stacks = new Stack();

		int count = 0;
		for (char ch : S.toCharArray()) {
			if (ch == '(') {
				stacks.push(')');
			} else {
				if (!stacks.empty()) {
					stacks.pop();

				} else {
					count++;
				}
			}

		}
		while (!stacks.empty()) {
			stacks.pop();
			count++;
		}
		return count;
	}
}
