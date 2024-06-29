package com.akash.day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistances {
	public static void main(String[] args) {
		int arr[] = { 7, 1, 3, 4, 1, 7 };
		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(7);
		MinimumDistances p = new MinimumDistances();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
		System.out.println(p.solution3(list));

	}

	private int solution3(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (map.containsKey(list.get(i))) {
				min = Math.min(min, i - map.get(list.get(i)));
			}
			map.put(list.get(i), i);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private int solution2(int[] arr) {
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] == arr[end]) {
				int diff = end - start;
				min = Math.min(min, diff);
			}
			start++;
			end--;
		}

		return min;
	}

	private int solution1(int[] arr) {
		int minValue = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					minValue = j - i;// 5
				}
				min = Math.min(min, minValue);
			}
		}
		return min;
	}

}
