package com.akash.day5;

import java.util.Arrays;
//LUKY NUMBER
import java.util.Scanner;

public class Problem1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter limit");
		int limit = sc.nextInt();
		System.out.println("Enter the lucky Number");
		int number = sc.nextInt();
		Problem1 p = new Problem1();
		p.solution1(number, limit);
		System.out.println();
		p.solution2(number, limit);
		System.out.println();
		p.solution3(number, limit);
	}

	// solution 1
	private void solution1(int number, int limit) {
		for (int i = 1; i < limit; i++) {
			int temp = i;// 15
			while (temp > 0) {
				int last = temp % 10;// 5
				if (last == number) {
					System.out.print(i + " ");
					break;
				}
				temp /= 10;
			}
		}
	}

	// solution 2
	private void solution2(int number, int limit) {
		String convert = String.valueOf(number);// 5
		for (int i = 1; i < limit; i++) {
			String value = String.valueOf(i);
			if (value.contains(convert)) {
				System.out.print(value + " ");
			}
		}
	}

	public static boolean containsDigit(int number, int digit) {
		String numberStr = String.valueOf(number);
		String digitStr = String.valueOf(digit);
		return numberStr.contains(digitStr);
	}

	// solution 3
	private void solution3(int number, int limit) {
		for (int i = 0; i < limit; i++) {
			if (containDigit(i, number))
				System.out.print(i + " ");
		}
	}

	private static boolean containDigit(int number, int digit) {
		if (number == 0) {
			return false;
		}
		if (number % 10 == digit) {
			return true;
		}
		return containsDigit(number / 10, digit);
	}

}
