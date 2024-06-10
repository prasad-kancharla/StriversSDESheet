package com.prasad.stackandqueue;

class ImplementStackUsingArraysGFG {

    int top;
    int arr[] = new int[1000];

    ImplementStackUsingArraysGFG() {
        top = -1;
    }

    //Function to push an integer into the stack.
    void push(int a) {
        top++;
        arr[top] = a;
    }

    //Function to remove an item from top of the stack.
    int pop() {
        if (top < 0) {
            return -1;
        }
        int popped = arr[top];
        top--;
        return popped;
    }

}