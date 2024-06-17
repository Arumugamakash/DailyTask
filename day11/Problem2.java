package com.akash.day11;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		Problem2 p = new Problem2();
		System.out.println(p.solution1(arr));
		System.out.println(p.solution2(arr));
		System.out.println(p.solution3(arr));
	}

	// solution 1
	public int solution1(int[][] grid) {
		int min = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 || j == 0) {
					grid[i][j] = min + grid[i][j];
					min = grid[i][j];// 4//2
				} else if (i != 0 && j != 0) {
					grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
			min = grid[i][0];// 1
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

	// solution 2
	private int solution2(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != 0 && j == arr.length - 1) {
					sum += arr[i][j];
				}
				if (i == 0) {
					sum += arr[i][j];
				}
			}
		}
		return sum;
	}

	// solution 1
	public int solution3(int[][] arr) {
		int[][] temp = new int[arr.length][arr[0].length];
		return findMinimumRecursively(arr, 0, 0, temp);
	}

	private int findMinimumRecursively(int[][] arr, int i, int j, int[][] temp) {
		if (i >= arr.length || j >= arr[0].length)
			return Integer.MAX_VALUE;
		if (i == arr.length - 1 && j == arr[0].length - 1)
			return arr[i][j];
		if (temp[i][j] != 0)
			return temp[i][j];

		int right = findMinimumRecursively(arr, i, j + 1, temp);
		int down = findMinimumRecursively(arr, i + 1, j, temp);

		temp[i][j] = arr[i][j] + Math.min(right, down);
		return temp[i][j];
	}

}
