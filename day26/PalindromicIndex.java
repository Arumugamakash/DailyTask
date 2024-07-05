package com.akash.day26;

public class PalindromicIndex {
	public static void main(String[] args) {
		String s = "aaab";
		PalindromicIndex p = new PalindromicIndex();
		System.out.println(p.solution1(s));
		System.out.println(p.solution2(s));
	}

	// solution 1
	private int solution1(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				if (isPalindrome(s, left + 1, right)) {
					return left;
				} else if (isPalindrome(s, left, right - 1)) {
					return right;
				} else {
					return -1;
				}
			}
			left++;
			right--;
		}
		return -1;
	}

	// solution 2
	public int solution2(String s) {
		return findIndex(s, 0, s.length() - 1);
	}

	private int findIndex(String s, int left, int right) {
		if (left >= right) {
			return -1;
		}

		if (s.charAt(left) == s.charAt(right)) {
			return findIndex(s, left + 1, right - 1);
		} else {
			if (isPalindrome(s, left + 1, right)) {
				return left;
			} else if (isPalindrome(s, left, right - 1)) {
				return right;
			} else {
				return -1;
			}
		}
	}

	private boolean isPalindrome(String s, int left, int right) {

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
