package com.akash.day47;

import java.util.Stack;

public class ConvertBinaryNumberinLinkedListtoInteger {
	public static void main(String[] args) {
		int arr[] = { 1, 0, 1, 1 };
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = temp.next;
		}
		System.out.println(solution1(head));
		System.out.println(solution2(head));
		printNode(head);
	}

	private static int solution2(Node head) {
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			sb.append(temp.data);
			temp = temp.next;
		}
		sb = sb.reverse();
		int pow = 1;
		int res = 0;
		for (int i = 0; i < sb.length(); i++) {
			res += (sb.charAt(i) - '0') * pow;
			pow *= 2;// 2 4
		}

		System.out.println("res " + res);
		return res;

	}

	private static int solution1(Node head) {
		Node temp = head;
		Stack<Integer> rev = new Stack<Integer>();
		while (temp != null) {
			rev.push(temp.data);
			temp = temp.next;
		}
		int ans = 0;
		int i = 0;
		while (rev.size() != 0) {
			ans += (((int) rev.pop()) * (Math.pow(2, i++)));
		}
		return ans;
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
