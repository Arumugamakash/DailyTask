package com.akash.day28;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AlternatingGroupsI {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 0, 1 };
		AlternatingGroupsI p = new AlternatingGroupsI();
		p.solution1(arr);
		p.solution2(arr);
		p.solution3(arr);
	}

	// solution 1
	private void solution1(int[] colors) {
		int count = 0;
		int a, b, c;
		for (int i = 0; i < colors.length; i++) {

			if (i == colors.length - 2) {
				a = colors[i];
				b = colors[i + 1];
				c = colors[0];
				if (a != b && b != c) {
					count++;
				}
			} else if (i == colors.length - 1) {
				a = colors[i];
				b = colors[0];
				c = colors[1];
				if (a != b && b != c) {
					count++;
				}
			} else {
				if (colors[i] != colors[i + 1] && colors[i + 1] != colors[i + 2]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	// solution 2
	private void solution2(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[(i + 2) % (arr.length)] && arr[i] != arr[(i + 1) % (arr.length)]) {
				count++;
			}
		}
		System.out.println(count);
	}

	// solution 3
	private void solution3(int[] colors) {
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i : colors) {
			list.add(i);
		}
		ListIterator<Integer> it = list.listIterator();
		int k = 0;
		while (it.hasNext()) {
			it.next();
			if (k < list.size() - 2) {
				if (it.previous() == it.next() && list.get(k) != it.previous()) {
					count++;
				}

			}
			if (k < list.size() - 1) {
				if (list.get(k) == list.get(0) && list.get(k) != list.get(k + 1)) {
					count++;
				}
			}
			k++;
		}
		System.out.println(count);
	}

}
