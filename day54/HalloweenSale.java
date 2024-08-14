package com.akash.day54;

public class HalloweenSale {
	public static void main(String[] args) {
		int p = 20;
		int d = 3;
		int m = 6;
		int s = 80;
		System.out.println(solution1(p, d, m, s));
		System.out.println(solution2(p, d, m, s));
	}

	private static int solution2(int p, int d, int m, int s) {
		int count = 0;
		while (s >= p) {
			s = s - p;// 60//43//29//18//10//4
			count++;// 1 2//3//4//5//6
			p = Math.max(p - d, m);// 6
		}
		return count;
	}

	private static int solution1(int p, int d, int m, int s) {
		if (s < p) {
			return 0;
		}
		return 1 + solution1(Math.max(p - d, m), d, m, s - p);
	}

}
