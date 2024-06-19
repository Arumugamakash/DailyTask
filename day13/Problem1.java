package com.akash.day13;

import java.util.Stack;

//valid paranthasis
public class Problem1 {
	public static void main(String[] args) {
		String s = "()]{}";
		Problem1 p = new Problem1();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution 1
	private boolean solution1(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(')');
			else if (s.charAt(i) == '{')
				stack.push('}');
			else if (s.charAt(i) == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != s.charAt(i))
				return false;
		}
		return stack.isEmpty();
	}

	// solution 2
	private boolean solution2(String s) {
		int arr[] = new int[3];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				arr[0]++;
			} else if (s.charAt(i) == ']' || s.charAt(i) == '[') {
				arr[1]++;
			} else {
				arr[2]++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	// solution 3
	private boolean solution3(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char pop = stack.pop();
				if (s.charAt(i) == ')' && pop != '(' || s.charAt(i) == '}' && pop != '{'
						|| s.charAt(i) == ']' && pop != '[') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}
