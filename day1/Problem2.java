package com.akash.day1;

import java.util.Arrays;

//FIBONACI SERIES
public class Problem2 {
	static int n1 = 0, n2 = 1, size = 1;

	public static void main(String[] args) {
		System.out.println("Enter the size of the series");

		soltion1(size);
		System.out.println();
		solution2(size);
		System.out.print(n1 + " " + n2 + " ");
		size -= 2;
		System.out.println();
		soltion3(n1 + n2);

	}

	// SOLTION 1
	private static void soltion1(int size) {
		int n1 = 0, n2 = 1, n3 = 0;
		int i = 2;
		System.out.print(n1 + " " + n2 + " ");
		while (i < size) {
			n3 = n1 + n2;// 1 2
			System.out.print(n3 + " ");
			n1 = n2;// 1 //1
			n2 = n3;// 1 //2
			i++;
		}
	}

//SOLUTION 2
	private static void solution2(int size) {
		int arr[] = new int[size];
		if (size == 1) {
			System.out.print(0);
		} else if (size == 2) {
			System.out.print(1);
		} else {
			arr[0] = 0;
			System.out.print(arr[0] + " ");
			arr[1] = 1;
			System.out.print(arr[1] + " ");
			for (int i = 2; i < arr.length; i++) {
				arr[i] = arr[i - 2] + arr[i - 1];
				System.out.print(arr[i] + " ");
			}
		}
	}

//SOLUTION 3
	private static void soltion3(int n3) {

		if (size > 0) {
			System.out.print(n3 + " ");
			n1 = n2;
			n2 = n3;
			n3 = n1 + n2;
			size--;
			soltion3(n3);
		}

	}
}
