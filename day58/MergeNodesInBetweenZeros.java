package com.akash.day58;

public class MergeNodesInBetweenZeros {
	public static void main(String[] args) {
		int arr[] = { 0, 3, 1, 0, 4, 5, 2, 0 };
		Node head = new Node(arr[0]);
		Node travel = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			travel.next = temp;
			travel = travel.next;
		}
		solution(head);
		//printNode(head);
	}

	private static void solution(Node head) {
		Node newNode = new Node(0);
		Node newNodetravel = newNode;
		Node travel = head;
		int sum = 0;
		while (travel!= null) {
			sum += travel.val;
			if (travel.val == 0) {
				if (sum != 0) {
					newNodetravel.next = new Node(sum);
					newNodetravel = newNodetravel.next;
				}
				sum=0;
			}
			travel = travel.next;
		}
		printNode(newNode.next);
	}

	private static void printNode(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

}

class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
	}
}