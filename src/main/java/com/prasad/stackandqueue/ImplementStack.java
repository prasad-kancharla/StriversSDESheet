package com.prasad.stackandqueue;

public class ImplementStack {

    static class Stack {

        private int[] arr;
        private int i;
        private int capacity = 0;

        Stack(int capacity) {
            this.arr = new int[capacity];
            this.i = -1;
            this.capacity = capacity;
        }

        public void push(int num) {
            if (isFull() == 0) {
                i++;
                arr[i] = num;
            }
        }

        public int pop() {
            if (i != -1) {
                int peek = arr[i];
                i--;
                return peek;
            }
            return -1;
        }

        public int top() {
            if (i != -1) {
                return arr[i];
            }
            return -1;
        }

        public int isEmpty() {
            return i == -1 ? 1 : 0;
        }

        public int isFull() {
            return i == capacity - 1 ? 1 : 0;
        }

    }

}