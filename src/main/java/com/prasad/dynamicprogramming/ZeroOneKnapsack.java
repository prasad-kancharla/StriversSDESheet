package com.prasad.dynamicprogramming;

import java.util.ArrayList;

public class ZeroOneKnapsack {

    static int[][] dp;

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return getMaxProfit(values, weights, 0, w);
    }

    private static int getMaxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int i, int w) {
        if (i == values.size() || w == 0) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int ans1 = getMaxProfit(values, weights, i + 1, w);
        int ans2 = 0;
        if (weights.get(i) <= w) {
            ans2 = values.get(i) + getMaxProfit(values, weights, i + 1, w - weights.get(i));
        }
        dp[i][w] = Math.max(ans1, ans2);
        return dp[i][w];
    }

}