package com.akash.day34;

class Node {
	Node next;
	int val;

	Node(int val) {
		this.val = val;
	}
}

class LinkedListClass {
	Node head, tail;

	public void insert(int data) {
		Node n = new Node(data);

		if (head == null) {
			tail = n;
			head = n;
		}

		tail.next = n;
		tail = n;
	}

	public void DeleteNode(int data) {
		Node temp = head;
		Node prev = null;

		if (head.val == data)
			head = head.next;
		while (temp != null) {

			if (temp.val == data)
				prev.next = temp.next;

			prev = temp;
			temp = temp.next;
		}
	}

	public void printLL() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class DeleteNode {
	public static void main(String[] args) {
		LinkedListClass list = new LinkedListClass();

		// Adding nodes to the linked list
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println("Original List:");
		list.printLL();

		list.DeleteNode(3);

		System.out.println("List after deleting node 3:");
		list.printLL();
	}
}
