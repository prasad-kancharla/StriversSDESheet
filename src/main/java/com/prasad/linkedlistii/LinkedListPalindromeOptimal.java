package com.prasad.linkedlistii;

class LinkedListPalindromeOptimal {

    public static void main(String[] args) {
        ListNode input = getInput();
        System.out.println(new LinkedListPalindromeOptimal().isPalindrome(null));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode secondHalfFirstNode = mid.next;
        mid.next = null;
        ListNode reversedHead = reverseList(secondHalfFirstNode);

        ListNode first = head;
        ListNode second = reversedHead;

        while (second != null) {
            if (first.val == second.val) {
                first = first.next;
                second = second.next;
            } else {
                reverseList(reversedHead);
                mid.next = secondHalfFirstNode;
                return false;
            }
        }
        reverseList(reversedHead);
        mid.next = secondHalfFirstNode;
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    private static ListNode getInput() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(1);
        return head;
    }

}