package com.prasad.stackandqueue;

import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr, int n) {
        int[] greaterElements = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                greaterElements[i] = -1;
            } else {
                greaterElements[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return greaterElements;
    }
}