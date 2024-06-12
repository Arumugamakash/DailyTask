package com.akash.day6;

import java.util.HashSet;
import java.util.Set;

//happy number
public class Problem3 {
	public static void main(String[] args) {
		int a = 100;
		Problem3 p = new Problem3();
		System.out.println(p.solution1(a) ? "Given Number is happy_Number" : "Given Number is Not happy_Number");
		System.out.println(p.solution2(a) ? "Given Number is happy_Number" : "Given Number is Not happy_Number");
		System.out.println(p.solution3(a) ? "Given Number is happy_Number" : "Given Number is Not happy_Number");
	}

	// solution 1
	private boolean solution1(int a) {

		int sum = 0;
		while (a != 1 || a != 2) {
			while (a > 0) {
				int last = a % 10;// 2
				sum += last * last;
				a = a / 10;
			}
			a = sum;
			return sum == 1 ? true : sum == 2 ? true : false;
		}
		return a == 1 ? true : a == 2 ? true : false;
	}

	private boolean solution2(int a) {
		Set<Integer> set = new HashSet<Integer>();
		int sum = 0;
		while (true) {
			while (a > 0) {
				int last = a % 10;// 2
				sum += last * last;
				a = a / 10;
			}
			a = sum;
			if (set.contains(a)) {
				return false;
			}
			if (sum == 1) {
				return true;
			}
//			else if(sum==2 ||set.add(sum)){
//				return false;
//			}
		}
	}

	// solution 3
	private boolean solution3(int n) {
		int sum = travers(n);
		if (sum <= 5) {
			return sum == 1;
		}
		return solution3(sum);
	}

	private static int travers(int n) {
		if (n == 0) {
			return 0;
		}
		return ((n % 10) * (n % 10)) + travers(n / 10);

	}
}
