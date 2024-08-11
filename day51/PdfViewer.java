package com.akash.day51;

import java.util.ArrayList;
import java.util.List;

public class PdfViewer {
	public static void main(String[] args) {
		String s = "abcd";
		List<Integer> list = new ArrayList<>(
				List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
		System.out.println(pdfViewer1(s, list));
		System.out.println(pdfViewer2(s, list));
	}

	private static int pdfViewer1(String word, List<Integer> list) {

		int max = 0;
		int n = word.length();

		for (int i = 0; i < n; i++) {
			int ele = (word.charAt(i) - 'a');
			if (list.get(ele) > max)
				max = list.get(ele);
		}

		return n * max;
	}

	public static int pdfViewer2(String word, List<Integer> list) {
		int maxHeight = 0;
		for (char c : word.toCharArray()) {
			int height = list.get(c - 'a');
			if (height > maxHeight) {
				maxHeight = height;
			}
		}
		return maxHeight * word.length();
	}

}
