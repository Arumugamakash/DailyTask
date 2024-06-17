package com.akash.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3 {
	public static void main(String[] args) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };
		Problem3 p = new Problem3();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
	}

	// solution 1
	private List<List<Integer>> solution1(int[] arr) {
		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			Set<Integer> seen = new HashSet<>();
			int target = -arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (seen.contains(target - arr[j])) {
					result.add(Arrays.asList(arr[i], target - arr[j], arr[j]));
				}
				seen.add(arr[j]);
			}
		}

		return new ArrayList<>(result);
	}

	// solution 2
	private List<List<Integer>> solution2(int[] arr) {
		Arrays.sort(arr);
		int target = 0;
		List<List<Integer>> ans = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			int j = i + 1;
			int k = arr.length - 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == target) {
					set.add(Arrays.asList(arr[i], arr[j], arr[k]));
					j++;
					k--;
				} else if (sum < target)
					j++;
				else
					k--;
			}
		}
		ans.addAll(set);
		return ans;
	}

}
