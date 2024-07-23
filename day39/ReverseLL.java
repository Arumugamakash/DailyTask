package com.akash.day39;

import java.util.Stack;

public class ReverseLL {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 1, 7 };
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp1 = new Node(arr[i]);
			temp.next = temp1;
			temp = temp.next;
		}
		printNode(head);
		Node ans1 = solution1(head);
		printNode(ans1);
		Node ans2 = solution2(head);
		printNode(ans2);
	}

	private static void printNode(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node solution1(Node head) {
		Node temp = head;
		Stack rev = new Stack();
		Node reverse = new Node(0);
		Node reverseTemp = reverse;
		while (temp != null) {
			rev.push(temp.data);
			temp = temp.next;
		}
		while (head != null) {
			Node add = new Node((int) rev.pop());
			reverseTemp.next = add;
			head = head.next;
			reverseTemp = reverseTemp.next;
		}
		return reverse.next;
	}

	private static Node solution2(Node head) {
		Node previous = null;
		Node current = head;

		while (current != null) {
			Node temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}

		return head = previous;
	}
}
