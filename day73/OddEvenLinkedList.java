package com.akash.day73;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		ListNode head = new ListNode(arr[0]);
		ListNode travel = head;
		for (int i = 1; i < arr.length; i++) {
			travel.next = new ListNode(arr[i]);
			travel = travel.next;
		}
		printNode(solution(head));
	}

	private static ListNode solution(ListNode head) {

		ListNode travel = head;
		ListNode odd = new ListNode(0);
		ListNode oddTravel = odd;

		ListNode even = new ListNode(0);
		ListNode evenTravel = even;
		int oddCount = 0;
		int count = 1;
		while (travel != null) {
			if (count % 2 != 0) {
				oddCount++;
				oddTravel.next = new ListNode(travel.val);
				oddTravel = oddTravel.next;
			} else {
				evenTravel.next = new ListNode(travel.val);
				evenTravel = evenTravel.next;
			}
			count++;
			travel = travel.next;
		}
		ListNode merge = new ListNode(0);
		ListNode mergeTravel = merge;
		while (odd.next != null || even.next != null) {
			if (oddCount != 0) {
				mergeTravel.next = new ListNode(odd.next.val);
				mergeTravel = mergeTravel.next;
				odd = odd.next;
				oddCount--;
			} else {
				mergeTravel.next = new ListNode(even.next.val);
				mergeTravel = mergeTravel.next;
				even = even.next;
			}
		}
		return merge.next;
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
