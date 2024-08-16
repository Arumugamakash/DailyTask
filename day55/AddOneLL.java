package com.akash.day55;

public class AddOneLL {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 4 };
		Node head = new Node(arr[0]);
		Node travel = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			travel.next = temp;
			travel = travel.next;
		}
		printLL(solution1(head));
	}

	private static Node solution1(Node head) {
		head = reverseList(head);
		Node travel = head;
		Node pre = null;
		int carry = 1;

		while (travel != null) {
			int sum = travel.data + carry;
			carry = sum / 10;
			travel.data = sum % 10;
			pre = travel;
			travel = travel.next;
		}

		if (carry > 0)
			pre.next = new Node(carry);

		head = reverseList(head);

		return head;
	}

	private static Node reverseList(Node head) {
		Node pre = null;
		Node current = head;

		while (current != null) {
			Node next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}

		return pre;
	}

	private static void printLL(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}

class Node {
	Node next;
	int data;

	Node(int data) {
		this.data = data;
	}
}