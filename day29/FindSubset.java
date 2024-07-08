package com.akash.day29;

import java.util.ArrayList;
import java.util.List;

public class FindSubset {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		FindSubset p = new FindSubset();
		System.out.println(p.solution1(nums));
		System.out.println(p.solution2(nums));
	}

	private List<List<Integer>> solution2(int[] arr) {
		List<List<Integer>> subset = new ArrayList<>();
		subset.add(new ArrayList());
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				List<Integer> list = new ArrayList<>();
				for (int k = i; k <= j; k++) {
					list.add(arr[k]);
				}
				subset.add(list);
			}
		}

		return subset;
	}

	private List<List<Integer>> solution1(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> addList = new ArrayList<Integer>();
		findSubset(list, addList, nums, 0);
		return list;
	}

	private void findSubset(List<List<Integer>> list, List<Integer> addList, int[] nums, int i) {
		list.add(new ArrayList<Integer>(addList));
		for (int j = i; j < nums.length; j++) {
			addList.add(nums[j]);// 1
			findSubset(list, addList, nums, j + 1);
			addList.remove(addList.size() - 1);
		}
	}

}
