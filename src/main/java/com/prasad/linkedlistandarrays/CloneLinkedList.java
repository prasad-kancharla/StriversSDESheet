package com.prasad.linkedlistandarrays;

import java.util.HashMap;

class CloneLinkedList {

    public static void main(String[] args) {
        Node out = new CloneLinkedList().copyRandomList(getInput());
        System.out.println(1);
    }

    static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node temp = head;

        while (temp != null) {
            curr.next = new Node(temp.val);
            map.put(temp, curr.next);
            temp = temp.next;
            curr = curr.next;
        }

        temp = head;
        curr = dummy.next;
        while (temp != null) {
            curr.random = map.get(temp.random);
            curr = curr.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    private static Node getInput() {
        Node head = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        second.random = head;
        third.random = fifth;
        fourth.random = third;
        fifth.random = head;
        return head;
    }

}