package com.akash.day48;

import java.util.Stack;

public class ClearDigits {
	public static void main(String[] args) {
		String s = "cb3c4";
		System.out.println("ANS " + solution1(s));
		System.out.println("ANS " + solution2(s));

	}

	private static String solution2(String s) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		int i = 0;
		int count = 0;
		while (i < s.length()) {
			if (stack.peek() >= '0' && stack.peek() <= '9') {
				stack.pop();
				count++;
			} else {
				if (count != 0) {
					stack.pop();
					count--;
				}

			}
			i++;
		}
		if (stack.isEmpty()) {
			return "";
		} else {
			for (Character ch : stack) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	private static String solution1(String s) {
		int len = 0;
		String sb = new String();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sb = sb.substring(0, len - 1);
				len--;
			} else {
				sb += s.charAt(i);
				len = sb.length();
			}
		}
		return sb;
	}

}
