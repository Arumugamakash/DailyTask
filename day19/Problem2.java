package com.akash.day19;

import java.util.Arrays;

public class Problem2 {
	public static void main(String[] args) {
		String s = "malayalam";
		Problem2 p = new Problem2();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution1
	private int solution1(String s) {
		for (int i = 0; i < s.length(); i++) {
			int count = 0;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					count++;
				}
			}
			if (count == 0)
				return i;
		}
		return 0;
	}

	// solution 2
	private int solution2(String s) {
		for (int i = 0; i < s.length(); i++) {
			boolean flag = true;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && s.charAt(i) != ' ') {
					s.replace(s.charAt(j), ' ');
					flag = false;
				}
			}
			if (flag) {
				return i;
			}
		}
		return 0;
	}

	// solution3
	private int solution3(String s) {
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		System.out.println(Arrays.toString(arr));
		return 0;
	}
}
