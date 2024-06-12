package com.akash.day6;

public class Problem2 {
	public static void main(String[] args) {
		String inp = "aabbbcc";
		Problem2 p = new Problem2();
		p.solution1(inp);
		System.out.println();
		p.solution2(inp);
		System.out.println();
		p.solution3(inp);
	}

	// solution1
	private void solution1(String inp) {
		int count = 1;
		for (int i = 0; i < inp.length() - 1; i++) {
			if (inp.charAt(i) == inp.charAt(i + 1)) {
				count++;
			} else {
				System.out.print(inp.charAt(i) + "" + count);
				count = 1;
			}
		}
		System.out.print(inp.charAt(inp.length() - 1) + "" + count);
	}

	// solution 2
	private void solution2(String inp) {
		int arr[] = new int[26];
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < inp.length(); i++) {
			int a = (int) inp.charAt(i);
			arr[a - 97] += 1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				res.append((char) (i + 'a') + "" + arr[i]);
		}

		System.out.println(res.toString());
	}

	// solution 3
	private void solution3(String inp) {
		int count = 1;
		int first = inp.charAt(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < inp.length(); i++) {
			if (first == inp.charAt(i)) {
				count++;
			} else {
				sb.append(inp.charAt(i - 1) + "" + count);
				first = inp.charAt(i);
				count = 1;
			}
		}
		sb.append(inp.charAt(inp.length() - 1) + "" + count);
		System.out.println(sb.toString());
	}

}
