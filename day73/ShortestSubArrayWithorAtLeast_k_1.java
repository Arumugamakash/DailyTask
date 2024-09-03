package com.akash.day73;

public class ShortestSubArrayWithorAtLeast_k_1 {
	public static void main(String[] args) {
		int nums[] = { 2, 15, 32, 1 };
		int k = 50;
		System.out.println(solution2(nums, k));
		System.out.println(solution3(nums, k));
	}

	private static int solution3(int[] nums, int k) {
		int n = nums.length;
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int value = 0;
			for (int j = i; j < n; j++) {
				value = (value | nums[j]);
				if (value >= k) {
					max = Math.min(max, j - i + 1);
					break;
				}
			}
		}
		if (max != Integer.MAX_VALUE)
			return max;
		else
			return -1;
	}

	private static int solution2(int[] nums, int k) {
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum >= k) {
					minLength = Math.min(minLength, j - i + 1);
					break;
				}
			}
		}

		return minLength == Integer.MAX_VALUE ? -1 : minLength;
	}
}
