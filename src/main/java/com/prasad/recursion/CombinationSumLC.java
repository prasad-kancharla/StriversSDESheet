package com.prasad.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumLC {

    public static void main(String[] args) {
        int[] input = {5, -2, 0, -5, 2 };
        System.out.println(new CombinationSumLC().combinationSum(input, 0));
    }

    List<List<Integer>> combinations;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations = new ArrayList<>();
        int n = candidates.length;
        List<Integer> combination = new ArrayList<>();
        getCombinations(0, 0, target, candidates, combination);
        return combinations;
    }

    private void getCombinations(int i, int sum, int target, int[] candidates, List<Integer> combination) {
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if (i == candidates.length || sum > target) {
            return;
        }

        sum += candidates[i];
        combination.add(candidates[i]);
        getCombinations(i, sum, target, candidates, combination);
        sum -= candidates[i];
        combination.remove(combination.size() - 1);

        getCombinations(i + 1, sum, target, candidates, combination);
    }

}