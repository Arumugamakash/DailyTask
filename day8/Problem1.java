package com.akash.day8;
//find mageroty element in array

import java.util.Arrays;

public class Problem1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3, 3, 3, 3, 3, 5, 4 };
		Problem1 p = new Problem1();
		System.out.println("Majarity Element in the array is :" + p.solution1(arr));
		p.solution2(arr);
		p.solution3(arr);
	}

	private int solution1(int[] arr) {
		Arrays.sort(arr);
		int n = arr[arr.length - 1];
		int hash[] = new int[n + 1];
		for (int i = 0; i < arr.length; i++) {
			hash[arr[i]]++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > arr.length / 2) {
				return i;
			}
		}
		return -1;
	}

	private void solution2(int[] arr) {

		out: for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					if (count >= arr.length / 2) {
						System.out.println("Majarity Element in the array is :" + arr[i]);
						break out;
					}
				}
			}
		}
	}

	private void solution3(int arr[]) {
		int count = 0, majorElement = 0;
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				majorElement = arr[i];
			}
			if (arr[i] == majorElement) {
				count++;
			} else {
				count--;
			}
		}
		System.out.println("Majarity Element in the array is :" + majorElement);
	}

}
