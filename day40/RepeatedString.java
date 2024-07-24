package com.akash.day40;

public class RepeatedString {
	public static void main(String[] args) {
		String s = "aba";
		int n = 10;
		System.out.println(solution1(s, n));
		System.out.println(solution2(s, n));
	}

	private static long solution2(String s, int n) {
		long countA = s.chars().filter(ch -> ch == 'a').count();
		long fullRepetitions = n / s.length();
		long rem = n % s.length();
		long totalA = fullRepetitions * countA;
		for (int i = 0; i < rem; i++) {
			if (s.charAt(i) == 'a') {
				totalA++;
			}
		}

		return totalA;
	}

	private static long solution1(String s, int n) {

		StringBuilder sb = new StringBuilder(s);
		while (sb.length() < n) {
			sb.append(s);
		}
		long count = 0;
		for (int i = 0; i < n; i++) {
			if (sb.charAt(i) == 'a') {
				count++;
			}
		}
		return count;
	}
}
