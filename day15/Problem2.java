package com.akash.day15;

//peak element
public class Problem2 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 5, 6, 4 };
		Problem2 p = new Problem2();
		System.out.println("Peak Element is :" + p.solution3(arr));
		System.out.println("Peak Element is :" + p.solution2(arr));
		System.out.println("Peak Element is :" + p.solution1(arr));
	}

	// solution 1 /binary search
	private int solution1(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;// 1
			if (arr[mid] < arr[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	// solution 2
	private int solution2(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return nums.length - 1;
	}

	// solution 3
	private int solution3(int[] arr) {
		int peak = 0;
		int maxPeak = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (max <= arr[i]) {
				peak = (arr[i] > arr[i + 1]) ? i : i + 1;
				max = arr[peak];// 3
				maxPeak = Math.max(maxPeak, peak);
			}
		}
		return maxPeak;
	}
}
