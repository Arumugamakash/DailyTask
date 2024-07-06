package com.akash.day27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInArray {
	public static void main(String[] args) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		LeadersInArray p = new LeadersInArray();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
	}

	private List<Integer> solution2(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int j;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] <= arr[j]) {
					break;
				}
			}
			if (j == arr.length) {
				list.add(arr[i]);
			}
		}
		return list;
	}

	private List<Integer> solution1(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		int max = arr[arr.length - 1];
		list.add(max);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				list.add(max);
			}
		}
		Collections.sort(list, Collections.reverseOrder());
		return list;
	}

}
