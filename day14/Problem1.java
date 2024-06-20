package com.akash.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Find the common character in the array
public class Problem1 {
	public static void main(String[] args) {
		String s[] = { "bella", "label", "roller" };
		Problem1 p = new Problem1();
//		System.out.println(p.solution1(s));
//		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution 1
	public List<String> solution1(String[] words) {
		List<String> list = new ArrayList<>();
		String first = words[0];
		int count = 0;
		for (int i = 0; i < first.length();) {
			count = 0;
			for (int j = 1; j < words.length; j++) {
				String str = words[j];// label
				for (int k = 0; k < str.length(); k++) {
					if (str.charAt(k) == first.charAt(i)) {
						count++;
						str = str.replaceFirst("" + str.charAt(k), "*");
						break;
					}
				}
				words[j] = words[j].replace(words[j], str);
			}
			if (count == words.length - 1) {
				list.add("" + first.charAt(i));
			}
			i++;
		}
		return list;

	}

	// solution 2
	private List<String> solution2(String[] s) {
		int arr[] = new int[26];
		for (int j = 0; j < s.length; j++) {
			String str = s[j];
			for (int i = 0; i < str.length(); i++) {
				int num = (str.charAt(i) - 'a');
				arr[num]++;
			}
		}
		return commonCharacer(arr, s.length);
	}

	private List<String> commonCharacer(int[] arr, int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n || arr[i] > n) {
				int count = arr[i];
				while (count >= n) {
					list.add("" + (char) (i + 'a'));
					count = count - n;
				}
			}
		}
		return list;
	}

	// solution 3
	private List<String> solution3(String[] s) {
		List<HashMap<Character, Integer>> list = new ArrayList<>();

		for (String word : s) {
			HashMap<Character, Integer> map = new HashMap<>();
			for (char c : word.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			list.add(map);
		}

		List<String> result = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) {
			int min = Integer.MAX_VALUE;
			for (HashMap<Character, Integer> map : list) {
				min = Math.min(min, map.getOrDefault(c, 0));
			}
			for (int i = 0; i < min; i++) {
				result.add(String.valueOf(c));
			}
		}
		return result;
	}
}
