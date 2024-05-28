package com.prasad.companies.amazon;

import java.util.EmptyStackException;
import java.util.Stack;

class MinStackOptimal {

    private Stack<Long> stack;
    Long min;

    public MinStackOptimal() {
        stack = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if (stack.isEmpty()) {
            stack.push(value);
            min = value;
        } else {
            if (val > min) {
                stack.push(value);
            } else {
                stack.push(2 * value - min);
                min = value;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
            // or throw any runtime exception with a message
        }
        Long value = stack.pop();
        if (value < min) {
            min = 2 * min - value;
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new UnsupportedOperationException("Cannot get top when stack is empty");
        }
        if (stack.peek() < min) {
            return min.intValue();
        } else {
            return stack.peek().intValue();
        }

    }

    public int getMin() {
        return min.intValue();
    }

}