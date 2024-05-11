package com.prasad.companies.apple;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        Node out = uniqueSortedList(head);
        System.out.println(out);
    }

    public static Node uniqueSortedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.data == prev.data) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    ;
}