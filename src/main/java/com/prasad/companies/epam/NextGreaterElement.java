package com.prasad.companies.epam;

import java.util.HashMap;
import java.util.Stack;

class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        Stack<Integer> stack = new Stack();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                hashMap.put(nums2[i], -1);
            } else {
                hashMap.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        int m = nums1.length;
        int[] greaterElements = new int[m];
        for (int i = 0; i < m; i++) {
            greaterElements[i] = hashMap.get(nums1[i]);
        }
        return greaterElements;
    }

}