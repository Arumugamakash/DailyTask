package com.akash.day24;

public class Problem3 {
	public static void main(String[] args) {
		int n = 10;
		Problem3 p = new Problem3();
		p.solution3(n);
		p.solution2(n);
		p.solution1(n);
	}

	private void solution1(int n) {
		StringBuilder sb = new StringBuilder();
		int num = 1;
		int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2);
		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				sb.append(" ");
			}
			for (int k = 1; k <= i; k++) {
				if (num <= n) {
					sb.append(num).append(" ");
					num++;
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private void solution2(int n) {
		int num = 1;
		int rows = (int) ((-1 + Math.sqrt(1 + 8 * n)) / 2);

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				if (num <= n) {
					System.out.print(num + " ");
					num++;
				}
			}
			System.out.println();
		}
	}

	private void solution3(int n) {
		int a = 1;
		int i;
		for (i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				a++;
			}
			if (i + 2 > n - (a - 1)) {
				break;
			}
		}
		int space = (i + 1) / 2 + 1, k;
		a = 1;
		for (k = 0; k < n; k++) {
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			for (int m = 0; m < k + 1; m++) {
				if (a < 10) {
					System.out.print(a++ + " ");
				} else {
					System.out.println(a++ + " ");
				}
			}
			space--;
			System.out.println();
			if (k + 2 > n - (a - 1)) {
				break;
			}
		}
	}

}
