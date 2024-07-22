package com.akash.day38;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}

class Linkedlist {
	Node head, tail;

	public void insert(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = tail.next;
		}
	}

	public void solution1() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}

		Node temp1 = head;
		for (int i = 0; i < count / 2; i++) {
			temp1 = temp1.next;
		}
		System.out.print(temp1.data + " ");
	}

	public void solution2() {
		Node temp = head;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		System.out.println(list.get(list.size() / 2));
	}
}

public class MiddleOfLinkedList {
	public static void main(String[] args) {
		Linkedlist l = new Linkedlist();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elemnts in LinkedList");
		int n = sc.nextInt();
		System.out.println("Enter elemnts:");
		for (int i = 0; i < n; i++) {
			l.insert(sc.nextInt());
		}
		l.solution1();
		l.solution2();
	}

}
