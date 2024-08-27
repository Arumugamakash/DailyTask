package com.akash.day66;

import java.util.Stack;

public class RemovingStarsFromString {
	public static void main(String[] args) {
		String s = "leet**cod*e";
		System.out.println("Answer " + solution1(s));
		System.out.println("Answer " + solution2(s));

	}

	private static String solution1(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*' && !stack.isEmpty())
				stack.pop();
			else
				stack.push(s.charAt(i));// a
		}

		StringBuilder sb= new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();

	}

	private static String solution2(String s) {
		String store = "";
		int i = 0;
		while (i < s.length() - 1) {
			if (s.charAt(i + 1) == '*') {
				s = store + s.substring(i + 2);
				store = "";
				i = 0;
			} else {
				store += s.charAt(i);// lee
				i++;
			}
		}
		return s;
	}

}
