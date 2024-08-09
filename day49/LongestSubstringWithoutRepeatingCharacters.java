package com.akash.day49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "cadbzabcd";
		System.out.println(solution2(s));
		System.out.println(solution1(s));
		System.out.println(solution3(s));
	}

	private static int solution3(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int l = 0, r = 0;
		int max = 0;
		while (r < s.length()) {
			if (!map.containsKey(s.charAt(r))) {
				map.put(s.charAt(r), r);
			} else {
				map.put(s.charAt(r), r);
				l++;
			}
			int len = r - l + 1;
			max = Math.max(max, len);
			r++;
		}
//		System.out.println("Max " + max);
//		System.out.println(map);
		return max;
	}

	private static int solution1(String s) {
		int max = 0;
		if (s.length() == 0) {
			return 0;
		} else if (s.length() == 1) {
			return 1;
		}
		for (int i = 0; i < s.length(); i++) {
			String ans = "";
			for (int j = i; j < s.length(); j++) {
				if (!ans.contains(s.substring(j, j + 1))) {
					ans += s.substring(j, j + 1);
				} else {
					break;
				}
				max = Math.max(max, ans.length());
			}
		}
		return max;
	}

	private static int solution2(String s) {
		int max = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int hash[] = new int[256];
			for (int j = i; j < n; j++) {
				if (hash[s.charAt(j)] == 1) {
					break;
				}
				hash[s.charAt(j)] = 1;
				int len = j - i + 1;
				max = Math.max(max, len);
			}
		}
		return max;
	}
}
