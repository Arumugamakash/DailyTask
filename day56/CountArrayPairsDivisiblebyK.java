package com.akash.day56;

import java.util.HashMap;
import java.util.Map;

public class CountArrayPairsDivisiblebyK {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int k = 2;
		System.out.println(solution1(arr, k));
		System.out.println(solution2(arr, k));
	}

	private static long solution2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		long count = 0;
		for (int num : nums) {
			int gcdVal = gcd(num, k);
			System.out.println("GCD "+gcdVal);
			for (int key : map.keySet()) {
				if ((long) gcdVal * key % k == 0) {
					count += map.get(key);
				}
			}
			map.put(gcdVal, map.getOrDefault(gcdVal, 0) + 1);
		}

		return count;
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;//2 1
			b = a % b;//1 //0
			a = temp;//2//1
		}
		return a;
	}

	private static long solution1(int[] nums, int k) {
		long count = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++)
				if (((long) (nums[i] * nums[j])) % k == 0)
					count++;
		}
		return count;

	}

}
