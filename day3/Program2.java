package com.akash.day3;

import java.util.Arrays;

public class Program2 {
	public static void main(String[] args) {
		String s1 = "army";
		String s2 = "mary";
		Program2 p = new Program2();
		System.out.println("Given String is : " + p.solution1(s1, s2));
		boolean b1 = p.solution2(s1, s2);
		String ans = b1 ? "Anagram" : "Not a Angram";
		System.out.println(ans);
		boolean b2 = p.solution3(s1, s2);
		ans = b2 ? "Anagram" : "Not a Angram";
		System.out.println(ans);

	}

	// SOLUTION 1
	private String solution1(String s1, String s2) {
		String ans = "Not Anagram";
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char ch1[] = s1.toCharArray();
		Arrays.sort(ch1);
		char ch2[] = s2.toCharArray();
		Arrays.sort(ch2);
		if (ch1.length != ch2.length) {
			return ans;
		} else {
			for (int i = 0; i < ch2.length; i++) {
				if (ch1[i] != ch2[i]) {
					return ans;
				}
			}
			ans = "Anagram";
			return ans;
		}
	}

	// SOLUTION 2
	private boolean solution2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] count = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}

		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}

		return true;
	}

	// SOLUTION 3
	private boolean solution3(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		return Arrays.equals(charArray1, charArray2);
	}
}
