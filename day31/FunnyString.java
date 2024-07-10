package com.akash.day31;

public class FunnyString {
	public static void main(String[] args) {
		String s = "acxz";
		FunnyString p = new FunnyString();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution 1
	private String solution1(String s) {
		StringBuilder from = new StringBuilder();
		for (int i = 0; i < s.length() - 1; i++) {
			from.append(Math.abs((s.charAt(i) - 'a') - (s.charAt(i + 1) - 'a')));
		}
		System.out.println(from);
		StringBuilder rev = new StringBuilder();
		for (int i = s.length() - 1; i > 0; i--) {
			rev.append(Math.abs((s.charAt(i) - 'a') - (s.charAt(i - 1) - 'a')));
		}
		System.out.println(rev);
		return from.toString().equals(rev.toString()) ? "funny" : "Not Funny";
	}

	// solution 2
	private String solution2(String s) {
		int from[] = new int[s.length() - 1];
		int end[] = new int[s.length() - 1];
		for (int i = 1; i < s.length(); i++) {
			from[i - 1] = Math.abs((s.charAt(i) - 'a') - (s.charAt(i + 1) - 'a'));
			end[i - 1] = Math.abs((s.charAt(i) - 'a') - (s.charAt(i + 1) - 'a'));
		}
		for (int i = 0; i < end.length; i++) {
			if (from[i] != end[i]) {
				return "Not Funny";
			}
		}
		return "Funny";
	}

	// solution 3
	private String solution3(String s) {
		StringBuilder start = new StringBuilder();
		int i = 0, j = s.length() - 1;
		StringBuilder end = new StringBuilder();
		while (i < s.length() - 1) {
			start.append(Math.abs((s.charAt(i) - 'a') - (s.charAt(i + 1) - 'a')));
			end.append(Math.abs((s.charAt(j) - 'a') - (s.charAt(j - 1) - 'a')));
			i++;
			j--;
		}
		return start.toString().equals(end.toString()) ? "Funny String" : "Not Funny";
	}

}
