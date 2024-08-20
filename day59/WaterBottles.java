package com.akash.day59;

public class WaterBottles {
	public static void main(String[] args) {
		int numBottles = 9;
		int numExchange = 3;
		System.out.println(solution1(numBottles, numExchange));
		System.out.println(solution2(numBottles, numExchange));
	}

	private static int solution1(int numBottles, int numExchange) {
		if (numBottles < numExchange) {
			return numBottles;
		}
		int count = numBottles;
		int temp = numBottles;
		int i = 0;
		while (temp >= numExchange) {
			if (temp >= numExchange) {
				temp = temp - numExchange;// 15-4/11-4//7-4//3
				i++;// 3
				count++;// 18
			}
			if (temp < numExchange) {
				temp += i;
				i = 0;
			}
		}

		return count;
	}

	private static int solution2(int numBottles, int numExchange) {
		return numBottles + (numBottles - 1) / (numExchange - 1);
	}

}
