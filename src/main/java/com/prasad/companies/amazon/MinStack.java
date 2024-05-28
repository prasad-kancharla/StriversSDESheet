package com.prasad.companies.amazon;

import java.util.Stack;

class MinStack {

    private Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.peek().min, val);
        stack.push(new Pair(val, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().number;
    }

    public int getMin() {
        return stack.peek().min;
    }

}

class Pair {

    int number;
    int min;

    Pair(int number, int min) {
        this.number = number;
        this.min = min;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */