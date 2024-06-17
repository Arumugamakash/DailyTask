package com.akash.day11;

import java.util.Arrays;

public class Problem1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		Problem1 p = new Problem1();
		System.out.println(Arrays.toString(p.solution1(arr)));
		System.out.println(Arrays.toString(p.solution2(arr)));

	}

	// solution 1
	private int[] solution1(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int temp = 1;
			for (int j = 0; j < arr.length; j++)
				if (i != j)
					temp *= arr[j];
			res[i] = temp;
		}
		return res;
	}

	// solution 2
	private int[] solution2(int[] nums) {
		int pre[] = new int[nums.length];
		int pos[] = new int[nums.length];
		int sum = 1;
		pre[0] = 1;
		for (int i = 1; i < pre.length; i++) {
			sum = sum * nums[i - 1];
			pre[i] = sum;
		}
		sum = 1;
		pos[pos.length - 1] = 1;
		for (int i = pos.length - 2; i >= 0; i--) {
			sum = sum * nums[i + 1];
			pos[i] = sum;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = pre[i] * pos[i];
		}
		return nums;
	}

}
