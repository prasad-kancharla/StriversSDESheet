package com.prasad.stackandqueue2;

import java.util.Arrays;

public class SlidingMaximumBruteForce {

    public static void main(String[] args) {
        int[] input = {3, 2, -6, 1, 0};
        System.out.println(Arrays.toString(maxSlidingWindow(input, 5, 3)));
    }

    public static int[] maxSlidingWindow(int[] arr, int n, int k) {
        int[] maxValues = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            maxValues[j++] = getMaxInWindow(arr, i, i + k - 1);
        }
        return maxValues;
    }

    private static int getMaxInWindow(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

}