package com.akash.day46;

import java.util.Stack;

public class PalindromeLL {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3,3, 2, 1 };
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = temp.next;
		}
		// System.out.println(solution1(head) == true ? "Given Node is Palindrome" :
		// "Given Node is Not a palindrome");
		System.out.println(solution2(head) == true ? "Given Node is Palindrome" : "Given Node is Not a palindrome");
		print(head);
	}

	private static boolean solution2(Node head) {
		return findMiddleLL(head);
	}

	private static boolean findMiddleLL(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			System.out.println("times");
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("hi " + slow.data);
		Node reverse = reverse(slow.next);
		return combareNodes(head, reverse);
	}

	private static boolean combareNodes(Node head, Node reverse) {
		Node first = head;
		Node second = reverse;
		while (second != null) {
			if (first.data != second.data) {
				return false;
			}
			first = first.next;
			second = second.next;
		}
		return true;
	}

	private static Node reverse(Node newNode) {
		Stack<Integer> stack = new Stack<Integer>();
		// Node temp = newNode;
		Node reverse = new Node(0);
		Node temp = reverse;
		while (newNode != null) {
			stack.push(newNode.data);
			newNode = newNode.next;
		}
		System.out.println(stack);
		while (!stack.isEmpty()) {
			System.out.println("ula varan");
			Node rev = new Node(stack.pop());
			temp.next = rev;
			temp = temp.next;
		}
		return reverse.next;
	}

	private static boolean solution1(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node temp = head;
		while (temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			if (temp.data != stack.pop()) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}

	private static void print(Node head) {
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
