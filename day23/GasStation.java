package com.akash.day23;

public class GasStation {
	public static void main(String[] args) {
		int gas[] = { 1, 2, 3, 4, 5 };
		int cost[] = { 3, 4, 5, 1, 2 };
		GasStation p = new GasStation();
		System.out.println(p.solution3(gas, cost));
		System.out.println(p.solution2(gas, cost));
		System.out.println(p.solution1(gas, cost));
	}

	private int solution1(int[] gas, int[] cost) {
		int totalGas = 0, totalCost = 0;
		int startIndex = 0, tank = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
		}
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				startIndex = i + 1;
				tank = 0;
			}
		}

		return totalGas >= totalCost ? startIndex : -1;

	}

	private int solution2(int[] gas, int[] cost) {
		int totalGas = 0;
		for (int i = 0; i < cost.length; i++) {
			totalGas += gas[i] - cost[i];
		}
		if (totalGas < 0) {
			return -1;
		}
		int startIndex = 0;
		int remGas = 0;
		for (int i = 0; i < gas.length; i++) {
			remGas += gas[i] - cost[i];
			if (remGas < 0) {
				remGas = 0;
				startIndex = i + 1;
			}
		}
		return startIndex;
	}

	private int solution3(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int remGas = 0;
			int startIndex = i;
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				int start = (i + j) % n;
				remGas += gas[start] - cost[start];
				if (remGas < 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return startIndex;
			}
		}

		return -1;
	}
}