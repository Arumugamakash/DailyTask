package com.akash.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Integer to Roman
public class Problem3 {
	public static void main(String[] args) {
		int number = 3345;
		Problem3 p = new Problem3();
		p.solution1(number);
		p.solution2(number);
	}

	// solution1
	private void solution1(int number) {
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (number > 0) {
			if (number >= values[i]) {
				sb.append(romanNumerals[i]);
				number -= values[i];
			} else {
				i++;
			}
		}
		System.out.println(sb);
	}

	// solution 2
	private void solution2(int number) {
		TreeMap<Integer, String> map = new TreeMap();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (number > 0) {
			Map.Entry<Integer, String> entry = map.floorEntry(number);
			System.out.println(entry);
			sb.append(entry.getValue());
			number -= entry.getKey();
		}
		System.out.println(sb);

	}
}
