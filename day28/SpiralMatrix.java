package com.akash.day28;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		SpiralMatrix p = new SpiralMatrix();
		// System.out.println(p.solution1(matrix));
		System.out.println(p.solution2(matrix));
		System.out.println(p.solution3(matrix));
	}

	private List<Integer> solution2(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int rowL = 0;
		int colL = 0;
		int colU = matrix[0].length - 1;
		int rowU = matrix.length - 1;
		while (rowL <= rowU && colL <= colU) {
			for (int i = colL; i <= colU; i++) {
				list.add(matrix[rowL][i]);
			}
			rowL++;// 1
			for (int i = rowL; i <= rowU; i++) {
				list.add(matrix[i][colU]);
			}
			colU--;// 1
			if (rowL > rowU || colL > colU) {
				break;
			}
			for (int i = colU; i >= colL; i--) {
				list.add(matrix[rowU][i]);
			}
			rowU--;// 1
			for (int i = rowU; i >= rowL; i--) {
				list.add(matrix[i][colL]);
			}
			colL++;
		}
		return list;
	}

	// solution 2
	private List<Integer> solution3(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int x = 0;
		int y = 0;
		int dy = 1;
		int dx = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < rows * cols; i++) {
			list.add(matrix[x][y]);
			matrix[x][y] = -101;
			if (!(0 <= y + dy && y + dy < cols && 0 <= x + dx && x + dx < rows) || matrix[x + dx][y + dy] == -101) {
				int temp = dy;
				dy = -dx;
				dx = temp;
			}
			y += dy;
			x += dx;
		}
		return list;
	}
}
