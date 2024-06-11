package com.akash.day5;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Number");
		int number = sc.nextInt();
		Problem3 p = new Problem3();
		p.solution1(number);
		p.solution2(number);
		p.solution3(number);
	}

	// solution 1
	private void solution1(int number) {
		int onesCount = 0, sum = 0;
		while (number != 0) {
			int divide = number % 2;// 0
			sum = sum * 10 + divide;// 0
			if (divide == 1)
				onesCount++;
			number /= 2;
		}
		System.out.println("Binary form: " + sum);
		System.out.println("Ones Count :" + onesCount);
	}

	// solution 2
	private void solution2(int number) {
		StringBuilder sb = new StringBuilder();
		int onesCount = 0;
		for (int i = 0; i < 10; i++) {
			if (number % 2 == 0)
				sb.append("0");
			else {
				sb.append("1");
				onesCount++;
			}
			number /= 2;
		}
		System.out.println("Binary form: " + sb.reverse());
		System.out.println("Ones Count :" + onesCount);
	}

	// solution 3
	private void solution3(int number) {
		int onesCount = 0;
		for (int i = 9; i >= 0; i--) {
			int binary = (int) Math.pow(2, i);// using math.power
			if (binary <= number) {
				System.out.print(1);
				onesCount++;
				number = number - binary;
			} else
				System.out.print(0);
		}
		System.out.println();
		System.out.println("Ones Count :" + onesCount);
	}

}
