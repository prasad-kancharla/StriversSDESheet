package com.prasad.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/description/
class ImplementStackUsing2Queues {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public ImplementStackUsing2Queues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.offer(x);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}