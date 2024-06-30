package com.akash.day24;

import java.util.Arrays;
import java.util.HashMap;

public class Problem2 {
	public static void main(String[] args) {
		String s = "abcd", t = "abcde";
		Problem2 p = new Problem2();
		System.out.println(p.solution1(s, t));
		System.out.println(p.solution2(s, t));
	}

	// solution 1
	private char solution1(String s, String t) {
		int[] arr = new int[26];
		for (int i = 0; i < t.length(); i++) {
			arr[t.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']--;
		}
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > 0) {
				return (char) (i + 'a');
			}

		return ' ';
	}

	// solution 2
	private char solution2(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (char c : s.toCharArray()) {
			map.put(c, map.get(c) - 1);
			if (map.get(c) == 0) {
				map.remove(c);
			}
		}

		for (char c : map.keySet()) {
			return c;
		}

		return ' ';
	}

}
