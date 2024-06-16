package com.akash.day10;

import java.util.Arrays;

public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		Problem3 p = new Problem3();
		System.out.println(Arrays.toString(p.solution1(arr, target)));
		System.out.println(Arrays.toString(p.solution2(arr, target)));
		System.out.println(Arrays.toString(p.solution3(arr, target)));
	}

	// solution 1
	public int[] solution1(int[] nums, int target) {
		int ans[] = new int[2];
		int count1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				ans[0] = i;
				count1++;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == target) {
				ans[1] = i;
				count1++;
				break;
			}
		}
		if (count1 > 0) {
			return ans;
		} else {
			ans[0] = -1;
			ans[1] = -1;
		}
		return ans;
	}

	// solution 2
	private int[] solution2(int[] arr, int target) {
		int startPosition = -1, endPosition = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				if (startPosition == -1)
					startPosition = i;
				else
					endPosition = i;
			}
		}

		if (endPosition == -1 && startPosition != -1)
			endPosition = startPosition;

		return new int[] { startPosition, endPosition };
	}

	// solution 3
	private int[] solution3(int[] arr, int target) {
		int start = -1, end = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				start = i;// 0
				end = i;// 0
				while (end < arr.length && arr[end] == target) {
					end++;
				}
				end--;
				break;
			}
		}

		return new int[] { start, end };
	}

}
