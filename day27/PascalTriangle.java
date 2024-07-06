package com.akash.day27;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		int n = 3;
		PascalTriangle p = new PascalTriangle();
		System.out.println(p.solution1(n));
		p.solution2(n);
	}

	// solution 1
	private List<List<Integer>> solution1(int n) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			return out;
		}
		list.add(1);
		out.add(list);
		for (int i = 1; i < n; i++) {
			List<Integer> prevRow = out.get(i - 1);
			List<Integer> row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j < i; j++)
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			row.add(1);
			out.add(row);
		}
		return out;
	}

	// solution 2
	private void solution2(int n) {

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

}
