package com.akash.day55;

import java.util.Arrays;

public class KidsWithCandies {
	public static void main(String[] args) {
		int[] candies = { 2, 3, 5, 1, 3 };
		int extraCandies = 3;
		boolean[] result = solution1(candies, extraCandies);
		result = solution2(candies, extraCandies);
		System.out.println(Arrays.toString(result));
	}

	private static boolean[] solution2(int[] candies, int extraCandies) {
		int n = candies.length;
		boolean[] result = new boolean[n];
		int maxCandies = 0;
		for (int candy : candies) {
			if (candy > maxCandies) {
				maxCandies = candy;
			}
		}
		for (int i = 0; i < n; i++) {
			result[i] = candies[i] + extraCandies >= maxCandies;
		}

		return result;
	}

	private static boolean[] solution1(int[] candies, int extraCandies) {
		int n = candies.length;
		boolean[] result = new boolean[n];

		for (int i = 0; i < n; i++) {
			int totalCandies = candies[i] + extraCandies;
			result[i] = true;

			for (int j = 0; j < n; j++) {
				if (candies[j] > totalCandies) {
					result[i] = false;
					break;
				}
			}
		}

		return result;
	}

}
