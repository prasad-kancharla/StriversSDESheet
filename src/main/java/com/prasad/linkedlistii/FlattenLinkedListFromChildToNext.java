package com.prasad.linkedlistii;

public class FlattenLinkedListFromChildToNext {

    public static void main(String[] args) {
        Node node = new FlattenLinkedListFromChildToNext().getTestInput();
        Node output = flattenLinkedList(node);
        System.out.println(2);
    }

    public static Node flattenLinkedList(Node head) {
        Node temp = head;
        // store next in next node
        // For each child convert bottoms to next
        // connect last node of temp list to next node

        while (temp != null) {
            Node nextNode = temp.next;
            Node endOfFlattenedListComponent = flattenOneLinkedListComponent(temp);
            endOfFlattenedListComponent.next = nextNode;
            temp = nextNode;
        }
        return head;
    }

    private static Node flattenOneLinkedListComponent(Node head) {
        Node temp = head;
        while (temp.child != null) {
            Node child = temp.child;
            temp.child = null;
            temp.next = child;
            temp = temp.next;
        }
        return temp;
    }

    class Node {

        public int data;
        public Node next;
        public Node child;

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

    private Node getTestInput() {
        Node node = new Node(1);
        node.child = new Node(2);
        node.child.child = new Node(3);

        Node second = new Node(8);
        second.child = new Node(10);
        second.child.child = new Node(15);

        node.next = second;

        Node third = new Node(18);
        third.child = new Node(22);

        second.next = third;

        Node fourth = new Node(29);
        third.next = fourth;
        //        fourth.child = new Node(12);
        //
        //        third.next =fourth;
        //        fourth.next = new Node(20);
        return node;
    }

}