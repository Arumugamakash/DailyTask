package com.akash.day36;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsequencesWithSumEqualsToK {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4 };
		int K = 4;
		FindAllSubsequencesWithSumEqualsToK p = new FindAllSubsequencesWithSumEqualsToK();
		p.solution1(arr, K);
		List<List<Integer>> subsequences = solution2(arr, K);

		System.out.println("Subsequences with sum " + K + ":");
		for (List<Integer> subsequence : subsequences) {
			System.out.println(subsequence);
		}
	}

	private void solution1(int[] arr, int sum) {
		int n = arr.length;
		int totalSubsequences = 1 << n;

		for (int j = 0; j < totalSubsequences; j++) {
			List<Integer> subsequence = new ArrayList<>();
			int total = 0;

			for (int i = 0; i < n; i++) {
				if ((i & (1 << i)) != 0) {
					subsequence.add(arr[i]);
					total += arr[i];
				}
			}

			if (total == sum) {
				System.out.print(subsequence);
			}
		}
	}

	public static List<List<Integer>> solution2(int[] arr, int K) {
		List<List<Integer>>[] dp = new List[K + 1];
		for (int i = 0; i <= K; i++) {
			dp[i] = new ArrayList<>();
		}
		dp[0].add(new ArrayList<>());

		for (int num : arr) {
			for (int sum = K; sum >= num; sum--) {
				for (List<Integer> subsequence : dp[sum - num]) {
					List<Integer> newSubsequence = new ArrayList<>(subsequence);
					newSubsequence.add(num);
					dp[sum].add(newSubsequence);
				}
			}
		}

		return dp[K];
	}
}
