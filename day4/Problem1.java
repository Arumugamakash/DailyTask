package com.akash.day4;

import java.util.Arrays;
import java.util.HashSet;

//REMOVE THE DUPLICATE ELEMENT IN THE ARRAY
public class Problem1 {
	public static void main(String[] args) {
		int arr[] = { 1, 4, 3, 1, 5, 3, 5 };
		Problem1 p = new Problem1();
		p.solution1(arr);
		System.out.println();
		System.out.println(Arrays.toString(p.solution2(arr)));
		System.out.println(Arrays.toString(p.solution3(arr)));
	}
//	SOLUTION 1
	private void solution1(int[] arr) {
		int i = 0;
		while (i < arr.length) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			i++;
		}
		for (int j = 0; j < arr.length - 1; j++) {
			if (arr[j] != -1 && arr[j] == arr[j + 1]) {
				arr[j + 1] = -1;

			}
		}
		for (int number : arr) {
			if (number != -1) {
				System.out.print(number + " ");
			}
		}
	}
//	SOLUTION 2
	private int[] solution2(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		int originalPos = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean duplicate = false;
			for (int j = 0; j < originalPos; j++) {
				if (arr[i] == arr[j]) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				arr[originalPos] = arr[i];
				originalPos++;
			}
		}
		for (int i = originalPos; i < arr.length; i++) {
			arr[i] = 0;
		}
		return arr;
	}
//	SOLUTION 3
	private int[] solution3(int[] arr) {
		int originalPos = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
				arr[originalPos] = arr[i];
				originalPos++;
			}
		}
		for (int i = originalPos; i < arr.length; i++) {
			arr[i] = 0;
		}
		return arr;

	}

}
