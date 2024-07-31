package com.akash.day46;

public class MinimumBitFlipsToConvertNumber {
	public static void main(String[] args) {
		int start = 9155;
		int goal = 3670;
		System.out.println(solution1(start, goal));
		System.out.println(solution2(start, goal));
		System.out.println(solution3(start, goal));
	}

	private static int solution1(int start, int goal) {
		int ans = start ^ goal;
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((ans & (1 << i)) != 0) {
				count++;
			}
		}
		return count;
	}

	private static int solution2(int start, int goal) {
		int res = start ^ goal;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (res >= 1) {
			sb.append(res % 2);
			res = res / 2;
		}
		System.out.println(sb);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	private static int solution3(int start, int goal) {
		return Integer.bitCount(start ^ goal);
	}
}
