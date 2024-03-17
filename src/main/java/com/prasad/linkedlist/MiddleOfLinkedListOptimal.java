package com.prasad.linkedlist;

public class MiddleOfLinkedListOptimal {

    public static void main(String[] args) {
        Node mid = findMiddle(getInput());
        System.out.println(2);
    }
    public static Node findMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node getInput() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        return node;
    }
}