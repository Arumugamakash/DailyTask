package com.akash.day1;

import java.util.Scanner;

//prime number
public class Problem3 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the Number");
		int n = sc.nextInt();
		solution1(n);
		if (solution2(n, n - 1)) {
			System.out.println("Number is Prime number");

		} else {
			System.out.println("Number is not prime number");
		}
		if (n == 0 || n == 1) {
			System.out.println("Either prime nor composite");
		} else if (solution3(n)) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Not prime");
		}

	}

//SOLUTION 1
	private static void solution1(int n) {
		int count = 0;
		if (n == 0 || n == 1) {
			System.out.println("Either prime nor composite");
		} else {
			int i = 1;
			while (n >= i) {
				if (n % i == 0) {
					count++;
				}
				i++;
			}
			System.out.println(count == 2 ? "Prime Number" : "Not a Prime Number");
		}
	}

//SOLUTION 2
	private static boolean solution2(int n, int i) {
		if (n <= 1) {
			return false;
		}
		if (i == 1) {
			return true;
		}
		if (n % i == 0) {
			return false;
		}
		return solution2(n, i - 1);
	}

//SOLUTION 3
	private static boolean solution3(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
