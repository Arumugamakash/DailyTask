package com.akash.day5;

import java.util.Arrays;

//longest increasing sub Array length
public class Problem2 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 1, 2, 3, 6, 7, 1 };
		Problem2 p = new Problem2();
		p.solution1(arr);
		System.out.println();
		p.solution2(arr);
		System.out.println();
		p.solution3(arr);
	}

	// solution 1
	private void solution1(int[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("longest increasing sub Array Length =" + 0);
		}
		int count = 1;
		int max = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 1;
			}
		}
		System.out.println("longest increasing sub Array Length =" + max);
	}

	// solution 2
	private void solution2(int[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("longest increasing sub Array Length =" + 0);
		}
		int travels[] = new int[arr.length];
		int maxL = 1;
		travels[0] = 1;
		for (int i = 1; i < travels.length; i++) {
			if (arr[i - 1] < arr[i]) {
				travels[i] = travels[i - 1] + 1;
			} else {
				travels[i] = 1;
			}
			maxL = Math.max(maxL, travels[i]);
		}
		System.out.println("longest increasing sub Array Length =" + maxL);
	}

	// solution 3
	private void solution3(int[] arr) {
		int max = 1;
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[j - 1]) {
					count++;
				} else {
					i = j - 1;
					break;
				}
			}
			max = Math.max(max, count);

		}
		System.out.println("longest increasing sub Array Length =" + max);
	}

}
