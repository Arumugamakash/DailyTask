package com.akash.day23;

public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		String s = "abcabcabcabc";
		RepeatedSubstringPattern p = new RepeatedSubstringPattern();
		// System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	private boolean solution3(String s) {
		int len = s.length();
		for (int i = len / 2; i >= 1; i--) {
			if (len % i == 0) {
				int m = len / i;
				String sub = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(sub);
				}
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean solution2(String s) {
		int n = s.length();// 3
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				String sub = s.substring(0, i);//
				System.out.println(sub);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n / i; j++) {
					sb.append(sub);
				}
				System.out.println("sb " + sb);
				if (sb.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean solution1(String s) {
		String sub = "";
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			sub += s.charAt(i);
			int len = sub.length();
			for (int j = 0; j < s.length() - len; j += len) {
				if (s.substring(j, j + len).equals(sub)) {
					flag = true;
				} else {
					flag = false;
					break;
				}
				System.out.println(flag);
			}
			if (flag) {
				return flag;
			}
		}

		return false;
	}

}
