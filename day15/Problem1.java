package com.akash.day15;
//counting bits
import java.util.Arrays;

public class Problem1 {
	public static void main(String[] args) {
		int number = 5;
		Problem1 p = new Problem1();
		System.out.println(Arrays.toString(p.solution1(number)));
		System.out.println(Arrays.toString(p.solution2(number)));
		System.out.println(Arrays.toString(p.solution3(number)));
	}

	// solution 1
	private int[] solution1(int n) {
		int arr[] = new int[n + 1];
		while (n > 0) {
			int sum = 0;
			int temp = n;
			while (temp > 0) {
				sum += temp % 2;
				temp = temp / 2;
			}
			arr[n] = sum;
			n--;

		}
		return arr;
	}

	// solution 2
	private int[] solution2(int n) {
		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ans[i] = ans[i >> 1] + (i & 1);
		}
		return ans;
	}

	// solution 3
	private int[] solution3(int number) {
		int ans[] = new int[number + 1];
		for (int i = 0; i <= number; i++) {
			ans[i] = Integer.bitCount(i);
		}
		return ans;
	}

}
