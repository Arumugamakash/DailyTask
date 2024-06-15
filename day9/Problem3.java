package com.akash.day9;

import java.math.BigInteger;

public class Problem3 {
	public static void main(String[] args) {
		String s1 = "45";
		String s2 = "39";
		Problem3 p = new Problem3();
		System.out.println(p.solution1(s1, s2));
		System.out.println(p.solution2(s1, s2));

	}

	// solution 1
	private String solution1(String s1, String s2) {
		BigInteger value1 = new BigInteger(s1);
		BigInteger value2 = new BigInteger(s2);
		BigInteger ans = value1.multiply(value2);
		return ans.toString();
	}

	// solution 2
	private String solution2(String s1, String s2) {
		int result[] = new int[s1.length() + s2.length()];
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				int char1 = s1.charAt(i) - '0';
				int char2 = s2.charAt(j) - '0';
				result[i + j + 1] += char1 * char2;
			}
		}
		int carry = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			int temp = (result[i] + carry) % 10;
			carry = (result[i] + carry) / 10;
			result[i] = temp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i);
		}
		if (sb.length() != 0 && sb.charAt(0) == 0) {
			sb.deleteCharAt(0);
		}
		if (sb.length() == 0) {
			return "0";
		}
		return sb.toString();
	}

}
