package com.akash.day66;

public class BinarySubarraysWithSum {

	public static void main(String[] args) {
		int nums[] = { 0, 0, 0, 0, 0 };
		int goal = 0;
		System.out.println(solution3(nums, goal));
		System.out.println(solution2(nums, goal));
		System.out.println(solution1(nums, goal));
	}

	private static int solution1(int[] nums, int goal) {
		int prefix[] = new int[nums.length + 1];
		int count = 0;
		int sum = 0;
		prefix[0] = 1;
		for (int num : nums) {
			sum += num;
			if (sum >= goal) {
				count += prefix[sum - goal];
			}
			prefix[sum]++;
		}
		return count;
	}

	private static int solution2(int[] nums, int goal) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;
		if (goal < 0) {
			return 0;
		}
		while (end < nums.length) {
			sum += nums[end];// 3
			while (sum > goal) {
				sum -= nums[start];
				start++;
			}
			count = end - start + 1;
			end++;// 1
		}
		return count;
	}

	private static int solution3(int[] nums, int goal) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];// 1
				if (sum == goal) {
					count++;
					// break;
				}
			}
		}
		return count;
	}

}
