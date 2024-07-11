package com.akash.day32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubArrayWith_0_sum {
	public static void main(String[] args) {
		int arr[] = { 1, 2, -2, 4, -4 };
		LongestSubArrayWith_0_sum p = new LongestSubArrayWith_0_sum();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
	}

	private int solution2(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i]; // 2
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];// 3
				count++;
				System.out.println("sum " + sum);
				if (sum == 0) {
					max = Math.max(max, count);// 3
				}
			}
		}
		return max;
	}

	private int solution1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0)
				max = i + 1;
			else {
				if (map.get(sum) != null)
					max = Math.max(max, i - map.get(sum));
				else
					map.put(sum, i);
			}
		}

		return max;
	}

}
