package com.akash.day25;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static void main(String[] args) {
		int n = 10;
		FizzBuzz p = new FizzBuzz();
		System.out.println(p.solution1(n));
		System.out.println(p.solution2(n));
	}

	private List<String> solution2(int n) {
		List<String> answer = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();

			if (i % 3 == 0) {
				sb.append("Fizz");
			}
			if (i % 5 == 0) {
				sb.append("Buzz");
			}
			if (sb.length() == 0) {
				sb.append(i);
			}

			answer.add(sb.toString());
		}

		return answer;
	}

	public List<String> solution1(int n) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				list.add("FizzBuzz");
			else if (i % 3 == 0)
				list.add("Fizz");
			else if (i % 5 == 0)
				list.add("Buzz");
			else
				list.add(i + "");
		}
		return list;
	}

}
