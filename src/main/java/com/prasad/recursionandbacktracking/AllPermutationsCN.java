package com.prasad.recursionandbacktracking;

import java.util.* ;

public class AllPermutationsCN {

    public static void main(String[] args) {
        System.out.println(findPermutations("cba"));
    }
    public static List<String> findPermutations(String s) {
       List<String> permutations = new ArrayList();
       StringBuilder permutation = new StringBuilder();
       boolean[] used = new boolean[s.length()];
       getPermutations(s, used, permutation, permutations);
       return  permutations;
    }

    private static void getPermutations(String s, boolean[] used, StringBuilder permutation, List<String> permutations) {
        if (permutation.length() == s.length()) {
            permutations.add(permutation.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                permutation.append(s.charAt(i));
                used[i] = true;
                getPermutations(s, used, permutation, permutations);
                used[i] = false;
                permutation.deleteCharAt(permutation.length() - 1);
            }
        }
    }

}