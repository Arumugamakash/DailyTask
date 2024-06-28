package com.akash.day22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		int arr[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		SetMatrixZeroes p = new SetMatrixZeroes();
		p.solution3(arr);
		p.solution2(arr);
		p.solution1(arr);
	}

	// solution 1
	private void solution1(int[][] arr) {
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> col = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (row.contains(i) || col.contains(j)) {
					arr[i][j] = 0;
				}
			}
		}
		printArray(arr);
	}

	// solution 2
	private void solution2(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int rowArr[] = new int[m];
		int colsArr[] = new int[n];
		Arrays.fill(rowArr, 1);
		Arrays.fill(colsArr, 1);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					rowArr[i] = 0;
					colsArr[j] = 0;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (rowArr[i] == 0 || colsArr[j] == 0) {
					arr[i][j] = 0;
				}
			}
		}
		printArray(arr);
	}

	// solution 3
	private void solution3(int[][] matrix) {

		System.out.println("Original Array is :");
		printArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					int k = j;
					while (k >= 0) {
						if (matrix[i][k] != 0) {
							matrix[i][k] = -1;
						}
						k--;
					}
					k = j;
					while (k < matrix[i].length) {
						if (matrix[i][k] != 0) {
							matrix[i][k] = -1;
						}
						k++;
					}
					k = i;
					while (k >= 0) {
						if (matrix[k][j] != 0) {
							matrix[k][j] = -1;
						}
						k--;
					}
					k = i;
					while (k < matrix.length) {
						if (matrix[k][j] != 0) {
							matrix[k][j] = -1;
						}
						k++;
					}
				}
			}
			// System.out.println();
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}
		System.out.println("Your valid output is: ");
		printArray(matrix);

	}

	private void printArray(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
