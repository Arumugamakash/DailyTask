package com.akash.day53;

import java.util.Arrays;

public class ReverseString3 {
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		solution1(s);
		System.out.println(solution2(s));
		System.out.println(solution3(s));
	}

	private static String solution3(String s) {
		String arr[] = s.split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new StringBuilder(arr[i]).reverse().toString();
		}
		return String.join(" ", arr);
	}

	private static String solution2(String s) {
		String add = "";
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				add += s.charAt(i);
			}
			if (s.charAt(i) == ' ' || i == s.length() - 1) {
				System.out.println(add);
				ans.append(reverse(add) + " ");
				add = "";
			}
		}
		ans.deleteCharAt(ans.length() - 1);
		return ans.toString();
	}

	private static String reverse(String add) {
		String rev = "";
		for (int i = add.length() - 1; i >= 0; i--) {
			rev += add.charAt(i);
		}
		return rev;
	}

	private static void solution1(String s) {
		String sp[] = s.split(" ");
		System.out.println(Arrays.toString(sp));
		s = "";
		for (int i = 0; i < sp.length; i++) {
			StringBuilder sb = new StringBuilder(sp[i]);
			if (i != sp.length - 1) {
				s += sb.reverse().toString() + " ";
			} else {
				s += sb.reverse().toString();
			}
		}
		System.out.println(s);
	}
}
