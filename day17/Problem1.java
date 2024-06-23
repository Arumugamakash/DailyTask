package com.akash.day17;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
	public static void main(String[] args) {
		String s = "abc";
		Problem1 p = new Problem1();
		p.solution1(0, s, " ");
		System.out.println(p.solution2(s));
	}

	// solution 1
	private void solution1(int i, String s, String temp) {
		if (i == s.length()) {
			System.out.print(temp + " ");
			return;
		}
		solution1(i + 1, s, temp + s.charAt(i));
		solution1(i + 1, s, temp);
	}

	// solution 2
	private List<String> solution2(String s) {
		List<String> result = new ArrayList<>();
		int len = s.length();
		int max = 1 << len;
		for (int i = 0; i < max; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < len; j++) {
				if ((i & (1 << j)) != 0) {
					sb.append(s.charAt(j));
				}
			}
			result.add(sb.toString());
		}

		return result;
	}

}
