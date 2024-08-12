package com.akash.day52;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
	public static void main(String[] args) {
		String s = "YaZaAay";
		System.out.println(solution1(s));
		System.out.println(solution2(s));
	}

	private static String solution2(String s) {
		int maxLength = 0;
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + maxLength + 1; j <= s.length(); j++) {
				String sub = s.substring(i, j);
				if (isNice(sub)) {
					if (sub.length() > maxLength) {
						maxLength = sub.length();
						result = sub;
					}
				}
			}
		}

		return result;
	}

	private static boolean isNice(String sub) {
		for (char c = 'a'; c <= 'z'; c++) {
			char upper = Character.toUpperCase(c);
			char lower = Character.toLowerCase(c);
			if ((sub.indexOf(upper) != -1 && sub.indexOf(lower) == -1)
					|| (sub.indexOf(upper) == -1 && sub.indexOf(lower) != -1)) {
				return false;
			}
		}
		return true;
	}

	private static String solution1(String s) {
		System.out.println("String " + s);
		Set<Character> set = new HashSet<Character>();
		for (char c : s.toCharArray()) {
			set.add(c);
		}
		System.out.println(set);
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(Character.toUpperCase(s.charAt(i))) && set.contains(Character.toLowerCase(s.charAt(i)))) {
				continue;
			}

			String s1 = solution1(s.substring(0, i));// ""
			String s2 = solution1(s.substring(i + 1));
			return s1.length() >= s2.length() ? s1 : s2;
		}

		return s;
	}

}
