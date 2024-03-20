package com.prasad.linkedlistii;

import java.util.ArrayList;
import java.util.List;

class LinkedListPalindromeBruteForce {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,3,2,1);
        System.out.println(new LinkedListPalindromeBruteForce().isPalindrome(integers));
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> integers = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            integers.add(temp.val);
            temp = temp.next;
        }

        return isPalindrome(integers);
    }

    private boolean isPalindrome(List<Integer> integers) {
        int i = 0;
        int j = integers.size() - 1;

        while (i < j) {
            if (integers.get(i) == integers.get(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    // 1 fast slow
    // 1 2 1
    // 1 2 2 1

}