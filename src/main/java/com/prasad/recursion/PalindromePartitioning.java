package com.prasad.recursion;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    List<List<String>> palindromePartitions;
    public List<List<String>> partition(String s) {
        palindromePartitions = new ArrayList<>();
        List<String> palindromePartition = new ArrayList<>();
        getPalindromePartitions(s, 0, palindromePartition);
        return palindromePartitions;
    }

    private void getPalindromePartitions(String s, int index, List<String> palindromePartition) {
        int n = s.length();
        if (index == n) {
            palindromePartitions.add(new ArrayList<>(palindromePartition));
            return;
        }
        for (int i = index; i < n; i++) {
            if (isPalindrome(s, index, i)) {
                palindromePartition.add(s.substring(index, i + 1));
                getPalindromePartitions(s, i + 1, palindromePartition);
                palindromePartition.remove(palindromePartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}