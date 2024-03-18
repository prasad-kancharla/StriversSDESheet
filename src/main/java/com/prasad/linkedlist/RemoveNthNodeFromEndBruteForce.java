package com.prasad.linkedlist;

class RemoveNthNodeFromEndBruteForce {

    public static void main(String[] args) {
        ListNode input = new RemoveNthNodeFromEndBruteForce().getInput();
        ListNode output = new RemoveNthNodeFromEndBruteForce().removeNthFromEnd(input, 2);
        System.out.println(output);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (size == 1) {
            return null;
        }

        if (size == n) {
            head = head.next;
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        int k = 0;
        while (k < size - n) {
            prev = curr;
            if (curr != null) {
                curr = curr.next;
            }
            k++;
        }
        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    private ListNode getInput () {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
        return node;
    }

}