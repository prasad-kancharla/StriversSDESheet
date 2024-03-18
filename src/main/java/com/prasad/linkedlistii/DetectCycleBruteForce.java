package com.prasad.linkedlistii;

import java.util.HashSet;

public class DetectCycleBruteForce {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (hashSet.contains(temp)) {
                return true;
            } else {
                hashSet.add(temp);
            }
            temp = temp.next;
        }
        return false;
    }
}