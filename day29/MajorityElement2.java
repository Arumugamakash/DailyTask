package com.akash.day29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
	public static void main(String[] args) {
		int nums[] = { 3, 2, 3 };
		MajorityElement2 p = new MajorityElement2();
		System.out.println(p.solution1(nums));
		System.out.println(p.solution2(nums));
	}

	private List<Integer> solution2(int[] nums) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		System.out.println(map);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			if (val > nums.length / 3)
				list.add(key);
		}
		return list;
	}

	private List<Integer> solution1(int[] nums) {
		int n = nums.length;
		int count = 0, element = 0;
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			if (count == 0) {
				element = nums[i];
				count = 1;
			} else if (element == nums[i]) {
				count++;
			} else {
				if (count > n / 3 && !list.contains(element)) {
					list.add(element);
				}
				element = nums[i];
				count = 1;
			}
		}

		if (count > n / 3 && !list.contains(element)) {
			list.add(element);
		}

		return list;
	}

}
