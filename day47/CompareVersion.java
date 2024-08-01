package com.akash.day47;

public class CompareVersion {
	public static void main(String[] args) {
		String v1 = "1.0.23";
		String v2 = "1.0.24";
		System.out.println(solution1(v1, v2));
		System.out.println(solution2(v1, v2));
		System.out.println(solution3(v1, v2));
	}

	private static String solution3(String v1, String v2) {
		if (v1.compareTo(v2) < 0)
			return "Upgrade";
		else if (v1.compareTo(v2) > 0)
			return "Downgrade";
		else
			return "equal";
	}

	private static int solution2(String v1, String v2) {
		String[] sp1 = v1.split("\\.");
		String[] sp2 = v2.split("\\.");
		int min = Math.min(sp1.length, sp2.length);
		int i = 0;
		while (i < min) {
			int num1 = i < sp1.length ? Integer.parseInt(sp1[i]) : 0;
			int num2 = i < sp2.length ? Integer.parseInt(sp2[i]) : 0;
			if (num1 != num2) {
				return Integer.compare(num1, num2);
			}
			i++;
		}
		return 0;

	}

	private static String solution1(String v1, String v2) {

		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		for (int i = 0; i < v1.length(); i++) {
			if (v1.charAt(i) != '.') {
				s1.append(v1.charAt(i));
				s2.append(v2.charAt(i));
			}
		}

		if (Integer.parseInt(s1.toString()) < Integer.parseInt(s2.toString()))
			return "Upgrade";
		else if (Integer.parseInt(s1.toString()) > Integer.parseInt(s2.toString()))
			return "Downgrade";
		else
			return "equal";
	}
}
