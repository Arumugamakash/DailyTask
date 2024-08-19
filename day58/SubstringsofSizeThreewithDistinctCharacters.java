package com.akash.day58;

import java.util.HashSet;
import java.util.Set;

public class SubstringsofSizeThreewithDistinctCharacters {
	public static void main(String[] args) {
		String s = "aababcabc";
		System.out.println(solution1(s));
		System.out.println(solution2(s));
	}

	private static int solution2(String s) {
		int start = 0;
		int end = 0;
		String store = "";
		int count = 0;
		Set<Character> set = new HashSet<Character>();
		while (end < s.length()) {
			set.add(s.charAt(end));//
			if (end - start + 1 == 3) {
				set.remove(start);
				start++;
				if (set.size() == 3) {
					count++;
				}
				end = start;

			}
			end++;

		}
		return count;

	}

	private static int solution1(String s) {
		Set<Character> set = new HashSet<Character>();
		int count = 0;

		for (int i = 0; i <= s.length() - 3; i++) {
			for (int j = i; j < i + 3; j++) {
				set.add(s.charAt(j));
			}
			System.out.println(set);
			if (set.size() == 3) {
				count++;
			}
			set = new HashSet<Character>();
		}
		return count;
	}

}
