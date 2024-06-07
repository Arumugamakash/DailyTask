package com.akash.day1;

import java.math.BigInteger;
import java.util.Scanner;

//WAJP FACTORIAL
public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		System.out.println("Factorial of " + number + " = " + solution1(number));
		System.out.println("Factorial of " + number + " = " + solution2(number));
		System.out.println("Factorial of " + number + " = " + solution3(number));
	}

	//// SOLUTION 1
	private static int solution1(int n) {
		int fact = 1;
		int i = 1;
		while (i <= n) {
			fact *= i;
			i++;
		}
		return fact;
	}

//SOLUTION 2
	private static int solution2(int number) {
		if (number == 0 || number == 1) {
			return 1;
		} else {
			return  number * solution2(number - 1);
		}
	}

//SOLUTIN 3
	private static BigInteger solution3(int number) {
		BigInteger ans = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			ans = ans.multiply(BigInteger.valueOf(i));// 1
		}
		return ans;
	}
}
