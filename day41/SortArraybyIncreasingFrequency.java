package com.akash.day41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortArraybyIncreasingFrequency {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 3, 1, 4, 2, 1 };
		frequencySort1(arr);
		System.out.println(Arrays.toString(frequencySort2(arr)));
	}

	private static int[] frequencySort2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();
			if (!sortedMap.containsKey(val)) {
				sortedMap.put(val, new ArrayList<>());
			}
			sortedMap.get(val).add(key);
		}
		int index = 0;
		int[] result = new int[nums.length];
		for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
			int key = entry.getKey();
			List<Integer> list = entry.getValue();
			Collections.sort(list);
			for (int num : list) {
				for (int i = 0; i < key; i++) {
					result[index++] = num;
				}
			}
		}
//		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			Integer key = entry.getKey();
//			Integer val = entry.getValue();
//			System.out.println(key + "->" + val);
//		}
		return result;
	}

	public static int[] frequencySort1(int[] nums) {
		int hash[] = new int[100];
		int res[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			hash[nums[i]]++;
		}
		int count = 1;
		int k = 0;
		System.out.println(Arrays.toString(hash));
		for (int i = 0; i < hash.length; i++) {
			for (int j = 0; j < hash.length; j++) {
				if (hash[j] == count) {
					int times = hash[j];
					while (times > 0) {
						res[k++] = j;// 3
						times--;
					}
				}
			}
			count++;
		}

		return hash;
	}
}
