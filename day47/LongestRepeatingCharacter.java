package com.akash.day47;

public class LongestRepeatingCharacter {

	public static void main(String[] args) {
		String s = "AABBABA";
		int k = 2;
		System.out.println(solution1(s, k));
		System.out.println(solution2(s, k));
	}

	private static int solution2(String s, int k) {
		int ans = 0;
		int n = s.length();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			int i = 0, j = 0, replaced = 0;
			while (j < n) {
				if (s.charAt(j) == ch) {
					j++;
				} else if (replaced < k) {
					j++;
					replaced++;
				} else if (s.charAt(i) == ch) {
					i++;
				} else {
					i++;
					replaced--;
				}
				ans = Math.max(ans, j - i);
			}
		}
		return ans;
	}

	private static int solution1(String s, int k) {
		int left = 0;
		int max = 0;
		int count = 0;
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);// A
			freq[ch - 'A']++;
			max = Math.max(max, freq[ch - 'A']);
			while (i - left + 1 - max > k) {
				freq[s.charAt(left++) - 'A']--;
			}
			count = Math.max(count, i - left + 1);
		}
		return count;
	}

}
