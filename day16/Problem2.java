package com.akash.day16;

/*
 2.change the order of words in the string
Sample: one two three
Output : three two one

 */
import java.util.Arrays;
import java.util.Stack;

public class Problem2 {
	public static void main(String[] args) {
		String s = "one two three";
		Problem2 p = new Problem2();
		System.out.println(p.solution3(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution1(s));
	}

	// solution 1
	private String solution1(String s) {
		Stack<String> stack = new Stack<String>();
		String sp[] = s.split(" ");
		for (int i = 0; i < sp.length; i++) {
			stack.push(sp[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		return sb.toString();
	}

	// solution 2
	private String solution2(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; j < s.length(); j++) {
			if (s.charAt(j) == ' ') {
				sb.insert(0, " " + s.substring(i, j));
				i = j + 1;
			} else if (j == s.length() - 1) {
				sb.insert(0, s.substring(i, j + 1));
			}
		}
		return sb.toString();
	}

	// solution 3
	private String solution3(String s) {
		String sp[] = s.split(" ");
		String ans = "";
		for (int i = sp.length - 1; i >= 0; i--) {
			ans += sp[i] + " ";
		}
		return ans;
	}

}
