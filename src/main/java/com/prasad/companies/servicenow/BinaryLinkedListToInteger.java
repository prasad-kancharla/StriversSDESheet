package com.prasad.companies.servicenow;

public class BinaryLinkedListToInteger {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("",2));
    }
    public static int binaryToInteger(int n, Node head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) return 0;
        while (head != null) {
            sb.append(head.data);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}