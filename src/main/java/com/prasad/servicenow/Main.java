package com.prasad.servicenow;

public class Main {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcbc";
        System.out.println(getSubsequenceCount(s1, s2)); // Output: 4
    }

    public static long getSubsequenceCount(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D array to store the results of subproblems
        long[][] dp = new long[m + 1][n + 1];

        // Base case initialization:
        // If s1 is empty, it's always a subsequence of s2
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        // Fill the dp array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, we have two options:
                // 1. Include the current character of s2 in the subsequence count.
                // 2. Exclude the current character of s2 and continue with the next character.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // If characters don't match, exclude the current character of s2
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // The result will be in dp[m][n]
        return dp[m][n];
    }
}
