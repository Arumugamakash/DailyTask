package com.akash.day54;

import java.util.HashMap;
import java.util.Map;

public class FindNumbeGoodPairsII {
	public static void main(String[] args) {
		int nums1[] = { 1, 3, 4 };
		int nums2[] = { 1, 3, 4 };
		int k = 1;
		System.out.println(solution1(nums1, nums2, k));
		System.out.println(solution3(nums1, nums2, k));
	}

	private static long solution1(int[] nums1, int[] nums2, int k) {
		long count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i] * k, map.getOrDefault(nums2[i] * k, 0) + 1);
		}
		System.out.println(map);
		for (int num : nums1) {
			for (int i = 1; i * i <= num; i++) {
				if (num % i == 0) {
					int complement = num / i;
					if (map.containsKey(i)) {
						count += map.get(i);
					}
					if (complement != i && map.containsKey(complement)) {
						count += map.get(complement);
					}
				}
			}
		}

		return count;
	}

	private static int solution3(int[] nums1, int[] nums2, int k) {
		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] % (nums2[j] * k) == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
