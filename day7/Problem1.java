package com.akash.day7;

import java.util.Scanner;

//matrix rotation
public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length");
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		int start = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = start++;
			}
		}
		System.out.println("Input :-");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		Problem1 p = new Problem1();
		p.solution1(arr);
		p.solution2(arr);
		p.solution3(arr);
	}

	// SOLUTION 1
	private void solution1(int[][] arr) {
		int k = arr.length - 1;
		int ans[][] = new int[arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				ans[i][j] = arr[k--][i];
			}
			k = arr.length - 1;
		}
		printArray(ans);

	}

	// SOLUTION 2
	private void solution2(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int temp = arr[i][j];// 1 2
				arr[i][j] = arr[j][i];// 1 4
				arr[j][i] = temp;// 1 2
			}
		}
		int first = 0, last = 0;
		for (int[] a : arr) {
			first = 0;
			last = arr.length - 1;
			while (first < last) {
				int temp = a[first];
				a[first] = a[last];
				a[last] = temp;
				first++;
				last--;
			}
		}
		printArray(arr);
	}

	// SOLUTION 3
	private void solution3(int[][] arr) {
		int n = arr.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n - j - 1][i];
				arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
				arr[n - i - 1][n - j - 1] = arr[j][n - i - 1];
				arr[j][n - i - 1] = temp;
			}
		}
		printArray(arr);
	}

	private void printArray(int[][] ans) {
		System.out.println("Output :-");
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
