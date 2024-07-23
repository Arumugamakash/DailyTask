package com.akash.day39;

public class DeleteNode {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 1, 7 };
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp1 = new Node(arr[i]);
			temp.next = temp1;
			temp = temp.next;
		}
		Node ans1 = deleteNode1(head);
		printNode(ans1);
		Node ans2 = deleteNode2(head);
		printNode(ans2);
		int pos = 3;
		Node ans3 = deleteNode3(head, pos);
		printNode(ans3);
	}

	private static Node deleteNode3(Node head, int pos) {
		Node temp = head;
		Node temp1 = new Node(pos);
		while (temp != null) {
			if (temp.next.data == temp1.data) {
				temp.next = temp.next.next;
				return head;
			}
			temp = temp.next;
		}
		return head;
	}

	private static Node deleteNode2(Node head) {
		Node temp = head;
		Node result = new Node(0);
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}

	private static Node deleteNode1(Node head) {
		// delete head of the LL
		Node temp = head;
		if (temp.next == null || temp == null) {
			return null;
		}
		return head.next;
	}

	private static void printNode(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}
