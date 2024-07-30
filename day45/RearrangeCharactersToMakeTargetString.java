package com.akash.day45;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharactersToMakeTargetString {
	public static void main(String[] args) {
		String s = "ilovecodingonleetcode";
		String target = "code";
		System.out.println(solution1(s, target));
		System.out.println(solution2(s, target));
	}

	private static int solution2(String s, String target) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
			map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);

		for (int i = 0; i < target.length(); i++)
			map2.put(target.charAt(i), map2.getOrDefault(target.charAt(i), 0) + 1);

		int min = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : map2.entrySet()) {

			char c = entry.getKey();
			int y = entry.getValue();
			if (!map1.containsKey(c))
				return 0;

			int x = map1.get(c);

			min = Math.min(min, (x / y));

		}

		return min;
	}

	private static int solution1(String s, String target) {
		int[] arr1 = new int[26];
		int arr2[] = new int[26];
		for (char ch : s.toCharArray()) {
			arr1[ch - 'a']++;
		}
		for (char ch : target.toCharArray()) {
			arr2[ch - 'a']++;
		}

		int min = Integer.MAX_VALUE;
		for (char ch : target.toCharArray())
			min = Math.min(min, arr1[ch - 'a'] / arr2[ch - 'a']);

		return min;
	}

}
