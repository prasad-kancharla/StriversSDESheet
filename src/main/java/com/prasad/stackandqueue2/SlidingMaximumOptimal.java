package com.prasad.stackandqueue2;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingMaximumOptimal {

    public static int[] maxSlidingWindow(int[] arr, int n, int k) {
        int[] maxValues = new int[n - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int startOfSlidingWindow = i - k + 1;
            if (!deque.isEmpty() && deque.peekFirst() < startOfSlidingWindow) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                maxValues[index++] = arr[deque.peekFirst()];
            }
        }

        return maxValues;
    }

}