package com.prasad.dynamicprogramming;

class EditDistanceRecursive {

    public int minDistance(String word1, String word2) {
        return getMinOperation(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int getMinOperation(String word1, String word2, int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return getMinOperation(word1, word2, i - 1, j - 1);
        }
        // insert
        int ans1 = 1 + getMinOperation(word1, word2, i, j - 1);
        // delete
        int ans2 = 1 + getMinOperation(word1, word2, i - 1, j);
        // replace
        int ans3 = 1 + getMinOperation(word1, word2, i - 1, j - 1);

        return Math.min(ans1, Math.min(ans2, ans3));
    }

}