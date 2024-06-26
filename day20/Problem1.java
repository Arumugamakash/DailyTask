package com.akash.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Roman to integer
public class Problem1 {
	public static void main(String[] args) {
		String s = "MCMXCIV";
		Problem1 p = new Problem1();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
		System.out.println(p.solution3(s));
	}

	// solution 1
	private int solution1(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int a = romanNumber(s.charAt(i));
			if (i + 1 < s.length()) {
				int b = romanNumber(s.charAt(i + 1));
				if (a >= b) {
					sum += a;
				} else {
					sum -= a;
				}
			} else {
				sum += a;
			}
		}
		return Math.abs(sum);
	}

	// solution 2
	private int solution2(String s) {
		int sum = 0;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			int a = romanNumber(s.charAt(i));
			if (i + 1 < s.length()) {
				int b = romanNumber(s.charAt(i + 1));
				if (a >= b) {
					list.add("" + a);
				} else {
					list.add("-" + a);
				}
			} else {
				list.add("" + a);
			}
		}
		for (String string : list) {
			sum += Integer.parseInt(string);
		}
		return sum;
	}

	// solution3
	private int solution3(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);

		int res = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (map.get("" + s.charAt(i)) > map.get("" + s.charAt(i + 1))) {
				res += map.get("" + s.charAt(i));
			} else {
				res -= map.get("" + s.charAt(i));
			}
		}
		res += map.get("" + s.charAt(s.length() - 1));
		return res;
	}

	private int romanNumber(char ch) {
		switch (ch) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

}
