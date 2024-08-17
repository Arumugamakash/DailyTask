package com.akash.day56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceLane {
	public static void main(String[] args) {
		int[] width = { 2, 3, 2, 1 };
		int[][] cases = { { 1, 2 }, { 2, 3 } };
		System.out.println(Arrays.toString(solution1(width, cases)));
	}

	private static int[] solution1(int[] width, int[][] cases) {
		int[] result = new int[cases.length];
		for (int i = 0; i < cases.length; i++) {
			int entry = cases[i][0];
			int exit = cases[i][1];
			int minWidth = Integer.MAX_VALUE;

			for (int j = entry; j <= exit; j++) {
				minWidth = Math.min(minWidth, width[j]);
			}
			result[i] = minWidth;
		}

		return result;
	}
}
