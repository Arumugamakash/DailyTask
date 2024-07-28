package com.akash.day43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		String s = "Aabb";// Aabb
		// System.out.println(solution1(s));
		// System.out.println(solution2(s));
		System.out.println(solution3(s));
	}

	private static String solution3(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		// sort the map
		return sortMapByValue(map);
	}

	private static String sortMapByValue(Map<Character, Integer> map) {
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		StringBuilder sb = new StringBuilder();
		// sort the list
		list.sort(Map.Entry.comparingByValue());
		Map<Character, Integer> sortedValue = new LinkedHashMap<Character, Integer>();
		for (Map.Entry<Character, Integer> entry : list) {
			sortedValue.put(entry.getKey(), entry.getValue());
		}
		for (Map.Entry<Character, Integer> entry : sortedValue.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			while (val > 0) {
				sb.append(key);
				val--;
			}
		}
		return sb.reverse().toString();
	}

	private static String solution2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
		List<Character>[] buckets = new List[s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			buckets[i] = new ArrayList<>();
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			buckets[val].add(key);
		}
//		for (List<Character> list : buckets) {
//			System.out.println(list);
//		}
		StringBuilder sb = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (!buckets[i].isEmpty()) {
				for (char c : buckets[i]) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}

		return sb.toString();
	}

	private static String solution1(String s) {
		int alpha[] = new int[52];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				int a = (s.charAt(i) - 'A');
				System.out.println(a);
				alpha[(s.charAt(i) - 'A') + 26]++;
			} else {
				alpha[s.charAt(i) - 'a']++;
			}
		}
		System.out.println(Arrays.toString(alpha));
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] != 0 && i < 26) {
				map.put((char) ('a' + i), alpha[i]);
			} else if (alpha[i] != 0 && i > 25) {
				System.out.println(i);
				map.put((char) ('A' + (i - 26)), alpha[i]);
			}
		}
		List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

		// Sort the list by values in descending order
		entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		System.out.println(entryList);
		for (Map.Entry<Character, Integer> entry : entryList) {
			int val = entry.getValue();
			while (val > 0) {
				sb.append(entry.getKey());
				val--;
			}
		}
		return sb.toString();
	}

	private static char[] alpha() {
		char alpha[] = new char[26];
		char ch = 'a';
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = ch++;
		}
		return alpha;
	}
}
