package com.prasad.linkedlist;

class Merge2SortedLinkedListsOptimal {

    public static void main(String[] args) {
        ListNode list1 = new Merge2SortedLinkedListsOptimal().getList1();
        ListNode list2 = new Merge2SortedLinkedListsOptimal().getList2();
        ListNode sorted = new Merge2SortedLinkedListsOptimal().mergeTwoLists(list1, list2);
        System.out.println(2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    private ListNode getList1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        return head;
    }

    private ListNode getList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        return head;
    }

}