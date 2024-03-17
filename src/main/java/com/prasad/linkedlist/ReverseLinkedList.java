package com.prasad.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {

        System.out.println(reverseLinkedList(getInput()));
        System.out.println(2);
    }

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;

        while (curr != null) {
            LinkedListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static LinkedListNode<Integer> getInput() {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        return head;
    }
}