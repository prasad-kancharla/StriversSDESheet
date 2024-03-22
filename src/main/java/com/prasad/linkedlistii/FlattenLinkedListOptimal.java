package com.prasad.linkedlistii;

public class FlattenLinkedListOptimal {

    public static void main(String[] args) {
        Node node = new FlattenLinkedListOptimal().getTestInput2();
        Node output = flattenLinkedList(node);
        System.out.println(2);
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node firstHead = head;
        Node secondHead = mid.next;
        mid.next = null;

        firstHead = flattenLinkedList(firstHead);
        secondHead = flattenLinkedList(secondHead);
        return merge(firstHead, secondHead);
    }

    private static Node merge(Node firstHead, Node secondHead) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (firstHead != null && secondHead != null) {
            if (firstHead.data <= secondHead.data) {
                curr.child = firstHead;
                firstHead = firstHead.child;
            } else {
                curr.child = secondHead;
                secondHead = secondHead.child;
            }
            curr = curr.child;
        }

        if (firstHead != null) {
            curr.child = firstHead;
        }

        if (secondHead != null) {
            curr.child = secondHead;
        }
        return dummy.child;
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node getTestInput() {
        Node node = new Node(4);
        node.child = new Node(6);
        //        node.child.child = new Node(3);

        Node second = new Node(5);
        second.child = new Node(71);
        //        second.child.child = new Node(15);

        node.next = second;

        Node third = new Node(7);
        third.child = new Node(8);
        third.child.child = new Node(9);

        second.next = third;

        Node fourth = new Node(11);
        fourth.child = new Node(12);
        fourth.child.child = new Node(19);
        third.next = fourth;

        Node fifth = new Node(14);
        fifth.child = new Node(15);
        fifth.child.child = new Node(17);
        fourth.next = fifth;
        return node;
    }

    private Node getTestInput2() {
        Node node = new Node(12);
        node.child = new Node(19);
        node.child.child = new Node(20);
        node.child.child.child = new Node(29);

        Node second = new Node(7);
        second.child = new Node(26);
        second.child.child = new Node(31);
        second.child.child.child = new Node(33);

        node.next = second;

        Node third = new Node(15);

        second.next = third;

        Node fourth = new Node(9);
        fourth.child = new Node(16);
        fourth.child.child = new Node(18);

        third.next = fourth;

        Node fifth = new Node(5);
        fifth.child = new Node(8);
        fifth.child.child = new Node(21);
        fifth.child.child.child = new Node(42);

        fourth.next = fifth;

        Node sixth = new Node(50);

        fifth.next = sixth;

        Node seventh = new Node(13);
        seventh.child = new Node(17);
        seventh.child.child = new Node(23);
        seventh.child.child.child = new Node(37);

        sixth.next = seventh;

        return node;
    }

    static class Node {

        public int data;
        Node next;
        Node child;

        Node() {
            this.data = 0;
            this.next = null;
            this.child = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }

    }

}