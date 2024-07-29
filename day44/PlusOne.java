package com.akash.day44;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int arr[] = { 8 };
		System.out.println(Arrays.toString(solution3(arr)));
		System.out.println(Arrays.toString(solution2(arr)));
	}

	private static int[] solution2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	private static int[] solution3(int[] digits) {
		String s = "";
		for (int i : digits) {
			s += i;
		}
		long num = Long.parseLong(s) + 1;
		System.out.println(num);// 10
		if (digits.length > 1) {
			plusOne(digits, num);
		} else {
			if (num > 9) {
				digits = new int[digits.length + 1];
				plusOne(digits, num);
			} else {
				digits[0] = (int) num;
				return digits;
			}

		}
		return digits;
	}

	private static void plusOne(int[] digits, long num) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = (int) num % 10;
			num = num / 10;
		}
	}

}
