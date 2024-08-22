package com.akash.day61;

public class MaxRepeatingWord {
	public static void main(String[] args) {
		String seq = "ababc";
		String word = "ab";
		System.out.println(solution1(seq, word));
	}

	private static int solution1(String sequence, String word) {

		int n = sequence.length();
		int m = word.length();
		int[] dp = new int[n + 1];
		int maxRepeat = 0;

		for (int i = m; i <= n; i++) {
			if (sequence.substring(i - m, i).equals(word)) {
				dp[i] = dp[i - m] + 1;
				maxRepeat = Math.max(maxRepeat, dp[i]);
			}
		}

		return maxRepeat;
	}

}
