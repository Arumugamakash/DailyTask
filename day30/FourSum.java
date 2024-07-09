package com.akash.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {
	public static void main(String[] args) {
		int nums[] = { 2, 2, 2, 2, 2 };
		int target = 8;
		FourSum p = new FourSum();
		System.out.println(p.solution1(nums, target));
		System.out.println(p.solution2(nums, target));
	}

	// solution 1
	private List<List<Integer>> solution1(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		for (int a = 0; a < nums.length; a++) {
			for (int b = a + 1; b < nums.length; b++) {
				for (int c = b + 1; c < nums.length; c++) {

					for (int d = c + 1; d < nums.length; d++) {
						int sum = nums[a] + nums[b] + nums[c] + nums[d];
						if (sum == target) {
							set.add(nums[a]);
							set.add(nums[b]);
							set.add(nums[c]);
							set.add(nums[d]);
							List<Integer> innerList = new ArrayList<Integer>(set);
							list.add(innerList);
							break;
						}
					}

				}
			}

		}
		return list;
	}

	// solution 2
	private List<List<Integer>> solution2(int[] nums, int target) {

		Set<List<Integer>> result = new HashSet<>();
		if (nums == null || nums.length < 4) {
			return new ArrayList<>(result);
		}

		Arrays.sort(nums);
		int n = nums.length;
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = nums[i] + nums[j];
				if (!map.containsKey(sum)) {
					map.put(sum, new ArrayList<>());
				}
				map.get(sum).add(new int[] { i, j });
			}
		}
		System.out.println(map);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int currentSum = nums[i] + nums[j];
				int complement = target - currentSum;
				if (map.containsKey(complement)) {
					for (int[] pair : map.get(complement)) {
						if (pair[0] > j) {
							List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[pair[0]], nums[pair[1]]);
							Collections.sort(quad);
							result.add(quad);
						}
					}
				}
			}
		}

		return new ArrayList<>(result);
	}
}
