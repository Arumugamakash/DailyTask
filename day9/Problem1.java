package com.akash.day9;

//triangle
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
	public static void main(String[] args) {
		int numofRows = 5;
		Problem1 p = new Problem1();
		System.out.println(p.solution1(numofRows));
		System.out.println(p.solution2(numofRows));
	}

	// solution 1
	private List<List<Integer>> solution1(int numofRows) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if (numofRows == 0) {
			return out;
		}
		list.add(1);
		out.add(list);
		for (int i = 1; i < numofRows; i++) {
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
	private List<List<Integer>> solution2(int numofRows) {
		List<List<Integer>> out = new ArrayList<>();
		out.add(Arrays.asList(1));
		for (int i = 1; i < numofRows; i++) {
			out.add(new ArrayList<>());
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == 0 || j == i) {
					out.get(i).add(1);
				} else {
					out.get(i).add(out.get(i - 1).get(j) + out.get(i - 1).get(j - 1));
				}
			}
		}

		return out;
	}

}
