package com.akash.day67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(solution3(nums1, nums2)));
		System.out.println(Arrays.toString(solution2(nums1, nums2)));
		System.out.println(Arrays.toString(solution1(nums1, nums2)));
	}

	private static int[] solution1(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums2) {
			for (int i = 0; i < nums1.length; i++) {
				if (num == nums1[i]) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				}
			}
		}
		int ans[] = new int[map.size()];
		int j = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans[j] = entry.getKey();
			j++;
		}
		return ans;
	}

	private static Object[] solution2(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			int j = 0;
			int first = 0;
			int last = nums2.length;
			int mid = (first + last) / 2;
			while (j < nums2.length) {
				mid = (first + last) / 2;
				if (nums2[mid] == nums1[i] && !list.contains(nums1[i])) {
					list.add(nums1[i]);
				} else if (nums2[mid] < nums1[i]) {
					first = mid + 1;
				} else if (nums2[mid] > nums1[i]) {
					last = mid - 1;
				}
				j++;
			}
		}
		return list.toArray();
	}

	private static int[] solution3(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums2) {
			for (int i = 0; i < nums1.length; i++) {
				if (num == nums1[i]) {
					set.add(num);
				}
			}
		}
		int[] ans = new int[set.size()];
		int i = 0;
		for (Integer num : set) {
			ans[i++] = num;
		}
		return ans;
	}

}
