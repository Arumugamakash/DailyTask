package com.akash.day46;

import java.util.Arrays;

public class FrogsandJumps {
	public static void main(String[] args) {
		int frogs[] = { 3, 2, 4 };
		int leaves = 4;
		int n = 3;
		solution1(n, frogs, leaves);
	}

	private static int solution1(int n, int[] frogs, int leaves) {
		Arrays.sort(frogs);
		boolean[] visit = new boolean[leaves + 1];

		for (int i = 0; i < n; i++) {
			int frog = frogs[i];
			for (int j = 0; j <= leaves; j++)
				if (j % frog == 0) {
					visit[j] = true;
				}

		}
		int count = 0;
		System.out.println(Arrays.toString(visit));
		for (int i = 0; i < visit.length; i++)
			if (!visit[i])
				count++;
		System.out.println(count);

		return count;
	}

}
