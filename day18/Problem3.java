package com.akash.day18;

import java.util.ArrayList;
import java.util.List;

/*
 2. Insert 0 after consecutive (K times) of 1 is found.
Example:
Input:  Number of bits: 12
		Bits: 1 0 1 1 0 1 1 0 1 1 1 1
		Consecutive K: 2
		Output: 1 0 1 1 0 0 1 1 0 0 1 1 0 1 1 0
 */
public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 };
		int k = 2;
		Problem3 p = new Problem3();
		p.solution1(arr, k);
		p.solution2(arr, k);

	}

	// solution 2
	private void solution2(int[] arr, int k) {
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
			if (arr[i] == 1) {
				count++;
				if (count == k) {
					list.add(0);
					count = 0;
				}
			} else {
				count = 0;
			}
		}
		System.out.println(list);
	}

	// solution 1
	private void solution1(int[] arr, int k) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (arr[i] == 1) {
				count++;
				if (count == k) {
					sb.append("0");
					count = 0;
				}
			} else
				count = 0;
		}
		System.out.println(sb);
	}
}
