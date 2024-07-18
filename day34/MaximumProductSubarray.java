package com.akash.day34;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 1 };
		MaximumProductSubarray p = new MaximumProductSubarray();
		p.solution2(arr);
		p.solution3(arr);
	}

	private void solution3(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int mul = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				ans = Math.max(ans, mul);
				mul *= nums[j];
			}
			ans = Math.max(ans, mul);
		}
		System.out.println("Maximum product subArray is :" + ans);
	}

	private void solution2(int[] nums) {
		int left = 1;
		int right = 1;
		int ans = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (left == 0) {
				left = 1;
			}
			if (right == 0) {
				right = 1;
			}
			left *= nums[i];
			right *= nums[nums.length - i - 1];
			ans = Math.max(ans, Math.max(left, right));
		}
		System.out.println("Maximum product subArray is :" + ans);
	}

}
