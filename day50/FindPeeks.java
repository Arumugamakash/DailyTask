package com.akash.day50;

import java.util.ArrayList;
import java.util.List;

public class FindPeeks {
	static List<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) {
		int arr[] = { 1, 4, 3, 8, 5 };
		System.out.println(solution3(arr));
		System.out.println(solution2(arr, 1, arr.length - 2));
	}

	private static List<Integer> solution2(int[] mountain, int l, int r) {
		if (l <= r) {
			int mid = l + ((r - l) / 2);
			if (mountain[mid] > mountain[mid - 1] && mountain[mid] > mountain[mid + 1]) {
				ans.add(mid);
			}
			solution2(mountain, l, mid - 1);
			solution2(mountain, mid + 1, r);
		}
		return ans;

	}

	private static List<Integer> solution3(int[] mountain) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < mountain.length - 1; i++) {
			if (mountain[i - 1] < mountain[i] && mountain[i + 1] < mountain[i]) {
				list.add(i);
			}
		}
		return list;
	}

}
