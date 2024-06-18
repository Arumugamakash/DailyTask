package com.akash.day12;

import java.util.ArrayList;
import java.util.List;

// find the length of the last word.
public class Problem1 {
	public static void main(String[] args) {
		String s = "hello4 y world";
		Problem1 p = new Problem1();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution 1
	private int solution1(String s) {
		String sp[] = s.split(" ");
		String ans = sp[sp.length - 1];
		return ans.length();
	}

	// solution 2
	private int solution2(String s) {
		int total = s.length();
		int wordStart = s.lastIndexOf(" ");
		return total - (wordStart + 1);
	}

	// solution 3
	private int solution3(String s) {
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}
			count++;
		}
		return count;
	}

}
