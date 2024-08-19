package com.akash.day58;

public class PartitionArrayforMaximumSum {
	public static void main(String[] args) {
		int arr[] = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		System.out.println(solution1(arr, k));
	}

	private static int solution1(int[] arr, int k) {
		int n = arr.length;
		int[] dp = new int[n + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			int len = 0;
			int maxi = Integer.MIN_VALUE;
			int maxAns = Integer.MIN_VALUE;
			for (int j = ind; j < Math.min(ind + k, n); j++) {
				len++;
				maxi = Math.max(maxi, arr[j]);
				int sum = len * maxi + dp[j + 1];
				maxAns = Math.max(maxAns, sum);
			}
			dp[ind] = maxAns;
		}
		return dp[0];
	}

}
