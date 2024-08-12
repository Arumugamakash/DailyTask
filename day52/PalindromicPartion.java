package com.akash.day52;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartion {
	public static void main(String[] args) {
		String s = "aabb";
		List<String> list = new ArrayList<String>();
		List<List<String>> res = new ArrayList<List<String>>();
		solution1(s, list, res, 0);
		System.out.println(res);
	}

	private static void solution1(String s, List<String> list, List<List<String>> res, int index) {
		if (index == s.length()) {
			res.add(new ArrayList<String>(list));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (ispalindrome(s, index, i)) {
				list.add(s.substring(index, i + 1));
				solution1(s, list, res, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private static boolean ispalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
