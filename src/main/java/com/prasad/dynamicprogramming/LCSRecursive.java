package com.prasad.dynamicprogramming;

class LCSRecursive {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return getLCS(text1, text2, n - 1, m - 1);
    }

    private int getLCS(String text1, String text2, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + getLCS(text1, text2, index1 - 1, index2 - 1);
        }
        return Math.max(getLCS(text1, text2, index1 - 1, index2), getLCS(text1, text2, index1, index2 - 1));
    }

}