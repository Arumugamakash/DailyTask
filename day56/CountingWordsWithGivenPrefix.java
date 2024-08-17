package com.akash.day56;

public class CountingWordsWithGivenPrefix {
	public static void main(String[] args) {
		String words[] = { "pay", "attention", "practice", "attend" };
		String pref = "at";
		System.out.println(solution1(words, pref));
		System.out.println(solution2(words, pref));
		System.out.println(solution3(words, pref));
	}

	private static int solution3(String[] words, String pref) {
		int n = pref.length();
		int count = words.length;
		for (String x : words) {
			for (int i = 0; i < n; i++)
				if (x.charAt(i) != pref.charAt(i)) {
					count--;
					break;
				}

		}

		return count;
	}

	private static int solution1(String[] words, String pref) {
		int count = 0;
		for (String word : words) {
			if (word.startsWith(pref))
				count++;
		}

		return count;
	}

	private static int solution2(String[] words, String pref) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];// leetcode
			for (int j = 0; j < word.length() - pref.length(); j++) {
				if (word.substring(j, j + pref.length()).equals(pref)) {
					count++;
					break;
				}
			}
		}
		return count;
	}

}
