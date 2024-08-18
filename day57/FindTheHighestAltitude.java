package com.akash.day57;

import java.util.Arrays;

public class FindTheHighestAltitude {
	public static void main(String[] args) {
		int gain[] = { -5, 1, 5, 0, -7 };
		System.out.println(solution1(gain));
		System.out.println(solution2(gain));
	}

	private static int solution2(int[] gain) {
		int sum = 0;
		int max = 0;
		for (int i = 0; i < gain.length; i++) {
			sum = sum + gain[i];// -5 -4 1
			max = Math.max(max, sum);// 0
		}
		return max;

	}

	private static int solution1(int[] gain) {
		int altitude[] = new int[(gain.length) + 1];

		for (int i = 0; i < gain.length; i++) {
			altitude[i + 1] = altitude[i] + gain[i];
		}
		Arrays.sort(altitude);
		return altitude[altitude.length - 1];
	}

}
