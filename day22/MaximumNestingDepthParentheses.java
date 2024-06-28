package com.akash.day22;

import java.util.Stack;

public class MaximumNestingDepthParentheses {
	public static void main(String[] args) {
		String inp = "(1+(2*3)+((8)/4))+1";
		MaximumNestingDepthParentheses p = new MaximumNestingDepthParentheses();
		System.out.println(p.solution1(inp));
		System.out.println(p.solution3(inp));
	}

	// solution 1
	private int solution1(String s) {
		int ans = 0;
		int bracketCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				bracketCount++;
			} else if (s.charAt(i) == ')') {
				bracketCount--;
			}
			ans = Math.max(ans, bracketCount);
		}
		return ans;
	}

	// solution 3
	private int solution3(String s) {
		int ans = 0;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push("" + s.charAt(i));
			} else if (s.charAt(i) == ')') {
				ans = Math.max(ans, stack.size());
				stack.pop();
			}
		}

		return ans;
	}

}
