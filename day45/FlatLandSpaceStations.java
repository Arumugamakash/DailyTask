package com.akash.day45;

import java.util.Arrays;

public class FlatLandSpaceStations {
	public static void main(String[] args) {
		int n = 5;
		int[] c = { 0, 4 };
		System.out.println(solution1(n, c));
		System.out.println(solution2(n, c));
	}

	private static int solution2(int n, int[] c) {
		Arrays.sort(c);
		int maxDistance = 0;
		maxDistance = Math.max(maxDistance, c[0]);

		for (int i = 1; i < c.length; i++) {
			int midDistance = (c[i] - c[i - 1]) / 2;
			maxDistance = Math.max(maxDistance, midDistance);
		}

		maxDistance = Math.max(maxDistance, n - 1 - c[c.length - 1]);

		return maxDistance;
	}

	private static int solution1(int n, int[] c) {
		int maxDistance = 0;
		for (int i = 0; i < n; i++) {
			int minDistance = Integer.MAX_VALUE;
			for (int station : c) {
				int distance = Math.abs(station - i);
				if (distance < minDistance) {
					minDistance = distance;
				}
			}
			if (minDistance > maxDistance) {
				maxDistance = minDistance;
			}
		}
		return maxDistance;
	}

}
