package com.prasad.companies.amazon;

public class MaxSubArraySum {

    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = 0;
        if (n == 0) {
            return 0;
        }
        long cf = 0;

        for (int i = 0; i < n; i++) {
            long sum = cf + arr[i];
            maxSum = Math.max(maxSum, sum);
            cf = sum > 0 ? sum : 0;
        }

        return maxSum;
    }

}
