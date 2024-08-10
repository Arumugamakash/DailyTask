package com.akash.day50;

import java.util.Iterator;

public class RotateList {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int k = 2;
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = temp.next;
		}
		Node ans = solution1(head, k);
		printNode(ans);
	}

	private static Node solution1(Node head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		int length = 1;
		Node temp = head;// 12345
		while (temp.next != null) {
			temp = temp.next;
			length++;
		}
		System.out.println(temp.data);
		temp.next = head;
		while (k > 0) {
			temp = temp.next;
			k--;
		}

		head = temp.next;
		temp.next = null;

		return head;
	}

	private static void printNode(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}

class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(int data) {
		this.data = data;
	}
}