package com.akash.day29;

public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 2;
		ClimbingStairs p = new ClimbingStairs();
		System.out.println(p.solution1(n));
		System.out.println(p.solution3(n));
		System.out.println(p.solution2(n));
	}

	private int solution2(int n) {
		if (n <= 1)
			return 1;
		return solution2(n - 1) + solution2(n - 2);
	}

	private int solution3(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		return arr[n];
	}

	private int solution1(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int prev = 1, curr = 1;
		for (int i = 2; i <= n; i++) {
			int temp = curr;// 2
			curr = prev + curr;// 3
			prev = temp;// 2
		}
		return curr;
	}

}
