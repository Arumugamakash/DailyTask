package com.akash.day44;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		String s = "235";
		System.out.println(solution1(s));
		System.out.println(solution2(s));
	}

	private static List<String> solution2(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}

		StringBuilder sb = new StringBuilder();
		int index = 0;
		recursiveCombination(result, sb, s, index);
		return result;
	}

	private static void recursiveCombination(List<String> result, StringBuilder sb, String s, int index) {
		if (s.length() == index) {
			result.add(sb.toString());
			return;
		}
		String letter = combination(s.charAt(index));
		for (char ch : letter.toCharArray()) {
			sb.append(ch);
			recursiveCombination(result, sb, s, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static List<String> solution1(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}
		result.add("");
		for (int i = 0; i < s.length(); i++) {
			String letter = combination(s.charAt(i));
			List<String> temp = new ArrayList<String>();
			for (String combination : result) {
				for (char ch : letter.toCharArray()) {
					temp.add(combination + ch);
				}
			}
			result = temp;
		}
		return result;
	}

	private static String combination(char ch) {
		switch (ch) {
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "pqrs";
		case '8':
			return "tuv";
		case '9':
			return "wxyz";
		default:
			return "";
		}
	}

}
