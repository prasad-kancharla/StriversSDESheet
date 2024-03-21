package com.prasad.linkedlistii;

public class StartingPointOfCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode collisionNode = null;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                collisionNode = slow;
                break;
            }
        }

        if (collisionNode == null) {
            return null;
        }

        ListNode start = head;
        while (start != collisionNode) {
            start = start.next;
            collisionNode = collisionNode.next;
        }
        return start;
    }

}