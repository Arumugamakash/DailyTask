package com.akash.day40;

public class VowelsGame {
	public static void main(String[] args) {
		String s = "akash";
		System.out.println(solution1(s));
		System.out.println(solution2(s));
	}

	private static boolean solution1(String s) {
		int vowels = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i'
					|| s.charAt(i) == 'u')
				vowels++;
		}

		if (vowels == 0)
			return false;

		if (vowels % 2 != 0)
			return true;

		return true;

	}

	private static boolean solution2(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i'
					|| s.charAt(i) == 'u')
				return true;
		}

		return false;
	}

}
