package com.akash.day21;

import java.util.Arrays;

public class SubArraySum {
	public static void main(String[] args) {
		int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		SubArraySum p = new SubArraySum();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
		System.out.println(p.solution3(arr));
	}

	// solution 1
	private int solution1(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				maxSum = Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}

	// solution 2
	private int solution2(int[] nums) {
		int maxsum = nums[0];// -2
		int sum = 0;// 0
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];// -2
			maxsum = Math.max(sum, maxsum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}

	// solution 3
	private int solution3(int[] arr) {
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = arr[i] + (Math.max(0, dp[i - 1]));
		}
		System.out.println(Arrays.toString(dp));
		int max = Integer.MIN_VALUE;
		for (int i : dp) {
			max = Math.max(max, i);
		}
		return max;
	}

}
