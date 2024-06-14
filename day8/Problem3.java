package com.akash.day8;

import java.util.HashSet;
import java.util.Set;

//subset
public class Problem3 {
	public static void main(String[] args) {
		int a[] = { 1, 3, 2, 5, 6, 12 };
		int b[] = { 1, 3, 2, 12 };
		Problem3 p = new Problem3();
		System.out.println(p.solution1(a, b) ? "Given array is SubSet" : "Given array is not SubSet");
		System.out.println(p.solution2(a, b) ? "Given array is SubSet" : "Given array is not SubSet");
		System.out.println(p.solution3(a, b) ? "Given array is SubSet" : "Given array is not SubSet");
	}

	private boolean solution3(int[] a, int[] b) {
		boolean[] arr = new boolean[1000];
		for (int i = 0; i < a.length; i++) {
			arr[a[i]] = true;
		}
		for (int i = 0; i < b.length; i++) {
			if (arr[b[i]] == false) {
				return false;
			}
		}
		return true;
	}

	private boolean solution2(int[] a, int[] b) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		int j = 0;
		while (j < b.length) {
			if (!set.contains(b[j])) {
				return false;
			}
			j++;
		}
		return true;
	}

	private boolean solution1(int[] a, int[] b) {
		boolean flag = false;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (b[i] == a[j]) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		return flag;
	}
}
