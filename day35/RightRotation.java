package com.akash.day35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightRotation {
	public static void main(String[] args) {
		int arr[] = { 3, 4, 5 };
		int k = 2;
		int quries[] = { 1, 2 };
		RightRotation p = new RightRotation();
		System.out.println(Arrays.toString(p.solution1(arr, k, quries)));
		System.out.println(p.solution2(arr, k, quries));
	}

	private List<Integer> solution2(int[] arr, int k, int[] quries) {
		List<Integer> list = new ArrayList<Integer>();
		int len = arr.length;
		k = k % len;//
		int count = 0;
		for (int start = 0; count < len; start++) {
			int curr = start;
			int prev = arr[start];
			do {
				int next = (curr + k) % len;
				int temp = arr[next];
				arr[next] = prev;
				prev = temp;
				curr = next;
				count++;
			} while (start != curr);
		}
		for (int i = 0; i < quries.length; i++) {
			list.add(arr[quries[i]]);
		}
		return list;
	}

	private int[] solution1(int[] arr, int k, int[] queries) {
		int n = arr.length;
		k = k % n;
		int[] rotatedArray = new int[n];
		for (int i = 0; i < n; i++) {
			rotatedArray[(i + k) % n] = arr[i];
		}

		int[] result = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = rotatedArray[queries[i]];
		}

		return result;
	}

}
