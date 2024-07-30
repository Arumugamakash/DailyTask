package com.akash.day45;

public class FindtheCountOfNumbersWhichAreNotSpecial {
	public static void main(String[] args) {
		int l = 5;
		int r = 7;
		System.out.println(solution1(l, r));
		System.out.println(solution2(l, r));
	}

	private static int solution1(int l, int r) {
		int count = 0;
		while (l <= r) {
			if (!isSpecial(l)) {
				count++;
			}
			l++;
		}
		return count;
	}

	private static boolean isSpecial(int n) {
		int count = 1;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				count++;
			}
			if (count > 2) {
				return false;
			}
		}
		return count == 2;
	}

	private static int solution2(int l, int r) {
		int num = (int) Math.sqrt(r);
		int special = 0;
		while (num * num >= l && num * num <= r) {
			boolean flag = true;
			for (int i = 2; i <= (int) Math.sqrt(num); i++) {
				if (num % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				special++;
			}
			num--;
		}
		int ans = r - l + 1 - special;
		if (l == 1) {
			ans++;
		}
		return ans;
	}

}
