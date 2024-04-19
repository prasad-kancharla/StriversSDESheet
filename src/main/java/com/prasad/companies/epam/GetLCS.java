package com.prasad.companies.epam;

public class GetLCS {

    public static void main(String[] args) {
        System.out.println(lcs("abcdb", "bcacdhb"));
    }

    static int[][] dp;

    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return getLcs(s, t, n - 1, m - 1);
    }

    private static int getLcs(String s, String t, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + getLcs(s, t, i - 1, j - 1);
        } else {
            ans = Math.max(getLcs(s, t, i, j - 1), getLcs(s, t, i - 1, j));
        }

        dp[i][j] = ans;
        return dp[i][j];
    }

}