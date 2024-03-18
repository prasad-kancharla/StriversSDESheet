package com.prasad.linkedlistii;

import java.util.ArrayList;
import java.util.List;

class ReverseNodesInKGroupBruteForce {

    public static void main(String[] args) {
        ListNode output = new ReverseNodesInKGroupBruteForce().reverseKGroup(getInput(), 3);
        System.out.println(2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }


        int i = 0;
        int n = list.size();
        while (i < n) {
           int start = i;
           int end = start + k - 1;
           if (end < n) {
               reverse(list, start, end);
               i += k;
           } else {
               break;
           }

        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int j = 0; j < n; j++) {
            curr.next = new ListNode(list.get(j));
            curr = curr.next;
        }

        return dummy.next;
    }

    private void reverse(List<Integer> list, int start, int end) {
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    private static ListNode getInput() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

}