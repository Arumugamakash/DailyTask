package com.akash.day68;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
		System.out.println(solution3(nums));
		System.out.println(solution2(nums));
	}

	private static int solution2(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		System.out.println(map);
		for (int i : map.keySet()) {
			if (map.containsKey(i + 1)) {
				res = Math.max(map.get(i) + map.get(i + 1), res);// 5
			}
		}
		return res;
	}

	private static int solution3(int[] nums) {
		int start = 0;
		int end = 1;
		int res = 0;
		Arrays.sort(nums);
		while (end < nums.length) {
			int diff = nums[end] - nums[start];
			if (diff == 1) {
				res = Math.max(end - start + 1, res);
			}
			if (diff <= 1) {
				end++;
			} else {
				start++;
			}
		}

		return res;
	}
}
