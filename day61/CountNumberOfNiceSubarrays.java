package com.akash.day61;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
	public static void main(String[] args) {
		int arr[] = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		int k = 2;
		System.out.println(solution1(arr, k));
		System.out.println(solution2(arr, k));

	}

	private static int solution2(int[] nums, int k) {
		int n = nums.length;
		int ans = 0;
		int prefSum = 0;
		Map<Integer, Integer> freq = new HashMap<>();
		freq.put(0, 1);

		for (int i = 0; i < n; i++) {
			prefSum += (nums[i] % 2 == 1) ? 1 : 0;
			ans += freq.getOrDefault(prefSum - k, 0);
			freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
		}
		return ans;
	}

	private static int solution1(int[] nums, int k) {
		return atMostK(nums, k) - atMostK(nums, k - 1);
	}

	private static int atMostK(int[] nums, int k) {
		int count = 0;
		int left = 0;
		int oddCount = 0;
		for (int right = 0; right < nums.length; right++) {
			if (nums[right] % 2 == 1) {
				oddCount++;
			}
			while (oddCount > k) {
				if (nums[left] % 2 == 1) {
					oddCount--;
				}
				left++;
			}
			count += right - left + 1;
		}

		return count;
	}

}
