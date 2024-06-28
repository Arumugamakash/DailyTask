package com.akash.day22;

import java.util.Arrays;

public class RemoveThePalindromeWords {
	public static void main(String[] args) {
		String inp = "He did a good deed";
		RemoveThePalindromeWords p = new RemoveThePalindromeWords();
		System.out.println(p.solution1(inp));
		System.out.println(p.solution2(inp));
		System.out.println(p.solution3(inp));
	}

	// solution 1
	private String solution1(String inp) {
		String sp[] = inp.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sp.length; i++) {
			StringBuilder word = new StringBuilder(sp[i]);
			if (!sp[i].equals(word.reverse().toString())) {
				sb.append(sp[i] + " ");
			}
		}
		return sb.toString();
	}

	// solution 2
	private String solution2(String inp) {
		StringBuilder sb = new StringBuilder(inp);
		StringBuilder res = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != ' ') {
				res.append(sb.charAt(i));
			} else {
				String s = res.toString();
				if (!s.equals(res.reverse().toString())) {
					ans.append(s + " ");
				}
				res = new StringBuilder();
			}
		}
		return ans.toString();
	}

	// solution 3
	private String solution3(String inp) {
		String sp[] = inp.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sp.length; i++) {
			if (!isPalindrome(sp[i])) {
				sb.append(sp[i] + " ");
			}
		}
		return sb.toString();
	}

	private boolean isPalindrome(String str) {
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		if (rev.equals(str)) {
			return true;
		}
		return false;
	}

}
