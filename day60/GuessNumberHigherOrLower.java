package com.akash.day60;

public class GuessNumberHigherOrLower {
	public static void main(String[] args) {
		int n = 10;
		int pick = 6;
		System.out.println(solution2(n, pick));
		System.out.println(solution1(n, pick));
	}

	private static int solution1(int n, int pick) {
		return binarySearch(1, n, pick);

	}

	private static int binarySearch(int start, int end, int pick) {
		int mid = start + (end - start) / 2;

		if (mid == pick) {
			return mid;
		} else if (mid > pick) {
			return binarySearch(start, mid - 1, pick);
		} else {
			return binarySearch(mid + 1, end, pick);
		}
	}

	private static int solution2(int n, int pick) {
		int start = 1, end = n;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid > pick)
				end = mid - 1;
			else if (mid < pick)
				start = mid + 1;
			else
				return mid;
		}
		return -1;
	}
}
