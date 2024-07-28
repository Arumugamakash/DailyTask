package com.akash.day43;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean flag[] = new boolean[arr.length];
		solution1(arr, res, list, flag);
	}

	private static void solution1(int[] arr, List<List<Integer>> res, List<Integer> list, boolean flag[]) {
		if (list.size() == arr.length) {
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!flag[i]) {
				list.add(arr[i]);
				flag[i] = true;
				solution1(arr, res, list, flag);
				list.remove(list.size() - 1);
				flag[i] = false;
			}
		}
		print(res);
	}

	private static void print(List<List<Integer>> res) {
		System.out.println(res);
	}

}
