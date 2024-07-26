package com.akash.day42;

public class GCDofStrings {
	public static void main(String[] args) {
		String s1 = "abcabc";
		String s2 = "abc";
		System.out.println(gcdOfStrings1(s1, s2));
		System.out.println(gcdOfStrings2(s1, s2));
	}

	public static String gcdOfStrings1(String s1, String s2) {
		if (!(s1 + s2).equals(s2 + s1))
			return "";
		int gcd = gcd(s1.length(), s2.length());
		return s1.substring(0, gcd);
	}

	private static int gcd(int a, int b) {
//		return b == 0 ? a : gcd(b, a % b);
		while (b != 0) {
			int temp = b;// 3
			b = a % b;// 0
			a = temp;// 3
		}
		return a;
	}

	public static String gcdOfStrings2(String s1, String s2) {
		while (!s2.isEmpty()) {
			if (s1.startsWith(s2)) {
				s1 = s1.substring(s2.length());// abc
				if (s1.isEmpty()) {
					return s2;
				}
			} else {
				return "";
			}
			String temp = s1;// abc
			s1 = s2;// abc
			s2 = temp;// abc
			System.out.println(s1 + " " + s2);
		}
		return s1;
	}
}
