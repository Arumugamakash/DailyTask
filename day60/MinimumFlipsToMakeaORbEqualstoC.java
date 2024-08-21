package com.akash.day60;

public class MinimumFlipsToMakeaORbEqualstoC {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		int c = 5;
		System.out.println(solution1(a, b, c));
	}

	private static int solution1(int a, int b, int c) {
		int flip = 0;
		while (a != 0 || b != 0 || c != 0) {
			int aBit = a & 1;
			int bBit = b & 1;
			int cBit = c & 1;

			if (cBit == 1) {
				if (aBit == 0 && bBit == 0) {
					flip++;
				}
			} else {
				flip += aBit + bBit;
			}

			a >>= 1;
			b >>= 1;
			c >>= 1;
		}
		return flip;
	}

}
