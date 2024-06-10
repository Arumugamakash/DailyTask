package com.akash.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem3 {
	public static void main(String[] args) {
		int arr1[] = { 2, 2, 4, 5, 6 };
		int arr2[] = { 1, 3, 3, 7 };
		Problem3 p = new Problem3();
		p.solution1(arr1, arr2);
		System.out.println();
		p.solution2(arr1, arr2);
		System.out.println();
		p.solution3(arr1, arr2);
	}

//SOLUTION 1
	private void solution1(int[] arr1, int[] arr2) {
		int merge[] = new int[arr1.length + arr2.length];
		Arrays.fill(merge, -1);
		int i = 0, j = 0;
		while (i < merge.length) {
			while (j < arr1.length) {
				merge[i++] = arr1[j];
				unionArray(merge);
				j++;
			}
			j = 0;
			while (j < arr2.length) {
				merge[i++] = arr2[j];
				unionArray(merge);
				j++;
			}
		}
		Arrays.sort(merge);
		System.out.println("Union Elements:");
		for (int k = 0; k < merge.length; k++) {
			if (merge[k] != -1) {
				System.out.print(merge[k] + " ");
			}
		}
	}

	private void unionArray(int[] merge) {
		for (int i = 0; i < merge.length - 1; i++) {
			if (merge[i] != -1 && merge[i] == merge[i + 1]) {
				merge[i + 1] = -1;
			}
		}
	}

//	SOLUTION 2
	private void solution2(int[] arr1, int[] arr2) {
		Set<Integer> set = new TreeSet<Integer>();
		int j = 0;
		while (j < arr1.length) {
			set.add(arr1[j++]);
		}
		j = 0;
		while (j < arr2.length) {
			set.add(arr2[j++]);
		}
		System.out.println("Union Elements:");
		for (Integer number : set) {
			System.out.print(number + " ");
		}
	}

	// SOLUTION 3
	public void solution3(int[] arr1, int[] arr2) {
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				if (list.size() == 0 || list.get(list.size() - 1) != arr1[i])
					list.add(arr1[i]);
				i++;
			} else {
				if (list.size() == 0 || list.get(list.size() - 1) != arr2[j])
					list.add(arr2[j]);
				j++;
			}
		}

		while (i < arr1.length) {
			if (list.get(list.size() - 1) != arr1[i])
				list.add(arr1[i]);
			i++;
		}

		while (j < arr2.length) {
			if (list.get(list.size() - 1) != arr2[j])
				list.add(arr2[j]);
			j++;
		}
		System.out.println(list);

	}

}
