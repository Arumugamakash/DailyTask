package com.akash.day31;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static void main(String[] args) {
		int nums[] = new int[] { 0, 1, 2, 4, 5, 7 };
		SummaryRanges p = new SummaryRanges();
		System.out.println(p.solution1(nums));
		System.out.println(p.solution2(nums));
	}

	private List<String> solution2(int[] nums) {
		List<String> list = new ArrayList<String>();
		int j = 1;
		int start = 0;
		while (start < nums.length) {
			int end = start;// 0
			while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]) {
				end++;// 1 2
			}
			if (start == end) {
				list.add("" + nums[start]);
			} else {
				list.add(nums[start] + "->" + nums[end]);
			}
			start = end + 1;
		}
		return list;
	}

	private List<String> solution1(int[] nums) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			boolean flag = false;
			String s = "";
			int a = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) == 1) {
					s = a + "->" + nums[j];
					i++;
					flag = true;
				} else {
					break;
				}
			}
			if (!flag) {
				s = "" + a;
			}
			list.add(s);

		}
		System.out.println(list);
		return list;
	}

}
