package com.akash.day28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedUniformStrings {
	public static void main(String[] args) {
		String words = "abccddde";
		List<Integer> queries = List.of(6, 1, 3, 12, 5, 9, 10);
		System.out.println(queries);
		WeightedUniformStrings p = new WeightedUniformStrings();
		p.solution1(words);
		p.solution2(words, queries);
	}

	public void solution2(String s, List<Integer> queries) {
		Map<Integer, Boolean> weightMap = new HashMap<>();
		int currentWeight = 0;
		char prevChar = ' ';

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (currentChar == prevChar) {
				currentWeight += currentChar - 'a' + 1;
			} else {
				currentWeight = currentChar - 'a' + 1;
			}
			weightMap.put(currentWeight, true);
			prevChar = currentChar;
		}

		for (int query : queries) {
			System.out.println(weightMap.getOrDefault(query, false) ? "Yes" : "No");
		}
	}

	private void solution1(String word) {
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				count += word.charAt(i) - 'a' + 1;
			}
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				count += word.charAt(i) - 'A' + 1;
			}

		}
		System.out.println(count);
	}

}
