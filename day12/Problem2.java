package com.akash.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  Group Anagrams
public class Problem2 {
	public static void main(String[] args) {
		String s[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		Problem2 p = new Problem2();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution 1
	private List<List<String>> solution1(String[] s) {
		List<List<String>> out = new ArrayList<List<String>>();
		for (int i = 0; i < s.length; i++) {
			List<String> list = new ArrayList<String>();
			if (!s[i].equals("empty")) {
				char ch1[] = s[i].toCharArray();
				Arrays.sort(ch1);
				String s1 = new String(ch1);
				list.add(s[i]);
				s[i] = "empty";
				for (int j = i + 1; j < s.length; j++) {
					if (!s[j].equals("empty")) {
						char ch2[] = s[j].toCharArray();// t e a
						Arrays.sort(ch2);
						String s2 = new String(ch2);
						if (s1.equals(s2)) {
							list.add(s[j]);
							s[j] = "empty";
						}
					}
				}
				out.add(list);
			}
		}
		return out;
	}

	// solution 2
	private List<List<String>> solution2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ch1 = s.toCharArray();// eat
			Arrays.sort(ch1);// aet
			String sorted = new String(ch1);// eat

			if (!map.containsKey(sorted)) {// eat
				map.put(sorted, new ArrayList<String>());
			}
			map.get(sorted).add(s);
		}

		return new ArrayList<>(map.values());
	}

	// solution 3
	private List<List<String>> solution3(String[] s) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String element : s) {
			int count[] = new int[26];
			for (char ch : element.toCharArray()) {
				count[ch - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count.length; i++) {
				sb.append(count[i]);
			}
			if (!map.containsKey(sb.toString())) {
				map.put(sb.toString(), new ArrayList<String>());
			}
			map.get(sb.toString()).add(element);
		}
		return new ArrayList<List<String>>(map.values());
	}

}
