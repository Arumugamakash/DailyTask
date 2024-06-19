package com.akash.day13;

//Find the Index of the First Occurrence in a String
public class Problem2 {
	public static void main(String[] args) {
		String inp = "leetcode";
		String check = "code";
		Problem2 p = new Problem2();
		System.out.println(p.solution1(inp, check));
		System.out.println(p.solution2(inp, check));
		System.out.println(p.solution3(inp, check));
	}

	// solution 1
	private int solution1(String inp, String check) {
		int len = check.length();// 3
		int res = -1;
		if (inp.length() < check.length())
			return res;
		for (int i = 0; i <= inp.length() - len; i++) {
			if (inp.substring(i, i + len).equals(check)) {
				return i;
			}
		}
		return res;
	}

	// solution 2
	private int solution2(String inp, String check) {
		int i = 0;// index for inp
		int j = 0; // index for check
		while (i < inp.length()) {
			if (check.charAt(j) == inp.charAt(i)) {
				i++;
				j++;
			}
			if (j == check.length()) {
				return i - j;
			} else if (check.charAt(j) != inp.charAt(i)) {
				if (j != 0) {
					j = 0;
				} else {
					i++;
				}
			}
		}
		return -1;
	}

	// solution 3
	private int solution3(String inp, String check) {
		int a = inp.indexOf(check);
		return a;
	}
}
