package com.prasad.linkedlist;

public class Merge2SortedLinkedLists {

	public static void main(String[] args) {
		LinkedListNode<Integer> sortedHead = sortTwoLists(getList1(), getList2());
		System.out.println(sortedHead);
	}
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		LinkedListNode<Integer> curr1 = first;
		LinkedListNode<Integer> curr2 = second;

		LinkedListNode<Integer> sortedHead;
		if (curr1 != null && curr2 != null && curr1.data <= curr2.data) {
			sortedHead = new LinkedListNode<>(curr1.data);
			curr1 = curr1.next;
		} else {
			sortedHead = new LinkedListNode<>(curr2.data);
			curr2 = curr2.next;
		}

		LinkedListNode<Integer> curr = sortedHead;
		while (curr1 != null && curr2 != null) {
			if (curr1.data <= curr2.data) {
				curr.next = new LinkedListNode<>(curr1.data);
				curr1 = curr1.next;
			} else {
				curr.next = new LinkedListNode<>(curr2.data);
				curr2 = curr2.next;
			}
			curr = curr.next;
		}

		while (curr1 != null) {
			curr.next = curr1;
			curr1 = curr1.next;
			curr = curr.next;
		}

		while (curr2 != null) {
			curr.next = curr2;
			curr2 = curr2.next;
			curr = curr.next;
		}

		return sortedHead;
	}

	private static LinkedListNode<Integer> getList1() {
		LinkedListNode<Integer> head = new LinkedListNode<>(4);
		head.next = new LinkedListNode<>(8);
		return head;
	}

	private static LinkedListNode<Integer> getList2() {
		LinkedListNode<Integer> head = new LinkedListNode<>(1);
		head.next = new LinkedListNode<>(3);
		head.next.next = new LinkedListNode<>(5);
		head.next.next.next = new LinkedListNode<>(6);
		return head;
	}
}