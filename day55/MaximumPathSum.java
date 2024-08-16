package com.akash.day55;

public class MaximumPathSum {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(solution1(arr));
	}

	private static int solution1(int[][] arr) {
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = min + arr[i][j];
					min = arr[i][j];// 4//2
				} else if (i != 0 && j != 0) {
					arr[i][j] = arr[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
				}
			}
			min = arr[i][0];// 1
		}
		return arr[arr.length - 1][arr[0].length - 1];
	}

}
