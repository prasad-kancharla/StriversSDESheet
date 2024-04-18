package com.prasad.companies.epam;

public class ZeroOneKnapsack {

    static int[][] dp;

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        dp = new int[n][maxWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return getMaxValue(weight, value, 0, maxWeight);
    }

    private static int getMaxValue(int[] weight, int[] value, int i, int maxWeight) {
        if (maxWeight == 0 || i == weight.length) {
            return 0;
        }

        if (dp[i][maxWeight] != -1) {
            return dp[i][maxWeight];
        }

        int value1 = weight[i] <= maxWeight ? value[i] + getMaxValue(weight, value, i + 1, maxWeight - weight[i]) : 0;
        int value2 = getMaxValue(weight, value, i + 1, maxWeight);

        dp[i][maxWeight] = Math.max(value1, value2);
        return dp[i][maxWeight];
    }

}