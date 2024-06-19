package com.akash.day13;

import java.util.Arrays;

//Search in Rotated Sorted Array
public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 0, 3, 4, 5 };
		int target = 4;
		Problem3 p = new Problem3();
		System.out.println(p.solution1(arr, target));
		System.out.println(p.solution2(arr, target));
		System.out.println(p.solution3(arr, target, 0, arr.length - 1));
	}

	// solution 1
	public int solution1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}

	// solution 2
	private int solution2(int[] arr, int target) {
		int first = 0;
		int last = arr.length - 1;
		while (first <= last) {
			int mid = (first + last) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[first] <= arr[mid]) {
				if (arr[first] <= target && target < arr[mid]) {
					last = mid - 1;
				} else {
					first = mid + 1;
				}
			} else {
				if (arr[mid] <= target && target <= arr[last]) {
					first = mid + 1;
				} else {
					last = mid - 1;
				}

			}
		}
		return -1;
	}
	//solution 3
	private int solution3(int[] arr, int target, int first, int last) {
		if (first >= last) {
			return -1;
		}
		int mid = (first + last) / 2;
		if (arr[mid] == target) {
			return mid;
		}
		if (arr[first] <= arr[mid]) {
			if (arr[first] <= target && target < arr[mid]) {
				return solution3(arr, target, first, mid - 1);
			} else {
				return solution3(arr, target, mid + 1, last);
			}
		} else {
			if (arr[mid] <= target && target <= arr[last]) {
				return solution3(arr, target, mid + 1, last);
			} else {
				return solution3(arr, target, first, mid - 1);
			}
		}
	}

}
