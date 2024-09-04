package com.akash.day74;

public class SherlockAndSquares {
	public static void main(String[] args) {
		int a = 2, b = 9;
		System.out.println(solution1(a, b));
		System.out.println(solution2(a, b));
	}

	private static int solution1(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			int sqrt = (int) Math.sqrt(i);
			if (sqrt * sqrt == i) {
				count++;
			}
		}
		return count;
	}

	private static int solution2(int a, int b) {
		int start = (int) Math.ceil(Math.sqrt(a));
		int end = (int) Math.floor(Math.sqrt(b));
		return (start > end) ? 0 : (end - start + 1);
	}

}
