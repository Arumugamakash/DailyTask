package com.akash.day40;

public class NumberOfBitChangesToMakeTwoIntegersEqual {
	public static void main(String[] args) {
		int k = 4;
		int n = 13;
		System.out.println(solution1(n, k));
		System.out.println(solution2(n, k));
	}

	private static int solution1(int n, int k) {
		if (n == k) {
			return 0;
		} else if (n < k) {
			return -1;
		}
		int count = 0;
		char[] ns = Integer.toBinaryString(n).toCharArray();
		char[] ks = Integer.toBinaryString(k).toCharArray();
		for (int i = ns.length - 1, j = ks.length - 1; i >= 0; i--, j--) {
			if (j < 0) {
				if (ns[i] == '1') {
					count++;
				}
			} else if (ks[j] != ns[i] && ns[i] == '1') {
				count++;
			} else if (ks[j] != ns[i]) {
				return -1;
			}
		}
		return count;
	}

	private static int solution2(int n, int k) {
		int xor = n ^ k;
		int count = 0;
		while (xor != 0) {
			count += xor & 1;
			xor >>= 1;
		}
		return count;
	}


}
