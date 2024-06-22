package com.akash.day16;

/*
1.Alternate Sorting
Input: {1, 2, 3, 4, 5, 6, 7}
output: {7, 1, 6, 2, 5, 3, 4}
 */
import java.util.Arrays;

public class Problem1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		Problem1 p = new Problem1();
		p.solution1(arr);
		p.solution3(arr);
		p.solution2(arr);
	}

	// solution 1
	private void solution1(int[] arr) {
		int ans[] = new int[arr.length];
		int first = 0;
		int last = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				ans[i] = arr[last--];
			} else {
				ans[i] = arr[first++];
			}
		}
		System.out.println(Arrays.toString(ans));
	}

	// solution 3
	private void solution3(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			System.out.print(arr[right--] + " ");
			System.out.print(arr[left++] + " ");
		}
		if (arr.length % 2 != 0)
			System.out.print(arr[left] + "\n");
	}

	// solution 2
	private void solution2(int[] arr) {
		int last = arr.length - 1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (count == 2) {
				last--;
				count = 0;
			}
			if (i >= last) {
				break;
			}
			int temp = arr[i];// 1
			if (count == 1) {
				arr[i] = arr[arr.length - 1];
				arr[arr.length - 1] = temp;

			} else {
				arr[i] = arr[last];
				arr[last] = temp;
			}
			count++;
		}
		System.out.println(Arrays.toString(arr));
	}

}
