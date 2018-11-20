package com.coolcats20181113;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LenOfLongestSubstring {

	public static void main(String[] args) {

		HashMap<Character, Integer> map = new HashMap<>();
		LenOfLongestSubstring l = new LenOfLongestSubstring();
		int res = l.lengthOfLongestSubstring1("anviaj");
		System.out.println(res);
		System.out.println(l.isUnique(""));
		System.out.println(l.isUnique("anviaj"));
		System.out.println(l.isUnique("asdff"));
		res = l.lengthOfLongestSubstring1("asdff");
		System.out.println(res);

	}

	public int lengthOfLongestSubstring(String s) {
		if (s.equals("")) {
			return 0;
		}
		int max = 1;
		int currM = 1;
		char[] chs = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (chs[i + 1] != chs[i]) {
				map.put(chs[i], i);
				if (!map.containsKey(chs[i + 1])) {
					// 如果不重复，则长度加一
					currM++;
					max = (max > currM) ? max : currM;
				} else {

					max = (max > currM) ? max : currM;
					currM = currM - map.get(chs[i]) + 1;
				}
			} else {
				currM = 1;
			}
		}
		return max;
	}

	public int lengthOfLongestSubstring1(String s) {
		int max = 0;
		int curr = 1;
		if (s.length() == 0) {
			return max;
		} else {
			max++;

			for (int i = 0; i < s.length() - 1; i++) {
				for (int j = i + 1; j <= s.length(); j++) {
					if (isUnique(s.substring(i, j))) {
						curr = s.substring(i, j).length();
						max = (max > curr) ? max : curr;

					}
				}
			}
		}
		return max;
	}

	public boolean isUnique(String s) {
		Set<Character> set = new HashSet();
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if (!set.contains(chs[i])) {
				set.add(chs[i]);
			} else {
				return false;
			}
		}
		return true;
	}

	public int lengthOfLongestSubstring2(String s) {
		int max = 0;
		int curr = 1;
		if (s.length() == 0) {
			return max;
		} else {
			max++;

			for (int i = 0; i < s.length() - 1; i++) {
				for (int j = i + 1; j <= s.length(); j++) {
					if (isUnique(s, i, j)) {
						curr = s.substring(i, j).length();
						max = (max > curr) ? max : curr;

					}
				}
			}
		}
		return max;
	}

	public boolean isUnique(String s, int i, int j) {
		Set<Character> set = new HashSet();
		char[] chs = s.toCharArray();
		for (int k = 0; k < chs.length; k++) {
			if (!set.contains(chs[k])) {
				set.add(chs[k]);
			} else {
				return false;
			}
		}
		return true;
	}
}
