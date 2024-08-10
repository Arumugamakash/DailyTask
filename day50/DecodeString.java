package com.akash.day50;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		String s = "3[a2[c]]";
		System.out.println(solution1(s));
		System.out.println(solution2(s,0));
	}

	private static String solution2(String s, int i) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		String temp = "";
		while (i < s.length()) {
			char c = s.charAt(i);
			i++;
			if (c == '[') {
				temp = solution2(s,i);
				int j = 0;
				while (j < count) {
					sb.append(temp);
					j++;
				}
				count = 0;
			} else if (c == ']')
				break;
			else if (Character.isAlphabetic(c))
				sb.append(c);
			else
				count = count * 10 + c - '0';
		}
		return sb.toString();

	}

	private static String solution1(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch != ']') {
				stack.push(ch);
				continue;
			}
			StringBuilder charString = new StringBuilder();
			while (!stack.isEmpty() && stack.peek() != '[') {
				charString.insert(0, stack.pop());
			}

			stack.pop();//

			StringBuilder numberString = new StringBuilder();
			while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
				numberString.append(stack.pop());
			}

			System.out.println(charString + "   " + numberString);

			int multiply = Integer.parseInt(numberString.reverse().toString());// 3
			String repeated = charString.toString().repeat(multiply);// aaa
			for (char c : repeated.toCharArray()) {
				stack.push(c);
			}

		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.reverse().toString();
	}

}
