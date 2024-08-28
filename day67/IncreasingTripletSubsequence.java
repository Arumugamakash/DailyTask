package com.akash.day67;

public class IncreasingTripletSubsequence {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 0, 4, 6 };
		System.out.println(solution1(nums));
		System.out.println(solution2(nums));
	}

	private static boolean solution2(int[] nums) {
		if (nums.length < 2) {
			return false;
		}
		int prev1 = Integer.MAX_VALUE;
		int prev2 = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > prev2 && prev2 > prev1) {
				return true;
			}
			if (nums[i] > prev1) {
				prev2 = nums[i];//5
			} else {
				prev1 = nums[i];//1
			}
		}
		return false;
	}

	private static boolean solution1(int[] nums) {
		int t1 = Integer.MAX_VALUE;
		int t2 = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= t1) {
				t1 = nums[i];
			} else if (nums[i] < t2) {
				t2 = nums[i];
			} else
				return true;
		}
		return false;
	}
}
