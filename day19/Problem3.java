package com.akash.day19;

import java.util.Arrays;

//3sum closest
public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { -1, 2, 1, -4 };
		int target = 1;
		Problem3 p = new Problem3();
		 p.solution1(arr, target);
		System.out.println(p.solution2(arr, target));
	}

	private void solution1(int[] arr, int target) {
		int sum = 0;
		// if (target < arr.length) {
		for (int i = 0; i < arr.length; i++) {
			if (target == i - 1 || target == i + 1 || target == i) {
				sum += arr[i];
			}
		}
//		}
		System.out.println(sum);
	}

	public int solution2(int[] nums, int target) {
		Arrays.sort(nums);
		int closestSum = nums[0] + nums[1] + nums[2];
		System.out.println("c " + closestSum);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;// 2
			int k = nums.length - 1;// 3

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
					closestSum = sum;
				}

				if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return closestSum;
	}
}
