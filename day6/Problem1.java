package com.akash.day6;

import java.util.Arrays;

//ROTATE ARRAY Left & right rotate
public class Problem1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int count = 3;
		Problem1 p = new Problem1();
		p.solution1(arr, count);
		p.solution2(arr, count);
		p.solution3(arr, count);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	// solution 1
	private void solution1(int[] arr, int count) {
		int newArray[] = Arrays.copyOf(arr, arr.length);
		while (count > 0) {
			for (int j = 1; j < newArray.length; j++) {
				newArray[j] = arr[j - 1];
			}
			newArray[0] = arr[arr.length - 1];
			arr = Arrays.copyOf(newArray, newArray.length);
			count--;
		}
		System.out.println(Arrays.toString(newArray));
	}

	// solution 2
	private void solution2(int[] arr, int count) {
		while (count > 0) {
			int first = arr[arr.length - 1];// 5
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = first;
			count--;
		}
		System.out.println(Arrays.toString(arr));

	}
//	private void solution2(int[] arr, int count) {
//		while (count > 0) {
//			int first = arr[0];// 1
//			for (int i = 1; i < arr.length; i++) {
//				arr[i - 1] = arr[i];
//			}
//			arr[arr.length - 1] = first;
//			count--;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//	}

	// solution 3
	private void solution3(int[] arr, int count) {
		int n = arr.length;
		count = count % n;
		reverse(arr, 0, count - 1);
		reverse(arr, count, n - 1);
		reverse(arr, 0, n - 1);
	}

	private void reverse(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

}
