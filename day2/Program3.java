package com.akash.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// String sort
public class Program3 {
	public static void main(String[] args) {
		String inp = "AZFWAS";
		Program3 p1 = new Program3();
		p1.solution2(inp);
		solution1(inp);
		System.out.println(p1.solution3(inp));

	}

	// SOLUTION 1
	private static void solution1(String inp) {
		char[] ch = inp.toCharArray();
		int i = 0;
		while (i < ch.length) {
			for (int j = 0; j < ch.length; j++) {
				if (ch[i] < ch[j]) {
					char temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp;
				}
			}
			i++;
		}
		String ans = new String(ch);
		System.out.println("Sorted String : " + ans);
	}

	// SOLUTION 2
	private void solution2(String input) {
		int arr[] = new int[26];
		for (int i = 0; i < input.length(); i++) {
			int a = (int) input.charAt(i);// 65
			arr[a - 65] += 1;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int count = arr[i];
				while (count > 0) {
					sb.append((char) (65 + i));
					count--;
				}
			}
		}
		System.out.println(sb.toString());
	}

	// SOLUTION 3
	private String solution3(String input) {
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		Collections.sort(list);
		String s = "";
		for (Character character : list) {
			s += character;
		}
		return s;
	}
}
