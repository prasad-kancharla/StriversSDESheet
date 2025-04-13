package com.prasad.dynamicprogramming;

class PerfectSquares {
    private int[] dp;

    public int numSquares(int n) {
        dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }

        return getNumSquares(n);
    }

    private int getNumSquares(int i) {
        if (i == 0) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Integer.MAX_VALUE;

        for (int j = 1; j <= Math.sqrt(i); j++) {
            dp[i] = Math.min(dp[i], 1 + getNumSquares(i - (j * j)));
        }

        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
}