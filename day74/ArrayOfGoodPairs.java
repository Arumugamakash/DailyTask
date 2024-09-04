package com.akash.day74;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfGoodPairs {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 3, 6 };
		System.out.println(solution3(arr));
		System.out.println(solution2(arr));
	}

	private static boolean solution2(int[] arr) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int n : arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		System.out.println(map);
		for (int n : map.keySet()) {
			System.out.println("N " + map.get(n));
			if (map.get(n) > 0) {
				if (n < 0 && n % 2 != 0)
					return false;

				int target = n < 0 ? n / 2 : n * 2;

				if (map.get(n) > map.getOrDefault(target, 0)) {
					return false;
				}

				map.put(target, map.get(target) - map.get(n));
			}
		}

		return true;
	}

	private static boolean solution3(int[] arr) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int a : arr) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		for (int x : map.keySet()) {
			if (map.get(x) == 0)
				continue;
			int want = x < 0 ? x / 2 : x * 2;
			if (x < 0 && x % 2 != 0 || map.get(x) > map.getOrDefault(want, 0))
				return false;
			map.put(want, map.get(want) - map.get(x));
		}
		return true;
	}

}
