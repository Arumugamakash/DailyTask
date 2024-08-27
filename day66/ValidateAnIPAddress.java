package com.akash.day66;

import java.util.StringTokenizer;

public class ValidateAnIPAddress {
	public static void main(String[] args) {
		String s = "";
		System.out.println(solution1(s));
		System.out.println(solution2(s));
	}

	private static boolean solution1(String str) {

		StringTokenizer tokenizer = new StringTokenizer(str, ".");
		if (tokenizer.countTokens() != 4) {
			return false;
		}
		while (tokenizer.hasMoreTokens()) {
			String part = tokenizer.nextToken();
			if (part.length() == 0 || part.length() > 3) {
				return false;
			}
			if (part.charAt(0) == '0' && part.length() > 1) {
				return false;
			}
			for (char c : part.toCharArray()) {
				if (!Character.isDigit(c)) {
					return false;
				}
			}
			int num = Integer.parseInt(part);
			if (num < 0 || num > 255) {
				return false;
			}
		}
		return true;
	}

	private static boolean solution2(String str) {
		String[] s = str.split("\\.");

		if (s.length != 4)
			return false;

		for (String st : s) {
			if (st.length() == 0 || st.length() > 3)
				return false;

			if (st.charAt(0) == '0' && st.length() > 1)
				return false;

			for (int i = 0; i < st.length(); i++)
				if (!Character.isDigit(st.charAt(i)))
					return false;

			int num = Integer.parseInt(st);
			if (num < 0 || num > 255)
				return false;

		}

		return true;
	}

}
