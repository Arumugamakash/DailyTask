package com.akash.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//word pattern
public class Problem3 {
	public static void main(String[] args) {
		String pattern = "abba";
		String word = "dog cat cat dog";
		Problem3 p = new Problem3();
		System.out.println(p.solution1(pattern, word));
		System.out.println(p.solution2(pattern, word));
	}

	// solution 1
	private boolean solution1(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		String[] arr = str.split(" ");
		if (pattern.length() != arr.length)
			return false;
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(arr[i]))
					return false;
			} else if (map.containsValue(arr[i]))
				return false;
			map.put(pattern.charAt(i), arr[i]);
		}
		return true;
	}

	// solution 2
	private boolean solution2(String pattern, String word) {
		Map<Character, String> map = new HashMap<Character, String>();
		List<String> list = new ArrayList<String>();
		String words[] = word.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}
		for (int i = 0; i < words.length; i++) {
			String str = words[i];
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(str)) {
					return false;
				}
			} else {
				if (list.contains(str)) {
					return false;
				}
				map.put(pattern.charAt(i), str);
				list.add(str);
			}
		}
		return true;
	}
}
