package com.akash.day17;

import java.util.Arrays;

public class Problem2 {
	public static void main(String[] args) {
		String sp[] = { "Flow", "Flower", "Flight" };
		String sp1[] = { "dog", "car", "racecar" };
		Problem2 p = new Problem2();
		System.out.println(p.solution1(sp));
		System.out.println(p.solution2(sp));
		System.out.println(p.solution3(sp));
	}

	private String solution3(String[] sp) {
		String present = "";
		String first = sp[0];// flow
		String res = "";
		for (int i = 1; i < sp.length; i++) {
			String check = sp[i];
			int j = 0;
			while (j < first.length()) {
				if (first.charAt(j) == check.charAt(j)) {
					present += (first.charAt(j));
				}
				if (present.contains("" + check.charAt(j))) {
					res += (check.charAt(j));
				}
				j++;
			}
			if (i == sp.length - 1) {
				return res;
			}
			res = "";
		}
		return "";

	}

	private String solution2(String[] sp) {
		String frst = sp[0];
		for (int i = 1; i < sp.length; i++) {
			while (sp[i].indexOf(frst) != 0) {
				frst = frst.substring(0, frst.length() - 1);
				if (frst.isEmpty())
					return "";
			}
		}
		return frst;
	}

	private String solution1(String[] sp) {
		StringBuilder ans = new StringBuilder();
		Arrays.sort(sp);
		String first = sp[0];
		String last = sp[sp.length - 1];
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != last.charAt(i)) {
				return ans.toString();
			}
			ans.append(first.charAt(i));
		}
		return ans.toString();
	}
}
