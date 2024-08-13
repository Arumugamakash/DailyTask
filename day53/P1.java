package com.akash.day53;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1 {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "ooolleoooleh";
		System.out.println(solution1(s1, s2));
		System.out.println(solution2(s1, s2));
	}

	private static boolean solution1(String s1, String s2) {
		Map<Character, Integer> need = new HashMap<Character, Integer>();
		Map<Character, Integer> have = new HashMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++) {
			need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
		}
		System.out.println(need);
		int l = 0;
		int r = 0;
		while (r < s2.length()) {
			char c = s2.charAt(r);/// o
			if (!need.containsKey(c)) {
				r += 1;
				l = r;
				have.clear();
				continue;
			}
//			if (!have.containsKey(c)) {
//				have.put(c, 0);
//			}
//			have.put(c, have.get(c) + 1);
			have.put(c, have.getOrDefault(c, 0) + 1);
			System.out.println("Befo " + have);
//			}
			if (have.get(c) > need.get(c)) {
				char startChar = s2.charAt(l);// o
				have.put(startChar, have.get(startChar) - 1);
				System.out.println("after have" + have);
				l += 1;
			}
			int windowSize = r - l + 1;
			if (windowSize == s1.length()) {
				return true;
			}
			r += 1;
		}
		return false;
	}

	private static boolean solution2(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		int[] s1Freq = new int[26];
		int[] s2Freq = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			s1Freq[s1.charAt(i) - 'a']++;
			s2Freq[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length() - s1.length(); i++) {
			if (Arrays.equals(s1Freq, s2Freq)) {
				return true;
			}
			s2Freq[s2.charAt(i + s1.length()) - 'a']++;
			s2Freq[s2.charAt(i) - 'a']--;
		}

		return Arrays.equals(s1Freq, s2Freq);
	}
}
