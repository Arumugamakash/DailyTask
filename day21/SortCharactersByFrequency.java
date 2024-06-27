package com.akash.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharactersByFrequency {
	public static void main(String[] args) {
		String s = "baAb";
		SortCharactersByFrequency p = new SortCharactersByFrequency();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
	}

	private String solution2(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char ch[] = s.toCharArray();
		for (char c : ch) {
			if (map.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			} else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
		List<Character>[] list = new List[s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			list[i] = new ArrayList<>();
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			list[val].add(key);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= list.length - 1; i++) {
			for (char c : list[i]) {
				for (int j = 0; j < i; j++) {
					sb.append(c);
				}
			}
		}
		return sb.reverse().toString();
	}

	private String solution1(String s) {
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

	private String sortMapByValue(Map<Character, Integer> map) {
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		StringBuilder sb = new StringBuilder();
		// sort the list
		list.sort(Map.Entry.comparingByValue());
		System.out.println(list);
		for (Entry<Character, Integer> entry : list) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			while (val > 0) {
				sb.append(key);
				val--;
			}
		}

		return sb.reverse().toString();
	}

}
