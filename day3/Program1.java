package com.akash.day3;

import java.util.Arrays;
import java.util.HashSet;

//FIND MISSING ELEMENT IN THE ARRAY
public class Program1 {
	public static void main(String[] args) {
		int arr[] = { 2, 1, 6, 5, 4 };
		Program1 p = new Program1();
		System.out.println("Missing Number int he array is : " + p.solution3(arr));
		System.out.println("Missing Number int he array is : " + p.solution2(arr));
		System.out.println("Missing Number int he array is : " + p.solution1(arr));

	}

	// solution 1
	private int solution1(int[] arr) {
		int n = arr.length + 1;// 6
		int sum = 0;
		int total = n * (n + 1) / 2;// 21
		for (int i : arr) {
			sum += i;
		}
		return total - sum;

	}

	// solution 2
	private int solution2(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int number : arr) {
			set.add(number);
		}
		for (int i = 1; i <= arr.length + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 0;
	}

	// solution 3
	private int solution3(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return arr.length + 1;
	}
}
