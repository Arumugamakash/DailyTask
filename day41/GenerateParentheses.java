package com.akash.day41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(solution1(n));
	}

	private static List<String> solution1(int n) {
		List<List<String>> dp = new ArrayList<>();
		dp.add(Collections.singletonList(""));
		System.out.println(dp);
		for (int i = 1; i <= n; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				for (String left : dp.get(j)) {
					for (String right : dp.get(i - 1 - j)) {
						list.add("(" + left + ")" + right);
					}
				}
			}
			dp.add(list);
		}

		return dp.get(n);
	}
}
