package com.akash.day15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {
	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		Problem3 p = new Problem3();
		System.out.println(p.solution1(coins, amount));
		System.out.println(p.solution2(coins, amount));
	}

	// solution 1
	private int solution1(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[dp.length - 1];
	}

	// solution 2
	private int solution2(int[] coins, int amount) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = coinChange(coins, amount, map);
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private int coinChange(int[] coins, int amount, Map<Integer, Integer> map) {
		if (amount < 0)
			return Integer.MAX_VALUE;
		if (amount == 0)
			return 0;
		if (map.containsKey(amount))
			return map.get(amount);

		int minCoins = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, amount - coin, map);
			if (res != Integer.MAX_VALUE) {
				minCoins = Math.min(minCoins, res + 1);
			}
		}

		map.put(amount, minCoins);
		return minCoins;
	}
}
