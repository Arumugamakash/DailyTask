package com.akash.day39;

public class NimGame {
	public static void main(String[] args) {
		int n = 45;
		NimGame p = new NimGame();
		System.out.println(p.solution1(n));
		System.out.println(p.solution2(n));
	}

	private boolean solution1(int n) {
		return n % 4 != 0;
	}

	private boolean solution2(int n) {
		if (n <= 3)
			return true;

		boolean[] arr = new boolean[n + 1];

		arr[1] = arr[2] = arr[3] = true;

		for (int i = 4; i < n + 1; i++)
			arr[i] = !arr[i - 1] || !arr[i - 2] || !arr[i - 3];

		return arr[n];
	}

}
