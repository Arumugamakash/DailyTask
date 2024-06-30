package com.akash.day24;

public class Problem1 {
	public static void main(String[] args) {
		String s1 = "test123string";
		String s2 = "123";
		Problem1 p = new Problem1();
		System.out.println(p.solution1(s1, s2));
		System.out.println(p.solution2(s1, s2));
		System.out.println(p.solution3(s1, s2));
	}

	// solution 1
	private int solution1(String s1, String s2) {
		int len = s2.length();
		for (int i = 0; i < s1.length() - len; i++) {
			if (s1.substring(i, i + len).equals(s2)) {
				return i;
			}
		}
		return -1;
	}

	// solution 2
	private int solution2(String s1, String s2) {
		if (s1.contains(s2)) {
			return s1.indexOf(s2);
		}
		return -1;
	}

	// solution 3
	private int solution3(String s1, String s2) {
		if (s1.matches(".*" + s2 + ".*"))
			return s1.indexOf(s2);

		return -1;
	}
}
