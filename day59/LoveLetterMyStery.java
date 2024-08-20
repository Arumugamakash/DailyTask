package com.akash.day59;

public class LoveLetterMyStery {
	public static void main(String[] args) {

		String s = "abc";
		System.out.println(solution1(s));
		System.out.println(solution2(s));

	}

	private static int solution2(String s) {
		int first = 0, last = s.length();
		int count = 0;
		int half = (last % 2 == 0) ? ((last / 2) - 1) : (last / 2);

		while (first <= half) {
			if (s.charAt(first) != s.charAt(last - 1 - first))
				count += Math.abs(s.charAt(first) - s.charAt(last - 1 - first));
			first++;
		}

		return count;
	}

	private static int solution1(String s) {
		int j = s.length() - 1;
		int x;
		int y;
		int count = 0;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(j)) {
				x = s.charAt(i);// a
				y = s.charAt(j);// c
				count += Math.abs(x - y);
				System.out.println(count);
				j--;

			} else {
				j--;
			}
		}
		return count;
	}

}
