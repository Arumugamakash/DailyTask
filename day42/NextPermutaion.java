package com.akash.day42;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutaion {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		System.out.println(Arrays.toString(solution1(nums)));
		Integer arr[] = { 1, 2, 3 };
		System.out.println(solution2(arr));
	}

	public static List<Integer> solution2(Integer[] nums) {
		List<Integer> list = Arrays.asList(nums);
		if (!nextPermutation(list)) {
			Collections.sort(list);
		}
		return list;
	}

	private static boolean nextPermutation(List<Integer> list) {
		int i = list.size() - 2;
		while (i >= 0 && list.get(i) >= list.get(i + 1)) {
			i--;
		}

		if (i >= 0) {
			int j = list.size() - 1;
			while (j >= 0 && list.get(j) <= list.get(i)) {
				j--;
			}
			Collections.swap(list, i, j);
			Collections.reverse(list.subList(i + 1, list.size()));
			return true;
		} else {
			Collections.reverse(list);
			return false;
		}
	}

	private static int[] solution1(int[] nums) {
		int i = nums.length - 2;

		// Find the first decreasing element
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;

			// Find the element just larger than nums[i]
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}

			// Swap elements at i and j
			swap(nums, i, j);
		}

		// Reverse the elements from i+1 to the end of the array
		reverse(nums, i + 1);
		return nums;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
}
