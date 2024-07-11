package com.akash.day32;

import java.util.Arrays;

public class AssignCokkies {
	public static void main(String[] args) {
		int g[] = { 10, 9, 8, 7 };
		int s[] = { 5, 6, 7, 8 };
		AssignCokkies p = new AssignCokkies();
		System.out.println(p.solution1(g, s));
		System.out.println(p.solution2(g, s));
	}

	private int solution2(int[] g, int[] s) {
		int count = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		for (int i = 0, j = 0; i < g.length && j < s.length;) {
			if (g[i] <= s[j]) {
				count++;
				i++;
				j++;
			}
			while (i < g.length && j < s.length && g[i] > s[j]) {
				j++;
			}
		}
		return count;
	}

	private int solution1(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int cokkie = 0;
		int child = 0;
		while (cokkie < s.length && child < g.length) {
			if (s[cokkie] >= g[child]) {
				child++;
			}
			cokkie++;
		}
		return child;
	}

}
