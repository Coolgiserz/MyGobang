package com.coolcats20181113;

import java.util.Stack;

public class MakeParenthesesValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * +1 -1 表示偏斜，+1代表存在1個不平衡的左括號，-1代表存在1個不平衡的右括號
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
	 * 判断括号是否平衡，使用栈
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
