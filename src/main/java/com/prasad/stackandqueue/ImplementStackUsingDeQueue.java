package com.prasad.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-stack-using-queues/description/
class ImplementStackUsingDeQueue {

    Deque<Integer> deque;
    public ImplementStackUsingDeQueue() {
        deque = new ArrayDeque<>();
    }
    
    public void push(int x) {
        deque.offer(x);
    }
    
    public int pop() {
        return deque.pollLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */