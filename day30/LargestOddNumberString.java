package com.akash.day30;

import java.util.ArrayList;
import java.util.List;

public class LargestOddNumberString {
	public static void main(String[] args) {
		String num = "123456";
		LargestOddNumberString p = new LargestOddNumberString();
		System.out.println(p.solution1(num));
		System.out.println(p.solution2(num));
		System.out.println(p.solution3(num));
	}
	//solution 1
	private String solution1(String num) {
		long max = 0;
		if (Long.parseLong(num) % 2 != 0) {
			return num;
		} else {
			for (int i = 0; i < num.length(); i++) {
				for (int j = i + 1; j < num.length(); j++) {
					long number = Long.parseLong(num.substring(i, j));
					if (number % 2 == 1) {
						max = Math.max(max, number);
					}
				}
			}
		}
		// System.out.println(max);
		return max != 0 ? "" + max : "";
	}
	//solution 2
	private String solution2(String num) {

		List<String> oddList = new ArrayList<String>();
		for (int i = 0; i < num.length(); i++) {
			if ((num.charAt(i) - '0') % 2 != 0) {
				oddList.add(num.substring(0, i + 1));
			}
		}
		String s = "";
		for (String odd : oddList) {
			if (odd.length() > s.length()) {
				s = odd;
			}
		}
		return s;
	}
	//solution 3
	private String solution3(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			if ((num.charAt(i) - '0') % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}

}
