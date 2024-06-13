package com.akash.day7;

import java.util.Arrays;

public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 4, 4 };
		Problem3 p = new Problem3();
		System.out.println("Single Element is :" + p.solution1(arr));
		p.solution2(arr);
		p.solution3(arr);
	}

	// SOLUTION 1
	private int solution1(int[] arr) {
		int hash[] = new int[arr.length + 1];// 8
		for (int i = 0; i < arr.length; i++) {
			hash[arr[i]]++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == 1) {
				return i;
			}
		}
		return -1;
	}

	// SOLUTION 2
	private void solution2(int[] arr) {
		int singleElement = 0;
		Arrays.sort(arr);// 1113444
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				singleElement = arr[i + 1];
				break;
			}
		}
		System.out.println("Single Element is :" + singleElement);
	}

	// SOLUTION 3
	private void solution3(int[] arr) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor = xor ^ arr[i];
			System.out.println(xor);
		}
		System.out.println("Single Element is" + xor);
	}
}
