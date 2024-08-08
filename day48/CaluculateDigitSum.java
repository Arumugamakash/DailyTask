package com.akash.day48;

public class CaluculateDigitSum {
	public static void main(String[] args) {
		String s = "11111222223";
		int k = 3;
		// System.out.println("Final Ans :" + solution2(s, k));
		System.out.println("Final Ans :" + solution3(s, k));
	}

	private static String solution2(String s, int k) {

		while (s.length() > k) {
			int i = 0;
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			while (i < (s.length() - k)) {

				String digit = s.substring(i, k + i);
				int j = 0;
				System.out.println(digit);
				while (j < digit.length()) {
					sum += digit.charAt(j) - '0';
					j++;
				}
				sb.append(sum);
				System.out.println(sum);
				i += k;
				sum = 0;
			}
			sum = 0;
			while (i < s.length()) {
				sum += s.charAt(i) - '0';
				i++;
			}
			sb.append(sum);
			System.out.println(sb);
			s = sb.toString();
		}
		return s;
	}

	private static String solution3(String s, int k) {
		if (s.length() <=k) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (int i = 1; i <= s.length(); i++) {

			sum += s.charAt(i - 1) - '0';
			if (i % k == 0 || s.length() == i) {
				sb.append(sum);
				sum = 0;
			}
		}
		System.out.println(sb);
		return solution3(sb.toString(), k);
	}
}
