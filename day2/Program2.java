package com.akash.day2;

import java.math.BigInteger;
//perfect number or not
import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer the number");
		int number = sc.nextInt();
		solution1(number);
		solution2(number);
		int ans = solution3(number, 1);
		System.out.println(ans == number ? "Number is Perfect Number" : "Number is Not a Perfect Number");
	}

	// SOLUTION 1
	private static void solution1(int number) {
		int i = 1;
		int sum = 0;
		while (number > i) {
			if (number % i == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum == number ? "Number is Perfect Number" : "Number is Not a Perfect Number");
	}

	// SOLUTION 2
	private static void solution2(int number) {
		BigInteger sum = BigInteger.ZERO;// 0
		System.out.println(sum);
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum = sum.add(BigInteger.valueOf(i));
			}
		}
		System.out.println(
				sum.equals(BigInteger.valueOf(number)) ? "Number is Perfect Number" : "Number is Not a Perfect Number");
	}

	// SOLUTION 3
	private static int solution3(int number, int count) {
		if (count >= number / 2) {
			return count;
		}
		if (number % count == 0) {
			return count + solution3(number, count + 1);
		}
		return solution3(number, count + 1);
	}

}
