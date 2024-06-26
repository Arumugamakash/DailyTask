package com.akash.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
	public static void main(String[] args) {
		String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String banned[] = { "hit" };
		Problem2 p = new Problem2();
		System.out.println(p.mostCommonWord1(s, banned));
		System.out.println(p.mostCommonWord2(s, banned));
		System.out.println(p.mostCommonWord3(s, banned));
	}

	// solution 1
	public String mostCommonWord1(String paragraph, String[] banned) {
		paragraph = paragraph.toLowerCase();
		List<String> bannedList = Arrays.asList(banned);
		Map<String, Integer> map = new HashMap<String, Integer>();
		int max = 0;
		String sp[] = paragraph.split(" ");
		for (int i = 0; i < sp.length; i++) {
			String s = sp[i];
			char ch = s.charAt(s.length() - 1);
			if (!(ch >= 'a' && ch <= 'z')) {
				s = s.substring(0, s.length() - 1);
			}
			if (map.containsKey(s)) {
				map.put(s, map.getOrDefault(s, 0) + 1);
			} else {
				map.put(s, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (!bannedList.contains(key)) {
				max = Math.max(val, max);
			}
		}
		System.out.println(max);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (max == val) {
				return key;
			}
		}
		return "";
	}

	// solution 2
	private String mostCommonWord2(String paragraph, String[] banned) {
		paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
		String sp[] = paragraph.split(" ");
		List<String> bannedList = Arrays.asList(banned);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : sp) {
			if (!word.isEmpty() && !bannedList.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		System.out.println(map);
		String res = "";
		int maxCount = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			if (val > maxCount) {
				maxCount = val;
				res = key;
			}
		}
		return res;
	}

	// solution 3
	private String mostCommonWord3(String paragraph, String[] banned) {
		paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
		String sp[] = paragraph.split(" ");
		List<String> newList = new ArrayList<String>();
		List<String> paragraphList = Arrays.asList(sp);
		System.out.println("hi" + paragraphList);
		List<String> bannedlist = Arrays.asList(banned);
		for (int i = 0; i < paragraphList.size(); i++) {
			for (String word : bannedlist) {
				if (!paragraphList.get(i).isEmpty() && !paragraphList.get(i).equals(word)) {
					newList.add(paragraphList.get(i));
				}
			}
		}
		String mostCommonWord = "";
		// int maxCount = 0;
		Collections.sort(newList);
		for (int i = 0; i < newList.size() - 1; i++) {
			int count = 0;
			if (newList.get(i).equals(newList.get(i + 1))) {
				mostCommonWord = newList.get(i);
			}
//			else {
//				maxCount=0;
//			}
		}
		System.out.println(newList);

		return mostCommonWord;
	}

}
