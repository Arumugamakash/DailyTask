package com.akash.day57;

public class MinCostClimbingStairs {
	public static void main(String[] args) {
		int cost[] = { 10, 15, 20 };
		System.out.println(solution1(cost));
		System.out.println(solution2(cost));
	}

	private static int solution1(int[] cost) {
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];

		for (int i = 2; i < cost.length; i++)
			dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);

		return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
	}

	public static int solution2(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];
		return Math.min(minCost(cost, n - 1, dp), minCost(cost, n - 2, dp));

	}

	private static int minCost(int[] cost, int n, int[] dp) {
		if (n < 0)
			return 0;
		if (n == 0 || n == 1)
			return cost[n];
		if (dp[n] != 0)
			return dp[n];
		dp[n] = cost[n] + Math.min(minCost(cost, n - 1, dp), minCost(cost, n - 2, dp));
		return dp[n];
	}
}
