package com.akash.day67;

import java.util.ArrayList;
import java.util.List;

public class GenerateIPAddress {
	public static void main(String[] args) {
		String s = "1111";
		System.out.println(solution1(s));
	}

	private static boolean isValid(String s) {
		if (s.length() > 1 && s.startsWith("0"))
			return false;
		int value = Integer.parseInt(s);
		return value >= 0 && value <= 255;
	}

	public static List<String> solution1(String s) {
		List<String> result = new ArrayList<>();
		int n = s.length();
		if (n < 4 || n > 12)
			return result;

		for (int i = 1; i < 4 && i < n - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < n; k++) {
					String part1 = s.substring(0, i);
					String part2 = s.substring(i, j);
					String part3 = s.substring(j, k);
					String part4 = s.substring(k);

					if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
						result.add(part1 + "." + part2 + "." + part3 + "." + part4);
					}
				}
			}
		}
		return result;
	}

}
