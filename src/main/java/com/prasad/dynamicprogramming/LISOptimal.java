package com.prasad.dynamicprogramming;

class LISOptimal {

    static int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return getLIS(nums, 0, -1);
    }

    private int getLIS(int[] nums, int index, int prevIndex) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }
        int ans1 = getLIS(nums, index + 1, prevIndex);
        int ans2 = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            ans2 = 1 + getLIS(nums, index + 1, index);
        }
        dp[index][prevIndex + 1] = Math.max(ans1, ans2);
        return dp[index][prevIndex + 1];
    }

}