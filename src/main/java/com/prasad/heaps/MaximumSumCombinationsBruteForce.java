package com.prasad.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSumCombinationsBruteForce {

    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        int m = B.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                priorityQueue.offer(A[i] + B[j]);
            }
        }

        int[] ans = new int[C];
        for (int i = 0; i < C; i++) {
            if (!priorityQueue.isEmpty()) {
                ans[i] = priorityQueue.poll();
            }
        }
        return ans;
    }

}
