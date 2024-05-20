package com.prasad.dynamicprogramming;

class EditDistanceOptimal {

    static int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return getMinOperations(word1, word2, n - 1, m - 1);
    }

    private int getMinOperations(String word1, String word2, int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = getMinOperations(word1, word2, i - 1, j - 1);
        } else {
            int ans1 = getMinOperations(word1, word2, i, j -1);
            int ans2 = getMinOperations(word1, word2, i - 1, j);
            int ans3 = getMinOperations(word1, word2, i - 1, j - 1);
            dp[i][j] = 1 + Math.min (ans1, Math.min(ans2, ans3));
        }

        return dp[i][j];
    }

}