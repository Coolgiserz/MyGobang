package com.coolcats20181113;

import java.util.ArrayList;
import java.util.Stack;

/**
 * (1)java中除了基本数据类型以外的对象都是按引用传递
 * 
 * 
 * @author CoolCats
 *
 */
public class TestNum {

	private static int[] arri = { 10, 101, 800, 9009, 5002005, 3, 0, -4, 745547 };
	private static boolean[] judi = { false, true, false, true, true, true, true, false, true };

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE + 1);

//		testAddTwoNumber();
//		testPalindrome();
		testPalindrome2();

//		System.out.println(Integer.reverseBytes(2233));

	}

	private static void testPalindrome2() {
		long start = System.currentTimeMillis();

		for (int i = 0; i < arri.length; i++) {
			System.out.println("Output" + i);

			System.out.println(isPalindrome2(arri[i]));
			System.out.println("Expected" + i);
			System.out.println(judi[i]);

		}
//		System.out.println(isPalindrome2(1020201));
		long end = System.currentTimeMillis();
		System.out.println("運行時間：" + (end - start));
		start = System.currentTimeMillis();
		for (int i = 0; i < arri.length; i++) {
			System.out.println("Output" + i);

			System.out.println(isPalindrome(arri[i]));
			System.out.println("Expected" + i);
			System.out.println(judi[i]);

		}
		end = System.currentTimeMillis();
		System.out.println("運行時間：" + (end - start));
		// test3
		start = System.currentTimeMillis();
		for (int i = 0; i < arri.length; i++) {
			System.out.println("Output" + i);

			System.out.println(isPalindrome3(arri[i]));
			System.out.println("Expected" + i);
			System.out.println(judi[i]);

		}
		end = System.currentTimeMillis();
		System.out.println("運行時間：" + (end - start));
	}

	private static void testPalindrome() {
		long start = System.currentTimeMillis();
		System.out.println(isPalindrome(1020201));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		start = System.currentTimeMillis();
		System.out.println(isPalindrome(-1016));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	/**
	 * 测试
	 */
	private static void testAddTwoNumber() {
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(9);
//		l1.printList(l1);
		ListNode l2 = l1.next;
		l2.val = 4;
		l1.printList(l1);

		l2.printList(l2);
		long start = System.currentTimeMillis();
		ListNode res = addTwoNumber(l1, l2);
		long end = System.currentTimeMillis();
		System.out.println("運行時間：" + (end - start));
		res.printList(res);
	}

	/**
	 * 需要注意的问题
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);// 初始化一个结点
		ListNode p = l1, q = l2;
		ListNode curr = res;
		int carry = 0;// 进位
		while (p != null || q != null) {
			int sum = ((p != null) ? p.val : 0) + ((q != null) ? q.val : 0) + carry;
			carry = sum / 10;// 计算看是否需要进位
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return res.next;

	}

	/**
	 * 判斷一個int型数字是否是回文 156ms
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		String s = x + "";

		Stack sta = new Stack();
		for (int i = 0; i < s.length(); i++) {
			sta.push(s.substring(i, i + 1));
		}
		String st = new String("");
		for (int i = 0; i < s.length(); i++) {
			st = st + sta.pop();
		}
		if (!st.equals(s)) {
			return false;
		}
		return true;
	}

	/**
	 * 218ms
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome1(int x) {
		String s1 = "";
		String s2 = "";
		String s = x + "";
		int carry = s.length() / 2;
		for (int i = 0; i < carry; i++) {
			s1 = s1 + s.substring(i, i + 1);
		}
		for (int i = s.length() - 1; i >= s.length() - carry; i--) {
			s2 = s2 + s.substring(i, i + 1);
		}
		if (s1.equals(s2)) {
			return true;
		}
		return false;
	}

	/**
	 * 整數反轉而不用字符串的方法，善用取模運算符
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome2(int x) {

		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int tmp = x;
		int revtx = 0;
		while (tmp != 0) {
			revtx = revtx * 10;
			revtx += tmp % 10;
			tmp = tmp / 10;
		}
		if (revtx == x) {
			return true;
		}
		return false;
	}

	/**
	 * 基於隊列
	 * 85ms
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome3(int x) {
		ArrayList<Integer> digits = new ArrayList<>();
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int tmp = x;
		while (tmp != 0) {
			digits.add(tmp % 10);
			tmp = tmp / 10;
		}
		int si = 0;
		int ei = digits.size() - 1;
		while (si < ei) {
			if (digits.get(si) != digits.get(ei)) {
				return false;
			}
			si++;
			ei--;
		}
		return true;
	}

}
