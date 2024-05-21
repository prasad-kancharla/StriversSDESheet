package com.prasad.dynamicprogramming2;

import java.util.Arrays;

class CoinChange {

    static int[][] dp;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int result = getCoins(coins, n - 1, amount);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private int getCoins(int[] coins, int i, int amount) {
        if (i < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int ans1 = Integer.MAX_VALUE;
        // pick coin
        if (amount >= coins[i]) {
            int subResult = getCoins(coins, i, amount - coins[i]);
            if (subResult != Integer.MAX_VALUE) {
                ans1 = 1 + subResult;
            }
        }
        // didn't pick coin
        int ans2 = getCoins(coins, i - 1, amount);
        dp[i][amount] = Math.min(ans1, ans2);
        return dp[i][amount];
    }

}