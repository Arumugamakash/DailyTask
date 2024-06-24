package com.akash.day18;

/*
 1. Given an array of integers, replace every element with the next greatest element 
 (greatest element on the right side) in the array.Since there is no element next to the last element, replace it with -1.
eg:  i/p: {16, 17, 4, 3, 5, 2}
 o/p: {17, 5, 5, 5, 2, -1}
 */
import java.util.Arrays;
import java.util.Stack;

public class Problem1 {
	public static void main(String[] args) {
		int nums[] = { 16, 17, 4, 3, 5, 2 };
		Problem1 p = new Problem1();
		p.solution1(nums);
		p.solution2(nums);
		p.solution3(nums);
	}

	// solution 1
	private void solution1(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int greatest = -1;
			for (int j = i + 1; j < nums.length; j++) {
				if (greatest < nums[j]) {
					greatest = nums[j];// 17
				}
			}
			nums[i] = greatest;
		}
		System.out.println("OUTPUT is: " + Arrays.toString(nums));
	}

	// solution 2
	private void solution2(int[] nums) {
		int greatest = -1;
		for (int i = nums.length - 1; i >= 0; i--) {
			int currentElement = nums[i];// 2 5 3
			nums[i] = greatest;// -1 2 5 5 5 17
			if (currentElement > greatest) {
				greatest = currentElement;// 2 5 17
			}
		}
		System.out.println("OUTPUT is: " + Arrays.toString(nums));
	}

	// solution 3
	private void solution3(int[] arr) {
		int res[] = new int[arr.length];
		Arrays.fill(res, -1);
		for (int i = arr.length - 2; i >= 0; i--) {
			res[i] = Math.max(arr[i + 1], res[i + 1]);
		}
		System.out.println("OUTPUT is :" + Arrays.toString(res));
	}

}
