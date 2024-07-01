package com.prasad.companies.google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class CustomStack {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.pop();
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
    }

    private int maxSize;

    private Deque<Integer> deque;

    public CustomStack(int maxSize) {
        deque = new ArrayDeque<>(maxSize);
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (deque.size() < maxSize) {
            deque.offerLast(x);
        }
    }

    public int pop() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.removeLast();
    }

    public void increment(int k, int val) {
        Stack<Integer> stack = new Stack<>();
        int  i = 0;
        while (!deque.isEmpty() && i < k ) {
            int element = deque.removeFirst();
            element += val;
            stack.push(element);
            i++;
        }
        while (!stack.isEmpty()) {
            deque.offerFirst(stack.pop());
        }
    }

}
