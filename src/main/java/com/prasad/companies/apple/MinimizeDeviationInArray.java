package com.prasad.companies.apple;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MinimizeDeviationInArray {

    public static void main(String[] args) {
        int[] input = {2, 10, 8};
        System.out.println(new MinimizeDeviationInArray().minimumDeviation(input));
    }

    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        int minValue = Integer.MAX_VALUE;
        int minDeviation = Integer.MAX_VALUE;
        Comparator<Integer> comparator = (i1, i2) -> i2 - i1;
        Queue<Integer> maxHeap = new PriorityQueue<>(comparator);
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] = nums[i] * 2;
            }
            minValue = Math.min(nums[i], minValue);
            maxHeap.offer(nums[i]);
        }

        while (!maxHeap.isEmpty() && maxHeap.peek() % 2 == 0) {
            int maxValue = maxHeap.poll();
            minDeviation = Math.min(maxValue - minValue, minDeviation);
            minValue = Math.min(maxValue / 2, minValue);
            maxHeap.offer(maxValue / 2);
        }

        if (!maxHeap.isEmpty()) {
            minDeviation = Math.min(minDeviation, maxHeap.poll() - minValue);
        }

        return minDeviation;
    }

}