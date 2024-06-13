package com.akash.day7;

//Palindrome or not
public class Problem2 {
	public static void main(String[] args) {
		String inp = "madam";
		Problem2 p = new Problem2();
		p.solution1(inp);
		System.out.println(p.solution2(inp) ? "Given String is Palindrome" : "Given String is Not Palindrome");
		p.solution3(inp);
		System.out.println(p.solution4(inp) ? "Given String is Palindrome" : "Given String is Not Palindrome");
	}

	// SOLUTION 1
	private void solution1(String inp) {
		String rev = "";
		for (int i = inp.length() - 1; i >= 0; i--) {
			rev += inp.charAt(i);
		}
		System.out.println(inp.equalsIgnoreCase(rev) ? "Given String is Palindrome" : "Given String is Not Palindrome");
	}

	// SOLUTION 2
	private boolean solution2(String inp) {
		inp = inp.toLowerCase();
		int n = inp.length() - 1;
		boolean b = false;
		for (int i = 0; i < inp.length(); i++) {
			if (inp.charAt(i) == inp.charAt(n)) {
				b = true;
				n--;
				if (i > n)
					break;

			} else {
				return false;
			}
		}
		return b;
	}

	// SOLUTION 3
	private void solution3(String inp) {
		StringBuilder sb = new StringBuilder(inp);
		sb = sb.reverse();
		if (inp.substring(0, inp.length()).equalsIgnoreCase(sb.substring(0, sb.length()))) {
			System.out.println("Given String is Palindrome");
		} else {
			System.out.println("Given String is Not Palindrome");
		}
	}

	// SOLUTION 4
	private boolean solution4(String inp) {
		if (inp.length() == 0 || inp.length() == 1) {
			return true;
		} else if (inp.charAt(0) != inp.charAt(inp.length() - 1)) {
			return false;
		} else {
			return solution4(inp.substring(1, inp.length() - 1));
		}
	}

}
