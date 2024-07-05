package com.akash.day26;

public class MaximumHeightOfTriangle {
	public static void main(String[] args) {
		int blue = 4;
		int red = 2;
		MaximumHeightOfTriangle p = new MaximumHeightOfTriangle();
		System.out.println(Math.max(p.solution1(blue, red), p.solution1(red, blue)));
		System.out.println(Math.max(p.solution2(blue, red), p.solution2(red, blue)));
	}

	// solution 1
	private int solution1(int blue, int red) {
		int max = blue + red;// 6
		int count = 0;
		for (int i = 1; i <= max; i++) {
			if (i % 2 == 1) {
				if (red >= i) {
					red -= i;
				} else {
					break;
				}
			} else {
				if (blue >= i) {
					blue -= i;
				} else {
					break;
				}
			}
			count++;
		}

		return count;
	}

	// solution 2
	private int solution2(int blue, int red) {
		return Math.max(find(red, blue, true), find(red, blue, false));
	}

	public int find(int red, int blue, boolean b) {
		int count = 0;
		while (true) {
			count++;
			if (b) {
				if (blue >= count) {
					blue -= count;
				} else {
					break;
				}
			} else {
				if (red >= count) {
					red -= count;
				} else {
					break;
				}
			}
			b = !b;
		}
		return count - 1;
	}

}
