package com.akash.day38;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 7 };
		int target = 7;
		CombinationSum p = new CombinationSum();
		System.out.println(p.solution2(arr, target));
		System.out.println(p.solution3(arr, target));
	}

//	private void solution1(int[] arr, int target) {
//		List<List<Integer>> li = new ArrayList<List<Integer>>();
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//
//			}
//		}F
//		System.out.println(li);
//	}

	public List<List<Integer>> solution3(int[] candidates, int target) {
		List<List<Integer>>[] list = new ArrayList[target + 1];
		for (int i = 0; i <= target; i++) {
			list[i] = new ArrayList<>();
		}
		list[0].add(new ArrayList<>());

		for (int num : candidates) {
			for (int i = num; i <= target; i++) {
				for (List<Integer> li : list[i - num]) {
					List<Integer> newList = new ArrayList<>(li);
					newList.add(num);
					list[i].add(newList);
				}
			}
		}
		return list[target];
	}

	public List<List<Integer>> solution2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		combinationSum(candidates, target, 0, new ArrayList<>(), result);
		return result;
	}

	private void combinationSum(int[] arr, int target, int start, List<Integer> current, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (arr[i] <= target) {
				current.add(arr[i]);
				combinationSum(arr, target - arr[i], i, current, result);
				current.remove(current.size() - 1);
			}
		}
	}

}
