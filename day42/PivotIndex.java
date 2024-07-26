package com.akash.day42;

import java.util.Arrays;

public class PivotIndex {
	public static void main(String[] args) {
		int arr[] = { 1, 7, 3, 6, 5, 6 };
		System.out.println(pivotIndex1(arr));
		System.out.println(pivotIndex2(arr));
		System.out.println(pivotIndex3(arr));
	}

	private static int pivotIndex2(int[] arr) {
		int preSum[] = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			preSum[i + 1] = preSum[i] + arr[i];
		}
		System.out.println(Arrays.toString(preSum));
		for (int i = 0; i < arr.length; i++) {
			if (preSum[i] == preSum[arr.length] - preSum[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	private static int pivotIndex3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int leftSum = 0;
			for (int j = 0; j < i; j++) {
				leftSum += nums[j];
			}

			int rightSum = 0;
			for (int j = i + 1; j < nums.length; j++) {
				rightSum += nums[j];
			}

			if (leftSum == rightSum) {
				return i;
			}
		}

		return -1;
	}

	private static int pivotIndex1(int[] arr) {
		int totalCount = 0;
		for (int number : arr) {
			totalCount += number;// 28
		}
		int leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (leftSum == (totalCount - leftSum - arr[i])) {
				return i;
			}
			leftSum += arr[i];// 11
		}
		return -1;
	}

}
