package com.coolcats20181113;

import java.util.HashMap;
import java.util.Stack;

/**
 * �ɼ������������µ�����ƥ������ʹ�ù�ϣ���ʱ��Ч��Զ���ڲ�ʹ��
 * @author CoolCats
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses va = new ValidParentheses();
		String[] testStrings = { "({{[[[]]]}})", "[{{()}}]", "{{{}}}}", "{{{{", "}}}}}", "((()]((", "[(])", "([{}])" };
//		String[] tests {}

		// ����isValid
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			for (String s : testStrings) {
//				System.out.println(va.isValid(s));
				va.isValid(s);
			}
		}
		System.out.println(System.currentTimeMillis() - start);

		// ����isValid1
		start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {

			for (String s : testStrings) {
//				System.out.println(va.isValid1(s));
				va.isValid1(s);
			}
		}
		System.out.println(System.currentTimeMillis() - start);

	}

	public ValidParentheses() {

	}

	/**
	 * ����ƥ�����⣬���ù�ϣ��ʱ�临�Ӷ�
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		HashMap<Character, Character> map;
		map = new HashMap<>();
		map.put('}', '{');
		map.put(')', '(');
		map.put(']', '[');
		if (s.equals("")) {
			return true;
		} else if (s.length() % 2 != 0) {
			return false;
		} else {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				Character c = s.charAt(i);
				if (c.equals('{') || c.equals('(') || c.equals('[')) {
					stack.push(c);
				} else {
					if (stack.empty()) {
						return false;
					}
					Character t = stack.pop();
					if (!t.equals(map.get(c))) {
						return false;
					}
				}
			}
			if (!stack.empty()) {
				return false;
			}
		}
		return true;

	}

	/**
	 * ����ƥ�����⣬���ù�ϣ��
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid1(String s) {
		if (s.length() % 2 != 0) {
			return false;
		} else if (s.equals("")) {
			return true;
		} else {
			Stack<Character> stack = new Stack<>();
			char[] chs = s.toCharArray();
			for (char c : chs) {
				if (c == '{') {
					stack.push('}');
				} else if (c == '(') {
					stack.push(')');
				} else if (c == '[') {
					stack.push(']');
				} else {

					if (stack.empty()) {
						return false;
					} else {
						char t = stack.pop();
						if (t != c) {
							return false;
						}
					}
				}

			}
			if (!stack.empty()) {
				return false;
			}
		}
		return true;
	}
}
