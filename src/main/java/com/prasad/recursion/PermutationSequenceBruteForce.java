package com.prasad.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PermutationSequenceBruteForce {

    public static void main(String[] args) {
        System.out.println(new PermutationSequenceBruteForce().getPermutation(3,3));
    }

    List<String> permutations;

    public String getPermutation(int n, int k) {
        permutations = new ArrayList<>();
        int[] used = new int[n];
        StringBuilder permutation = new StringBuilder();
        getPermutations(n, used, permutation);
        Collections.sort(permutations);
        return permutations.get(k - 1);
    }

    private void getPermutations(int n, int[] used, StringBuilder permutation) {
        if (permutation.length() == n) {
            permutations.add(permutation.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i - 1] == 0) {
                permutation.append(i);
                used[i - 1] = -1;
                getPermutations(n, used, permutation);
                permutation.deleteCharAt(permutation.length() - 1);
                used[i - 1] = 0;
            }
        }

    }

}