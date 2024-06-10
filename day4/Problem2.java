package com.akash.day4;

//GIVEN NUMBER IS STRONG OR NOT
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter INPUT");
		int inp = sc.nextInt();// 145
		Problem2 p = new Problem2();
		p.solution1(inp);
		p.solution2(inp);
		System.out.print(p.solution3(inp) == inp ? "Strong Number" : "Not a Strong Number");
	}

	// SOLUTION 1
	private void solution1(int inp) {
		int original = inp;
		int sum = 0;
		while (inp > 0) {
			int fact = 1;
			int last = inp % 10;// 5
			while (last > 0) {
				fact *= last;
				last--;
			}
			sum += fact;
			inp /= 10;
		}
		System.out.println(sum == original ? "Given Number is Strong Number" : "Given Number is Not Strong Number");
	}

	// SOLUTION 2
	private void solution2(int inp) {
		int temp = inp;
		int sum = 0;
		int storeFact[] = new int[10];
		for (int i = 1; i <= 9; i++) {
			int fact = 1;
			int j = i;
			while (j > 0) {
				fact *= j;
				j--;
			}
			storeFact[i] = fact;
		}
		while (inp > 0) {
			int last = inp % 10;// 5
			sum += storeFact[last];
			inp /= 10;
		}
		System.out.println(sum == temp ? "Strong Number" : "Not a Strong Number");
	}

	// SOLUTION 3
	private int solution3(int inp) {
		if (inp == 0)
			return 0;
		else {
			return fact(inp % 10) + solution3(inp / 10);
		}
	}

	private int fact(int inp) {
		if (inp == 0 || inp == 1) {
			return 1;
		}
		return inp * fact(inp - 1);
	}

}
