package com.akash.day25;

import java.util.Stack;

public class ReverseVowelsOfString {
	public static void main(String[] args) {
		String s = "leetcode";
		s.replace(s.charAt(0), s.charAt(3));
		System.out.println(s);
		ReverseVowelsOfString p = new ReverseVowelsOfString();
		System.out.println(p.solution3(s));
		System.out.println(p.solution2(s));
	}

	private String solution2(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U')
				stack.push(s.charAt(i));
		}

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U' && !stack.isEmpty())
				str.append(stack.pop());
			else
				str.append(s.charAt(i));
		}

		return str.toString();
	}

	private char[] solution3(String s) {
		char ch[] = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			boolean s1 = checkVowels(s.charAt(start));//
			boolean e1 = checkVowels(s.charAt(end));//
			if (s1 == true && e1 == true) {
				char temp = ch[start];// e
				ch[start] = ch[end];
				ch[end] = temp;
				start++;
				end--;
			}
			if (!s1) {
				start++;
			}
			if (!e1) {
				end--;
			}
		}
		return ch;

	}

	private boolean checkVowels(char ch) {
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
		}
	}

}
