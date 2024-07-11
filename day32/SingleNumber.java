package com.akash.day32;

import java.util.Arrays;

public class SingleNumber {
	public static void main(String[] args) {
		int arr[] = { 2, 2, 1, 1, 4 };
		SingleNumber p = new SingleNumber();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
		System.out.println(p.solution3(arr));

	}

	// solution 1
	private int solution1(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1;) {
			if (nums[i] == nums[i + 1]) {
				i = i + 2;
			} else {
				return nums[i];
			}
		}
		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			return nums[nums.length - 1];
		}
		return 0;
	}

	// solution 2
	private int solution2(int[] nums) {
		Arrays.sort(nums);
		int single = 0;
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				single = nums[i];
			} else {
				i = i + 1;
			}
		}
		if (nums.length > 3 && nums[nums.length - 1] != nums[nums.length - 2]) {
			single = nums[nums.length - 1];
		}
		return single;
	}

	// solution 3
	private int solution3(int[] nums) {
		int result = nums[0];// 2
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
			System.out.println("result " + result);
		}
		return result;
	}

}
