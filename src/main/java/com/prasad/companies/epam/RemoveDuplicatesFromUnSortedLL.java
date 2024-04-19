package com.prasad.companies.epam;

import java.util.HashSet;

public class RemoveDuplicatesFromUnSortedLL {

    public static void main(String[] args) {
        //		LinkedListNode<Integer> head = new LinkedListNode<>(2);
        //		head.next = new LinkedListNode<>(2);
        //		head.next.next = new LinkedListNode<>(3);
        //		head.next.next.next = new LinkedListNode<>(2);
        LinkedListNode<Integer> head = new LinkedListNode<>(3);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(2);
        head.next.next.next.next.next = new LinkedListNode<>(3);

        LinkedListNode<Integer> out = removeDuplicates(head);
        System.out.println(out);
    }

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        dummy.next = head;
        LinkedListNode<Integer> prev = dummy;
        LinkedListNode<Integer> curr = head;

        while (curr != null) {
            if (hashSet.contains(curr.data)) {
                LinkedListNode<Integer> nextNode = curr.next;
                // optional curr.next = null;
                prev.next = nextNode;
                curr = nextNode;
            } else {
                hashSet.add(curr.data);
                prev = curr;
                curr = curr.next;
            }

        }
        return dummy.next;
    }

}