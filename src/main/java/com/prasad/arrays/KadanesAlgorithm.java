package com.prasad.arrays;

class KadanesAlgorithm {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int carryForward = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentSum = carryForward + nums[i];
            maxSum = Math.max(currentSum, maxSum);
            carryForward = currentSum;
            if (carryForward < 0) {
                carryForward = 0;
            }
        }

        return maxSum;
    }

}