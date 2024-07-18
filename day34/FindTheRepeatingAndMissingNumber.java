package com.akash.day34;

import java.util.Arrays;

public class FindTheRepeatingAndMissingNumber {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 5, 6, 2 };
		FindTheRepeatingAndMissingNumber p = new FindTheRepeatingAndMissingNumber();
		System.out.println(Arrays.toString(p.solution1(arr)));
		System.out.println(Arrays.toString(p.solution2(arr)));
	}

	private int[] solution2(int[] arr) {
		int[] res = new int[2];
		int max = arr[0];// 2
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		int[] hash = new int[max + 1];// 7
		for (int i = 0; i < arr.length; i++)
			hash[arr[i]]++;

		for (int i = 1; i < arr.length; i++) {
			if (hash[i] == 2)
				res[0] = i;
			if (hash[i] == 0)
				res[1] = i;
		}

		if (res[1] == 0)
			res[1] = arr.length;

		return res;
	}

	private int[] solution1(int[] arr) {
		int n = arr.length;

		int sn1 = n * (n + 1) / 2;
		int sn2 = (n * (n + 1) * (2 * n + 1)) / 6;

		int sum1 = 0, sum2 = 0;

		for (int i = 0; i < arr.length; i++) {
			sum1 += arr[i];
			sum2 += arr[i] * arr[i];
		}

		int val1 = sum1 - sn1;
		int val2 = sum2 - sn2;

		val2 = val2 / val1;

		int x = (val1 + val2) / 2;
		int y = x - val1;

		return new int[] { x, y };
	}

}
