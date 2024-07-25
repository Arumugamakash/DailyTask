package com.akash.day41;

import java.util.Stack;

public class RemoveOuterParanthesis {
	public static void main(String[] args) {
		String s = "((()())()())";
//		(()())(())(()(()))
		System.out.println(solution1(s));
		System.out.println(solution2(s));
	}

	private static String solution2(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				if (stack.size() > 0) {
					sb.append(s.charAt(i));
				}
				stack.push(s.charAt(i));
			} else {
				stack.pop();
				if (stack.size() > 0) {
					sb.append(s.charAt(i));
				}
			}
		}
		return sb.toString();
	}

	private static String solution1(String s) {
		if (s == "")
			return s;
		int k = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder str = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			if (str.charAt(i) == '(') {
				if (k > 0) {
					sb.append("(");
				}
				k++;

			} else if (str.charAt(i) == ')') {
				k--;
				if (k > 0) {
					sb.append(")");
				}

			}

		}
		return sb.toString();
	}

}
