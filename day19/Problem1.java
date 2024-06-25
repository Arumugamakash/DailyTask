package com.akash.day19;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		int inp = 3;
		Problem1 p = new Problem1();
		// p.solution1(inp);
		p.solution2(inp);
		p.solution3(inp);
		p.solution1(inp);
	}

	private void solution1(int inp) {
		int n = inp * 2 - 1;
		String arr[][] = new String[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = " ";
			}
		}
		for (int i = 0; i < inp; i++) {
			for (int j = inp - i - 1; j <= inp + i - 1; j++) {
				arr[i][j] = "*";
			}
		}
		for (int i = inp - 2; i >= 0; i--) {
			for (int j = inp - i - 1; j <= inp + i - 1; j++) {
				arr[2 * inp - i - 2][j] = "*";
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private void solution3(int inp) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inp; i++) {
			sb.append(" ".repeat(inp - i - 1));
			for (int j = 0; j <= i; j++) {
				sb.append("* ");
			}
			sb.append("\n");
		}
		for (int i = inp - 2; i >= 0; i--) {
			sb.append(" ".repeat(inp - i - 1));
			for (int j = 0; j <= i; j++) {
				sb.append("* ");
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

	private void solution2(int inp) {
		int row = inp * 2 - 1;
		int star = 1;
		int space = inp - 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < star; j++) {
				System.out.print("* ");
			}
			if (i >= row / 2) {
				star--;
				space++;
			} else {
				space--;
				star++;
			}
			System.out.println();
		}
	}

//	private void solution1(int inp) {
//		int n = (inp * 2) - 1;
//		int half = n / 2;
//		int var = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (i % 2 == 0 && (j % 2 == 0 && ((n / 2 - var) == j || (n / 2 + var) == j || j == n / 2))) {
//					System.out.print("*");
//				} else if (i % 2 != 0 && (j % 2 != 0 && ((n / 2 - var) == j || (n / 2 + var) == j))) {
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//
//			}
//			System.out.println("Var " + var);
//			if (i < n / 2) {
//				var++;
//			} else {
//				var--;
//			}
//			System.out.println();
//		}
//	}
}
