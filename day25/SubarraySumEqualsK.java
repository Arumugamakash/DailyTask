package com.akash.day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int k = 3;
		SubarraySumEqualsK p = new SubarraySumEqualsK();
		System.out.println(p.solution1(arr, k));
		p.solution2(arr, k);
		System.out.println(p.solution3(arr, k));
	}

	private int solution1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int curSum = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			int removeSum = curSum - k;
			if (map.containsKey(removeSum)) {
				count += map.get(removeSum);
			}
			map.put(curSum, map.getOrDefault(curSum, 0) + 1);
		}
		return count;

	}

	private int solution3(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				for (int s = i; s <= j; s++) {
					sum += nums[s];
				}
				if (map.containsKey(sum)) {
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				} else {
					map.put(sum, map.getOrDefault(sum, 1));
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() == k) {
				return entry.getValue();
			}
		}
		System.out.println(map);
		return 0;
	}

	private void solution2(int[] arr, int k) {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int s = i; s <= j; s++) {
					sum += arr[s];
				}
				if (sum == k) {
					count++;
				}
			}
		}
		System.out.println(count);

	}
}
