package com.akash.day49;

import java.util.HashSet;

public class KeyPair {
	public static void main(String[] args) {
		int arr[] = { 10, 4, 2, 5, 12 };
		int x = 7;
		System.out.println(solution1(arr, x));
		System.out.println(solution3(arr, x));
		System.out.println(solution2(arr, x, 0, 1));
	}

	private static boolean solution2(int[] arr, int x, int i, int j) {
		if (arr.length - 1 <= i) {
			return false;
		}
		if (arr.length <= j) {
			i = i + 1;
			j = i + 1;
		}
		if (arr[i] + arr[j] == x) {
			return true;
		}
		return solution2(arr, x, i, j + 1);
	}

	private static boolean solution3(int[] arr, int x) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int value : arr) {
			int complement = x - value;
			if (set.contains(complement)) {
				return true;
			}
			set.add(value);
		}
		return false;
	}

	private static boolean solution1(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == x) {
					return true;
				}
			}
		}
		return false;
	}

}
