package com.akash.day27;

public class PowerOfTwo {
	public static void main(String[] args) {
		int n = 2147483647;
		PowerOfTwo p = new PowerOfTwo();
		System.out.println(p.solution1(n));
		System.out.println(p.solution2(n));
	}

	private boolean solution2(int n) {
		if (n <= 0)
			return false;
		return (n & (n - 1)) == 0;

	}

	private boolean solution1(int n) {
		int pow = 0;
		int ans = 0;
		while (n >ans) {
			ans = (int) Math.pow(2, pow);
			pow++;
		}
		return (ans == n) ? true : false;
	}
}
