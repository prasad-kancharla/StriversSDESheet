package com.prasad.arraysiv;

public class CountSubArraysWithXorKBetter {

    public static void main(String[] args) {
        int[] input = {1, 3, 3, 3, 5};
        System.out.println(subarraysWithSumK(input, 6));
    }

    static int[][] dp;

    public static int subarraysWithSumK(int[] a, int b) {
        int n = a.length;
        dp = new int[n][n];

        int k = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = a[k++];
                    if (dp[i][j] == b) {
                        count++;
                    }
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] ^ a[j];
                if (dp[i][j] == b) {
                    count++;
                }
            }
        }

        return count;
    }

}