package com.akash.day68;

public class ReorderList {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		ListNode head = new ListNode(arr[0]);
		ListNode travel = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode temp = new ListNode(arr[i]);
			travel.next = temp;
			travel = travel.next;
		}
		solution1(head);
		printNode(head);

	}

	private static void solution1(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode prev = null;
		ListNode curr = slow;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		ListNode first = head;
		ListNode second = prev;
		while (second.next != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = second.next;

			first.next = second;
			first = temp1;

			second.next = first;
			second = temp2;
		}
	}

	private static void printNode(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}
