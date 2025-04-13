package com.prasad.dynamicprogramming;

class ClimbingStairs {
    private int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }

        return getStairs(n);
    }

    private int getStairs(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = getStairs(i - 1) + getStairs(i - 2);
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
    }
}