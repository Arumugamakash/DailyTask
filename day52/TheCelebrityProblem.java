package com.akash.day52;

public class TheCelebrityProblem {
	public static void main(String[] args) {
		int n = 4;
		int[][] matrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };
		printMatrix(matrix);
		int id1 = findCelebrity1(n, matrix);
		int id2 = findCelebrity2(n, matrix);
		System.out.println(id1 == -1 ? "No celebrity" : "Celebrity Id=" + id1);
		System.out.println(id2 == -1 ? "No celebrity" : "Celebrity Id=" + id2);
	}

	private static int findCelebrity2(int n, int[][] matrix) {
		for (int i = 0; i < n; i++) {
			boolean isCelebrity = true;
			for (int j = 0; j < n; j++) {
				if (i != j && (matrix[i][j] == 1 || matrix[j][i] == 0)) {
					isCelebrity = false;
					break;
				}
			}
			if (isCelebrity) {
				return i;
			}
		}
		return -1;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int findCelebrity1(int n, int[][] matrix) {
		int cele = 0;
		for (int i = 0; i < n; i++)
			if (matrix[cele][i] == 1)
				cele = i;

		for (int i = 0; i < n; i++) {
			if (i != cele)
				if (matrix[cele][i] != 0 || matrix[i][cele] != 1)
					return -1;
		}

		return cele;
	}

}
