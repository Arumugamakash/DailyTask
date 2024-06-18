package com.akash.day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//find Two Sum
public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { 1, 5, 2, 1 };
		int target = 7;
		Problem3 p = new Problem3();
		System.out.println(Arrays.toString(p.solution1(arr, target)));
		System.out.println(Arrays.toString(p.solution2(arr, target)));
		System.out.println(Arrays.toString(p.solution3(arr, target)));
	}

	// solution1
	private int[] solution1(int[] arr, int target) {
		int ans[] = new int[2];
		out: for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					ans[0] = i;
					ans[1] = j;
					break out;
				}
			}
		}
		return ans;
	}

	// solution 2
	private int[] solution2(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int k = 0;
		for (int i : arr) {
			map.put(k++, i);
		}
		for (int i = 0; i < arr.length; i++) {
			int com = target - arr[i];
			if (map.containsKey(com)) {
				return new int[] { i, map.get(com) };
			}
		}
		return new int[] {};
	}

	// solution 3
	private int[] solution3(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int com = target - arr[i];
			if (map.containsKey(com)) {
				return new int[] { map.get(com), i };
			}
			map.put(arr[i], i);
		}
		return new int[] {};
	}
}
