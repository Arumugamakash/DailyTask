package com.akash.day74;

import java.util.Arrays;

public class ConvertIntegerToTheSumOfTwoNo_ZeroIntegers {
	public static void main(String[] args) {
		int n = 11;
		System.out.println(Arrays.toString(solution1(n)));
		System.out.println(Arrays.toString(solution2(n)));
	}

	private static int[] solution2(int n) {
		for (int i = 1; i < n; i++) {
			if (nonZero(i) && nonZero(n - i)) {
				return new int[] { i, n - i };
			}
		}

		return new int[] { -1, -1 };
	}

	public static boolean nonZero(int n) {
		while (n > 0) {
			if (n % 10 == 0)
				return false;
			n /= 10;
		}
		return true;
	}

	private static int[] solution1(int n) {
		int a = 0;
		for (a = 1;; ++a) {
			int b = n - a;
			if (!(a + "" + b).contains("0")) {
				return new int[] { a, b };
			}
		}
	}
}
