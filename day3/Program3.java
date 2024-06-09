package com.akash.day3;

import java.util.Arrays;
import java.util.HashMap;

//Electronics Shop
public class Program3 {
	public static void main(String[] args) {
		int[] keyboards = { 40, 50, 60 };
		int drives[] = { 5, 8, 12 };
		int budget = 60;
		Program3 p = new Program3();
		System.out.println("Most Expensive is:" + p.solution1(keyboards, drives, budget));
		System.out.println("Most Expensive is:" + p.solution2(keyboards, drives, budget));
		System.out.println("Most Expensive is:" + p.solution3(keyboards, drives, budget));

	}

	// SOLUTION 1
	private int solution1(int[] keyboards, int[] drives, int b) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				sum = keyboards[i] + drives[j];
				if (sum >= max && sum <= b) {
					max = sum;
				}
			}
		}
		if (max == 0) {
			return -1;
		}
		return max;
	}

    //SOLUTION 2
	private int solution2(int[] keyboards, int[] drives, int budget) {
		Arrays.sort(keyboards);
		Arrays.sort(drives);

		int max = 0;
		int j = drives.length - 1;

		for (int i = 0; i < keyboards.length; i++) {
			while (j >= 0 && keyboards[i] + drives[j] > budget) {
				j--;
			}
			if (j >= 0) {
				max = Math.max(max, keyboards[i] + drives[j]);
			}
		}

		return max;
	}

	// SOLUTION 3
	private int solution3(int[] keyboards, int[] drives, int budget) {
		int max = 0;
		HashMap<Integer, Integer> keyboard = new HashMap<>();
		for (int keyboardPrice : keyboards) {
			if (keyboardPrice < budget)
				keyboard.put(keyboardPrice, keyboardPrice);
		}
		for (int drivePrice : drives) {
			if (drivePrice < budget) {
				int remainingBudget = budget - drivePrice;
				for (int keyboardPrice : keyboard.keySet()) {
					if (keyboardPrice <= remainingBudget) {
						max = Math.max(max, drivePrice + keyboardPrice);
					}
				}
			}
		}
		return max;

	}

}
