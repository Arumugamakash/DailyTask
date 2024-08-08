package com.akash.day48;

public class MaximumScoreAfterSplittingString {
	public static void main(String[] args) {
		String s = "00111";
		System.out.println(solution1(s));
		System.out.println(solution2(s));
		System.out.println(solution3(s));
	}

	private static int solution2(String s) {
		int zeroCount = 0, onesCount = 0;
		int max = Integer.MIN_VALUE;
		int i = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0')
				zeroCount++;// 2
			else
				onesCount++;// 0//1//2//3

			if (i != s.length() - 1) {
				max = Math.max(max, zeroCount - onesCount);
			}
			i++;
		}
		return max + onesCount;
	}

	private static int solution1(String s) {
		int max = -1;
		for (int i = 0; i < s.length() - 1; i++) {
			int sum = 0;
			String left = s.substring(0, i + 1);
			int j = 0;
			while (left.length() > j) {
				if (left.charAt(j) == '0') {
					sum++;// 1
				}
				j++;
			}
			String right = s.substring(i + 1);
			j = 0;
			while (right.length() > j) {
				if (right.charAt(j) == '1') {
					sum++;// 1
				}
				j++;
			}
			max = Math.max(max, sum);
		}
		return max;
	}

	private static int solution3(String s) {
		int n = s.length();
		int[] leftZeros = new int[n];
		int[] rightOnes = new int[n];

		leftZeros[0] = s.charAt(0) == '0' ? 1 : 0;
		for (int i = 1; i < n; i++) {
			leftZeros[i] = leftZeros[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
		}

		rightOnes[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
		for (int i = n - 2; i >= 0; i--) {
			rightOnes[i] = rightOnes[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
		}

		int maxScore = 0;
		for (int i = 0; i < n - 1; i++) {
			maxScore = Math.max(maxScore, leftZeros[i] + rightOnes[i + 1]);
		}

		return maxScore;
	}

}
