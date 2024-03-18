package com.prasad.linkedlistii;

import java.util.HashSet;

public class IntersectionOf2LinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while (temp1 != null) {
            hashSet.add(temp1);
            temp1 =temp1.next;
        }

        while (temp2 != null) {
            if (hashSet.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }

        return null;
    }
}