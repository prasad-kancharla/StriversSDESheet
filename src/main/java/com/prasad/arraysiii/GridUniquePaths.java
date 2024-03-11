package com.prasad.arraysiii;

class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println(new GridUniquePaths().uniquePaths(3,7));
    }

    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        return getCountOfUniquePaths(m - 1, n - 1);
    }

    private int getCountOfUniquePaths(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = getCountOfUniquePaths(i, j - 1) + getCountOfUniquePaths(i - 1, j);
        return dp[i][j];
    }

}