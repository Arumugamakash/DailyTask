package com.akash.day17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//contains duplicate
public class Problem3 {
	public static void main(String[] args) {
		int nums[] = { 1, 0, 1, 1 };
		int k = 1;
		Problem3 p = new Problem3();
		System.out.println(p.solution1(nums, k));
		System.out.println(p.solution2(nums, k));
	}

	private boolean solution2(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length && j <= i + k; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean solution1(int[] nums, int k) {
		Set<Integer> set = new HashSet();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}

		return false;
	}

}
