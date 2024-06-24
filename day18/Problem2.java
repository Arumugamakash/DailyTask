package com.akash.day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 Print second frequently occurring number in given series
Input: 1 1 2 3 1 2 4
Output: 2
 */
public class Problem2 {
	public static void main(String[] args) {
		int nums[] = { 1, 1, 3, 2, 3, 1, 2, 4 };
		Problem2 p = new Problem2();
		System.out.println(p.solution1(nums));
		System.out.println(p.solution2(nums));
		System.out.println(p.solution3(nums));
	}

	// solution 1
	private int solution1(int[] arr) {
		int secondFreq = -1;
		int firstFreq = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && firstFreq != arr[i]) {
					secondFreq = arr[i];// 1
				}
				if (arr[i] == arr[j]) {
					firstFreq = arr[i];// 1
					break;
				}
			}
		}
		return secondFreq;
	}

	// solution 2
	private int solution2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int last = 0;
		out: for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					set.add(nums[i]);// 1
					if (set.size() == 2) {
						break out;
					}
				}
			}
		}
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) {
			last = (int) i.next();
		}
		return last;
	}
	// solution 3

	private int solution3(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// HashMap<Integer, Integer>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		System.out.println(map);
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		int secongFreq = list.get(1);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == secongFreq) {
				return entry.getKey();
			}
		}

		return -1;
	}

}
