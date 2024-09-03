package com.akash.day73;

import java.util.HashMap;

public class NumberOfGoodPairs {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 1, 1, 3 };
		System.out.println(solution1(nums));
		System.out.println(solution2(nums));
	}

	private static int solution2(int[] nums) {
		int ans = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		for (int count : map.values()) {
			ans += count * (count - 1) / 2;
		}
		return ans;
	}

	private static int solution1(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
		}
		return count;
	}

}
