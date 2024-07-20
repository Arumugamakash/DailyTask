package com.akash.day36;

public class ValidWord {
	public static void main(String[] args) {
		String s = "234Adas";
		ValidWord p = new ValidWord();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
	}

	private boolean solution2(String word) {
		if (word.length() < 3) {
			return false;
		}
		int vowels = 0, letter = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				ch = Character.toLowerCase(ch);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					vowels++;
				} else {
					letter++;
				}
			} else if (ch >= '0' && ch <= '9') {
				continue;
			} else {
				return false;
			}
		}
		return vowels > 0 && letter > 0;
	}

	private boolean solution1(String word) {
		boolean number = false;
		boolean letter = false;
		boolean vowels = false;
		boolean constant = false;
		if (word.length() >= 3) {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
					number = true;
				}
				if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
						|| word.charAt(i) == 'u' || word.charAt(i) == 'A' || word.charAt(i) == 'E'
						|| word.charAt(i) == 'I' || word.charAt(i) == 'O' || word.charAt(i) == 'U') {
					vowels = true;
				}
				if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
						|| (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
					letter = true;
					constant = true;
				} else {
					System.out.println(i + "hix");
					return false;
				}
			}
		} else {
			return false;
		}
		return (constant && letter && number && vowels);
	}
}
