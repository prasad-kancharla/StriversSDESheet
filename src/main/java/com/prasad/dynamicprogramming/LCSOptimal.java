package com.prasad.dynamicprogramming;

class LCSOptimal {

    static int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return getLCS(text1, text2, n - 1, m - 1);
    }

    private int getLCS(String text1, String text2, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            dp[index1][index2] = 1 + getLCS(text1, text2, index1 - 1, index2 - 1);
        } else {
            dp[index1][index2] = Math.max(getLCS(text1, text2, index1 - 1, index2), getLCS(text1, text2, index1, index2 - 1));
        }
        return dp[index1][index2];
    }

}