package com.akash.day61;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SortThePeople {
	public static void main(String[] args) {
		String[] names = { "Mary", "John", "Emma" };
		int arr[] = { 180, 165, 170 };
		System.out.println(Arrays.toString(solution2(names, arr)));
		System.out.println(Arrays.toString(solution1(names, arr)));
	}

	private static String[] solution1(String[] names, int[] arr) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], names[i]);
		}
		int j = names.length - 1;
		System.out.println(map);
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			names[j--] = entry.getValue();
		}
		return names;
	}

	private static String[] solution2(String[] names, int[] heights) {
		for (int i = 0; i < heights.length; i++) {
			for (int j = i + 1; j < heights.length; j++)
				if (heights[i] < heights[j]) {
					// swap the Integer
					int temp = heights[i];
					heights[i] = heights[j];
					heights[j] = temp;
					// swap the String
					String t1 = names[i];
					names[i] = names[j];
					names[j] = t1;
				}
		}

		return names;

	}

}
