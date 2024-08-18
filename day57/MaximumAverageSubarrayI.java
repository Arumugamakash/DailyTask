package com.akash.day57;

public class MaximumAverageSubarrayI {
	public static void main(String[] args) {
		int[] arr = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		// System.out.println(solution1(arr, k));
		System.out.println(solution2(arr, k));
	}

	private static double solution2(int[] nums, int k) {

		int start = 0;
		int end = 0;
		double sum = 0;
		double max = Integer.MIN_VALUE;
		while (end < nums.length) {
			sum += nums[end];
			if ((end - start + 1) == k) {
				System.out.println("sum" + sum);
				max = Math.max(sum / k, max);
				sum = sum - nums[start];
				start++;
			}
			end++;
		}
		return max;
	}

	private static double solution1(int[] nums, int k) {
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			double sum = 0;
			int count = 0;
			for (int j = i; j < nums.length; j++) {
				if (count == k) {
					break;
				}
				sum += nums[j];// 1+12-5-6
				count++;
			}
			if (count == k) {
				sum = sum / k;
				max = Math.max(max, sum);
			}
		}
		return max;
	}

}
