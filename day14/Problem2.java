package com.akash.day14;

import java.util.HashMap;
import java.util.Map;

//triangle
public class Problem2 {
	public static void main(String[] args) {
		int[][] arr = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		Problem2 p = new Problem2();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
		System.out.println(p.solution3(arr));
	}

	// solution 1
	private int solution1(int[][] arr) {
		int min = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			min = arr[i][0];
			for (int j = 0; j < arr[i].length; j++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
				}
			}
			count += min;
		}
		return count;
	}

	// solution 2
	private int solution2(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < arr[i].length; j++) {
				min = Math.min(min, arr[i][j]);
			}
			sum += min;
		}
		return sum;
	}

	// solution 3
	public int solution3(int[][] arr) {
		Map<String, Integer> map = new HashMap<>();
		return findMinValue(arr, map, 0, 0);
	}

	private int findMinValue(int[][] arr, Map<String, Integer> map, int i, int j) {
		if (i == arr.length) {
			return 0;
		}
		String key = "(" + i + "," + j + ")";
		System.out.println(key);
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int left = findMinValue(arr, map, i + 1, j);
		int right = findMinValue(arr, map, i + 1, j + 1);
		int minPath = arr[i][j] + Math.min(left, right);

		map.put(key, minPath);
		return minPath;
	}

}
