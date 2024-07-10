package com.akash.day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		MergeIntervals p = new MergeIntervals();
		// int result[][] = p.solution1(arr);
		List<int[]> list = p.solution2(arr);
		for (int[] is : list) {
			System.out.print(Arrays.toString(is));
		}
//		for (int i = 0; i < result.length; i++) {
//			for (int j = 0; j < result[i].length; j++) {
//				System.out.print(result[i][j]);
//			}
//			System.out.println();
//		}

	}

	private List<int[]> solution2(int[][] intervals) {
		List<int[]> result = new ArrayList<>();
		if (intervals == null || intervals.length == 0)
			return result;

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		int[] prev = intervals[0];
		System.out.println("prev " + Arrays.toString(prev));
		result.add(prev);

		for (int[] interval : intervals) {
			int currentEnd = prev[1];
			System.out.println("CE " + currentEnd);
			int nextStart = interval[0];
			System.out.println("NS " + nextStart);
			int nextEnd = interval[1];
			System.out.println("NE " + nextEnd);
			if (currentEnd >= nextStart) {
				prev[1] = Math.max(currentEnd, nextEnd);
			} else {
				prev = interval;
				result.add(prev);
			}
		}

		return result;
	}

	private int[][] solution1(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> merged = new ArrayList<>();
		int[] prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];
			System.out.println(Arrays.toString(interval));
			if (interval[0] <= prev[1]) {
				prev[1] = Math.max(prev[1], interval[1]);
			} else {
				merged.add(prev);
				prev = interval;
			}

		}
		merged.add(prev);

		return merged.toArray(new int[merged.size()][]);
	}
}
