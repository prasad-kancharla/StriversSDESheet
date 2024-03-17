package com.prasad.linkedlist;

public class MiddleOfLinkedList {

    public static void main(String[] args) {
        Node mid = findMiddle(getInput());
        System.out.println(2);
    }

    public static Node findMiddle(Node head) {
       int size = 0;
       Node node = head;

       while ( node != null) {
           node = node.next;
           size++;
       }

       int k = size/2;
       Node mid = head;
       while (k > 0) {
           mid = mid.next;
           k--;
       }
       return mid;
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