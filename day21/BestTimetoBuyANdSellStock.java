package com.akash.day21;

public class BestTimetoBuyANdSellStock {
	public static void main(String[] args) {
		int arr[] = { 7, 1, 5, 3, 6, 4 };
		BestTimetoBuyANdSellStock p = new BestTimetoBuyANdSellStock();
		System.out.println(p.solution2(arr));
		System.out.println(p.solution1(arr));
		System.out.println(p.solution3(arr));
	}

	// solution 1
	private int solution1(int[] prices) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] < prices[j]) {
					max = Math.max(max, prices[j] - prices[i]);
				}
			}
		}
		return max > 0 ? max : 0;
	}

	// solution 2
	private int solution2(int[] prices) {

		int profit = 0;
		int buy = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buy) {
				buy = prices[i];
			} else if (prices[i] - buy > profit) {
				profit = prices[i] - buy;
			}
		}
		return profit;
	}

	// solution 3
	private int solution3(int[] arr) {
		int buy = arr[0];
		int Maxprofit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > buy) {
				int profit = arr[i] - buy;
				Maxprofit = Math.max(Maxprofit, profit);
			} else {
				buy = arr[i];
			}
		}
		return Maxprofit;
	}

}
