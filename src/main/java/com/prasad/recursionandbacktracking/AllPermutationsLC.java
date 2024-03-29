package com.prasad.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

class AllPermutationsLC {

    public static void main(String[] args) {
        int[] input = {1,2,3};
        System.out.println(new AllPermutationsLC().permute(input));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        int n = nums.length;
        List<Integer> permutation = new ArrayList<>();
        getPermutations(nums, 0, n, permutation, permutations);
        return permutations;
    }

    private void getPermutations(int[] nums, int index, int n, List<Integer> permutation, List<List<Integer>> permutations) {
        if (index == n) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                permutation.add(nums[i]);
                nums[i] = Integer.MIN_VALUE;
                getPermutations(nums, index + 1, n, permutation, permutations);
                nums[i] = permutation.get(permutation.size() - 1);
                permutation.remove(permutation.size() - 1);
            }
        }
    }

}