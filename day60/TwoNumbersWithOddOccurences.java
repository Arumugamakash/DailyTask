package com.akash.day60;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumbersWithOddOccurences {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(solution1(arr)));
		// System.out.println(Arrays.toString(solution2(arr)));
	}

	private static int[] solution2(int[] Arr) {
		HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < Arr.length; ++i) {
			if (mp.containsKey(Arr[i])) {
				mp.put(Arr[i], mp.get(Arr[i]) + 1);
			} else {
				mp.put(Arr[i], 1);
			}
		}

		int[] arr = new int[2];
		int k = 0;

		for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
			if (x.getValue() % 2 == 1 && k < 2) {
				arr[k++] = x.getKey();
			}
		}
		int[] out = new int[2];
		out[0] = Math.max(arr[0], arr[1]);
		out[1] = Math.min(arr[0], arr[1]);
		return out;
	}

	private static int[] solution1(int[] arr) {
		Arrays.sort(arr);
		int[] res = new int[2];
		int k = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1])
				i++;
			else {
				if (k >= 0) {
					res[k--] = arr[i];
				}
			}
		}
		if (res[0] == 0)
			res[0] = arr[arr.length - 1];

		return res;
	}
}
