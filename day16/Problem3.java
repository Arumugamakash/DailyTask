package com.akash.day16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 2, 6, 1, 6, 2, 7 };
		System.out.println(Arrays.toString(arr));
		Problem3 p = new Problem3();
		p.solution3(arr);
		p.solution2(arr);
		p.solution1(arr);
	}

	// solution 1
	private void solution1(int[] arr) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[j] != -1 && arr[i] == arr[j]) {
					count++;
					arr[j] = -1;
				}
			}
			if (arr[i] != -1)
				System.out.println(arr[i] + "-" + count);
		}
	}

	// solution 2
	private void solution2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
		}
	}

	// solution 3
	private void solution3(int[] arr) {
		Arrays.sort(arr);
		int count = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				System.out.print(arr[i] + "-" + count + "\n");
				count = 1;
			} else {
				count++;
			}
		}
		if (arr[arr.length - 1] != arr[arr.length - 2]) {
			count = 1;
			System.out.print(arr[arr.length - 1] + "-" + count + "\n");
		} else {
			System.out.print(arr[arr.length - 1] + "-" + count + "\n");
		}
	}

}
