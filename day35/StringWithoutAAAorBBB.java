package com.akash.day35;

public class StringWithoutAAAorBBB {
	public static void main(String[] args) {
		int a = 4;
		int b = 2;
		StringWithoutAAAorBBB p = new StringWithoutAAAorBBB();
		System.out.println(p.solution1(a, b));
		System.out.println(p.solution2(a, b));

	}

	private String solution2(int a, int b) {
		StringBuilder sb = new StringBuilder();
        int maxCount = Math.max(a, b);
        int minCount = Math.min(a, b);
        char maxChar = a >= b ? 'a' : 'b';
        char minChar = a >= b ? 'b' : 'a';

        while (maxCount > 0 || minCount > 0) {
            if (maxCount > 0) {
                sb.append(maxChar);
                maxCount--;
            }
            if (maxCount > 0) {
                sb.append(maxChar);
                maxCount--;
            }
            if (minCount > 0) {
                sb.append(minChar);
                minCount--;
            }
        }
        return sb.toString();
	}

	private String solution1(int a, int b) {
		StringBuilder sb = new StringBuilder();
		while (a > 0 || b > 0) {
			if (a > b) {
				if (a >= 2) {
					sb.append("aa");
					a -= 2;
				} else if (a == 1) {
					sb.append("a");
					a--;
				}
				if (b > 0) {
					sb.append("b");
					b--;
				}
			} else {
				if (b >= 2) {
					sb.append("bb");
					b -= 2;
				} else if (b == 1) {
					sb.append("b");
					b--;
				}
				if (a > 0) {
					sb.append("a");
					a--;
				}
			}
		}
		return sb.toString();
	}

}
