package com.akash.day59;

public class WaterBottle2 {
	public static void main(String[] args) {
		int numBottle = 13;
		int numExchange = 6;
		System.out.println(solution1(numBottle, numExchange));
		System.out.println(solution2(numBottle, numExchange));
	}

	private static int solution2(int numBottle, int numExchange) {
		int drunk = numBottle;
		while (numBottle >= numExchange) {
			numBottle -= numExchange;
			numBottle++;
			numExchange++;
			drunk++;
		}
		return drunk;
	}

	private static int solution1(int numBottles, int numExchange) {
		int res = numBottles;
		int emptyBottles = numBottles;
		int fullBottles = 0;

		while (numExchange <= emptyBottles) {
			while (emptyBottles >= numExchange) {
				fullBottles++;
				emptyBottles -= numExchange;
				numExchange++;
			}

			res += fullBottles;
			emptyBottles += fullBottles;
			fullBottles = 0;
		}
		return res;
	}

}
