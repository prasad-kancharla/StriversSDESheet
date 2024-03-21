package com.prasad.linkedlistii;

class GfGFlattenLinkedList {

    Node flatten(Node root) {
        Node temp = root;
        Node start = root;

        while (start != null && start.bottom != null) {
            start = start.bottom;
        }

        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = null;
            start.bottom = nextNode;
            temp = nextNode;

            while (start != null && start.bottom != null) {
                start = start.bottom;
            }
        }
        return root;
    }



    class Node {

        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }

    }

}