package com.akash.day8;

import java.util.Scanner;

//power of three
public class Problem2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your number");// 27
		int number = sc.nextInt();
		Problem2 p = new Problem2();
		System.out.println(p.solution1(number) ? "given Number is True" : "Given Number is False");
		System.out.println(p.solution2(number) ? "given Number is True" : "Given Number is False");
		System.out.println(p.solution3(number) ? "given Number is True" : "Given Number is False");

	}

	private boolean solution3(int number) {
		if (number <= 0) {
			return false;
		}
		if (number == 1) {
			return true;
		}
		int mul = 1;
		for (int i = 1; i < number / 2; i++) {
			mul *= 3;
			if (number == mul) {
				return true;
			}
		}

		return false;

	}

	private boolean solution2(int number) {
		int mul = 3;
		if (number <= 0 || number == 2) {
			return false;
		}
		while (mul < number) {
			mul = mul * 3;
			if (mul == number) {
				return true;
			}
		}
		return false;

	}

	private boolean solution1(int number) {
		if (number == 1)
			return true;
		if (number <= 0)
			return false;
		if (number % 3 != 0)
			return false;
		return solution1(number / 3);
	}
}
