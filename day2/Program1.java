package com.akash.day2;

import java.util.Arrays;
import java.util.TreeSet;

//find 2nd largest
public class Program1 {
	public static void main(String[] args) {
		int arr[] = { 32, 45, 21, 399, 12 };
		findSecondLargest(arr);
		solution2(arr);
		solution3(arr);
	}

	// SOLUTION 1
	private static void solution3(int[] arr) {
		if (arr.length < 2) {
			System.out.println("No Second Largest Number");
		} else {
			TreeSet<Integer> sort = new TreeSet<Integer>();
			for (int number : arr) {
				sort.add(number);
			}
			System.out.println("Second Largest Element is " + sort.lower(sort.last()));
		}
	}

	// SOLUTION 2
	private static void solution2(int[] arr) {
		if (arr.length > 2) {
			int firstLargest = arr[0];// 21;
			int secondLargest = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > firstLargest) {
					secondLargest = firstLargest;
					firstLargest = arr[i];
				}
			}
			System.out.println("Second Largest Element is :" + secondLargest);
		} else {
			System.out.println("No Second Largest Number");
		}
	}

	// SOLUTION 3
	private static void findSecondLargest(int[] arr) {
		if (arr.length > 2) {
			int i = 0;
			while (i < arr.length) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						int temp = arr[i];// 21
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				i++;
			}
			System.out.println("Second Largest Element is :" + arr[arr.length - 2]);
		} else {
			System.out.println("No Second Largest Number");
		}
	}

}
