package com.akash.day10;

import java.math.BigInteger;

/*Reverse Integer
   i/p:-123
   o/p:-321
 */
public class Problem2 {
	public static void main(String[] args) {
		int inp = 1223;
		Problem2 p = new Problem2();
		System.out.println("Output is:" + p.solution1(inp));
		System.out.println("Output is:" + p.solution2(inp));
		System.out.println("Output is:" + p.solution3(inp));
	}

	// solution 1
	private int solution1(int inp) {
		String rev = "";
		while (inp > 0) {
			rev += inp % 10;
			inp /= 10;
		}
		return inp = Integer.parseInt(rev);
	}

	// solution 2
	private int solution2(int inp) {
		int sum = 0;
		while (inp > 0) {
			int last = inp % 10;// 3 2
			sum = (sum * 10) + last;// 3
			inp /= 10;
		}
		return sum;
	}

	// solution 3
	private int solution3(int inp) {
		StringBuilder sb = new StringBuilder("" + inp);
		sb.reverse();
		String s = sb.toString();
		return Integer.parseInt(s);
	}

}
