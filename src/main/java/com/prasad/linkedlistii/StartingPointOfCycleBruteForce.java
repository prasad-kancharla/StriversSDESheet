package com.prasad.linkedlistii;

import java.util.HashSet;

public class StartingPointOfCycleBruteForce {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (hashSet.contains(temp)) {
                return temp;
            }
            hashSet.add(temp);
            temp = temp.next;
        }
        return null;
    }
}