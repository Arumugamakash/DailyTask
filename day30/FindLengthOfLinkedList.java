package com.akash.day30;

import java.util.LinkedList;

public class FindLengthOfLinkedList {
	public static void main(String[] args) {
//		Node head = new Node(1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(5);
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		Node head = new Node(0);
		Node temp = head;
		for (Integer val : list) {
			temp.next = new Node(val);
			temp = temp.next;
		}

		FindLengthOfLinkedList p = new FindLengthOfLinkedList();
		System.out.println(p.solution1(head.next));
		System.out.println(p.solution2(head.next, 1));
	}

	// solution 1
	private int solution1(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			System.out.println("varan");
			temp = temp.next;
		}
		System.out.println(count);
		return count;
	}

	// solution 2
	private int solution2(Node head, int count) {
		if (head == null) {
			return 0;
		}
		return count + solution2(head.next, count);
	}

}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}