package com.akash.day35;

public class LexicographicallySmallestString {
	public static void main(String[] args) {
		String s = "45320";
		LexicographicallySmallestString p = new LexicographicallySmallestString();
		System.out.println(p.solution3(s));
		System.out.println(p.solution2(s));
	}

	private String solution2(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (; i < s.length() - 1; i++) {
			if (s.charAt(i) % 2 == 0 && s.charAt(i + 1) % 2 == 0 || s.charAt(i) % 2 == 1 && s.charAt(i + 1) % 2 == 1) {
				if (s.charAt(i) > s.charAt(i + 1)) {
					sb.append(s.charAt(i + 1));
					sb.append(s.charAt(i));
					i = i + 2;
					break;
				}
			}
			sb.append(s.charAt(i));
		}
		sb.append(s.substring(i));
		return sb.toString();
	}

	private String solution3(String s) {
		char ch[] = s.toCharArray();
		int i = 0;
		while (i < ch.length - 1) {
			char cur = ch[i];
			char next = ch[i + 1];
			boolean b1 = cur % 2 == 0;
			boolean b2 = next % 2 == 0;
			if (b1 == b2) {
				if (cur > next) {
					ch[i] = next;
					ch[i + 1] = cur;
					break;
				}
			}
			i++;
		}
		return new String(ch);
	}

}
