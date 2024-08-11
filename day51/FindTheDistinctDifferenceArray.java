package com.akash.day51;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheDistinctDifferenceArray {
	public static void main(String[] args) {
		int arr[] = { 3, 2, 3, 4, 2 };

		System.out.println(Arrays.toString(solution1(arr)));
		System.out.println(Arrays.toString(solution2(arr)));
	}

	private static int[] solution2(int[] nums) {
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = findPrefix(i, nums) - findSuffix(i, nums);
		}
		return arr;
	}

	public static int findPrefix(int index, int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = index; i >= 0; i--)
			set.add(nums[i]);

		return set.size();

	}

	public static int findSuffix(int index, int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = index + 1; i < nums.length; i++)
			set.add(nums[i]);

		return set.size();

	}

	private static int[] solution1(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int res[] = new int[nums.length];
		Set<Integer> set = new HashSet<Integer>();
		int right = map.size();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.get(nums[i]) - 1);
			if (map.get(nums[i]) <= 0) {
				right--;
			}
			set.add(nums[i]);
			res[i] = set.size() - right;
		}
		return res;
	}

}
