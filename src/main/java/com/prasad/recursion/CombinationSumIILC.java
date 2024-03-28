package com.prasad.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumIILC {

    List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations = new ArrayList<>();
        int n = candidates.length;
        List<Integer> combination = new ArrayList();
        getCombinations(candidates, n, target, 0, 0, combination);
        return combinations;
    }

    private void getCombinations(int[] candidates, int n, int target, int i, int sum, List<Integer> combination) {
        if (sum == target) {
            combinations.add(new ArrayList(combination));
            return;
        }

        if (i == n || sum > target) {
            return;
        }
        combination.add(candidates[i]);
        getCombinations(candidates, n, target, i + 1, sum + candidates[i], combination);
        combination.remove(combination.size() - 1);

        while (i + 1 < n && candidates[i + 1] == candidates[i]) {
            i++;
        }
        getCombinations(candidates, n, target, i + 1, sum, combination);
    }

}