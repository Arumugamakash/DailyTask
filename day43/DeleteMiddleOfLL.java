package com.akash.day43;

import java.util.ArrayList;
import java.util.List;

public class DeleteMiddleOfLL {
	public static void main(String[] args) {
		int arr[] = { 1, 24, 45, 45, 53 };
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp1 = new Node(arr[i]);
			temp.next = temp1;
			temp = temp.next;
		}

		printNode(solution1(head));
		System.out.println();
		printNode(solution2(head));
		// printNode(head);
	}

	private static Node solution1(Node head) {
		int count = 0;
		Node temp = head;
		if (temp == null || temp.next == null) {
			return null;
		}
		if (temp.next.next == null) {
			temp.next = null;
			return head;
		}
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		temp = head;
		int i = 0;
		while (temp.next != null) {
			if ((i + 1) == (count / 2)) {
				temp.next = temp.next.next;
			}
			i++;// 1 2
			temp = temp.next;// 3 4
		}
		return head;
	}

	private static Node solution2(Node head) {
		List<Integer> list = new ArrayList<Integer>();
		Node temp = head;
		while (temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		list.remove(list.size() / 2);
		Node res = new Node(list.get(0));
		Node traverse = res;
		for (int i = 1; i < list.size(); i++) {
			Node temp1 = new Node(list.get(i));
			traverse.next = temp1;
			traverse = traverse.next;
		}
		return res;
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

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
