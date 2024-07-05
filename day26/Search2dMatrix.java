package com.akash.day26;

public class Search2dMatrix {
	public static void main(String[] args) {
		int arr[][] = { { 1, 3 } };
		int target = 3;
		Search2dMatrix p = new Search2dMatrix();
		System.out.println(p.solution1(arr, target));
		System.out.println(p.solution2(arr, target));
		System.out.println(p.solution3(arr, target));
	}

	// solution 1
	private boolean solution1(int[][] matrix, int target) {
		out: for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
				if (matrix[i][j] > target) {
					break out;
				}
			}
		}
		return false;
	}

	// solution 2
	private boolean solution2(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] <= target && matrix[i][matrix[i].length - 1] >= target) {
					System.out.println(matrix[i][j]);
					System.out.println(matrix[i][matrix[i].length - 1]);
					if (matrix[i][j] == target) {
						return true;
					}
				} else {
					break;
				}
			}
		}

		return false;
	}

	// solution 3
	private boolean solution3(int[][] arr, int target) {
		int row = arr.length, column = arr[0].length;
		int i = 0, j = column - 1;
		while (i < row && j >= 0) {
			int mid = arr[i][j];
			if (mid == target) {
				return true;
			}
			if (mid < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
