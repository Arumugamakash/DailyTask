package com.akash.day68;

public class CanPlaceFlowers {
	public static void main(String[] args) {
		int arr[] = { 1, 0, 0, 0, 1, 0, 0 };
		int n = 2;
		System.out.println(solution1(arr, n));
		System.out.println(solution2(arr, n));
	}

	private static boolean solution2(int[] flowerbed, int n) {
		int i = 0;
		while (i < flowerbed.length) {
			if (flowerbed[i] == 1)
				i += 2;
			else {
				if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
					flowerbed[i] = 1;
					n--;
					i += 2;
				} else {
					i++;
				}
			}

			if (n == 0)// 2
				return true;

		}

		return false;
	}

	private static boolean solution1(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				int prev = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1;
				int next = (flowerbed[flowerbed.length - 1] == 0 || flowerbed[i + 1] == 0) ? 0 : 1;
				if (prev == 0 && next == 0) {
					flowerbed[i] = 1;
					count++;
				}
			}
		}
		return count >= n;
	}
}
