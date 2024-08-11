package com.akash.day51;

import java.util.Arrays;

public class PickNumber {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(solution1(arr));
		System.out.println(solution2(arr));

	}

	private static int solution2(int[] a) {
		int[] frequency = new int[101];
		for (int num : a) {
			frequency[num]++;
		}

		int maxLength = 0;
		for (int i = 1; i < frequency.length; i++) {
			maxLength = Math.max(maxLength, frequency[i] + frequency[i - 1]);
		}

		return maxLength;
	}

	private static int solution1(int[] arr) {
		int l = arr.length;
		int max = 0;
		for (int i = 0; i < l; i++) {
			int count = 0;
			int n = arr[i];
			for (int j = 0; j < l; j++) {
				int curr = arr[j];
				if (n == curr || n + 1 == curr) {
					count++;
				}
			}
			max = Math.max(max, count);
		}
		return max;
	}

}
