package com.prasad.dynamicprogramming;

public class MaximumIncreasingSum {
    public int maxSumIS(int arr[], int n) {
        return getMaxSum(arr, 0, -1);
    }

    private int getMaxSum(int[] arr, int index, int prevIndex) {
        if (index == arr.length) {
            return 0;
        }
        // not take
        int ans1 = getMaxSum(arr, index + 1, prevIndex);

        // take
        int ans2 = Integer.MIN_VALUE;
        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            ans2 = arr[index] + getMaxSum(arr, index + 1, index);
        }
        return Math.max(ans1, ans2);
    }

}
