package com.prasad.linkedlist;

class RemoveNthNodeFromEndOptimal {

    public static void main(String[] args) {
        ListNode input = new RemoveNthNodeFromEndOptimal().getInput();
        ListNode output = new RemoveNthNodeFromEndOptimal().removeNthFromEnd(input, 2);
        System.out.println(2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            if (fast != null) fast = fast.next;
        }

        // the below condition becomes true when n = size of linkedlist
        // we have to remove first element
        if (fast == null) {
            head = head.next;
            return head;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) slow.next = slow.next.next;
        return head;
    }

    private ListNode getInput () {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        return node;
    }
}