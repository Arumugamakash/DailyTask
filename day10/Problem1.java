package com.akash.day10;

//1.Count Maximum Consecutive One's in the array
public class Problem1 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 9, 1, 1, 1 };
		Problem1 p = new Problem1();
		System.out.println("Maximum Ones int the Array is :" + p.solution1(arr));
		System.out.println("Maximum Ones int the Array is :" + p.solution2(arr));
	}

	// solution1
	private int solution1(int[] arr) {
		int count = 0;
		int maxOnes = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
			} else {
				count = 0;
			}
		}
		maxOnes = Math.max(maxOnes, count);
		return maxOnes;
	}

	// solution 2
	private int solution2(int[] arr) {
		int tempArray[] = new int[1];
		int max = 0;
		tempArray[0] = arr[0] == 1 ? 1 : 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 1) {
				tempArray[0] = tempArray[0] + 1;
			} else {
				tempArray[0] = 0;
			}
			max = Math.max(max, tempArray[0]);
		}
		return max;
	}
}
