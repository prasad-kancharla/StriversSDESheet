package com.prasad.linkedlistandarrays;

class RotateLinkedList {

    public static void main(String[] args) {
        ListNode input = getInput();
        ListNode output = new RotateLinkedList().rotateRight(input, 2);
        System.out.println(2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = getSize(head);
        if (k >= size) k = k % size;
        if (k == 0) {
            return head;
        }

        ListNode curr = head;
        int n = size - k;
        int i = 1;
        while (i < n && curr != null) {
            curr = curr.next;
            i++;
        }
        ListNode secondHalfFirstNode = head;
        ListNode kthNode = curr.next;
        curr.next = null;
        head = kthNode;
        while (kthNode != null && kthNode.next != null) {
            kthNode = kthNode.next;
        }
        kthNode.next = secondHalfFirstNode;
        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    private static ListNode getInput() {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i < 6; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head;
    }

}